package com.androidlearning.screens.kotlinlearning.designpatterns

import com.androidlearning.arch.CoreViewModel
import com.androidlearning.arch.EmptyScreenState
import com.androidlearning.navigation.AppNavigator

class DesignPatternsScreenViewModel(
    private val appNavigator: AppNavigator
) : CoreViewModel<EmptyScreenState, DesignPatternsScreenEvents>() {
    override fun createInitialScreenState(): EmptyScreenState = EmptyScreenState()

    override fun handleEvent(screenEvent: DesignPatternsScreenEvents) {
        when (screenEvent) {
            DesignPatternsScreenEvents.ObserverButtonClicked -> {
                TODO()
            }
        }
    }
}