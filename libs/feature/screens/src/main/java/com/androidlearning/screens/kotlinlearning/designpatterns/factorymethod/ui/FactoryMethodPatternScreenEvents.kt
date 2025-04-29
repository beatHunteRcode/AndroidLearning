package com.androidlearning.screens.kotlinlearning.designpatterns.factorymethod.ui

import com.androidlearning.arch.CoreEvent

internal sealed class FactoryMethodPatternScreenEvents : CoreEvent {
    data object DialogButtonClicked : FactoryMethodPatternScreenEvents()
    data object OpenDialogWithCircleButton : FactoryMethodPatternScreenEvents()
    data object OpenDialogWithRectangleButton : FactoryMethodPatternScreenEvents()
}