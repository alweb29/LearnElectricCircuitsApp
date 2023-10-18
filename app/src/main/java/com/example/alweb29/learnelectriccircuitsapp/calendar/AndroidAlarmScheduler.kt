package com.example.alweb29.learnelectriccircuitsapp.calendar

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.util.Log

class AndroidAlarmScheduler (
    private val context: Context
) : AlarmScheduler{

    private var notificationsList = mutableListOf<Long>()
    private val alarmManager = context.getSystemService(AlarmManager::class.java)

    @SuppressLint("ScheduleExactAlarm")
    override fun schedule(item: Long) {

        val intent = Intent(context, NotificationReceiver::class.java).apply {
            putExtra("Notification", item)
        }

        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            item,
            PendingIntent.getBroadcast(
                context,
                item.hashCode(),
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        )

        notificationsList.add(item)
        Log.e("NOTIFICATION Added", notificationsList.toString())
    }

    override fun cancel(item: Long) {
        alarmManager.cancel(
            PendingIntent.getBroadcast(
                context,
                item.hashCode(),
                Intent(context, NotificationReceiver::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        )
        Log.e("NOTIFICATION removed", notificationsList.toString())
        notificationsList.remove(item)
    }

    fun clearAllNotifications(){
        for (item in notificationsList){
            if (item >= Calendar.getInstance().timeInMillis){
                cancel(item)
            }
        }
        notificationsList.clear()
    }
}