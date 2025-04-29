package com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.factoriesimpls.purpledialog

import androidx.compose.ui.graphics.Color
import com.androidlearning.patterns.abstractfactory.AFBackgroundColor

class PurpleDialogBackgroundColor : AFBackgroundColor {
    override fun getColor(): Color = Color.hsv(
        hue = 273F,
        saturation = 0.78F,
        value = 0.99F
    )
}