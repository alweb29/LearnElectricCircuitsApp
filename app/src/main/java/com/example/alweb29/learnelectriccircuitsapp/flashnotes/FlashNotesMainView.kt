package com.example.alweb29.learnelectriccircuitsapp.flashnotes

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.MainActivity
import com.example.alweb29.learnelectriccircuitsapp.R
import com.example.alweb29.learnelectriccircuitsapp.test.Constants
import com.example.alweb29.learnelectriccircuitsapp.test.TestQuestionsActivity

class FlashNotesMainView :AppCompatActivity(), OnClickListener{

    private var btnDefaultFlashNotes : Button? = null
    private var btnManageFlashNotes : Button? = null
    private var btnYourFlashNotes : Button? = null
    private var tvGoBackArrow : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashnotes_main)

        btnDefaultFlashNotes = findViewById(R.id.btn_default_flash_notes)
        btnManageFlashNotes = findViewById(R.id.btn_manage_flash_notes)
        btnYourFlashNotes = findViewById(R.id.btn_your_flash_notes)
        tvGoBackArrow = findViewById(R.id.tv_back_arrow_flash_notes)

        btnDefaultFlashNotes?.setOnClickListener(this)
        btnManageFlashNotes?.setOnClickListener(this)
        btnYourFlashNotes?.setOnClickListener(this)
        tvGoBackArrow?.setOnClickListener(this)
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_default_flash_notes->{
                intent = Intent(this, FlashNoteLearningView::class.java)
                intent.putExtra("type", "default")
                startActivity(intent)
                finish()
            }
            R.id.btn_manage_flash_notes->{
                intent = Intent(this, FlashNotesEditView::class.java)
                startActivity(intent)
            }
            R.id.btn_your_flash_notes->{
                intent = Intent(this, FlashNoteLearningView::class.java)
                intent.putExtra("type", "user")
                startActivity(intent)
                finish()
            }
            R.id.tv_back_arrow_flash_notes->{
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}