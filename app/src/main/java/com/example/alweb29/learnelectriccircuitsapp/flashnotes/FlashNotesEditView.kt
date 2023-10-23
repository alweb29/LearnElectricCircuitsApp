package com.example.alweb29.learnelectriccircuitsapp.flashnotes

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.R


class FlashNotesEditView : AppCompatActivity(){

    private var btnCreate : Button? = null
    private var etShortText : EditText? = null
    private var etLongText : EditText? = null

    private var flashNotes : MutableList<FlashNote>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashnotes_edit_view)
        //TODO work on saving and making new flash notes
        /*//change to proper id
        btnCreate = findViewById(R.id.btn_create)
        etShortText = findViewById(R.id.btn_create)
        etLongText = findViewById(R.id.btn_create)

        btnCreate.setOnClickListener {
            createFlashNote()
        }

        val flashNoteManager = FlashNotesManager(context)
        val loadedFlashNotes = flashNoteManager.loadFlashNotes()

        flashNotes = loadedFlashNotes*/

    }

    private fun createFlashNote(){
        /*if (etShortText?.text!!.isNotEmpty() && etLongText?.text!!.isNotEmpty()){
            val newFlashNote = FlashNote(etShortText!!.text.toString(), etLongText!!.text.toString())
            flashNotes?.add(newFlashNote)
            Toast.makeText(this, "Flash note saved!", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Insert ", Toast.LENGTH_SHORT).show()
        }
        val flashNoteManager = FlashNoteManager(context)
        flashNoteManager.saveFlashNotes(flashNotes)*/
    }
}