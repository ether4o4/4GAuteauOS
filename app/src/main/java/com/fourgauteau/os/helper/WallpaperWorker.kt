package com.fourgauteau.os.helper

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class WallpaperWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result = Result.success()
}
