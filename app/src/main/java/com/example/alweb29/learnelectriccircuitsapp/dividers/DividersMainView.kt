package com.example.alweb29.learnelectriccircuitsapp.dividers

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.MainActivity
import com.example.alweb29.learnelectriccircuitsapp.R

class DividersMainView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dividers_main)

        val tvCurrentDivider : TextView = findViewById(R.id.tv_current_divider)
        val tvVoltageDivider : TextView = findViewById(R.id.tv_voltage_divider)
        val ibGoBackArrow : ImageButton = findViewById(R.id.ib_go_back_arrow_dividers)

        tvCurrentDivider.setOnClickListener {
            intent = Intent(this, CurrentDividerMainView::class.java)
            startActivity(intent)
            finish()
        }
        tvVoltageDivider.setOnClickListener {
            intent = Intent(this, VoltageDividerMainView::class.java)
            startActivity(intent)
            finish()
        }
        ibGoBackArrow.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}