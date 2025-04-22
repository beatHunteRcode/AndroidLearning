package com.androidlearning.screens.kotlinlearning.designpatterns.observer.ui

import com.androidlearning.arch.CoreState
import com.androidlearning.screens.kotlinlearning.designpatterns.observer.EventManagerImpl
import com.androidlearning.screens.kotlinlearning.designpatterns.observer.ObserverImpl

data class ObserverPatternScreenState(
    val observerBlockInputTextValue: String,
    val eventManagersBlockInputTextValue: String,
    val observers: List<ObserverData>,
    val eventManagers: List<EventManagerData>
) : CoreState {

    data class ObserverData(
        val observer: ObserverImpl,
        val listeningEventManager: EventManagerImpl? = null
    )

    data class EventManagerData(
        val eventManager: EventManagerImpl,
        val info: String? = null,
        val notAddedObservers: List<ObserverData>
    )

}