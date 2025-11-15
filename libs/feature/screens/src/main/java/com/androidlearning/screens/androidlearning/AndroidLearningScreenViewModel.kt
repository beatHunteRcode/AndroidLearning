package com.androidlearning.screens.androidlearning

import com.androidlearning.arch.CoreViewModel
import com.androidlearning.arch.EmptyScreenState
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination

class AndroidLearningScreenViewModel(
    private val appNavigator: AppNavigator
) : CoreViewModel<EmptyScreenState, AndroidLearningScreenEvents>() {
    override fun createInitialScreenState(): EmptyScreenState = EmptyScreenState()

    override fun handleEvent(screenEvent: AndroidLearningScreenEvents) {
        when (screenEvent) {
            AndroidLearningScreenEvents.JetpackComposeEssentialsButtonClicked -> {
                appNavigator.navigateTo(Destination.JCEInitialScreen.fullRoute)
            }

            AndroidLearningScreenEvents.ANRExampleButtonClicked -> {
                appNavigator.navigateTo(Destination.ANRExampleScreen.fullRoute)
            }
        }
    }
}