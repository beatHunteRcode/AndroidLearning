package com.androidlearning.screens.kotlinlearning.designpatterns.adapter

import com.androidlearning.arch.CoreState
import com.androidlearning.patterns.adapter.ComposeItemAdapter

internal data class AdapterPatternScreenState(
    val renderComposeItem: Boolean,
    val composeItemAdapter: ComposeItemAdapter<Unit>?
) : CoreState