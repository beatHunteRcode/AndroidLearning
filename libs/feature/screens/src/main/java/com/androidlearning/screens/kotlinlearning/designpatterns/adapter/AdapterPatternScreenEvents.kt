package com.androidlearning.screens.kotlinlearning.designpatterns.adapter

import com.androidlearning.arch.CoreEvent

sealed class AdapterPatternScreenEvents : CoreEvent {
    data object RenderComposeItem : AdapterPatternScreenEvents()
    data object RenderComposeItemFromComposeItemAdapter : AdapterPatternScreenEvents()
    data object Clear : AdapterPatternScreenEvents()
}