package com.example.androidlearning

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidlearning.navigation.screens.compose_essentials.WellnessTaskItem

data class WellnessTask(val id: Int, val goal: Int, val label: String, var checked: Boolean = false)

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    currentCounter: Int
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Tasks List",
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
        LazyColumn(
            modifier = modifier.height(300.dp)
        ) {
            items(
                items = list,
                key = { task -> task.id }
            ) { task ->
                WellnessTaskItem(
                    taskName = task.label,
                    goal = task.goal,
                    checked = task.checked,
                    onCheckedChange = { checked -> onCheckedTask(task, checked) },
                    onClose = { onCloseTask(task) },
                    currentCounter = currentCounter
                )
            }
        }
    }
}
