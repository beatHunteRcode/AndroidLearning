package com.androidlearning.screens.secondscreen

import com.androidlearning.arch.CoreViewModel
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination

internal class SecondScreenViewModel(
    private val appNavigator: AppNavigator
) : CoreViewModel<SecondScreenState, SecondScreenEvents>() {
    override fun createInitialScreenState(): SecondScreenState = SecondScreenState()

    override fun handleEvent(screenEvent: SecondScreenEvents) {
        when (screenEvent) {
            SecondScreenEvents.NavigateToFirstScreen -> {
                appNavigator.navigateTo(
                    route = Destination.FirstScreen.fullRoute,
                    popUpToRoute = null,
                    inclusive = false
                )
            }
        }
    }
}