package com.androidlearning.screens.kotlinlearning.designpatterns.factorymethod.ui

import com.androidlearning.arch.CoreState
import com.androidlearning.patterns.factorymethod.FMDialog

internal data class FactoryMethodPatternScreenState(
    val dialog: FMDialog<FactoryMethodPatternScreenEvents>?
) : CoreState