package com.androidlearning.screens.kotlinlearning.designpatterns

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
internal fun DesignPatternsScreen(viewModel: DesignPatternsScreenViewModel) {
    CoreComposeScreen(viewModel = viewModel) { _, onEvent ->
        Screen(onEvent)
    }
}

@Composable
private fun Screen(
    onEvent: EventTrigger<DesignPatternsScreenEvents>
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = {
                onEvent(DesignPatternsScreenEvents.ObserverButtonClicked)
            }
        ) {
            Text(text = stringResource(R.string.observer_title))
        }

        Button(
            onClick = {
                onEvent(DesignPatternsScreenEvents.FactoryMethodButtonClicked)
            }
        ) {
            Text(text = stringResource(R.string.factory_method_title))
        }

        Button(
            onClick = {
                onEvent(DesignPatternsScreenEvents.AbstractFactoryButtonClicked)
            }
        ) {
            Text(text = stringResource(R.string.abstract_factory_title))
        }

        Button(
            onClick = {
                onEvent(DesignPatternsScreenEvents.AdapterButtonClicked)
            }
        ) {
            Text(text = stringResource(R.string.adapter_title))
        }

        Button(
            onClick = {
                onEvent(DesignPatternsScreenEvents.StateButtonClicked)
            }
        ) {
            Text(text = stringResource(R.string.state_title))
        }
    }
}