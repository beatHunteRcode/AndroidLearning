package com.androidlearning.screens.kotlinlearning.designpatterns.factorymethod.ui

import com.androidlearning.arch.CoreViewModel
import com.androidlearning.screens.kotlinlearning.designpatterns.factorymethod.DialogWithCircleButton
import com.androidlearning.screens.kotlinlearning.designpatterns.factorymethod.DialogWithRectangleButton

internal class FactoryMethodPatternScreenViewModel :
    CoreViewModel<FactoryMethodPatternScreenState, FactoryMethodPatternScreenEvents>() {

    override fun createInitialScreenState(): FactoryMethodPatternScreenState =
        FactoryMethodPatternScreenState(
            dialog = null
        )

    override fun handleEvent(screenEvent: FactoryMethodPatternScreenEvents) {
        when (screenEvent) {
            FactoryMethodPatternScreenEvents.DialogButtonClicked -> {
                updateState(
                    stateData().copy(
                        dialog = null
                    )
                )
            }

            FactoryMethodPatternScreenEvents.OpenDialogWithCircleButton -> {
                updateState(
                    stateData().copy(
                        dialog = DialogWithCircleButton(
                            onButtonClickEvent = FactoryMethodPatternScreenEvents.DialogButtonClicked
                        )
                    )
                )
            }

            FactoryMethodPatternScreenEvents.OpenDialogWithRectangleButton -> {
                updateState(
                    stateData().copy(
                        dialog = DialogWithRectangleButton(
                            onButtonClickEvent = FactoryMethodPatternScreenEvents.DialogButtonClicked
                        )
                    )
                )
            }
        }
    }

}