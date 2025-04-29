package com.androidlearning.patterns.factorymethod

import androidx.compose.runtime.Composable
import com.androidlearning.arch.EventTrigger

interface FMButton<T> {
    @Composable
    fun render(eventTrigger: EventTrigger<T>)
}