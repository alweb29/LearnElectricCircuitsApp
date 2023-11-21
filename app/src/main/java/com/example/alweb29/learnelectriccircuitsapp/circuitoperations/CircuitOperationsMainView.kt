package com.example.alweb29.learnelectriccircuitsapp.circuitoperations

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.MainActivity
import com.example.alweb29.learnelectriccircuitsapp.R
import com.example.alweb29.learnelectriccircuitsapp.circuitoperations.dividers.DividersMainView
import com.example.alweb29.learnelectriccircuitsapp.circuitoperations.sourcereplacement.SourceReplacementMainView

class CircuitOperationsMainView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circuitoperations_main_view)

        val tvSourceReplacement : TextView = findViewById(R.id.tv_source_replacement)
        val tvDividers : TextView = findViewById(R.id.tv_dividers)
        val ibGoBackArrow : ImageButton = findViewById(R.id.ib_go_back_arrow_dividers)


        tvSourceReplacement.setOnClickListener {
            intent = Intent(this, SourceReplacementMainView::class.java)
            startActivity(intent)
        }

        tvDividers.setOnClickListener {
            intent = Intent(this, DividersMainView::class.java)
            startActivity(intent)
        }

        ibGoBackArrow.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}