package com.androidlearning.screens.kotlinlearning.designpatterns.observer.ui

import com.androidlearning.arch.CoreEvent

sealed class ObserverPatternScreenEvents : CoreEvent {
    data class ObserversBlockInputValueChanged(val newValue: String) : ObserverPatternScreenEvents()
    data class AddObserver(val name: String) : ObserverPatternScreenEvents()

    data class EventManagersBlockInputValueChanged(val newValue: String) : ObserverPatternScreenEvents()
    data class AddEventManager(val name: String) : ObserverPatternScreenEvents()
    data class EventManagerInputFieldValueChanged(
        val eventManagerData: ObserverPatternScreenState.EventManagerData,
        val newValue: String
    ) : ObserverPatternScreenEvents()
    data class SendEvent(val eventManagerData: ObserverPatternScreenState.EventManagerData) : ObserverPatternScreenEvents()
    data class AddObserverToEventManager(
        val eventManagerData: ObserverPatternScreenState.EventManagerData,
        val observerData: ObserverPatternScreenState.ObserverData
    ) : ObserverPatternScreenEvents()
}