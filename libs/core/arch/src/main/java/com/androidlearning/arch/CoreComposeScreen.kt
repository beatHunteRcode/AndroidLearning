package com.androidlearning.arch

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState

@Composable
fun <STATE: CoreState, EVENT: CoreEvent> CoreComposeScreen(
    viewModel: CoreViewModel<STATE, EVENT>,
    screen: @Composable (state: State<STATE>, onEvent: EventTrigger<EVENT>) -> Unit
) {
    val screenState = viewModel.state().collectAsState()
    MaterialTheme {
        screen(screenState, viewModel::handleEvent)
    }
}