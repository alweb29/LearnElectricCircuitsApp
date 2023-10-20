package com.example.alweb29.learnelectriccircuitsapp.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.MainActivity
import com.example.alweb29.learnelectriccircuitsapp.R

class CalculatorMainView : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)


        val ibSerialConnection : ImageButton = findViewById(R.id.ib_serial_connection)
        val ibParallelConnection : ImageButton = findViewById(R.id.ib_parallel_connection)
        val ibGoBackArrow : ImageButton = findViewById(R.id.ib_go_back_arrow_calculator_menu)


        ibSerialConnection.setOnClickListener {
            intent = Intent(this, CalculatorParallelView::class.java)
            startActivity(intent)

        }

        ibParallelConnection.setOnClickListener {
            intent = Intent(this, CalculatorSeriesView::class.java)
            startActivity(intent)

        }

        ibGoBackArrow.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}