package com.example.alweb29.learnelectriccircuitsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.alweb29.learnelectriccircuitsapp.calculator.CalculatorMainView

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition(
                SplashScreen.KeepOnScreenCondition {
                    viewModel.isLoading.value
                }
            ) // set condition to turn off splash screen

        }

        setContentView(R.layout.activity_main)


        val btnCalculator : ImageButton = findViewById(R.id.ib_calculator_1)
        val btnCalendar : ImageButton = findViewById(R.id.ib_calendar_main_view_button)
        val btnTest : ImageButton = findViewById(R.id.ib_test_main_view_button)

        btnCalculator.setOnClickListener{
            Log.e("msg", "went to calculator")
            val intent = Intent(this, CalculatorMainView::class.java)
            startActivity(intent)
        }


        btnTest.setOnClickListener{
            //TODO implement test activity
            //val intent = Intent(this, TestMainView::class.java)
            //startActivity(intent)
        }

        btnCalendar.setOnClickListener{
            //TODO implement calendar, find out about notifications
            //val intent = Intent(this, CalendarMainView::class.java)
            //startActivity(intent)
        }


    }
}