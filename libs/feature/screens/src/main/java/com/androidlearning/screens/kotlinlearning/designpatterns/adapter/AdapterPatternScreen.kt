package com.androidlearning.screens.kotlinlearning.designpatterns.adapter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.androidlearning.arch.CoreComposeScreen
import com.androidlearning.arch.EventTrigger
import com.androidlearning.screens.R
import com.androidlearning.uikit.ScreenLayoutSize
import com.androidlearning.uikit.TextSize
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset

/**
 * Reference - [Адаптер. RefactoringGuru.](https://refactoringguru.cn/ru/design-patterns/adapter)
 */
@Composable
internal fun AdapterPatternScreen(viewModel: AdapterPatternScreenViewModel) {
    CoreComposeScreen(viewModel = viewModel) { state, onEvent ->
        Screen(
            screenState = state,
            onEvent = onEvent
        )
    }
}

@Composable
private fun Screen(
    screenState: State<AdapterPatternScreenState>,
    onEvent: EventTrigger<AdapterPatternScreenEvents>
) {
    val state = screenState.value

    Text(
        modifier = Modifier.padding(ScreenLayoutSize.dp8),
        fontSize = TextSize.sp40,
        text = stringResource(R.string.adapter_title)
    )
    Column(
        modifier = Modifier
            .fillMaxWidthWithEdgeOffset()
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.padding(bottom = ScreenLayoutSize.dp48),
            onClick = {
                onEvent(
                    AdapterPatternScreenEvents.RenderComposeItem
                )
            }
        ) {
            Text(
                fontSize = TextSize.sp16,
                text = stringResource(R.string.render_compose_item_title)
            )
        }
        if (state.renderComposeItem) {
            Text(
                text = stringResource(R.string.this_is_compose_item_title)
            )
        }
        Button(
            onClick = {
                onEvent(
                    AdapterPatternScreenEvents.RenderComposeItemFromComposeItemAdapter
                )
            }
        ) {
            Text(
                fontSize = TextSize.sp16,
                text = stringResource(R.string.render_compose_item_from_composeItemAdapter_title)
            )
        }
        state.composeItemAdapter?.get()
        Button(
            modifier = Modifier.padding(bottom = ScreenLayoutSize.dp48),
            onClick = {
                onEvent(
                    AdapterPatternScreenEvents.Clear
                )
            }
        ) {
            Text(
                fontSize = TextSize.sp16,
                text = stringResource(R.string.clear_title)
            )
        }
    }
}