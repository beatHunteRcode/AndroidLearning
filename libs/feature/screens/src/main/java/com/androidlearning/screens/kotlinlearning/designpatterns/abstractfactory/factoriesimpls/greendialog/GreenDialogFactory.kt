package com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.factoriesimpls.greendialog

import com.androidlearning.patterns.abstractfactory.AFBackgroundColor
import com.androidlearning.patterns.abstractfactory.AFButton
import com.androidlearning.patterns.abstractfactory.AFDialogFactory
import com.androidlearning.patterns.abstractfactory.AFText
import com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.ui.AbstractFactoryScreenEvents

class GreenDialogFactory : AFDialogFactory<AbstractFactoryScreenEvents> {

    override fun getText(): AFText = GreenDialogText()

    override fun getButton(): AFButton<AbstractFactoryScreenEvents> = GreenDialogButton(
        onClickEvent = AbstractFactoryScreenEvents.DialogButtonClicked
    )

    override fun getBackgroundColor(): AFBackgroundColor = GreenDialogBackgroundColor()

}