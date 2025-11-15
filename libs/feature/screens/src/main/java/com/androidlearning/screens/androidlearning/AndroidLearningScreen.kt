package com.androidlearning.screens.androidlearning

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.androidlearning.arch.CoreComposeScreen
import com.androidlearning.arch.EventTrigger
import com.androidlearning.screens.R

@Composable
internal fun AndroidLearningScreen(viewModel: AndroidLearningScreenViewModel) {
    CoreComposeScreen(viewModel = viewModel) { _, onEvent ->
        Screen(onEvent)
    }
}

@Composable
private fun Screen(
    onEvent: EventTrigger<AndroidLearningScreenEvents>
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = {
                onEvent(AndroidLearningScreenEvents.JetpackComposeEssentialsButtonClicked)
            }
        ) {
            Text(text = stringResource(R.string.jetpack_compose_essentials_title))
        }
        Button(
            onClick = {
                onEvent(AndroidLearningScreenEvents.ANRExampleButtonClicked)
            }
        ) {
            Text(text = stringResource(R.string.anr_example_title))
        }
    }
}