package com.androidlearning.screens.kotlinlearning.designpatterns.observer

import com.androidlearning.patterns.observer.Observer


class ObserverImpl(
    override val name: String
) : Observer {

    private var lastReceivedInfo: String? = null

    override fun onEvent(info: String) {
        lastReceivedInfo = info
    }

    fun getLastReceivedInfoOrNull() = lastReceivedInfo

}