package com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.factoriesimpls.cyandialog

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.androidlearning.arch.EventTrigger
import com.androidlearning.patterns.abstractfactory.AFButton
import com.androidlearning.screens.R
import com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.ui.AbstractFactoryScreenEvents

class CyanDialogButton(
    private val onClickEvent: AbstractFactoryScreenEvents
) : AFButton<AbstractFactoryScreenEvents> {
    @Composable
    override fun render(eventTrigger: EventTrigger<AbstractFactoryScreenEvents>) {
        Button(
            onClick = {
                eventTrigger.invoke(onClickEvent)
            }
        ) {
            Text(
                text = stringResource(R.string.this_is_cyandialog_button_title)
            )
        }
    }
}