package com.example.alweb29.learnelectriccircuitsapp.flashnotes

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.MainActivity
import com.example.alweb29.learnelectriccircuitsapp.R
import com.example.alweb29.learnelectriccircuitsapp.dividers.DividersMainView
import com.example.alweb29.learnelectriccircuitsapp.flashnotes.data.FlashNote
import com.example.alweb29.learnelectriccircuitsapp.flashnotes.data.UserFlashNotesData.flashNotes
import java.lang.StringBuilder


class FlashNotesEditView : AppCompatActivity(){

    private var btnCreate : TextView? = null
    private var btnDelete : TextView? = null
    private var btnGoBackArrow : TextView? = null
    private var tvPrev : TextView? = null
    private var tvNext : TextView? = null
    private var etShortText : EditText? = null
    private var etLongText : EditText? = null
    private var flashNote : FlashNote? = null
    private var currentIndex = 0

    private val sharedPrefsFlashNotesList: SharedPreferences by lazy {
        getSharedPreferences("UserFlashNotes", Context.MODE_PRIVATE)
    }
    //TODO fix this function

    private var flashNotes : ArrayList<FlashNote> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashnotes_edit_view)


        btnCreate = findViewById(R.id.tv_add_flash_note)
        btnDelete = findViewById(R.id.tv_delete_flash_note)
        btnGoBackArrow = findViewById(R.id.tv_back_arrow_flash_notes)
        etShortText = findViewById(R.id.et_short_text)
        etLongText = findViewById(R.id.et_long_text)

        tvPrev = findViewById(R.id.tv_prev_flash_note)
        tvNext = findViewById(R.id.tv_next_flash_note)

        btnCreate!!.setOnClickListener {
            createFlashNote()
        }
        btnDelete!!.setOnClickListener {
            deleteFlashNote()
        }
        btnGoBackArrow!!.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        tvPrev!!.setOnClickListener {
            getNextFlashNote()
        }

        tvNext!!.setOnClickListener {
            getPrevFlashNote()
        }

        addDefaultFlashNote()
    }

    private fun getPrevFlashNote() {
        if (currentIndex <= 0){
            currentIndex = flashNotes.size -1
            flashNote = flashNotes[flashNotes.size - 1]
        }else{
            currentIndex--
            flashNote = flashNotes[currentIndex]
        }
        refreshCurrentFlashNoteView()
    }

    private fun getNextFlashNote() {
        if (currentIndex >= flashNotes.size - 1){
            currentIndex = 0
            flashNote = flashNotes[0]
        }else{
            currentIndex++
            flashNote = flashNotes[currentIndex]
        }
        refreshCurrentFlashNoteView()
    }

    private fun refreshCurrentFlashNoteView(){
        etShortText!!.setText(flashNote!!.shortDefinition)
        etLongText!!.setText(flashNote!!.longDefinition)
    }

    private fun addDefaultFlashNote(){
        flashNotes.add(FlashNote("Add header","Add text"))
        refreshCurrentFlashNoteView()
    }
    private fun deleteFlashNote() {

        //get index of flashnote
        val index = flashNotes.indexOf(flashNote)
        //if we are currently on last flash note then don't proceed because this flashNote is for adding other
        if (index == flashNotes.size-1){
            return
        }
        //delete flash note with this note+index - clear preferences
        getNextFlashNote()
        flashNotes.removeAt(index)
        addFlashNotesNamesToPreferences()
        addFlashNotesToPreferences()
        getFlashNotesFromPreferences()

        Toast.makeText(this, "Deleted this Flash Note", Toast.LENGTH_SHORT).show()
        getPrevFlashNote()
    }

    private fun createFlashNote(){

        //read edittext and create flash note
        if (etLongText!!.text.isNotEmpty() && etShortText!!.text.isNotEmpty()){
            val newFlashNote = FlashNote(etLongText!!.text.toString(), etShortText!!.text.toString())
            //add flash note to flashnotes
            flashNotes.add(flashNotes.size-1, newFlashNote)
            flashNote = newFlashNote

            addFlashNotesNamesToPreferences()
            addFlashNotesToPreferences()
            getFlashNotesFromPreferences()

            Toast.makeText(this, "Added this Flash Note", Toast.LENGTH_SHORT).show()
            getNextFlashNote()
        }
    }

    private fun deleteAllFlashNotes(){
        for (flashNoteName in getFlashNotesNamesFromPreferences()){
            val sharedPreferences = getSharedPreferences(flashNoteName, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
        }
        flashNotes.clear()
        addDefaultFlashNote()
        refreshCurrentFlashNoteView()
        addFlashNotesNamesToPreferences()
    }
    private fun addFlashNotesNamesToPreferences(){
        val editor = sharedPrefsFlashNotesList.edit()
        editor.clear()
        val strBld = StringBuilder()
        for (flashNote in flashNotes){
            strBld.append("note"+flashNotes.indexOf(flashNote).toString()).append(",")
        }
        editor.putString("UserFlashNotes", strBld.toString())
        editor.apply()
    }
    private fun addFlashNotesToPreferences(){
        for (flashNote in flashNotes){
            val sharedPrefsFlashNote = getSharedPreferences("note"+flashNotes.indexOf(flashNote).toString(), Context.MODE_PRIVATE)
            val editor = sharedPrefsFlashNote.edit()
            editor.clear()
            val strBld = StringBuilder()
            strBld.append(flashNote.shortDefinition).append(";").append(flashNote.longDefinition)
            editor.putString("note"+flashNotes.indexOf(flashNote).toString(), strBld.toString())
            editor.apply()
        }
    }

    private fun getFlashNotesNamesFromPreferences() : List<String>{
        var names : List<String> = ArrayList()
        val savedNames : String? = sharedPrefsFlashNotesList.getString("UserFlashNotes", "")
        savedNames.let {
            if (savedNames != null) {
                names = savedNames.split(",")
            }
        }
        return names
    }

    private fun getFlashNotesFromPreferences(){
        flashNotes.clear()
        for (name in getFlashNotesNamesFromPreferences()){
            val sharedPrefsFlashNote = getSharedPreferences(name, Context.MODE_PRIVATE)
            val content : List<String> = sharedPrefsFlashNote.getString(name, "")!!.split(";")
            val readFlashNote =FlashNote(content[0],content[1])
            flashNotes.add(readFlashNote)
        }
        addDefaultFlashNote()
    }

}