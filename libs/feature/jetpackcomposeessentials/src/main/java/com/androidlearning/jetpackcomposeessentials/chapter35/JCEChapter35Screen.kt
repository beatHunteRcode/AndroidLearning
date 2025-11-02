package com.androidlearning.jetpackcomposeessentials.chapter35

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.androidlearning.uikit.ScreenLayoutSize
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset

/**
 * IntrinsicSize provides the parent with information about the maximum
 * or minimum possible width or height of its widest or tallest child. This allows the parent
 * to make sizing decisions based on the sizing needs of its children.
 *
 * //
 *
 * **IntrinsicSize.Min**
 *
 * The height of the Row will be set to the minimum possible
 * height needed to display its tallest child.
 * ```
 * Row(modifier = modifier.height(IntrinsicSize.Min)) {
 * .
 * .
 * }
 * ```
 * //
 *
 * **IntrinsicSize.Max**
 *
 * Similarly, the following code configures the width of a Column to the maximum possible
 * width of its widest child:
 * ```
 * Column(modifier = modifier.width(IntrinsicSize.Max)) {
 * .
 * .
 * }
 * ```
 *
 * //
 *
 * To a composable, you can ask for its IntrinsicSize.Min or IntrinsicSize.Max:
 *
 * - `Modifier.width(IntrinsicSize.Min)` - What's the minimum width you need to display your content properly?
 * - `Modifier.width(IntrinsicSize.Max)` - What's the maximum width you need to display your content properly?
 * - `Modifier.height(IntrinsicSize.Min)` - What's the minimum height you need to display your content properly?
 * - `Modifier.height(IntrinsicSize.Max)` - What's the maximum height you need to display your content properly?
 *
 * For example, if you ask the minIntrinsicHeight of a Text with infinite width constraints
 * in a custom layout, it returns the height of the Text with the text drawn in a single line.
 */
@Composable
internal fun JCEChapter35Screen() {
    Screen()
}

@Composable
private fun Screen() {
    Column(Modifier.fillMaxWidthWithEdgeOffset()) {
        DefaultColumn()
        Spacer(Modifier.height(ScreenLayoutSize.dp48))
        IntrinsicSizeMaxColumn()
        Spacer(Modifier.height(ScreenLayoutSize.dp48))
        IntrinsicSizeMinColumn()
    }
}

@Composable
private fun DefaultColumn() {
    var textState by remember { mutableStateOf("") }
    val onTextChange = { text : String ->
        textState = text
    }

    Column(Modifier.width(ScreenLayoutSize.dp200).padding(ScreenLayoutSize.dp5)) {
        Column {
            Text(
                modifier = Modifier.padding(start = ScreenLayoutSize.dp4),
                text = textState
            )
            Box(Modifier.height(ScreenLayoutSize.dp10).fillMaxWidth().background(Color.Blue))
        }
        Spacer(Modifier.height(ScreenLayoutSize.dp16))
        MyTextField(text = textState, onTextChange = onTextChange)
    }
}

@Composable
private fun IntrinsicSizeMaxColumn() {
    var textState by remember { mutableStateOf("") }
    val onTextChange = { text : String ->
        textState = text
    }

    Column(Modifier.width(ScreenLayoutSize.dp200).padding(ScreenLayoutSize.dp5)) {
        Column(Modifier.width(IntrinsicSize.Max)) {
            Text(
                modifier = Modifier.padding(start = ScreenLayoutSize.dp4),
                text = textState
            )
            Box(Modifier.height(ScreenLayoutSize.dp10).fillMaxWidth().background(Color.Blue))
        }
        Spacer(Modifier.height(ScreenLayoutSize.dp16))
        MyTextField(text = textState, onTextChange = onTextChange)
    }
}

@Composable
private fun IntrinsicSizeMinColumn() {
    var textState by remember { mutableStateOf("") }
    val onTextChange = { text : String ->
        textState = text
    }

    Column(Modifier.width(ScreenLayoutSize.dp200).padding(ScreenLayoutSize.dp5)) {
        Column(Modifier.width(IntrinsicSize.Min)) {
            Text(
                modifier = Modifier.padding(start = ScreenLayoutSize.dp4),
                text = textState
            )
            Box(Modifier.height(ScreenLayoutSize.dp10).fillMaxWidth().background(Color.Blue))
        }
        Spacer(Modifier.height(ScreenLayoutSize.dp16))
        MyTextField(text = textState, onTextChange = onTextChange)
    }
}

@Composable
private fun MyTextField(text: String, onTextChange : (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = onTextChange
    )
}

@Preview(showBackground = true)
@Composable
private fun JCEChapter35ScreenPreview() {
    JCEChapter35Screen()
}