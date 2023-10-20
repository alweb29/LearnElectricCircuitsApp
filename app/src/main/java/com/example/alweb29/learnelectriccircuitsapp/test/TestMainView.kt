package com.example.alweb29.learnelectriccircuitsapp.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.R

class TestMainView : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_main)

        val btnChapter1 : Button = findViewById(R.id.btn_first_chapter_test)
        val btnChapter2 : Button = findViewById(R.id.btn_second_chapter_test)
        val btnChapter3 : Button = findViewById(R.id.btn_third_chapter_test)


        btnChapter1.setOnClickListener {
            intent = Intent(this, TestQuestionsActivity::class.java)
            intent.putExtra(Constants.CHAPTER, "1")
            startActivity(intent)
            finish()
        }

        btnChapter2.setOnClickListener {
            intent = Intent(this, TestQuestionsActivity::class.java)
            intent.putExtra(Constants.CHAPTER, "2")
            startActivity(intent)
            finish()
        }

        btnChapter3.setOnClickListener {
            intent = Intent(this, TestQuestionsActivity::class.java)
            intent.putExtra(Constants.CHAPTER, "3")
            startActivity(intent)
            finish()
        }
    }
}