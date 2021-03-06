package com.dicoding.latihan_background_process_dan_networking_2

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class MyJobIntentService : JobIntentService() {
    override fun onHandleWork(intent: Intent) {
        Log.d(TAG, "onHandleWork: Mulai.....")
        val duration = intent.getLongExtra(EXTRA_DURATION, 0)
        try {
            Thread.sleep(duration)
            Log.d(TAG, "onHandleWork: Selesai.....")
        } catch (e: InterruptedException) {
            e.printStackTrace()
            Thread.currentThread().interrupt()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }

    companion object {
        private const val JOB_ID = 1000
        internal const val EXTRA_DURATION = "extra_duration"
        private val TAG = MyJobIntentService::class.java.simpleName
        fun enqueueWork(context: Context, intent: Intent){
            enqueueWork(context, MyJobIntentService::class.java, JOB_ID, intent)
        }
    }
}