package com.androidlearning.patterns.observer

interface EventManager<T : Observer> {

    val observers: MutableList<T>

    fun addObserver(observer: T)
    fun removeObserver(observer: T)
    fun sendEvent(info: String)

}