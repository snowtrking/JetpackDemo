package com.example.jetpackdemo.common

import android.app.Application
import android.content.Context

open class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        lateinit var context: Context
    }
}