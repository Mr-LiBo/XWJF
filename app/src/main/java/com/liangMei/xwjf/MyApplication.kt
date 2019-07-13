package com.liangMei.xwjf

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

class MyApplication : Application() {

    companion object {

        var context: Context by Delegates.notNull()

    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

    }

}
