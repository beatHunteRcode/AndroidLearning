package com.example.androidlearning.navigation.screens.build_basic_layout

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidlearning.C
import com.example.androidlearning.R
import com.example.androidlearning.navigation.screens.Utils
import kotlinx.coroutines.delay
import kotlin.random.Random


@Preview(
    showBackground = true
)
@Composable
fun TaskManagerScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .semantics { testTag = C.Tag.task_manager_screen }
    ) {
        RepeatButton(text = stringResource(R.string.repeat_text))
        Spacer(modifier = Modifier.height(50.dp))
        TaskManagerImage(
            imageResourceId = R.drawable.ic_task_completed,
            modifier = Modifier.semantics { testTag = C.Tag.task_manager_image }
        )
        Text(
            text = Utils.TASK_MANAGER_FIRST_TEXT,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(0.dp, 24.dp, 0.dp, 8.dp)
                .semantics { testTag = C.Tag.task_manager_first_text }
        )
        Text(
            text = Utils.TASK_MANAGER_SECOND_TEXT,
            fontSize = 16.sp,
            modifier = Modifier.semantics { testTag = C.Tag.task_manager_second_text }
        )
        ButtonsSection()
    }
}

@Composable
fun TaskManagerImage(
    imageResourceId: Int,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = imageResourceId)
    Image(
        painter = image,
        contentDescription = "Task Manager Image",
        modifier = modifier
    )
}

@Composable
fun ButtonsSection(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(0.dp, 20.dp, 0.dp, 0.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)

        ) {
            AnimatedPushButton(
                text = stringResource(R.string.push_me_text),
                modifier = Modifier.semantics { testTag = C.Tag.task_manager_first_button }
            )
            Spacer(modifier = Modifier.width(30.dp))
            AnimatedPushButton(
                text = stringResource(R.string.push_me_text),
                modifier = Modifier.semantics { testTag = C.Tag.task_manager_second_button }
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            AnimatedPushButton(
                text = stringResource(R.string.push_me_text),
                modifier = Modifier.semantics { testTag = C.Tag.task_manager_third_button }
            )
            Spacer(modifier = Modifier.width(30.dp))
            AnimatedPushButton(
                text = stringResource(R.string.push_me_text),
                modifier = Modifier.semantics { testTag = C.Tag.task_manager_fourth_button }
            )
        }
    }
}

@Composable
fun AnimatedPushButton(text: String, modifier: Modifier = Modifier) {
    var isVisible by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = Unit) {
        delay(Random.nextLong(1000, 3000))
        isVisible = true
    }
    AnimatedVisibility(
        visible = isVisible,
        enter = scaleIn(),
        exit = scaleOut()
    ) {
        Button(
            onClick = {
                isVisible = !isVisible
            },
            modifier = modifier
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun RepeatButton(text: String, modifier: Modifier = Modifier) {
    var isVisible by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = Unit) {

    }
    AnimatedVisibility(
        visible = isVisible,
        enter = scaleIn(),
        exit = scaleOut()
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = modifier
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
