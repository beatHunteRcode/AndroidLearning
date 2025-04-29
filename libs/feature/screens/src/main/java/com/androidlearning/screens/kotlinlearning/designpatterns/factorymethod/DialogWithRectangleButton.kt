package com.androidlearning.screens.kotlinlearning.designpatterns.factorymethod

import com.androidlearning.patterns.factorymethod.FMButton
import com.androidlearning.patterns.factorymethod.FMDialog
import com.androidlearning.screens.kotlinlearning.designpatterns.factorymethod.fm_buttons.RectangleButton
import com.androidlearning.screens.kotlinlearning.designpatterns.factorymethod.ui.FactoryMethodPatternScreenEvents

internal class DialogWithRectangleButton(
    private val onButtonClickEvent: FactoryMethodPatternScreenEvents
) : FMDialog<FactoryMethodPatternScreenEvents>() {
    override fun createButton(): FMButton<FactoryMethodPatternScreenEvents> =
        RectangleButton(onClickEvent = onButtonClickEvent)
}