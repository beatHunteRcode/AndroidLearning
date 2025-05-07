package com.androidlearning.screens.kotlinlearning.designpatterns.state.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.androidlearning.arch.CoreComposeScreen
import com.androidlearning.arch.EventTrigger
import com.androidlearning.screens.R
import com.androidlearning.uikit.ScreenLayoutSize
import com.androidlearning.uikit.TextSize
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset

/**
 * Reference - [Состояние. RefactoringGuru.](https://refactoringguru.cn/ru/design-patterns/state)
 */
@Composable
internal fun StatePatternScreen(viewModel: StatePatternScreenViewModel) {
    CoreComposeScreen(viewModel = viewModel) { state, onEvent ->
        Screen(
            screenState = state,
            onEvent = onEvent
        )
    }
}

@Composable
private fun Screen(
    screenState: State<StatePatternScreenState>,
    onEvent: EventTrigger<StatePatternScreenEvents>
) {
    val state = screenState.value

    Text(
        modifier = Modifier.padding(ScreenLayoutSize.dp8),
        fontSize = TextSize.sp40,
        text = stringResource(R.string.state_title)
    )
    Column(
        modifier = Modifier
            .fillMaxWidthWithEdgeOffset()
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.background(color = Color.White),
            text = "AudioPlayer"
        )
        Text(
            text = state.audioPlayerString
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    onEvent(
                        StatePatternScreenEvents.PlayClicked
                    )
                }
            ) {
                Image(
                    modifier = Modifier.size(ScreenLayoutSize.dp48),
                    painter = painterResource(R.drawable.play),
                    contentDescription = null
                )
            }
            Button(
                onClick = {
                    onEvent(
                        StatePatternScreenEvents.LockClicked
                    )
                }
            ) {
                Image(
                    modifier = Modifier.size(ScreenLayoutSize.dp48),
                    painter = painterResource(R.drawable.stop),
                    contentDescription = null
                )
            }
            Button(
                onClick = {
                    onEvent(
                        StatePatternScreenEvents.PreviousClicked
                    )
                }
            ) {
                Image(
                    modifier = Modifier.size(ScreenLayoutSize.dp48),
                    painter = painterResource(R.drawable.previous),
                    contentDescription = null
                )
            }
            Button(
                onClick = {
                    onEvent(
                        StatePatternScreenEvents.NextClicked
                    )
                }
            ) {
                Image(
                    modifier = Modifier.size(ScreenLayoutSize.dp48),
                    painter = painterResource(R.drawable.next),
                    contentDescription = null
                )
            }
        }
    }
}