package com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.factoriesimpls.purpledialog

import com.androidlearning.patterns.abstractfactory.AFBackgroundColor
import com.androidlearning.patterns.abstractfactory.AFButton
import com.androidlearning.patterns.abstractfactory.AFDialogFactory
import com.androidlearning.patterns.abstractfactory.AFText
import com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.ui.AbstractFactoryScreenEvents

class PurpleDialogFactory : AFDialogFactory<AbstractFactoryScreenEvents> {

    override fun getText(): AFText = PurpleDialogText()

    override fun getButton(): AFButton<AbstractFactoryScreenEvents> = PurpleDialogButton(
        onClickEvent = AbstractFactoryScreenEvents.DialogButtonClicked
    )

    override fun getBackgroundColor(): AFBackgroundColor = PurpleDialogBackgroundColor()

}