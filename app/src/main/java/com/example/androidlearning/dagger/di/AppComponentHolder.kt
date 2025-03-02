package com.example.androidlearning.dagger.di

object AppComponentHolder {

    private var _appComponent: AppComponent? = null

    internal val appComponent: AppComponent
        get() = checkNotNull(_appComponent) {
            "AppComponent isn't initialized: AppComponentHolder.appComponent == null"
        }

    fun initAppComponent() {
        _appComponent = DaggerAppComponent.create()
    }

}