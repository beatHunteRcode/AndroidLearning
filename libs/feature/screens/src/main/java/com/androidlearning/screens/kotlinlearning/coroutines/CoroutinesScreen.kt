package com.androidlearning.screens.kotlinlearning.coroutines

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.androidlearning.arch.ButtonState
import com.androidlearning.arch.CoreComposeScreen
import com.androidlearning.arch.EventTrigger
import com.androidlearning.screens.R
import com.androidlearning.uikit.ScreenLayoutSize
import com.androidlearning.uikit.TextSize
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset

@Composable
internal fun CoroutinesScreen(viewModel: CoroutinesScreenViewModel) {
    CoreComposeScreen(viewModel = viewModel) { state, onEvent ->
        Screen(
            screenState = state,
            onEvent
        )
    }
}

@Composable
private fun Screen(
    screenState: State<CoroutinesScreenState>,
    onEvent: EventTrigger<CoroutinesScreenEvents>
) {
    val state = screenState.value

    Column(
        modifier = Modifier
            .fillMaxWidthWithEdgeOffset()
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier.padding(ScreenLayoutSize.dp8),
            fontSize = TextSize.sp40,
            text = stringResource(R.string.coroutines_title)
        )
        ThreadsBlock(
            state = state.threadsBlockState,
            onEvent = onEvent
        )
        Spacer(modifier = Modifier.height(ScreenLayoutSize.dp16))
        CoroutinesBlock(
            state = state.coroutinesBlockState,
            onEvent = onEvent
        )
    }
}

@Composable
private fun ThreadsBlock(
    state: CoroutinesScreenState.ThreadsBlockState,
    onEvent: EventTrigger<CoroutinesScreenEvents.ThreadsBlockEvents>
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidthWithEdgeOffset()
                .padding(bottom = ScreenLayoutSize.dp16),
            horizontalArrangement = Arrangement.spacedBy(ScreenLayoutSize.dp8),
            verticalAlignment = Alignment.Bottom
        ) {
            TextField(
                modifier = Modifier.weight(0.5F),
                value = state.threadsCount.toString(),
                onValueChange = { value ->
                    onEvent(CoroutinesScreenEvents.ThreadsBlockEvents.ThreadsCountChanged(value))
                }
            )
            Button(
                modifier = Modifier.weight(0.5F),
                enabled = state.buttonState != ButtonState.DISABLED,
                onClick = {
                    onEvent(
                        CoroutinesScreenEvents.ThreadsBlockEvents.ButtonClicked
                    )
                }
            ) {
                Text(
                    fontSize = TextSize.sp16,
                    text = stringResource(R.string.run_threads_title)
                )
            }
        }
        if (state.showLoader) {
            CircularProgressIndicator(
                modifier = Modifier.padding(ScreenLayoutSize.dp8)
            )
        }
        Text(
            modifier = Modifier
                .padding(ScreenLayoutSize.dp8)
                .background(Color.White),
            text = state.text
        )
    }
}

@Composable
private fun CoroutinesBlock(
    state: CoroutinesScreenState.CoroutinesBlockState,
    onEvent: EventTrigger<CoroutinesScreenEvents.CoroutinesBlockEvents>
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidthWithEdgeOffset()
                .padding(bottom = ScreenLayoutSize.dp16),
            horizontalArrangement = Arrangement.spacedBy(ScreenLayoutSize.dp8),
            verticalAlignment = Alignment.Bottom
        ) {
            TextField(
                modifier = Modifier.weight(0.5F),
                value = state.coroutinesCount.toString(),
                onValueChange = { value ->
                    onEvent(
                        CoroutinesScreenEvents.CoroutinesBlockEvents.CoroutinesCountChanged(
                            value
                        )
                    )
                }
            )
            Button(
                modifier = Modifier.weight(0.5F),
                enabled = state.buttonState != ButtonState.DISABLED,
                onClick = {
                    onEvent(
                        CoroutinesScreenEvents.CoroutinesBlockEvents.ButtonClicked
                    )
                }
            ) {
                Text(
                    fontSize = TextSize.sp16,
                    text = stringResource(R.string.run_coroutines_title)
                )
            }
        }
        if (state.showLoader) {
            CircularProgressIndicator(
                modifier = Modifier.padding(ScreenLayoutSize.dp8)
            )
        }
        Text(
            modifier = Modifier
                .padding(ScreenLayoutSize.dp8)
                .background(Color.White),
            text = state.text
        )
    }
}