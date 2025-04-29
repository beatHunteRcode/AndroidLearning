package com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.ui

import com.androidlearning.arch.CoreState
import com.androidlearning.patterns.abstractfactory.AFDialogFactory

data class AbstractFactoryScreenState(
    val dialogFactory: AFDialogFactory<AbstractFactoryScreenEvents>?
) : CoreState