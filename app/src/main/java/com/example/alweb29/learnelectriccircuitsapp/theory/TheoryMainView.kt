package com.example.alweb29.learnelectriccircuitsapp.theory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.MainActivity
import com.example.alweb29.learnelectriccircuitsapp.R

class TheoryMainView : AppCompatActivity() {

    var chosenChapter : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theory_main_view)

        val btnChapterOne : Button = findViewById(R.id.btn_first_chapter_learn)
        val btnChapterTwo : Button = findViewById(R.id.btn_second_chapter_learn)
        val btnChapterThree : Button = findViewById(R.id.btn_third_chapter_learn)
        val tvBackArrow : TextView = findViewById(R.id.tv_back_arrow_learn_main)

        btnChapterOne.setOnClickListener {
            chosenChapter = 1
            goToChosenChapter()
        }
        btnChapterTwo.setOnClickListener {
            chosenChapter = 2
            goToChosenChapter()
        }
        btnChapterThree.setOnClickListener {
            Toast.makeText(this, "chapter 3", Toast.LENGTH_SHORT).show()
        }
        tvBackArrow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun goToChosenChapter(){
        val intent = Intent(this, TheoryLearnView::class.java)
        intent.putExtra("Chapter", chosenChapter)
        startActivity(intent)
    }
}