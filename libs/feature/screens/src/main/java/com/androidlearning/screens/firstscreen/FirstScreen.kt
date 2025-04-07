package com.androidlearning.screens.firstscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidlearning.arch.CoreComposeScreen
import com.androidlearning.arch.EventTrigger

@Composable
internal fun FirstScreen(viewModel: FirstScreenViewModel) {
    CoreComposeScreen(viewModel = viewModel) { screenState, onEvent ->
        Screen(
            state = screenState,
            onEvent = onEvent
        )
    }
}

@Composable
private fun Screen(
    state: State<FirstScreenState>,
    onEvent: EventTrigger<FirstScreenEvents>
) {
    Column {
        Text(
            modifier = Modifier.padding(40.dp),
            text = "Text from :screens module: ABOBA",
            fontSize = 50.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            onEvent(FirstScreenEvents.NavigateToSecondScreen)
        }) {
            Text(
                "To SecondScreen"
            )
        }
    }
}