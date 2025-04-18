package com.androidlearning.screens.kotlinlearning.designpatterns

import com.androidlearning.arch.CoreEvent

sealed class DesignPatternsScreenEvents : CoreEvent {
    data object ObserverButtonClicked : DesignPatternsScreenEvents()
}