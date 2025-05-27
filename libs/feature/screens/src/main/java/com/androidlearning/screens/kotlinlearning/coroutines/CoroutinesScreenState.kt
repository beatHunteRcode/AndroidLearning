package com.androidlearning.screens.kotlinlearning.coroutines

import com.androidlearning.arch.ButtonState
import com.androidlearning.arch.CoreState

data class CoroutinesScreenState(
    val threadsBlockState: ThreadsBlockState,
    val coroutinesBlockState: CoroutinesBlockState
) : CoreState {

    data class ThreadsBlockState(
        val threadsCount: Int,
        val buttonState: ButtonState,
        val showLoader: Boolean,
        val text: String
    )

    data class CoroutinesBlockState(
        val coroutinesCount: Int,
        val buttonState: ButtonState,
        val showLoader: Boolean,
        val text: String
    )

}