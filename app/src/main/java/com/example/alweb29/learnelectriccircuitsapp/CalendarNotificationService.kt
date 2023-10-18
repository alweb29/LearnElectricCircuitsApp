package com.example.alweb29.learnelectriccircuitsapp

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.alweb29.learnelectriccircuitsapp.calendar.NotificationReceiver

class CalendarNotificationService (
    private val context: Context
    ){
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
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

    fun scheduleNotifications(selectedDays: MutableSet<String>, timeInMilliseconds: Long) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        //TODO clear all previous notifications that were set

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

            // Create a PendingIntent that will launch your notification when the time comes
            val intent = Intent(context, NotificationReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(
                context,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )

            // Schedule the alarm using the AlarmManager, possibly use setExact or setExactAndAllowWhileIdle
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
        }
    }

    companion object{
        const val COUNTER_CHANNEL_ID = "calendar_channel"
    }
}