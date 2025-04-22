package com.androidlearning.arch

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class CoreViewModel<STATE : CoreState, EVENT : CoreEvent>
    : ViewModel(), DefaultLifecycleObserver {

    private val screenStateFlow = MutableStateFlow(this.createInitialScreenState())

    fun stateData() = screenStateFlow.value

    fun state() = screenStateFlow

    abstract fun createInitialScreenState(): STATE

    abstract fun handleEvent(screenEvent: EVENT)

    fun updateState(state: STATE) {
        viewModelScope.launch(Dispatchers.Default) {
            screenStateFlow.emit(state)
        }
    }

}