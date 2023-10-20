package com.example.alweb29.learnelectriccircuitsapp.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.R

class CalculatorParallelView : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_calculator_parallel)

        val etR1 : EditText = findViewById(R.id.et_R1_serial)
        val etR2 : EditText = findViewById(R.id.et_R2_serial)
        val tvResult : TextView = findViewById(R.id.tv_result_calculator_serial)
        val btnCalculate : Button = findViewById(R.id.btn_calculate_calculator_serial)
        val ibGoBackArrow : ImageButton = findViewById(R.id.ib_go_back_arrow_calculator_serial)


        btnCalculate.setOnClickListener{

            if (etR1.text.isEmpty() || etR2.text.isEmpty()){
                Toast.makeText(this, "Enter both values", Toast.LENGTH_SHORT).show()
            }else{

                var result = calculateResult(etR1, etR2)
                tvResult.text = "Rn = $result ohm"
            }
        }


        ibGoBackArrow.setOnClickListener{
            intent = Intent(this, CalculatorMainView::class.java)
            startActivity(intent)
        }
    }

    private fun calculateResult(etR1: EditText, etR2: EditText): Float {
        val r1 = etR1.text.toString().toFloat()
        val r2 = etR2.text.toString().toFloat()

        return  (1 / ((1/r1) + (1/r2)))

    }


}