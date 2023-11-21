package com.example.alweb29.learnelectriccircuitsapp.theveninnorton

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.MainActivity
import com.example.alweb29.learnelectriccircuitsapp.R

class TheveninNortonMainView :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thevenin_norton_main)

        val theveninBtn : TextView = findViewById(R.id.tv_thevenin_method)
        val nortonBtn : TextView = findViewById(R.id.tv_norton_method)
        val goBackArrow : ImageButton = findViewById(R.id.ib_go_back_arrow_dividers)

        theveninBtn.setOnClickListener {
            val intent = Intent(this, TheveninMainView::class.java)
            startActivity(intent)
        }
        nortonBtn.setOnClickListener {
            val intent = Intent(this, NortonMainView::class.java)
            startActivity(intent)
        }

        goBackArrow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}