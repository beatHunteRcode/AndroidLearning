package com.androidlearning.screens.kotlinlearning

import com.androidlearning.arch.CoreViewModel
import com.androidlearning.arch.EmptyScreenState
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination

class KotlinLearningScreenViewModel(
    private val appNavigator: AppNavigator
) : CoreViewModel<EmptyScreenState, KotlinLearningScreenEvents>() {
    override fun createInitialScreenState(): EmptyScreenState = EmptyScreenState()

    override fun handleEvent(screenEvent: KotlinLearningScreenEvents) {
        when (screenEvent) {
            KotlinLearningScreenEvents.DesignPatternsButtonClicked -> {
                appNavigator.navigateTo(route = Destination.DesignPatternsScreen.fullRoute)
            }
        }
    }
}