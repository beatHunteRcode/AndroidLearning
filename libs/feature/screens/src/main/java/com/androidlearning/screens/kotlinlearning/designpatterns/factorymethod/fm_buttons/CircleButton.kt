package com.androidlearning.screens.kotlinlearning.designpatterns.factorymethod.fm_buttons

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.androidlearning.arch.EventTrigger
import com.androidlearning.patterns.factorymethod.FMButton
import com.androidlearning.screens.R


class CircleButton<T>(private val onClickEvent: T) : FMButton<T> {

    @Composable
    override fun render(eventTrigger: EventTrigger<T>) {
        Button(
            onClick = {
                eventTrigger.invoke(onClickEvent)
            },
            shape = CircleShape
        ) {
            Text(text = stringResource(R.string.ok_title))
        }
    }

}