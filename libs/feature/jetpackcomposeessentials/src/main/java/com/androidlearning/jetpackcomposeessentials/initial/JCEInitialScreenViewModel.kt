package com.androidlearning.jetpackcomposeessentials.initial

import com.androidlearning.arch.CoreViewModel
import com.androidlearning.arch.EmptyScreenState

internal class JCEInitialScreenViewModel : CoreViewModel<EmptyScreenState, JCEInitialScreenEvents>() {

    override fun createInitialScreenState(): EmptyScreenState = EmptyScreenState()

    override fun handleEvent(screenEvent: JCEInitialScreenEvents) {
        TODO("Not yet implemented")
    }

}