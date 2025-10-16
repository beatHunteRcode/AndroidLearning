package com.androidlearning.jetpackcomposeessentials.chapter20

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset

@Composable
internal fun JCEChapter20Screen() {
    Screen()
}

@Composable
private fun Screen() {
    Column(
        modifier = Modifier.fillMaxSize().fillMaxWidthWithEdgeOffset(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        CustomText(
            text = "Hello Compose",
            fontWeight = FontWeight.Bold,
            color = Color.Magenta
        )

        CustomSwitch()

        CustomList(
            items = listOf("One", "Two", "Three", "Four", "Five", "Six")
        )
    }
}

@Composable
fun CustomText(text: String, fontWeight: FontWeight, color: Color) {
    Text(text = text, fontWeight = fontWeight, color = color)
}

@Composable
fun CustomSwitch() {
    val checked = remember { mutableStateOf(true) }
    Column {
        Switch(
            checked = checked.value,
            onCheckedChange = { checked.value = it }
        )
        if (checked.value) {
            Text("Switch is On")
        } else {
            Text("Switch is Off")
        }
    }
}

@Composable
fun CustomList(items: List<String>) {
    Column {
        for (item in items) {
            Text(item)
            HorizontalDivider(color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomText(
        text = "Hello Compose",
        fontWeight = FontWeight.Bold,
        color = Color.Magenta
    )
}

@Preview(showBackground = true)
@Composable
fun CustomSwitchPreview() {
    CustomSwitch()
}

@Preview(showBackground = true)
@Composable
fun CustomListPreview() {
    CustomList(
        items = listOf("One", "Two", "Three", "Four", "Five", "Six")
    )
}