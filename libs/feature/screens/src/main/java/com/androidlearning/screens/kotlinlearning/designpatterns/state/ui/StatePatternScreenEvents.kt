package com.androidlearning.screens.kotlinlearning.designpatterns.state.ui

import com.androidlearning.arch.CoreEvent

sealed class StatePatternScreenEvents : CoreEvent {
    data object PlayClicked : StatePatternScreenEvents()
    data object LockClicked : StatePatternScreenEvents()
    data object NextClicked : StatePatternScreenEvents()
    data object PreviousClicked : StatePatternScreenEvents()
}