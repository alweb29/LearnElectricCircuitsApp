package com.example.alweb29.learnelectriccircuitsapp.theveninnorton

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.MainActivity
import com.example.alweb29.learnelectriccircuitsapp.R

class TheveninMainView : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thevenin)

        val etE : EditText = findViewById(R.id.et_E1)
        val etR1 : EditText = findViewById(R.id.et_R1)
        val etR2 : EditText = findViewById(R.id.et_R2)
        val etR3 : EditText = findViewById(R.id.et_R3)
        val etR4 : EditText = findViewById(R.id.et_R4)

        val btnSubmit : TextView = findViewById(R.id.tv_btn_calculate)
        val ibGoBackArrow : ImageButton = findViewById(R.id.ib_go_back_arrow_dividers)

        btnSubmit.setOnClickListener {
            if (etE.text.isNotEmpty() && etR1.text.isNotEmpty() && etR2.text.isNotEmpty()&&etR3.text.isNotEmpty()&&etR4.text.isNotEmpty()){
                calculateRThAndETh()
            }else{
                Toast.makeText(this, "Enter all values", Toast.LENGTH_SHORT).show()
            }
        }
        ibGoBackArrow.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun calculateRThAndETh() {
        Toast.makeText(this, "Implement calculating", Toast.LENGTH_SHORT).show()
    }
}