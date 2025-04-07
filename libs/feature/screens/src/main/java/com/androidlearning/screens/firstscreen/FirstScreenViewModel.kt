package com.androidlearning.screens.firstscreen

import com.androidlearning.arch.CoreViewModel
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination

internal class FirstScreenViewModel(
    private val appNavigator: AppNavigator
) : CoreViewModel<FirstScreenState, FirstScreenEvents>() {
    override fun createInitialScreenState(): FirstScreenState = FirstScreenState()

    override fun handleEvent(screenEvent: FirstScreenEvents) {
        when (screenEvent) {
            FirstScreenEvents.NavigateToSecondScreen -> {
                appNavigator.navigateTo(
                    route = Destination.SecondScreen.fullRoute,
                    popUpToRoute = null,
                    inclusive = false
                )
            }
        }
    }
}