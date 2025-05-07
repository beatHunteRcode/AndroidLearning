package com.androidlearning.screens.kotlinlearning.designpatterns.adapter

import androidx.compose.material.Text
import androidx.compose.ui.res.stringResource
import com.androidlearning.arch.CoreViewModel
import com.androidlearning.patterns.adapter.ComposeItemAdapter
import com.androidlearning.screens.R

internal class AdapterPatternScreenViewModel : CoreViewModel<AdapterPatternScreenState, AdapterPatternScreenEvents>() {

    override fun createInitialScreenState() = AdapterPatternScreenState(
        renderComposeItem = false,
        composeItemAdapter = null
    )

    override fun handleEvent(screenEvent: AdapterPatternScreenEvents) {
        when (screenEvent) {
            AdapterPatternScreenEvents.RenderComposeItem -> {
                updateState(stateData().copy(
                    renderComposeItem = true
                ))
            }
            AdapterPatternScreenEvents.RenderComposeItemFromComposeItemAdapter -> {
                updateState(stateData().copy(
                    composeItemAdapter = getComposeItemAdapter()
                ))
            }

            AdapterPatternScreenEvents.Clear -> {
                updateState(stateData().copy(
                    renderComposeItem = false,
                    composeItemAdapter = null
                ))
            }
        }
    }

    private fun getComposeItemAdapter() = ComposeItemAdapter {
        Text(
            text = stringResource(R.string.this_is_compose_item_from_composeItemAdapter_title)
        )
    }

}