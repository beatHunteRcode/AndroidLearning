package com.androidlearning.screens.androidlearning.screens.anrexample

import androidx.lifecycle.viewModelScope
import com.androidlearning.arch.CoreViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

class ANRExampleScreenViewModel : CoreViewModel<ANRExampleScreenState, ANRExampleScreenEvents>() {

    var count: Int = 0

    override fun createInitialScreenState(): ANRExampleScreenState = ANRExampleScreenState(
        text = ""
    )

    override fun handleEvent(screenEvent: ANRExampleScreenEvents) {
        when (screenEvent) {
            ANRExampleScreenEvents.WhileTrueDispatchersMainImmediateClicked -> {
                whileTrueOnDispatchersMainImmediate()
            }
            ANRExampleScreenEvents.WhileTrueWithSuspendDispatchersMainImmediateClicked -> {
                whileTrueWithSuspendInsideOnDispatchersMainImmediate()
            }
            ANRExampleScreenEvents.WhileTrueDispatchersDefaultClicked -> {

            }
        }
    }

    private fun whileTrueOnDispatchersMainImmediate() {
        viewModelScope.launch {
            while (true) {

            }
        }
    }

    private fun whileTrueWithSuspendInsideOnDispatchersMainImmediate() {
        count = 0
        viewModelScope.launch {
            while (true) {
                updateState(
                    state = stateData().copy(
                        text = "App is running: ${count++}"
                    )
                )
                delay(1000)
            }
        }
    }

    private fun whileTrueOnDispatchersDefault() {
        viewModelScope.launch(Dispatchers.Default) {
            while (true) {
                EmptyCoroutineContext
            }
        }
    }
}