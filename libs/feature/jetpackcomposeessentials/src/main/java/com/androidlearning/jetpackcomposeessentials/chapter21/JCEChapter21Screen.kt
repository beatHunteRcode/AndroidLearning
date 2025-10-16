package com.androidlearning.jetpackcomposeessentials.chapter21

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.androidlearning.uikit.ScreenLayoutSize
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset

@Composable
internal fun JCEChapter21Screen() {
    Screen()
}

@Composable
private fun Screen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidthWithEdgeOffset(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyTextField()

        FunctionA()

        Column {
            var textState by remember { mutableStateOf("") }
            val onTextChange = { text : String ->
                textState = text
            }

            Text(text = "State hoisting example")
            Spacer(modifier = Modifier.height(ScreenLayoutSize.dp4))
            MyTextFieldStateHoisting(
                text = textState,
                onTextChange = onTextChange
            )
            Spacer(modifier = Modifier.height(ScreenLayoutSize.dp16))
            Text(text = textState)
        }

        MyTextFieldSaveable()
    }
}

@Composable
private fun MyTextField() {
    var textState by remember { mutableStateOf("") }
    val onTextChange = { text : String ->
        textState = text
    }
    TextField(
        value = textState,
        onValueChange = onTextChange
    )
}

/**
 * Unidirectional Data Flow example
 *
 * Unidirectional data flow is an approach to app development whereby state stored in a composable
 * should not be directly changed by any child composable functions.
 */
@Composable
private fun FunctionA() {
    var switchState by remember { mutableStateOf(true) }
    val onSwitchChange = { value : Boolean ->
        switchState = value
    }

    FunctionB(
        switchState = switchState,
        onSwitchChange = onSwitchChange
    )
}

@Composable
fun FunctionB(switchState: Boolean, onSwitchChange : (Boolean) -> Unit ) {
    Switch(
        checked = switchState,
        onCheckedChange = onSwitchChange
    )
}

/**
 * State hoisting example
 *
 * The term state hoisting has a similar meaning in that it involves moving state from a child composable up to the
 * calling (parent) composable or a higher ancestor. When the child composable is called by the parent, it is passed
 * the state along with an event handler. When an event occurs in the child composable that requires an update to
 * the state, a call is made to the event handler passing through the new value. This
 * has the advantage of making the child composable stateless and, therefore, easier to reuse.
 */
@Composable
private fun MyTextFieldStateHoisting(text: String, onTextChange : (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = onTextChange
    )
}

/**
 * rememberSaveable example
 *
 * State is not retained through configuration changes unless
 * specifically configured to do so using the rememberSaveable keyword.
 */
@Composable
private fun MyTextFieldSaveable() {
    var textState by rememberSaveable { mutableStateOf("") }
    val onTextChange = { text : String ->
        textState = text
    }
    Column {
        Text(text = "rememberSaveable example")
        Spacer(modifier = Modifier.height(ScreenLayoutSize.dp4))
        TextField(
            value = textState,
            onValueChange = onTextChange
        )
        Spacer(modifier = Modifier.height(ScreenLayoutSize.dp16))
        Text(text = textState)
    }
}

@Preview(showBackground = true)
@Composable
fun JCEChapter21ScreenPreview() {
    Screen()
}