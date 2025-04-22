package com.androidlearning.patterns.observer

interface Observer {
    val name: String
    fun onEvent(info: String)
}