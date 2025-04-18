package com.androidlearning.screens.initial

import com.androidlearning.arch.CoreViewModel
import com.androidlearning.arch.EmptyScreenState
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination

class InitialScreenViewModel(
    private val appNavigator: AppNavigator
) : CoreViewModel<EmptyScreenState, InitialScreenEvents>() {

    override fun createInitialScreenState(): EmptyScreenState = EmptyScreenState()

    override fun handleEvent(screenEvent: InitialScreenEvents) {
        when (screenEvent) {
            InitialScreenEvents.KotlinLearningButtonClicked -> {
                appNavigator.navigateTo(
                    route = Destination.KotlinLearningScreen.fullRoute
                )
            }
            InitialScreenEvents.AndroidLearningButtonClicked -> {
                TODO()
            }
        }
    }
}