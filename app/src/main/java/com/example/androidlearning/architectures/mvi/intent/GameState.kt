package com.example.androidlearning.architectures.mvi.intent

import com.example.androidlearning.architectures.mvi.model.GameModel

data class GameState(
    val isLoading: Boolean,
    val games: List<GameModel>,
    val errorText: String?
)
