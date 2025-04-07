package com.androidlearning.screens.secondscreen

import com.androidlearning.arch.CoreEvent

internal sealed class SecondScreenEvents : CoreEvent {
    data object NavigateToFirstScreen : SecondScreenEvents()
}