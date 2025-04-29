package com.androidlearning.screens.kotlinlearning.designpatterns.factorymethod.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
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
 * Reference - [Фабричный метод. RefactoringGuru.](https://refactoringguru.cn/ru/design-patterns/factory-method)
 */
@Composable
internal fun FactoryMethodPatternScreen(viewModel: FactoryMethodPatternScreenViewModel) {
    CoreComposeScreen(viewModel = viewModel) { state, onEvent ->
        Screen(
            screenState = state,
            onEvent = onEvent
        )
    }
}

@Composable
private fun Screen(
    screenState: State<FactoryMethodPatternScreenState>,
    onEvent: EventTrigger<FactoryMethodPatternScreenEvents>
) {
    val state = screenState.value

    Text(
        modifier = Modifier.padding(ScreenLayoutSize.dp8),
        fontSize = TextSize.sp40,
        text = stringResource(R.string.factory_method_title)
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
                    FactoryMethodPatternScreenEvents.OpenDialogWithCircleButton
                )
            }
        ) {
            Text(
                fontSize = TextSize.sp16,
                text = stringResource(R.string.open_dialog_with_circle_button_title)
            )
        }
        Button(
            onClick = {
                onEvent(
                    FactoryMethodPatternScreenEvents.OpenDialogWithRectangleButton
                )
            }
        ) {
            Text(
                fontSize = TextSize.sp16,
                text = stringResource(R.string.open_dialog_with_rectangle_button_title)
            )
        }
    }

    if (state.dialog != null) {
        state.dialog.renderDialog(eventTrigger = onEvent)
    }
}