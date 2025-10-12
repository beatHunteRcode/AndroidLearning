package com.androidlearning.jetpackcomposeessentials.initial

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.androidlearning.arch.CoreComposeScreen
import com.androidlearning.jetpackcomposeessentials.DemoSlider
import com.androidlearning.jetpackcomposeessentials.DemoText
import com.androidlearning.uikit.ScreenLayoutSize
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset

@Composable
internal fun JCEInitialScreen(viewModel: JCEInitialScreenViewModel) {
    CoreComposeScreen(viewModel = viewModel) { _, _ ->
        Screen()
    }
}

@Composable
private fun Screen() {
    var sliderValue by remember { mutableFloatStateOf(20F) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidthWithEdgeOffset()
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

@Preview(showSystemUi = true)
@Composable
private fun JCEInitialScreenPreview() {
    Screen()
}