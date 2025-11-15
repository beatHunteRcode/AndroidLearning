package com.androidlearning.screens.androidlearning.screens.anrexample

import com.androidlearning.arch.CoreEvent

sealed class ANRExampleScreenEvents : CoreEvent {
    data object WhileTrueDispatchersMainImmediateClicked : ANRExampleScreenEvents()
    data object WhileTrueWithSuspendDispatchersMainImmediateClicked : ANRExampleScreenEvents()
    data object WhileTrueDispatchersDefaultClicked : ANRExampleScreenEvents()
}