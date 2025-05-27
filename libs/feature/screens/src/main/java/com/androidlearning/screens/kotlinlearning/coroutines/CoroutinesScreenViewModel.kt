package com.androidlearning.screens.kotlinlearning.coroutines

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.androidlearning.arch.ButtonState
import com.androidlearning.arch.CoreViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.time.measureTime

class CoroutinesScreenViewModel : CoreViewModel<CoroutinesScreenState, CoroutinesScreenEvents>() {

    override fun createInitialScreenState() = CoroutinesScreenState(
        threadsBlockState = CoroutinesScreenState.ThreadsBlockState(
            threadsCount = 0,
            buttonState = ButtonState.ENABLED,
            showLoader = false,
            text = ""
        ),
        coroutinesBlockState = CoroutinesScreenState.CoroutinesBlockState(
            coroutinesCount = 0,
            buttonState = ButtonState.ENABLED,
            showLoader = false,
            text = ""
        )
    )

    override fun handleEvent(screenEvent: CoroutinesScreenEvents) {
        when (screenEvent) {
            CoroutinesScreenEvents.ThreadsBlockEvents.ButtonClicked -> {
                val updatedThreadsBlockState = stateData().threadsBlockState.copy(
                    showLoader = true,
                    text = ""
                )
                updateState(
                    stateData().copy(
                        threadsBlockState = updatedThreadsBlockState
                    )
                )
                runThreads(stateData().threadsBlockState.threadsCount)
            }

            is CoroutinesScreenEvents.ThreadsBlockEvents.ThreadsCountChanged -> {
                val updatedThreadsBlockState = stateData().threadsBlockState.copy(
                    threadsCount = screenEvent.value.takeIf { it.isNotBlank() }?.toInt() ?: 0
                )
                updateState(
                    stateData().copy(
                        threadsBlockState = updatedThreadsBlockState
                    )
                )
            }

            CoroutinesScreenEvents.CoroutinesBlockEvents.ButtonClicked -> {
                val updatedCoroutinesBlockState = stateData().coroutinesBlockState.copy(
                    showLoader = true,
                    text = ""
                )
                updateState(
                    stateData().copy(
                        coroutinesBlockState = updatedCoroutinesBlockState
                    )
                )
                runCoroutines(stateData().coroutinesBlockState.coroutinesCount)
            }

            is CoroutinesScreenEvents.CoroutinesBlockEvents.CoroutinesCountChanged -> {
                val updatedCoroutinesBlockState = stateData().coroutinesBlockState.copy(
                    coroutinesCount = screenEvent.value.takeIf { it.isNotBlank() }?.toInt() ?: 0
                )
                updateState(
                    stateData().copy(
                        coroutinesBlockState = updatedCoroutinesBlockState
                    )
                )
            }
        }
    }

    private fun runThreads(count: Int) {
        viewModelScope.launch(Dispatchers.Default) {
            val duration = measureTime {
                for (i in 0..count) {
                    Thread().start()
                }
            }

            val updatedThreadsBlockState = stateData().threadsBlockState.copy(
                showLoader = false,
                text = "Starting $count threads took ${duration.inWholeMilliseconds} milliseconds"
            )
            updateState(
                stateData().copy(
                    threadsBlockState = updatedThreadsBlockState
                )
            )
        }
    }

    private fun runCoroutines(count: Int) {
        viewModelScope.launch(Dispatchers.Default) {
            val duration = measureTime {
                for (i in 0..count) {
                    launch { }
                }
            }

            val updatedCoroutinesBlockState = stateData().coroutinesBlockState.copy(
                showLoader = false,
                text = "Starting $count coroutines took ${duration.inWholeMilliseconds} milliseconds"
            )
            Log.i("DEBUG_PRINT", "Starting $count coroutines took ${duration.inWholeMilliseconds} milliseconds")
            updateState(
                stateData().copy(
                    coroutinesBlockState = updatedCoroutinesBlockState
                )
            )
        }
    }

}