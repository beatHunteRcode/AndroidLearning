package com.androidlearning.jetpackcomposeessentials.initial

import com.androidlearning.arch.CoreViewModel
import com.androidlearning.arch.EmptyScreenState
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination

internal class JCEInitialScreenViewModel(
    private val appNavigator: AppNavigator
) : CoreViewModel<EmptyScreenState, JCEInitialScreenEvents>() {

    override fun createInitialScreenState(): EmptyScreenState = EmptyScreenState()

    override fun handleEvent(screenEvent: JCEInitialScreenEvents) {
        when (screenEvent) {
            JCEInitialScreenEvents.JCEChapter4ButtonClicked -> {
                appNavigator.navigateTo(
                    route = Destination.JCEChapter4Screen.fullRoute
                )
            }

            JCEInitialScreenEvents.JCEChapter20ButtonClicked -> {
                appNavigator.navigateTo(
                    route = Destination.JCEChapter20Screen.fullRoute
                )
            }
        }
    }

}