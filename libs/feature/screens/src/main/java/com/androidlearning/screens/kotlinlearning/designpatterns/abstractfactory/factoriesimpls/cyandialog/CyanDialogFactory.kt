package com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.factoriesimpls.cyandialog

import com.androidlearning.patterns.abstractfactory.AFBackgroundColor
import com.androidlearning.patterns.abstractfactory.AFButton
import com.androidlearning.patterns.abstractfactory.AFDialogFactory
import com.androidlearning.patterns.abstractfactory.AFText
import com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.ui.AbstractFactoryScreenEvents

class CyanDialogFactory : AFDialogFactory<AbstractFactoryScreenEvents> {

    override fun getText(): AFText = CyanDialogText()

    override fun getButton(): AFButton<AbstractFactoryScreenEvents> = CyanDialogButton(
        onClickEvent = AbstractFactoryScreenEvents.DialogButtonClicked
    )

    override fun getBackgroundColor(): AFBackgroundColor = CyanDialogBackgroundColor()

}