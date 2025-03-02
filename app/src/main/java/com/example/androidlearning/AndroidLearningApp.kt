package com.example.androidlearning

import android.app.Application
import com.example.androidlearning.dagger.di.AppComponentHolder

class AndroidLearningApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppComponentHolder.initAppComponent()
    }

}