package com.androidlearning.screens.kotlinlearning.designpatterns.observer.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.androidlearning.arch.CoreComposeScreen
import com.androidlearning.arch.EventTrigger
import com.androidlearning.screens.R
import com.androidlearning.screens.kotlinlearning.designpatterns.observer.EventManagerImpl
import com.androidlearning.screens.kotlinlearning.designpatterns.observer.ObserverImpl
import com.androidlearning.uikit.ScreenLayoutSize
import com.androidlearning.uikit.TextSize
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset

/**
 * Reference - [Наблюдатель. RefactoringGuru.](https://refactoringguru.cn/ru/design-patterns/observer)
 */
@Composable
internal fun ObserverPatternScreen(viewModel: ObserverPatternScreenViewModel) {
    CoreComposeScreen(viewModel = viewModel) { state, onEvent ->
        Screen(
            screenState = state,
            onEvent = onEvent
        )
    }
}

@Composable
private fun Screen(
    screenState: State<ObserverPatternScreenState>,
    onEvent: EventTrigger<ObserverPatternScreenEvents>
) {
    val state = screenState.value

    Column(
        modifier = Modifier
            .fillMaxWidthWithEdgeOffset()
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier.padding(bottom = ScreenLayoutSize.dp48),
            fontSize = TextSize.sp40,
            text = stringResource(R.string.observer_title)
        )
        ObserversBlock(
            state = state,
            onEvent = onEvent
        )
        EventManagersBlock(
            state = state,
            onEvent = onEvent
        )
    }
}

@Composable
private fun ObserversBlock(
    state: ObserverPatternScreenState,
    onEvent: EventTrigger<ObserverPatternScreenEvents>
) {
    Text(
        modifier = Modifier.padding(bottom = ScreenLayoutSize.dp8),
        fontSize = TextSize.sp24,
        text = stringResource(R.string.observers_title)
    )
    Row(
        modifier = Modifier
            .fillMaxWidthWithEdgeOffset()
            .padding(bottom = ScreenLayoutSize.dp16),
        horizontalArrangement = Arrangement.spacedBy(ScreenLayoutSize.dp8),
        verticalAlignment = Alignment.Bottom
    ) {
        TextField(
            modifier = Modifier.weight(0.5F),
            value = state.observerBlockInputTextValue,
            onValueChange = { value ->
                onEvent(ObserverPatternScreenEvents.ObserversBlockInputValueChanged(value))
            },
            label = {
                Text(
                    text = stringResource(R.string.observer_name_title)
                )
            }
        )
        Button(
            modifier = Modifier.weight(0.5F),
            onClick = {
                onEvent(ObserverPatternScreenEvents.AddObserver(
                    name = state.observerBlockInputTextValue)
                )
            }
        ) {
            Text(
                fontSize = TextSize.sp16,
                text = stringResource(R.string.add_observer_title)
            )
        }
    }
    state.observers.forEach { observerData ->
        Row(
            modifier = Modifier
                .fillMaxWidthWithEdgeOffset()
                .padding(bottom = ScreenLayoutSize.dp16),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    fontSize = TextSize.sp16,
                    text = observerData.observer.name
                )
                Text(
                    fontSize = TextSize.sp12,
                    text = "Listening: ${observerData.listeningEventManager?.getName()}"
                )
            }
            Text(
                fontSize = TextSize.sp16,
                text = observerData.observer.getLastReceivedInfoOrNull() ?: ""
            )
        }
    }
}

@Composable
private fun EventManagersBlock(
    state: ObserverPatternScreenState,
    onEvent: EventTrigger<ObserverPatternScreenEvents>
) {
    Text(
        modifier = Modifier.padding(bottom = ScreenLayoutSize.dp8),
        fontSize = TextSize.sp24,
        text = stringResource(R.string.event_managers_title)
    )
    Row(
        modifier = Modifier
            .fillMaxWidthWithEdgeOffset()
            .padding(bottom = ScreenLayoutSize.dp16),
        horizontalArrangement = Arrangement.spacedBy(ScreenLayoutSize.dp8),
        verticalAlignment = Alignment.Bottom
    ) {
        TextField(
            modifier = Modifier.weight(0.5F),
            value = state.eventManagersBlockInputTextValue,
            onValueChange = { value ->
                onEvent(ObserverPatternScreenEvents.EventManagersBlockInputValueChanged(value))
            },
            label = {
                Text(
                    text = stringResource(R.string.event_manager_name_title)
                )
            }
        )
        Button(
            modifier = Modifier.weight(0.5F),
            onClick = {
                onEvent(ObserverPatternScreenEvents.AddEventManager(
                    name = state.eventManagersBlockInputTextValue
                ))
            }
        ) {
            Text(
                fontSize = TextSize.sp16,
                text = stringResource(R.string.add_event_manager_title)
            )
        }
    }
    state.eventManagers.forEach { eventManagerData ->
        val observersNames = buildString {
            eventManagerData.eventManager.observers.forEachIndexed { index, observer ->
                append(observer.name)
                if (index != eventManagerData.eventManager.observers.size - 1) {
                    append(", ")
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxWidthWithEdgeOffset()
        ) {
            Row(
                modifier = Modifier
                    .padding(bottom = ScreenLayoutSize.dp16),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        fontSize = TextSize.sp16,
                        text = eventManagerData.eventManager.getName()
                    )
                    Text(
                        fontSize = TextSize.sp12,
                        text = "Subscribers: $observersNames"
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidthWithEdgeOffset(),
                ) {
                    TextField(
                        modifier = Modifier.padding(bottom = ScreenLayoutSize.dp8),
                        value = eventManagerData.info ?: "",
                        onValueChange = { value ->
                            onEvent(
                                ObserverPatternScreenEvents.EventManagerInputFieldValueChanged(
                                    eventManagerData = eventManagerData,
                                    newValue = value
                                )
                            )
                        }
                    )
                    Button(
                        modifier = Modifier.fillMaxWidthWithEdgeOffset(),
                        onClick = {
                            onEvent(
                                ObserverPatternScreenEvents.SendEvent(eventManagerData)
                            )
                        }
                    ) {
                        Text(
                            fontSize = TextSize.sp16,
                            text = stringResource(R.string.send_title)
                        )
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(ScreenLayoutSize.dp8)
            ) {
                eventManagerData.notAddedObservers.forEach { observerData ->
                    Column {
                        Text(text = observerData.observer.name)
                        Button(onClick = {
                            onEvent(ObserverPatternScreenEvents.AddObserverToEventManager(
                                eventManagerData = eventManagerData,
                                observerData = observerData
                            ))
                        }) {
                            Text(text = stringResource(R.string.add_title))
                        }
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ObserverPatternScreenPreview() {
    val state = remember {
        mutableStateOf(
            ObserverPatternScreenState(
                observerBlockInputTextValue = "",
                eventManagersBlockInputTextValue = "",
                observers = listOf(
                    ObserverPatternScreenState.ObserverData(
                        observer = ObserverImpl(
                            name = "Aboba"
                        ).also {
                            it.onEvent("burrrbaloni luliloli")
                        },
                        listeningEventManager = EventManagerImpl("Manager 1")
                    ),
                    ObserverPatternScreenState.ObserverData(
                        ObserverImpl(
                            name = "Biba"
                        ).also {
                            it.onEvent("aloha")
                        },
                        listeningEventManager = EventManagerImpl("Manager 2")
                    ),
                    ObserverPatternScreenState.ObserverData(
                        ObserverImpl(
                            name = "Boba"
                        ).also {
                            it.onEvent("burrrbaloni luliloli")
                        },
                        listeningEventManager = EventManagerImpl("Manager 1")
                    )
                ),
                eventManagers = listOf(
                    ObserverPatternScreenState.EventManagerData(
                        eventManager = EventManagerImpl("Manager 1")
                            .also {
                                it.addObserver(
                                    ObserverImpl(
                                        name = "Aboba"
                                    )
                                )
                                it.addObserver(
                                    ObserverImpl(
                                        name = "Biba"
                                    )
                                )
                            },
                        notAddedObservers = listOf(
                            ObserverPatternScreenState.ObserverData(
                                observer = ObserverImpl(
                                    name = "Boba"
                                )
                            ),
                        )
                    )
                )
            )
        )
    }

    MaterialTheme {
        Screen(
            screenState = state,
            onEvent = { _: ObserverPatternScreenEvents -> }::invoke
        )
    }

}