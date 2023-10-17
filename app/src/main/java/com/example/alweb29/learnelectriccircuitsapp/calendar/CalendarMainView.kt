package com.example.alweb29.learnelectriccircuitsapp.calendar

import android.content.Intent
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.alweb29.learnelectriccircuitsapp.MainActivity
import com.example.alweb29.learnelectriccircuitsapp.R
import com.example.alweb29.learnelectriccircuitsapp.calculator.CalculatorMainView

class CalendarMainView : AppCompatActivity(), OnClickListener {

    private var btnMonday : TextView? = null
    private var btnTuesday : TextView? = null
    private var btnWednesday : TextView? = null
    private var btnThursday : TextView? = null
    private var btnFriday : TextView? = null
    private var btnSaturday : TextView? = null
    private var btnSunday : TextView? = null

    private var tvAllDays : TextView? = null

    private var allDaysSet = mutableSetOf<TextView>()
    private var allDaysBtnClicked : Boolean = false

    private val selectedDays = mutableSetOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_main)

        btnMonday= findViewById(R.id.btn_calendar_mon)
        btnTuesday = findViewById(R.id.btn_calendar_tue)
        btnWednesday = findViewById(R.id.btn_calendar_wed)
        btnThursday  = findViewById(R.id.btn_calendar_thr)
        btnFriday = findViewById(R.id.btn_calendar_fri)
        btnSaturday = findViewById(R.id.btn_calendar_sat)
        btnSunday = findViewById(R.id.btn_calendar_sun)
        tvAllDays = findViewById(R.id.tv_all_days_calendar)

        val timePicker : TimePicker = findViewById(R.id.tp_calendar)

        btnMonday?.setOnClickListener(this)
        btnTuesday?.setOnClickListener(this)
        btnWednesday?.setOnClickListener(this)
        btnThursday?.setOnClickListener(this)
        btnFriday?.setOnClickListener(this)
        btnSaturday?.setOnClickListener(this)
        btnSunday?.setOnClickListener(this)
        tvAllDays?.setOnClickListener(this)

        allDaysSet.add(btnMonday!!)
        allDaysSet.add(btnTuesday!!)
        allDaysSet.add(btnWednesday!!)
        allDaysSet.add(btnThursday!!)
        allDaysSet.add(btnFriday!!)
        allDaysSet.add(btnSaturday!!)
        allDaysSet.add(btnSunday!!)

        var hours : Int? = null 
        var minutes : Int? = null 

        timePicker.setOnTimeChangedListener{
            view, hourOfDay, minute ->
                hours = hourOfDay
                minutes = minute
        }
        
        val btnSubmit : TextView = findViewById(R.id.btn_submit_calendar)
        btnSubmit.setOnClickListener{
            Toast.makeText(this, "notification set to $hours hours and $minutes minutes, days set to : $selectedDays", Toast.LENGTH_SHORT).show()

            setSelectedDaysToNotifications()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_calendar_mon->{
                btnMonday?.let {
                    if (selectedDays.contains("Monday")){
                        unselectOptionView(it)
                        selectedDays.remove("Monday")
                    }else{
                        selectedOptionView(it)
                        selectedDays.add("Monday")
                    }
                }
            }
            R.id.btn_calendar_tue->{
                btnTuesday?.let {
                    if (selectedDays.contains("Tuesday")){
                        unselectOptionView(it)
                        selectedDays.remove("Tuesday")
                    }else{
                        selectedOptionView(it)
                        selectedDays.add("Tuesday")
                    }
                }
            }
            R.id.btn_calendar_wed->{
                btnWednesday?.let {
                    if (selectedDays.contains("Wednesday")){
                        unselectOptionView(it)
                        selectedDays.remove("Wednesday")
                    }else{
                        selectedOptionView(it)
                        selectedDays.add("Wednesday")
                    }
                }
            }
            R.id.btn_calendar_thr->{
                btnThursday?.let {
                    if (selectedDays.contains("Thursday")){
                        unselectOptionView(it)
                        selectedDays.remove("Thursday")
                    }else{
                        selectedOptionView(it)
                        selectedDays.add("Thursday")
                    }
                }
            }
            R.id.btn_calendar_fri->{
                btnFriday?.let {
                    if (selectedDays.contains("Friday")){
                        unselectOptionView(it)
                        selectedDays.remove("Friday")
                    }else{
                        selectedOptionView(it)
                        selectedDays.add("Friday")
                    }
                }
            }
            R.id.btn_calendar_sat->{
                btnSaturday?.let {
                    if (selectedDays.contains("Saturday")){
                        unselectOptionView(it)
                        selectedDays.remove("Saturday")
                    }else{
                        selectedOptionView(it)
                        selectedDays.add("Saturday")
                    }
                }
            }
            R.id.btn_calendar_sun->{
                btnSunday?.let {
                    if (selectedDays.contains("Sunday")){
                        unselectOptionView(it)
                        selectedDays.remove("Sunday")
                    }else{
                        selectedOptionView(it)
                        selectedDays.add("Sunday")
                    }
                }
            }
            R.id.tv_all_days_calendar->{
                tvAllDays?.let {

                    if (allDaysBtnClicked){
                        for (day in allDaysSet){
                            unselectOptionView(day)
                        }
                        selectedDays.clear()

                        unselectOptionView(it)
                        allDaysBtnClicked = false
                    }else{
                        for (day in allDaysSet){
                            selectedOptionView(day)
                        }
                        selectedDays.add("Monday")
                        selectedDays.add("Tuesday")
                        selectedDays.add("Wednesday")
                        selectedDays.add("Thursday")
                        selectedDays.add("Friday")
                        selectedDays.add("Saturday")
                        selectedDays.add("Sunday")

                        selectedOptionView(it)
                        allDaysBtnClicked = true
                    }
                }
            }
        }
    }


    private fun selectedOptionView(tv:TextView){
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.basic_choice_tile_selected
        )
    }
    private fun unselectOptionView(tv:TextView){
        tv.setTypeface(tv.typeface, Typeface.NORMAL)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.basic_choice_tile
        )
    }

    fun setSelectedDaysToNotifications(){
        //TODO implement this to send list to notifications
    }

}