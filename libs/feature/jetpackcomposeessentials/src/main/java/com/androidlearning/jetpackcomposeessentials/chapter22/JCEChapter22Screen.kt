package com.androidlearning.jetpackcomposeessentials.chapter22

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.androidlearning.uikit.ScreenLayoutSize
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset

/**
 * staticCompositionLocalOf() - is recommended for storing state values that are unlikely to change very
 * often. This is because any changes to the state value will cause the entire tree beneath where the value is assigned
 * to be recomposed.
 */
val LocalColor = staticCompositionLocalOf { Color.Cyan }

/**
 * compositionLocalOf() - function should be used when dealing with
 *  states that change frequently. It will cause recomposition to be
 *  performed on composables where the current state is accessed.
 */
val LocalIsChecked = compositionLocalOf { false }

@Composable
internal fun JCEChapter22Screen() {
    Screen()
}

@Composable
private fun Screen() {
    Composable1()
}

@Composable
private fun Composable1() {
    var isChecked by remember { mutableStateOf(false) }

    val color = if (!isSystemInDarkTheme()) {
        Color.Blue
    } else {
        Color.Magenta
    }

    Column(
        modifier = Modifier.fillMaxWidthWithEdgeOffset(),
        verticalArrangement = Arrangement.Center
    ) {
        Switch(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
            }
        )

        Spacer(modifier = Modifier.height(ScreenLayoutSize.dp48))

        Composable2()

        CompositionLocalProvider(LocalColor provides color, LocalIsChecked provides isChecked) {
            Composable3()
        }
    }
}

@Composable
private fun Composable2() {
    Composable4()
}

@Composable
private fun Composable3() {
    Row {
        Text(
            modifier = Modifier.background(LocalColor.current),
            text = "Composable 3",
        )
        Spacer(modifier = Modifier.width(ScreenLayoutSize.dp16))
        Text("isChecked: ${LocalIsChecked.current}")
    }
    CompositionLocalProvider(LocalColor provides Color.Red) {
        Composable5()
    }
}

@Composable
private fun Composable4() {
    Composable6()
}

@Composable
private fun Composable5() {
    Text(
        modifier = Modifier.background(LocalColor.current),
        text = "Composable 5"
    )

    CompositionLocalProvider(LocalColor provides Color.Green) {
        Composable7()
    }

    CompositionLocalProvider(LocalColor provides Color.Yellow) {
        Composable8()
    }
}

@Composable
fun Composable6() {
    Row {
        Text(
            modifier = Modifier.background(LocalColor.current),
            text = "Composable 6"
        )
        Spacer(modifier = Modifier.width(ScreenLayoutSize.dp16))
        Text("isChecked: ${LocalIsChecked.current}")
    }
}

@Composable
private fun Composable7() {
    Text(
        modifier = Modifier.background(LocalColor.current),
        text = "Composable 7"
    )
}

@Composable
fun Composable8() {
    Text(
        modifier = Modifier.background(LocalColor.current),
        text = "Composable 8"
    )
}

@Preview(showBackground = true)
@Composable
fun LightPreview() {
    Composable1()
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DarkPreview() {
    Composable1()
}