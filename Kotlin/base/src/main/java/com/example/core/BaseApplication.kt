package com.example.core

import android.app.Application
import android.content.Context

/**
 * @author wangyou
 * @desc:
 * @date :2021/5/20
 */
class BaseApplication : Application(){
    companion object{
        private lateinit var currentApplication: Context
        @JvmStatic
        fun currentApplication():Context{
            return currentApplication
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        currentApplication = this
    }
}