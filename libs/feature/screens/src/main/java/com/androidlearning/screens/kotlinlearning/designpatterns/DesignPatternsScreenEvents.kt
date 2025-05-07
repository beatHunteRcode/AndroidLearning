package com.androidlearning.screens.kotlinlearning.designpatterns

import com.androidlearning.arch.CoreEvent

sealed class DesignPatternsScreenEvents : CoreEvent {
    data object ObserverButtonClicked : DesignPatternsScreenEvents()
    data object FactoryMethodButtonClicked : DesignPatternsScreenEvents()
    data object AbstractFactoryButtonClicked : DesignPatternsScreenEvents()
    data object AdapterButtonClicked : DesignPatternsScreenEvents()
    data object StateButtonClicked : DesignPatternsScreenEvents()
}