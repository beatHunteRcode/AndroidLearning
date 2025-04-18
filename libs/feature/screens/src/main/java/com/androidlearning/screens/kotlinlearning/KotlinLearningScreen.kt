package com.androidlearning.screens.kotlinlearning

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
internal fun KotlinLearningScreen(viewmodel: KotlinLearningScreenViewModel) {
    CoreComposeScreen(viewModel = viewmodel) { _, onEvent ->
        Screen(onEvent)
    }
}

@Composable
private fun Screen(
    onEvent: EventTrigger<KotlinLearningScreenEvents>
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = {
                onEvent(KotlinLearningScreenEvents.DesignPatternsButtonClicked)
            }
        ) {
            Text(text = stringResource(R.string.design_patterns_title))
        }
    }
}