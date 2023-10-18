package com.example.alweb29.learnelectriccircuitsapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.content.getSystemService
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.alweb29.learnelectriccircuitsapp.calculator.CalculatorMainView
import com.example.alweb29.learnelectriccircuitsapp.calendar.CalendarMainView
import com.example.alweb29.learnelectriccircuitsapp.test.TestMainView

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
        val service = CalendarNotificationService(applicationContext)
        createNotificationChannel()

        setContentView(R.layout.activity_main)


        val btnCalculator : ImageButton = findViewById(R.id.ib_calculator_1)
        val btnPowerCalculator : ImageButton = findViewById(R.id.ib_power_calculator)
        val btnCircuitChanger : ImageButton = findViewById(R.id.ib_circuit_changer)
        val btnCurrentDivider : ImageButton = findViewById(R.id.ib_current_divider)
        val btnLearning : ImageButton = findViewById(R.id.ib_learning)
        val btnFlashNotes : ImageButton = findViewById(R.id.ib_flash_notes)
        val btnCalendar : ImageButton = findViewById(R.id.ib_calendar_main_view_button)
        val btnTest : ImageButton = findViewById(R.id.ib_test_main_view_button)

        btnCalculator.setOnClickListener{
            Log.e("msg", "went to calculator")
            val intent = Intent(this, CalculatorMainView::class.java)
            startActivity(intent)
        }


        //TODO implement other buttons
        btnPowerCalculator.setOnClickListener{
            service.showNotification()
            Toast.makeText(this, "kalkulator mocy", Toast.LENGTH_SHORT).show()
        }
        
        btnCircuitChanger.setOnClickListener{
            Toast.makeText(this, "zamiennik źródeł", Toast.LENGTH_SHORT).show()
        }
        btnCurrentDivider.setOnClickListener{
            Toast.makeText(this, "dzielnik prądowy", Toast.LENGTH_SHORT).show()
        }
        btnLearning.setOnClickListener{
            Toast.makeText(this, "nauka", Toast.LENGTH_SHORT).show()
        }
        btnFlashNotes.setOnClickListener{
            Toast.makeText(this, "fiszki", Toast.LENGTH_SHORT).show()
        }

        
        btnTest.setOnClickListener{
            val intent = Intent(this, TestMainView::class.java)
            startActivity(intent)
        }

        btnCalendar.setOnClickListener{
            val intent = Intent(this, CalendarMainView::class.java)
            startActivity(intent)
        }


    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                CalendarNotificationService.COUNTER_CHANNEL_ID,
                "Reminder",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = "Used for reminding about daily learning"

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}