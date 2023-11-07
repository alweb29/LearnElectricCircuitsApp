package com.example.alweb29.learnelectriccircuitsapp.flashnotes

import android.content.Context
import android.content.Intent
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

    val sharedPrefsFlashNotesList = getSharedPreferences("UserFlashNotes", Context.MODE_PRIVATE)

    private var flashNotes : ArrayList<FlashNote> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashnotes_edit_view)
        //TODO work on saving and making new flash notes

        btnCreate = findViewById(R.id.tv_add_flash_note)
        btnDelete = findViewById(R.id.tv_delete_flash_note)
        btnGoBackArrow = findViewById(R.id.tv_back_arrow_flash_notes)
        etShortText = findViewById(R.id.et_short_text)
        etLongText = findViewById(R.id.et_long_text)

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
        //add empty flashNote at the end
        //flashNotes.add(FlashNote())
    }

    private fun getPrevFlashNote() {
        TODO("Not yet implemented")
    }

    private fun getNextFlashNote() {
        TODO("Not yet implemented")
    }

    private fun deleteFlashNote() {
        TODO("Not yet implemented")
        //get index of flashnote
        //delete flash note with this note+index - clear preferences
        //edit flashnotes - with deleted flash note

        //addFlashNotesNamesToPreferences()
        //addFlashNotesToPreferences()

        Toast.makeText(this, "Deleted this Flash Note", Toast.LENGTH_SHORT).show()
        getPrevFlashNote()
    }

    private fun createFlashNote(){
        TODO("Not yet implemented")
        //read edittext and create flash note
        //add flash note to flashnotes

        //addFlashNotesNamesToPreferences()
        //addFlashNotesToPreferences()
        //getFlashNotesNamesFromPreferences()

        Toast.makeText(this, "Added this Flash Note", Toast.LENGTH_SHORT).show()
        getNextFlashNote()
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
        for (name in getFlashNotesNamesFromPreferences()){
            val sharedPrefsFlashNote = getSharedPreferences(name, Context.MODE_PRIVATE)
            val content : List<String> = sharedPrefsFlashNote.getString(name, "")!!.split(";")
            val readFlashNote =FlashNote(content[0],content[1])
            flashNotes.add(readFlashNote)
        }
    }

}