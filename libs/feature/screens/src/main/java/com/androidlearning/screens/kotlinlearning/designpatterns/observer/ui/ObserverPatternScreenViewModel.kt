package com.androidlearning.screens.kotlinlearning.designpatterns.observer.ui

import com.androidlearning.arch.CoreViewModel
import com.androidlearning.screens.kotlinlearning.designpatterns.observer.EventManagerImpl
import com.androidlearning.screens.kotlinlearning.designpatterns.observer.ObserverImpl

class ObserverPatternScreenViewModel : CoreViewModel<ObserverPatternScreenState, ObserverPatternScreenEvents>() {

    override fun createInitialScreenState(): ObserverPatternScreenState = ObserverPatternScreenState(
        observerBlockInputTextValue = "",
        eventManagersBlockInputTextValue = "",
        observers = listOf(),
        eventManagers = listOf()
    )

    override fun handleEvent(screenEvent: ObserverPatternScreenEvents) {
        when (screenEvent) {
            is ObserverPatternScreenEvents.ObserversBlockInputValueChanged -> {
                updateState(
                    stateData().copy(
                        observerBlockInputTextValue = screenEvent.newValue
                    )
                )
            }
            is ObserverPatternScreenEvents.AddObserver -> {
                val updatedObservers = stateData().observers.toMutableList()
                updatedObservers.add(
                    ObserverPatternScreenState.ObserverData(
                        observer = ObserverImpl(name = screenEvent.name)
                    )
                )

                updateState(
                    state = stateData().copy(
                        observers = updatedObservers
                    )
                )
            }
            is ObserverPatternScreenEvents.EventManagersBlockInputValueChanged -> {
                updateState(stateData().copy(
                    eventManagersBlockInputTextValue = screenEvent.newValue
                ))
            }
            is ObserverPatternScreenEvents.AddEventManager -> {
                val updatedEventManagers = stateData().eventManagers.toMutableList()
                updatedEventManagers.add(
                    ObserverPatternScreenState.EventManagerData(
                        eventManager =  EventManagerImpl(name = screenEvent.name),
                        notAddedObservers = stateData().observers
                    )
                )

                updateState(
                    state = stateData().copy(
                        eventManagers = updatedEventManagers
                    )
                )
            }
            is ObserverPatternScreenEvents.AddObserverToEventManager -> {
                val oldObserverData = stateData().observers.find {
                    it == screenEvent.observerData
                }
                val oldEventManagerData = stateData().eventManagers.find {
                    it == screenEvent.eventManagerData
                }
                if (oldObserverData != null && oldEventManagerData != null) {
                    val updatedObserverData = oldObserverData.copy(
                        listeningEventManager = screenEvent.eventManagerData.eventManager
                    )
                    val oldNotAddedObservers = oldEventManagerData.notAddedObservers.toMutableList()
                    oldNotAddedObservers.remove(screenEvent.observerData)
                    oldEventManagerData.eventManager.observers.add(screenEvent.observerData.observer)
                    val updatedEventMangerData = oldEventManagerData.copy(
                        notAddedObservers = oldNotAddedObservers
                    )

                    val updatedScreenEventManagers = stateData().eventManagers.toMutableList()
                    updatedScreenEventManagers.remove(screenEvent.eventManagerData)
                    updatedScreenEventManagers.add(updatedEventMangerData)

                    val updatedScreenObservers = stateData().observers.toMutableList()
                    updatedScreenObservers.remove(screenEvent.observerData)
                    updatedScreenObservers.add(updatedObserverData)

                    updateState(state = stateData().copy(
                        observers = updatedScreenObservers,
                        eventManagers = updatedScreenEventManagers
                    ))
                }
            }
            is ObserverPatternScreenEvents.SendEvent -> {
                screenEvent.eventManagerData.eventManager.sendEvent(screenEvent.eventManagerData.info ?: "")
                val oldEventManagers = stateData().eventManagers
                val updatedEventManager = oldEventManagers.find {
                    it == screenEvent.eventManagerData
                }?.copy(
                    info = ""
                )
                updatedEventManager?.let {
                    val updatedEventManagers = oldEventManagers.toMutableList()
                    updatedEventManagers.remove(screenEvent.eventManagerData)
                    updatedEventManagers.add(updatedEventManager)

                    updateState(
                        stateData().copy(
                            observers = stateData().observers,
                            eventManagers = updatedEventManagers
                        )
                    )
                }
            }

            is ObserverPatternScreenEvents.EventManagerInputFieldValueChanged -> {
                val updatedEventManagerData = stateData().eventManagers.find {
                    it == screenEvent.eventManagerData
                }?.copy(
                    info = screenEvent.newValue
                )
                updatedEventManagerData?.let {
                    val updatedEventManagers = stateData().eventManagers.toMutableList()
                    updatedEventManagers.remove(screenEvent.eventManagerData)
                    updatedEventManagers.add(updatedEventManagerData)
                    updateState(stateData().copy(
                        eventManagers = updatedEventManagers
                    ))
                }
            }
        }
    }
}