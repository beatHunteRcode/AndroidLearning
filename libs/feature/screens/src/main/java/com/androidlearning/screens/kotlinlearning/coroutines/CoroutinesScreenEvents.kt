package com.androidlearning.screens.kotlinlearning.coroutines

import com.androidlearning.arch.CoreEvent

sealed class CoroutinesScreenEvents : CoreEvent {

    sealed class ThreadsBlockEvents : CoroutinesScreenEvents() {
        data class ThreadsCountChanged(val value: String) : ThreadsBlockEvents()
        data object ButtonClicked : ThreadsBlockEvents()
    }

    sealed class CoroutinesBlockEvents : CoroutinesScreenEvents() {
        data class CoroutinesCountChanged(val value: String) : CoroutinesBlockEvents()
        data object ButtonClicked : CoroutinesBlockEvents()
    }

}