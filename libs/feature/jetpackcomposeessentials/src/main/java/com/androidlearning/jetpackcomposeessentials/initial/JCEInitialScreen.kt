package com.androidlearning.jetpackcomposeessentials.initial

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
import com.androidlearning.jetpackcomposeessentials.R

@Composable
internal fun JCEInitialScreen(viewModel: JCEInitialScreenViewModel) {
    CoreComposeScreen(viewModel = viewModel) { _, onEvent ->
        Screen(onEvent)
    }
}

@Composable
private fun Screen(onEvent: EventTrigger<JCEInitialScreenEvents>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = {
                onEvent(JCEInitialScreenEvents.JCEChapter4ButtonClicked)
            }
        ) {
            Text(text = stringResource(R.string.jce_chapter_4_title))
        }
    }
}