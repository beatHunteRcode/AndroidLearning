package com.androidlearning.patterns.abstractfactory

import androidx.compose.runtime.Composable
import com.androidlearning.arch.EventTrigger

interface AFButton<T> {
    @Composable
    fun render(eventTrigger: EventTrigger<T>)
}