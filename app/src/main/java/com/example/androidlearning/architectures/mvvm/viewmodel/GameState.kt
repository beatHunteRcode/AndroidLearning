package com.example.androidlearning.architectures.mvvm.viewmodel

import com.example.androidlearning.architectures.mvvm.model.GameModel

data class GameState(
    val isLoading: Boolean,
    val games: List<GameModel>,
    val errorText: String?
)
