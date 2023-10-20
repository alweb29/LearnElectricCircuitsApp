package com.example.alweb29.learnelectriccircuitsapp.ohmcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.R
import com.example.alweb29.learnelectriccircuitsapp.resistancecalculator.CalculatorMainView

class CalculatorOhm : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator_ohm)

        val etU : EditText = findViewById(R.id.et_U_ohm)
        val etI : EditText = findViewById(R.id.et_I_ohm)
        val etR : EditText = findViewById(R.id.et_R_ohm)
        val tvResult : TextView = findViewById(R.id.tv_result_power_ohm)
        val btnSubmit : Button = findViewById(R.id.btn_calculate_calculator_ohm)
        val ibGoBackArrow : ImageButton = findViewById(R.id.ib_go_back_arrow_calculator_ohm)

        btnSubmit.setOnClickListener {
            var result = "P(W) = ..."
            if (etI.text.isEmpty()&& etU.text.isNotEmpty() &&etR.text.isNotEmpty()){
                etI.setText(calculateI(etU.text.toString(), etR.text.toString()).toString(), TextView.BufferType.NORMAL)
                result = "P(W) = ${calculateP(etU.text.toString(), etI.text.toString())}"
            }else if (etI.text.isNotEmpty()&& etU.text.isEmpty() &&etR.text.isNotEmpty()){
                etU.setText(calculateU(etI.text.toString(), etR.text.toString()).toString(), TextView.BufferType.NORMAL)
                result = "P(W) = ${calculateP(etU.text.toString(), etI.text.toString())}"
            }else if (etI.text.isNotEmpty()&& etU.text.isNotEmpty() &&etR.text.isEmpty()){
                etR.setText(calculateR(etI.text.toString(), etU.text.toString()).toString(), TextView.BufferType.NORMAL)
                result = "P(W) = ${calculateP(etU.text.toString(), etI.text.toString())}"
            }else if (etI.text.isNotEmpty()&& etU.text.isNotEmpty() &&etR.text.isNotEmpty()){
                Toast.makeText(this, "Enter only two values", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Enter at least two values", Toast.LENGTH_SHORT).show()
            }
            tvResult.text = result
        }


        ibGoBackArrow.setOnClickListener{
            intent = Intent(this, CalculatorMainView::class.java)
            startActivity(intent)
            finish()
        }



    }

    private fun calculateP(etU: String, etI: String): Float{
        return etU.toFloat() * etI.toFloat()
    }

    private fun calculateR(etI: String, etU: String) : Float{
        return etU.toFloat()/etI.toFloat()
    }

    private fun calculateU(etI: String, etR: String) : Float{
        return etI.toFloat() * etR.toFloat()
    }

    private fun calculateI(etU: String, etR: String) : Float {
        return etU.toFloat()/etR.toFloat()
    }
}