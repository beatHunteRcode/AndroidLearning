package com.androidlearning.screens.firstscreen

import com.androidlearning.arch.CoreEvent

internal sealed class FirstScreenEvents : CoreEvent {
    data object NavigateToSecondScreen : FirstScreenEvents()
}