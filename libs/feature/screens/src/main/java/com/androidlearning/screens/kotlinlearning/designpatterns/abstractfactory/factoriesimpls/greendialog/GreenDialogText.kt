package com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.factoriesimpls.greendialog

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.androidlearning.patterns.abstractfactory.AFText
import com.androidlearning.screens.R

class GreenDialogText : AFText {
    @Composable
    override fun render() {
        Text(
            text = stringResource(R.string.this_is_greendialog_text_title)
        )
    }
}