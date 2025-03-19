package com.example.androidlearning.google_codelabs

import android.app.Application
import com.example.androidlearning.dagger.di.AppComponentHolder

class AndroidLearningApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppComponentHolder.initAppComponent()
    }

}