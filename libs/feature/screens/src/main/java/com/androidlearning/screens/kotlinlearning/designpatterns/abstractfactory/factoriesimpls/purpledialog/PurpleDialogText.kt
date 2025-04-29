package com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.factoriesimpls.purpledialog

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.androidlearning.patterns.abstractfactory.AFText
import com.androidlearning.screens.R

class PurpleDialogText : AFText {
    @Composable
    override fun render() {
        Text(
            text = stringResource(R.string.this_is_purpledialog_text_title)
        )
    }
}