package com.example.androidlearning.architectures.mvvm.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidlearning.architectures.mvvm.model.GameModel
import com.example.androidlearning.architectures.mvvm.model.GameRepository
import kotlinx.coroutines.launch

class GameViewModel(
    private val repository: GameRepository
) : ViewModel() {

    var isLoading = mutableStateOf(true)
    var games = mutableStateOf(emptyList<GameModel>())
    var errorText = mutableStateOf("")


    fun cardClicked(cardIndex: Int) {
        val updatedGames = games.value.toMutableList()
        updatedGames.removeAt(cardIndex)

        viewModelScope.launch {
            games.value = updatedGames
        }
    }

    suspend fun getGames() {
        try {
            val games = repository.getGames()
            isLoading.value = false
            this.games.value = games
            errorText.value = ""
        } catch (ex: Exception) {
            isLoading.value = false
            this.games.value = emptyList()
            errorText.value = ex.message ?: ""
        }
    }


}