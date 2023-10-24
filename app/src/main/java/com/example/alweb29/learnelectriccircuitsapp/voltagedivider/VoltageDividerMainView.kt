package com.example.alweb29.learnelectriccircuitsapp.voltagedivider

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

class VoltageDividerMainView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_voltage_divider)

        val etV1 : EditText = findViewById(R.id.et_V1_voltage_divider)
        val etR1 : EditText = findViewById(R.id.et_R1_voltage_divider)
        val etR2 : EditText = findViewById(R.id.et_R2_voltage_divider)
        val tvVOut : TextView = findViewById(R.id.tv_result_v_out_voltage_divider) 
        val btnSubmit : Button = findViewById(R.id.btn_calculate_voltage_divider)
        val ibGoBackArrow : ImageButton = findViewById(R.id.ib_go_back_arrow_voltage_divider)

        btnSubmit.setOnClickListener {
            if (etV1.text.isNotEmpty() && etR1.text.isNotEmpty() && etR2.text.isNotEmpty()){
                 tvVOut.text = "V out = ${calculateVOut(etV1.text.toString(), etR1.text.toString(), etR2.text.toString())}" 
            }else{
                Toast.makeText(this, "Enter all values", Toast.LENGTH_SHORT).show()
                tvVOut.text ="V out = ..."
            }
        }
        ibGoBackArrow.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun calculateVOut(v1: String, r1: String, r2: String) : Float{
        return (v1.toFloat()*r2.toFloat())/(r1.toFloat() + r2.toFloat())
    }


}