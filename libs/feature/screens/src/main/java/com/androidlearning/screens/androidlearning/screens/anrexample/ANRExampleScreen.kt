package com.androidlearning.screens.androidlearning.screens.anrexample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.androidlearning.arch.CoreComposeScreen
import com.androidlearning.arch.EventTrigger
import com.androidlearning.uikit.ScreenLayoutSize

@Composable
internal fun ANRExampleScreen(viewModel: ANRExampleScreenViewModel) {
    CoreComposeScreen(viewModel = viewModel) { state, onEvent ->
        Screen(state, onEvent)
    }
}

@Composable
private fun Screen(
    state: State<ANRExampleScreenState>,
    onEvent: EventTrigger<ANRExampleScreenEvents>
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        CircularProgressIndicator()
        Button(
            onClick = {
                onEvent(ANRExampleScreenEvents.WhileTrueDispatchersMainImmediateClicked)
            }
        ) {
            Text(text = "while (true) \n Dispatchers.Main.immediate (ANR)")
        }
        Button(
            onClick = {
                onEvent(ANRExampleScreenEvents.WhileTrueWithSuspendDispatchersMainImmediateClicked)
            }
        ) {
            Text(text = "while (true) with suspend inside \n Dispatchers.Main.immediate")
        }
        Button(
            onClick = {
                onEvent(ANRExampleScreenEvents.WhileTrueDispatchersDefaultClicked)
            }
        ) {
            Text(text = "while (true) \n Dispatchers.Default")
        }
        Spacer(Modifier.height(ScreenLayoutSize.dp48))
        Text(
            text = state.value.text,
            fontSize = 40.sp
        )
    }
}