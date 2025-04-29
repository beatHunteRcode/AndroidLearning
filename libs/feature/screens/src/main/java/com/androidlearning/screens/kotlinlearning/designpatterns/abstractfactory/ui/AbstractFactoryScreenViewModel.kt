package com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.ui

import com.androidlearning.arch.CoreViewModel
import com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.factoriesimpls.cyandialog.CyanDialogFactory
import com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.factoriesimpls.greendialog.GreenDialogFactory
import com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.factoriesimpls.purpledialog.PurpleDialogFactory

internal class AbstractFactoryScreenViewModel
    : CoreViewModel<AbstractFactoryScreenState, AbstractFactoryScreenEvents>() {

    override fun createInitialScreenState(): AbstractFactoryScreenState =
        AbstractFactoryScreenState(
            dialogFactory = null
        )

    override fun handleEvent(screenEvent: AbstractFactoryScreenEvents) {
        when (screenEvent) {
            AbstractFactoryScreenEvents.DialogButtonClicked -> {
                updateState(
                    stateData().copy(
                        dialogFactory = null
                    )
                )
            }

            AbstractFactoryScreenEvents.OpenCyanDialog -> {
                updateState(
                    stateData().copy(
                        dialogFactory = CyanDialogFactory()
                    )
                )
            }

            AbstractFactoryScreenEvents.OpenGreenDialog -> {
                updateState(
                    stateData().copy(
                        dialogFactory = GreenDialogFactory()
                    )
                )
            }

            AbstractFactoryScreenEvents.OpenPurpleDialog -> {
                updateState(
                    stateData().copy(
                        dialogFactory = PurpleDialogFactory()
                    )
                )
            }
        }
    }

}