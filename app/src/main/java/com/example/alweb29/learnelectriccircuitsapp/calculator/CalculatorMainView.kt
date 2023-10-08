package com.example.alweb29.learnelectriccircuitsapp.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.MainActivity
import com.example.alweb29.learnelectriccircuitsapp.R

class CalculatorMainView : AppCompatActivity() {


    private var ibGoBackArrow : ImageButton? = null
    private var ibSerialConnection : ImageButton? = null
    private var ibParallelConnection : ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)


        ibSerialConnection = findViewById(R.id.ib_serial_connection)
        ibParallelConnection = findViewById(R.id.ib_parallel_connection)
        ibGoBackArrow = findViewById(R.id.ib_go_back_arrow_calculator_menu)


        ibSerialConnection?.setOnClickListener {
            //TODO change to proper classes - serial and parallel
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        ibParallelConnection?.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        ibGoBackArrow?.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}