package com.androidlearning.jetpackcomposeessentials.initial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.androidlearning.arch.CoreComposeScreen
import com.androidlearning.arch.EventTrigger
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset

@Composable
internal fun JCEInitialScreen(viewModel: JCEInitialScreenViewModel) {
    CoreComposeScreen(viewModel = viewModel) { _, onEvent ->
        Screen(onEvent)
    }
}

@Composable
private fun Screen(onEvent: EventTrigger<JCEInitialScreenEvents>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidthWithEdgeOffset(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        JCEChapter.entries.forEach { chapter ->
            item {
                Button(onClick = { onEvent(JCEInitialScreenEvents.JCEChapterButtonClicked(chapter)) }) {
                    Text(text = stringResource(chapter.chapterTitleResId))
                }
            }
        }
    }
}