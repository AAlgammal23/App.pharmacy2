package com.alamin.pharma

import android.app.Application
import com.alamin.pharma.sync.SyncWorker

class AlAminApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // جدولة المزامنة الدورية كل 15 دقيقة
        SyncWorker.schedule(this)
    }
}
