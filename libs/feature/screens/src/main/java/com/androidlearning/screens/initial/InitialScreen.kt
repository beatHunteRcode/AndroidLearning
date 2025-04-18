package com.androidlearning.screens.initial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.androidlearning.arch.CoreComposeScreen
import com.androidlearning.arch.EventTrigger
import com.androidlearning.screens.R

@Composable
internal fun InitialScreen(viewModel: InitialScreenViewModel) {
    CoreComposeScreen(viewModel = viewModel) { _, onEvent ->
        Screen(
            onEvent = onEvent
        )
    }
}

@Composable
fun Screen(
    onEvent: EventTrigger<InitialScreenEvents>
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = {
                onEvent(InitialScreenEvents.KotlinLearningButtonClicked)
            }
        ) {
            Text(text = stringResource(R.string.kotlin_learning_title))
        }
        Button(
            onClick = {
                onEvent(InitialScreenEvents.AndroidLearningButtonClicked)
            }
        ) {
            Text(text = stringResource(R.string.android_learning_title))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InitialScreenPreview() {
    MaterialTheme {
        Screen(onEvent = { _: InitialScreenEvents -> }::invoke)
    }
}