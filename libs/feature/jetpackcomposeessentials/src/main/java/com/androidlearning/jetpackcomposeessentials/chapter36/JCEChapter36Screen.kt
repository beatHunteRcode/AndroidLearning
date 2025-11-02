package com.androidlearning.jetpackcomposeessentials.chapter36

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.androidlearning.uikit.ScreenLayoutSize
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * It is not possible to launch coroutines a composable function because it can cause adverse side
 * effects. In the context of Jetpack Compose, a side effect occurs when asynchronous code makes
 * changes to the state of a composable from a different scope without taking into consideration
 * the lifecycle of that composable. The risk here is the potential for a coroutine to continue
 * running after the composable exits, a particular problem if the coroutine is still executing
 * and making state changes the next time the composable runs.
 *
 * `LaunchedEffect` and `SideEffect` composables are considered safe to launch coroutines because
 * they are aware of the lifecycle of the parent composable.
 * When a `LaunchedEffect` composable containing coroutine launch code is called,
 * the coroutine will immediately launch and begin executing the asynchronous code.
 * As soon as the parent composable completes, the `LaunchedEffect` instance and coroutine are destroyed.
 * As long as the values of any of the key parameters in `LaunchedEffect` remain unchanged, `LaunchedEffect` will keep
 * the same coroutine running through multiple recompositions of the parent composable. If a key value changes,
 * however, `LaunchedEffect` will cancel the current coroutine and launch a new one.
 */
@Composable
internal fun JCEChapter36Screen() {
    Screen()
}

@Composable
private fun Screen() {
    Column {
        CoroutineInComposableBody()
        Spacer(Modifier.height(ScreenLayoutSize.dp48))
        CoroutineInLaunchedEffect()
    }
}

@Composable
private fun CoroutineInComposableBody() {
    val coroutineScope = rememberCoroutineScope()
    var textValue by remember { mutableIntStateOf(0) }

    coroutineScope.launch(Dispatchers.Default) {
        while (true) {
            textValue += 1
            delay(1000)
        }
    }

    Column(modifier = Modifier.fillMaxWidthWithEdgeOffset()) {
        Text(
            text = "Text: $textValue",
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(ScreenLayoutSize.dp16))
    }
}

@Composable
private fun CoroutineInLaunchedEffect() {
    var textValue by remember { mutableIntStateOf(0) }
    var isChecked by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = isChecked) {
        textValue = 0
        while (true) {
            delay(1000)
            textValue += 1
        }
    }

    Column(modifier = Modifier.fillMaxWidthWithEdgeOffset()) {
        Text(
            text = "Text: $textValue",
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(ScreenLayoutSize.dp16))
        Switch(
            checked = isChecked,
            onCheckedChange = {
                isChecked = !isChecked
            }
        )
    }
}