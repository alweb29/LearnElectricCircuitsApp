package com.example.alweb29.learnelectriccircuitsapp.theory

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.R
import com.example.alweb29.learnelectriccircuitsapp.flashnotes.FlashNotesMainView
import com.example.alweb29.learnelectriccircuitsapp.theory.chapters.Chapter
import com.example.alweb29.learnelectriccircuitsapp.theory.chapters.Chapter1
import com.example.alweb29.learnelectriccircuitsapp.theory.chapters.Chapter2
import com.example.alweb29.learnelectriccircuitsapp.theory.chapters.Chapter3
import com.example.alweb29.learnelectriccircuitsapp.theory.chapters.Page

class TheoryLearnView : AppCompatActivity() {
    private var chapter : Chapter? = null
    private var currentPage : Page? = null

    private var tvHeader : TextView? = null
    private var ivMain : ImageView? = null
    private var tvText : TextView? = null
    private var tvPrev : TextView? = null
    private var tvNext : TextView? = null
    private var tvBackArrow : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theory_learn_view)

        when (intent.getIntExtra("Chapter",1)){
            1->chapter = Chapter1
            2->chapter = Chapter2
            3->chapter = Chapter3
        }

        tvHeader = findViewById(R.id.tv_header_learn)
        ivMain  = findViewById(R.id.iv_image_learn)
        tvText = findViewById(R.id.tv_text_learn)
        tvPrev = findViewById(R.id.tv_prev_page)
        tvNext = findViewById(R.id.tv_next_page)
        tvBackArrow = findViewById(R.id.tv_back_arrow_learn)

        currentPage = chapter?.getFirstPage()
        loadPageContent()

        tvPrev!!.setOnClickListener {
            currentPage = chapter?.getPreviousPage()
            loadPageContent()
        }

        tvNext!!.setOnClickListener {
            currentPage = chapter?.getNextPage()
            loadPageContent()
        }

        tvBackArrow!!.setOnClickListener {
            intent = Intent(this, TheoryMainView::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun loadPageContent(){
        tvHeader!!.text = currentPage?.header
        tvText!!.text = currentPage?.text
        if (currentPage?.imageR != 0){
            ivMain!!.visibility = View.VISIBLE
            ivMain!!.setImageResource(currentPage!!.imageR)
        }else{
            ivMain!!.visibility = View.GONE
        }
    }


}