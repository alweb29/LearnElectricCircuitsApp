package com.example.alweb29.learnelectriccircuitsapp.calendar

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.alweb29.learnelectriccircuitsapp.R
import java.sql.Time
import java.time.LocalTime

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val time = intent.getLongExtra("Notification", 0)
        Log.e("Notification", time.toString())
        showNotification(context)
    }

    private fun showNotification(context: Context) {
        val builder = NotificationCompat.Builder(context, CalendarNotificationService.COUNTER_CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_bolt_24)
            .setContentTitle("Comeback and learn!")
            .setContentText("This is your daily reminder to learn")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(context)) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            notify(1, builder.build())
        }
    }
}
