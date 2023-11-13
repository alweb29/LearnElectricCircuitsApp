package com.example.alweb29.learnelectriccircuitsapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.alweb29.learnelectriccircuitsapp.resistancecalculator.CalculatorMainView
import com.example.alweb29.learnelectriccircuitsapp.calendar.CalendarMainView
import com.example.alweb29.learnelectriccircuitsapp.calendar.CalendarNotificationService
import com.example.alweb29.learnelectriccircuitsapp.dividers.DividersMainView
import com.example.alweb29.learnelectriccircuitsapp.flashnotes.FlashNotesMainView
import com.example.alweb29.learnelectriccircuitsapp.ohmcalculator.CalculatorOhm
import com.example.alweb29.learnelectriccircuitsapp.sourcereplacement.SourceReplacementMainView
import com.example.alweb29.learnelectriccircuitsapp.test.TestMainView
import com.example.alweb29.learnelectriccircuitsapp.theory.TheoryMainView
import com.example.alweb29.learnelectriccircuitsapp.dividers.VoltageDividerMainView
import com.example.alweb29.learnelectriccircuitsapp.theveninnorton.TheveninMainView
import com.example.alweb29.learnelectriccircuitsapp.theveninnorton.TheveninNortonMainView

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
            val intent = Intent(this, CalculatorMainView::class.java)
            startActivity(intent)
        }

        btnPowerCalculator.setOnClickListener{
            val intent = Intent(this, CalculatorOhm::class.java)
            startActivity(intent)
        }
        
        btnCircuitChanger.setOnClickListener{
            val intent = Intent(this, SourceReplacementMainView::class.java)
            startActivity(intent)
        }

        btnCurrentDivider.setOnClickListener{
            val intent = Intent(this, TheveninNortonMainView::class.java)
            startActivity(intent)
        }

        btnLearning.setOnClickListener{
            val intent = Intent(this, TheoryMainView::class.java)
            startActivity(intent)
        }

        btnFlashNotes.setOnClickListener{
            val intent = Intent(this, FlashNotesMainView::class.java)
            startActivity(intent)
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