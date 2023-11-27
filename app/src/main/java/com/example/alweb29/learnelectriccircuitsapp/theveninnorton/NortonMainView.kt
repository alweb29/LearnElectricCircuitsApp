package com.example.alweb29.learnelectriccircuitsapp.theveninnorton

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.MainActivity
import com.example.alweb29.learnelectriccircuitsapp.R

class NortonMainView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_norton)
        //TODO finish implementation
        val etE : EditText = findViewById(R.id.et_E1)
        val etR1 : EditText = findViewById(R.id.et_R1)
        val etR2 : EditText = findViewById(R.id.et_R2)
        val etR3 : EditText = findViewById(R.id.et_R3)

        val btnSubmit : TextView = findViewById(R.id.tv_btn_calculate)
        val tvRTh : TextView = findViewById(R.id.tv_rth)
        val tvETh : TextView = findViewById(R.id.tv_eth)
        val tvI3 : TextView = findViewById(R.id.tv_i3)
        val ibGoBackArrow : ImageButton = findViewById(R.id.ib_go_back_arrow_dividers)

        btnSubmit.setOnClickListener {
            if (etE.text.isNotEmpty() && etR1.text.isNotEmpty() && etR2.text.isNotEmpty()&&etR3.text.isNotEmpty()){

                val rTh = (etR1.text.toString().toFloat() * etR2.text.toString().toFloat())/(etR1.text.toString().toFloat() + etR2.text.toString().toFloat())
                val eTh = etE.text.toString().toFloat() - ((etE.text.toString().toFloat()/(etR1.text.toString().toFloat() + etR2.text.toString().toFloat())) * etR1.text.toString().toFloat())
                val i3 = eTh/(rTh + etR3.text.toString().toFloat())

                tvRTh.setText("R Th = $rTh")
                tvETh.setText("E Th = $eTh")
                tvI3.setText("I 3 = $i3")
            }else{
                Toast.makeText(this, "Enter all values", Toast.LENGTH_SHORT).show()
                tvRTh.setText("R Th = ...")
                tvETh.setText("E Th = ...")
                tvI3.setText("I 3 = ...")
            }
        }
        ibGoBackArrow.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}