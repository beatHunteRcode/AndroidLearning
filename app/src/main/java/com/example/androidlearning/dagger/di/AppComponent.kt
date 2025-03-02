package com.example.androidlearning.dagger.di

import com.example.androidlearning.dagger.Computer
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun getComputer(): Computer
}