package com.example.alweb29.learnelectriccircuitsapp.calendar

import android.os.Bundle
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alweb29.learnelectriccircuitsapp.R

class CalendarMainView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_main)

        val timePicker : TimePicker = findViewById(R.id.tp_calendar)
        var hours : Int? = null 
        var minutes : Int? = null 

        timePicker.setOnTimeChangedListener{
            view, hourOfDay, minute ->
                hours = hourOfDay
                minutes = minute
        }
        
        val btnSubmit : Button = findViewById(R.id.btn_submit_calendar)
        btnSubmit.setOnClickListener{
            Toast.makeText(this, "time set to $hours hours and $minutes minutes", Toast.LENGTH_SHORT).show()
        }
        
    }
}