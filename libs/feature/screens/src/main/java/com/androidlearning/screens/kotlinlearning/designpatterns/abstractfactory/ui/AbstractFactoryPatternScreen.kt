package com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.ui

import androidx.compose.foundation.background
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
import androidx.compose.ui.window.Dialog
import com.androidlearning.arch.CoreComposeScreen
import com.androidlearning.arch.EventTrigger
import com.androidlearning.screens.R
import com.androidlearning.uikit.ScreenLayoutSize
import com.androidlearning.uikit.TextSize
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset

/**
 * Reference - [Абстрактная фабрика. RefactoringGuru.](https://refactoringguru.cn/ru/design-patterns/abstract-factory)
 */
@Composable
internal fun AbstractFactoryScreen(viewModel: AbstractFactoryScreenViewModel) {
    CoreComposeScreen(viewModel = viewModel) { state, onEvent ->
        Screen(
            screenState = state,
            onEvent = onEvent
        )
    }
}

@Composable
private fun Screen(
    screenState: State<AbstractFactoryScreenState>,
    onEvent: EventTrigger<AbstractFactoryScreenEvents>
) {
    val state = screenState.value

    Text(
        modifier = Modifier.padding(ScreenLayoutSize.dp8),
        fontSize = TextSize.sp40,
        text = stringResource(R.string.abstract_factory_title)
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
                    AbstractFactoryScreenEvents.OpenGreenDialog
                )
            }
        ) {
            Text(
                fontSize = TextSize.sp16,
                text = stringResource(R.string.open_greendialog_title)
            )
        }
        Button(
            onClick = {
                onEvent(
                    AbstractFactoryScreenEvents.OpenCyanDialog
                )
            }
        ) {
            Text(
                fontSize = TextSize.sp16,
                text = stringResource(R.string.open_cyandialog_title)
            )
        }
        Button(
            onClick = {
                onEvent(
                    AbstractFactoryScreenEvents.OpenPurpleDialog
                )
            }
        ) {
            Text(
                fontSize = TextSize.sp16,
                text = stringResource(R.string.open_purpledialog_title)
            )
        }
    }

    if (state.dialogFactory != null) {
        Dialog(
            onDismissRequest = {}
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidthWithEdgeOffset()
                    .background(color = state.dialogFactory.getBackgroundColor().getColor())
                    .padding(ScreenLayoutSize.dp48),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                state.dialogFactory.getText().render()
                state.dialogFactory.getButton().render(onEvent)
            }
        }
    }
}