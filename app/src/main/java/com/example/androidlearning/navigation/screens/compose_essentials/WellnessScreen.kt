package com.example.androidlearning.navigation.screens.compose_essentials

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidlearning.WellnessTask
import com.example.androidlearning.WellnessTasksList
import com.example.androidlearning.WellnessViewModel
import kotlinx.coroutines.delay
import kotlin.random.Random

@Preview(showBackground = true)
@Composable
fun WellnessScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        StatefulCounter()
    }
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var showTask by rememberSaveable { mutableStateOf(true) }
    Column(
        modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        if (showTask) {
//            WellnessTaskItem(
//                taskName = "Have you taken your 15 minute walk today?",
//                onClose = { showTask = false }
//            )
//        }
    }
}

@Composable
fun StatefulCounter(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    var waterCount by rememberSaveable { mutableIntStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTasksList(
            currentCounter = waterCount,
            list = wellnessViewModel.tasks,
            onCheckedTask = { wellnessTask, checked ->
                wellnessViewModel.changeTaskChecked(wellnessTask, checked)
            },
            onCloseTask = { wellnessTask -> wellnessViewModel.remove(wellnessTask) }
        )
        StatelessCounter(counter = waterCount, onIncrement = { waterCount++ }, modifier)
        WaterCountRemoveButton(onRemove = { waterCount = 0 })
    }
}

@Composable
fun StatelessCounter(counter: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    if (counter > 0) {
        Text(
            text = "You've drunk $counter glasses",
            fontSize = 20.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
    Button(
        onClick = { onIncrement() },
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = "Drink",
            fontSize = 20.sp,
            modifier = Modifier.padding(20.dp)
        )
    }
}

@Composable
fun WaterCountRemoveButton(onRemove: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = { onRemove() },
    ) {
        Text(
            text = "Clear Water Count",
            fontSize = 20.sp,
            modifier = Modifier.padding(20.dp)
        )
    }
}

@Composable
fun WellnessTaskItem(
    taskName: String,
    goal: Int,
    checked: Boolean,
    currentCounter: Int,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    var checkedState by rememberSaveable { mutableStateOf(false) }
    var isVisible by rememberSaveable { mutableStateOf(false) }
    if (currentCounter >= goal) {
        checkedState = true
        isVisible = false
    }
    LaunchedEffect(key1 = Unit){
        delay(Random.nextLong(1000, 3000))
        isVisible = true
    }
    AnimatedVisibility(
        visible = isVisible,
        enter = scaleIn(),
        exit = scaleOut()
    ) {
        WellnessTaskItem(
            taskName = taskName,
            checked = checkedState,
            onCheckedChange = { newValue -> checkedState = newValue },
            onClose = {
                onClose()
                isVisible = false
            },
            modifier = modifier
        )
    }
}

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = taskName,
            fontSize = 16.sp,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Close"
            )
        }
    }
}

private fun getWellnessTasks(): List<WellnessTask> = List(20) { i ->
    val goal = Random.nextInt(1, 50)
    WellnessTask(i, goal, "Drink $goal glasses")
}

