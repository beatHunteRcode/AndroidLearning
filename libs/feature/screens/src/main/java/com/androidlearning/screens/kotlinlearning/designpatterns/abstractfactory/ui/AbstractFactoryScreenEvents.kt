package com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.ui

import com.androidlearning.arch.CoreEvent

sealed class AbstractFactoryScreenEvents : CoreEvent {
    data object DialogButtonClicked : AbstractFactoryScreenEvents()
    data object OpenGreenDialog : AbstractFactoryScreenEvents()
    data object OpenCyanDialog : AbstractFactoryScreenEvents()
    data object OpenPurpleDialog : AbstractFactoryScreenEvents()
}