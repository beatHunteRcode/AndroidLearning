package com.androidlearning.jetpackcomposeessentials.chapter4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.androidlearning.uikit.ScreenLayoutSize
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset

@Composable
internal fun JCEChapter4Screen() {
    Screen()
}

@Composable
private fun Screen() {
    var sliderValue by remember { mutableFloatStateOf(20F) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidthWithEdgeOffset()
            .fillMaxHeight()
    ) {
        DemoText(
            message = "ABOBA",
            fontSize = sliderValue
        )
        Spacer(Modifier.height(ScreenLayoutSize.dp8))
        DemoSlider(
            sliderValue = sliderValue,
            onValueChanged = { value ->
                sliderValue = value
            }
        )
    }
}

@Composable
private fun DemoSlider(
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

@Composable
private fun DemoText(message: String, fontSize: Float) {
    Text(
        text = message,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold
    )
}

@Preview
@Composable
private fun DemoTextPreview() {
    MaterialTheme {
        DemoText(message = "Welcome to Android", fontSize = 12f)
    }
}
