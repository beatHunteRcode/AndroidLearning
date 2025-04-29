package com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.factoriesimpls.greendialog

import androidx.compose.ui.graphics.Color
import com.androidlearning.patterns.abstractfactory.AFBackgroundColor

class GreenDialogBackgroundColor : AFBackgroundColor {
    override fun getColor(): Color = Color.Green
}