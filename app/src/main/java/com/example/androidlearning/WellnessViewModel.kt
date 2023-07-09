package com.example.androidlearning

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class WellnessViewModel : ViewModel() {

    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask> get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
        tasks.find { wellnessTask -> wellnessTask.id == item.id }?.let { wellnessTask ->
            wellnessTask.checked = checked
        }
    }
}

private fun getWellnessTasks(): List<WellnessTask> = List(20) { i ->
    val goal = Random.nextInt(1, 50)
    WellnessTask(i, goal, "Drink $goal glasses")
}