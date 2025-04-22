package com.androidlearning.screens.kotlinlearning.designpatterns.observer

import com.androidlearning.patterns.observer.EventManager

class EventManagerImpl(
    private val name: String
) : EventManager<ObserverImpl> {

    override val observers: MutableList<ObserverImpl> = mutableListOf()

    override fun addObserver(observer: ObserverImpl) {
        observers.add(observer)
    }

    override fun removeObserver(observer: ObserverImpl) {
        observers.remove(observer)
    }

    override fun sendEvent(info: String) {
        observers.forEach { observer ->
            observer.onEvent(info)
        }
    }

    fun getName() = name

}