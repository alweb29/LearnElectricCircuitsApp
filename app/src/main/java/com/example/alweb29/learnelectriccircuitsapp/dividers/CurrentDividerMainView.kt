package com.example.alweb29.learnelectriccircuitsapp.dividers

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

class CurrentDividerMainView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_divider)

        val etV1: EditText = findViewById(R.id.et_V1_voltage_divider)
        val etR1: EditText = findViewById(R.id.et_R1_voltage_divider)
        val etR2: EditText = findViewById(R.id.et_R2_voltage_divider)
        val tvR1Result: TextView = findViewById(R.id.tv_R1_result)
        val tvR2Result: TextView = findViewById(R.id.tv_R2_result)
        val btnSubmit: Button = findViewById(R.id.btn_calculate_voltage_divider)
        val ibGoBackArrow: ImageButton = findViewById(R.id.ib_go_back_arrow_voltage_divider)

        btnSubmit.setOnClickListener {
            if (etV1.text.isEmpty()) {
                Toast.makeText(this, "Enter Current source value", Toast.LENGTH_SHORT).show()
            } else if (etR1.text.isEmpty() && etR2.text.isEmpty()) {
                Toast.makeText(this, "Enter at least one resistor value", Toast.LENGTH_SHORT).show()
            } else if(etR1.text.isNotEmpty() && etR2.text.isEmpty()){
                tvR1Result.text = "= ${etV1.text} A"
                tvR2Result.text = "= ... A"
            }else if (etR1.text.isEmpty() && etR2.text.isNotEmpty()){
                tvR1Result.text = "= ... A"
                tvR2Result.text = "= ${etV1.text} A"
            }else{
                val sum = etR1.text.toString().toFloat() + etR2.text.toString().toFloat()
                val r1text = (etV1.text.toString().toFloat() * etR2.text.toString().toFloat()/(sum)).toString()
                val r2text = (etV1.text.toString().toFloat() * etR1.text.toString().toFloat()/(sum)).toString()

                tvR1Result.text = "= $r1text A"
                tvR2Result.text = "= $r2text A"
            }
        }
        ibGoBackArrow.setOnClickListener {
            intent = Intent(this, DividersMainView::class.java)
            startActivity(intent)
            finish()
        }
    }
}