package com.example.android.wearable.composeforwearos.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.android.wearable.composeforwearos.repository.BlogRepository
import com.example.android.wearable.composeforwearos.utils.NotificationHelper

class BlogNotificationWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        try {
            val blogs = BlogRepository().getPublishedBlogs()
            if (blogs.isNotEmpty()) {
                val latest = blogs.maxByOrNull { it.date } ?: blogs.first()
                NotificationHelper.showNotification(
                    applicationContext,
                    latest.title,
                    latest.description.take(100) + "..."
                )
            }
            return Result.success()
        } catch (e: Exception) {
            e.printStackTrace()
            return Result.retry()
        }
    }
}
