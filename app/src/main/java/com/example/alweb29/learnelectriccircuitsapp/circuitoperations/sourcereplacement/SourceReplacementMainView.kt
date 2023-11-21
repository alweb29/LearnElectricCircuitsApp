package com.example.alweb29.learnelectriccircuitsapp.circuitoperations.sourcereplacement

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.MainActivity
import com.example.alweb29.learnelectriccircuitsapp.R

class SourceReplacementMainView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source_replecament)

        val etJ : EditText = findViewById(R.id.et_J)
        val etE : EditText = findViewById(R.id.et_E)
        val etRs : EditText = findViewById(R.id.et_Rs)
        val btnSubmit : Button = findViewById(R.id.btn_calculate_source_replacement)
        val ibGoBackArrow : ImageButton = findViewById(R.id.ib_go_back_arrow_source_replacement)

        btnSubmit.setOnClickListener {
            if (etJ.text.isNotEmpty() && etRs.text.isNotEmpty() && etE.text.isEmpty()){
                etE.setText(calculateE(etJ.text.toString(), etRs.text.toString()).toString())
            }else if( etJ.text.isEmpty() && etRs.text.isNotEmpty() && etE.text.isNotEmpty()){
                etJ.setText(calculateJ(etE.text.toString(), etRs.text.toString()).toString())
            }else if (etJ.text.isNotEmpty() && etRs.text.isNotEmpty() && etE.text.isNotEmpty()){
                Toast.makeText(this, "Enter only J or E", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Enter J or E and Rs", Toast.LENGTH_SHORT).show()
            }
        }
        ibGoBackArrow.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun calculateJ(e: String, rs: String) : Float{
        return e.toFloat()/rs.toFloat()
    }

    private fun calculateE(j: String, rs: String) : Float{
        return j.toFloat()*rs.toFloat()
    }
}