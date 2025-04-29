package com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.factoriesimpls.cyandialog

import androidx.compose.ui.graphics.Color
import com.androidlearning.patterns.abstractfactory.AFBackgroundColor

class CyanDialogBackgroundColor : AFBackgroundColor {
    override fun getColor(): Color = Color.Cyan
}