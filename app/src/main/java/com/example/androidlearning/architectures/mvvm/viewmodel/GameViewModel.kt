package com.example.androidlearning.architectures.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidlearning.architectures.mvvm.model.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GameViewModel (
    private val repository: GameRepository
) : ViewModel() {

    private val stateFlow = MutableStateFlow(createInitialState())

    fun getState() = stateFlow.asStateFlow()

    fun handleScreenEvents(event: GameEvents) {
        when (event) {
            is GameEvents.CardClicked -> {
                val updatedGames = getState().value.games.toMutableList()
                updatedGames.removeAt(event.index)

                viewModelScope.launch {
                    stateFlow.emit(
                        getState().value.copy(
                            games = updatedGames
                        )
                    )
                }
            }
        }
    }

    suspend fun getGames() {
            try {
                val games = repository.getGames()
                stateFlow.emit(
                    GameState(
                        isLoading = false,
                        games = games,
                        errorText = null
                    )
                )
            } catch (ex: Exception) {
                stateFlow.emit(
                    GameState(
                        isLoading = false,
                        games = emptyList(),
                        errorText = ex.message
                    )
                )
            }
    }

    private fun createInitialState() = GameState(
        isLoading = true,
        games = emptyList(),
        errorText = null
    )


}