package com.example.alweb29.learnelectriccircuitsapp.flashnotes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.alweb29.learnelectriccircuitsapp.MainActivity
import com.example.alweb29.learnelectriccircuitsapp.R

class FlashNoteLearningView : AppCompatActivity(), OnClickListener {

    private var dataSetOfFlashNote : FlashNotesDataSet? = null

    private var tvFlashCardShortText : TextView? = null
    private var ivFlashCardImage : ImageView? = null
    private var cvFlashCard : CardView? = null
    private var tvPreviousFlashNote : TextView? = null
    private var tvNextFlashNote : TextView? = null
    private var tvGoBackToMenu : TextView? = null

    private var flashNote : FlashNote? = null
    private var isSwitched : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashnotes_learning_view)

        tvFlashCardShortText = findViewById(R.id.tv_flashcard_text)
        ivFlashCardImage = findViewById(R.id.iv_flashcard_image)
        cvFlashCard = findViewById(R.id.cv_flash_note_learning)
        tvPreviousFlashNote = findViewById(R.id.tv_prev_flash_note)
        tvNextFlashNote = findViewById(R.id.tv_next_flash_note)
        tvGoBackToMenu = findViewById(R.id.tv_back_arrow_flash_notes)


        cvFlashCard?.setOnClickListener(this)
        tvPreviousFlashNote?.setOnClickListener(this)
        tvNextFlashNote?.setOnClickListener(this)
        tvGoBackToMenu?.setOnClickListener(this)

        dataSetOfFlashNote = if (intent.getStringExtra("type") == "default"){
            DefaultFlashNotesData
        }else{
            UserFlashNotesData
        }
        flashNote = dataSetOfFlashNote!!.getFirstFlashNote()
        defaultFlashCardContent()
    }

    private fun defaultFlashCardContent(){

        tvFlashCardShortText?.text = flashNote?.shortDefinition

        if (flashNote?.imageR != null){
            ivFlashCardImage?.visibility = View.VISIBLE
            ivFlashCardImage?.setImageResource(flashNote!!.imageR)
        }
        isSwitched = false
    }

    private fun switchFlashNoteSide(){
        if (isSwitched){
            defaultFlashCardContent()
        }else{
            tvFlashCardShortText?.text = flashNote?.longDefinition
            ivFlashCardImage?.visibility=View.GONE
            isSwitched = true
        }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.cv_flash_note_learning->{
                switchFlashNoteSide()
            }
            R.id.tv_prev_flash_note->{
                flashNote = dataSetOfFlashNote?.getPreviousFlashNote()
                defaultFlashCardContent()
            }
            R.id.tv_next_flash_note->{
                flashNote = dataSetOfFlashNote?.getNextFlashNote()
                defaultFlashCardContent()
            }
            R.id.tv_back_arrow_flash_notes->{
                intent = Intent(this, FlashNotesMainView::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}