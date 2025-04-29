package com.androidlearning.patterns.factorymethod

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import com.androidlearning.arch.EventTrigger
import com.androidlearning.designpatterns.R
import com.androidlearning.uikit.ScreenLayoutSize
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset

abstract class FMDialog<T> {

    /**
     * Factory Method
     */
    abstract fun createButton() : FMButton<T>

    @Composable
    fun renderDialog(eventTrigger: EventTrigger<T>) {
        val button = createButton()

        Dialog(
            onDismissRequest = {}
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidthWithEdgeOffset()
                    .background(color = Color.White)
                    .padding(ScreenLayoutSize.dp48),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = stringResource(R.string.this_is_the_dialog_title))

                button.render(eventTrigger)
            }

        }
    }

}