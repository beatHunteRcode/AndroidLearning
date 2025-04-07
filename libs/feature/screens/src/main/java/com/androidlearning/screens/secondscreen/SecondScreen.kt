package com.androidlearning.screens.secondscreen

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
internal fun SecondScreen(viewModel: SecondScreenViewModel) {
    CoreComposeScreen(viewModel = viewModel) { screenState, onEvent ->
        Screen(
            state = screenState,
            onEvent = onEvent
        )
    }
}

@Composable
private fun Screen(
    state: State<SecondScreenState>,
    onEvent: EventTrigger<SecondScreenEvents>
) {
    Column {
        Text(
            modifier = Modifier.padding(40.dp),
            text = "Text from second screen: LOL",
            fontSize = 50.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            onEvent(SecondScreenEvents.NavigateToFirstScreen)
        }) {
            Text(
                "To First screeen"
            )
        }
    }
}