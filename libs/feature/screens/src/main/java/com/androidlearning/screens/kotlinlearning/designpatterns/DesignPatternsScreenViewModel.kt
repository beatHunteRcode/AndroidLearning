package com.androidlearning.screens.kotlinlearning.designpatterns

import com.androidlearning.arch.CoreViewModel
import com.androidlearning.arch.EmptyScreenState
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination

class DesignPatternsScreenViewModel(
    private val appNavigator: AppNavigator
) : CoreViewModel<EmptyScreenState, DesignPatternsScreenEvents>() {
    override fun createInitialScreenState(): EmptyScreenState = EmptyScreenState()

    override fun handleEvent(screenEvent: DesignPatternsScreenEvents) {
        when (screenEvent) {
            DesignPatternsScreenEvents.ObserverButtonClicked -> {
                appNavigator.navigateTo(route = Destination.ObserverPatternScreen.fullRoute)
            }

            DesignPatternsScreenEvents.FactoryMethodButtonClicked -> {
                appNavigator.navigateTo(route = Destination.FactoryMethodPatternScreen.fullRoute)
            }

            DesignPatternsScreenEvents.AbstractFactoryButtonClicked -> {
                appNavigator.navigateTo(route = Destination.AbstractFactoryPatternScreen.fullRoute)
            }

            DesignPatternsScreenEvents.AdapterButtonClicked -> {
                appNavigator.navigateTo(route = Destination.AdapterPatternScreen.fullRoute)
            }

            DesignPatternsScreenEvents.StateButtonClicked -> {
                appNavigator.navigateTo(route = Destination.StatePatternScreen.fullRoute)
            }
        }
    }
}