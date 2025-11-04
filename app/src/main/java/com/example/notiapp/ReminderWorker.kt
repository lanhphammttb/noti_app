package com.example.notiapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class ReminderWorker(appContext: Context, params: WorkerParameters) : CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        val notification = NotificationCompat.Builder(applicationContext, MainActivity.REMINDER_CHANNEL_ID)
            .setContentTitle("Noti App Reminder")
            .setContentText("It's time for your scheduled task.")
            .setSmallIcon(android.R.drawable.ic_popup_reminder)
            .setAutoCancel(true)
            .build()

        with(NotificationManagerCompat.from(applicationContext)) {
            if (ActivityCompat.checkSelfPermission(
                    applicationContext,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED || Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU
            ) {
                notify(REMINDER_NOTIFICATION_ID, notification)
            }
        }

        return Result.success()
    }

    companion object {
        private const val REMINDER_NOTIFICATION_ID = 1001
    }
}
