package com.androidlearning.jetpackcomposeessentials

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.androidlearning.uikit.ScreenLayoutSize

@Composable
fun DemoSlider(
    sliderValue: Float,
    onValueChanged: (Float) -> Unit
) {
    Slider(
        modifier = Modifier.padding(ScreenLayoutSize.dp10),
        valueRange = 20f..38f,
        value = sliderValue,
        onValueChange = { value -> onValueChanged(value) }
    )
}