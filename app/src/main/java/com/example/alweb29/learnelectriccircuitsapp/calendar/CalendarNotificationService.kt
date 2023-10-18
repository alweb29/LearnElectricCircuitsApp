package com.example.alweb29.learnelectriccircuitsapp.calendar

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import androidx.core.app.NotificationCompat
import com.example.alweb29.learnelectriccircuitsapp.MainActivity
import com.example.alweb29.learnelectriccircuitsapp.R

class CalendarNotificationService (
    private val context: Context
    ){
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    private val scheduler = AndroidAlarmScheduler(context)
    fun showNotification(){
        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            PendingIntent.FLAG_IMMUTABLE
        )
        val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_bolt_24)
            .setContentTitle("Comeback and learn!")
            .setContentText("This is your daily reminder to learn")
            .setContentIntent(activityPendingIntent)
            .build()

        notificationManager.notify(
            1, notification
        )
    }

    @SuppressLint("ScheduleExactAlarm")
    fun scheduleNotifications(selectedDays: MutableSet<String>, timeInMilliseconds: Long) {

        clearAllNotifications()

        for (day in selectedDays) {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timeInMilliseconds

            // Set the specific day of the week
            when (day) {
                "Monday" -> calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
                "Tuesday" -> calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY)
                "Wednesday" -> calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY)
                "Thursday" -> calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY)
                "Friday" -> calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY)
                "Saturday" -> calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY)
                "Sunday" -> calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
            }

            // Check if the selected day is in the past, and if so, add a week
            if (calendar.timeInMillis <= System.currentTimeMillis()) {
                calendar.add(Calendar.WEEK_OF_YEAR, 1)
            }

            calendar.timeInMillis.let(scheduler::schedule)
        }
    }

    /*
    possibly in the future can make a button to call this function
    */
    private fun clearAllNotifications(){
        scheduler.clearAllNotifications()
    }

    companion object{
        const val COUNTER_CHANNEL_ID = "calendar_channel"
    }


}