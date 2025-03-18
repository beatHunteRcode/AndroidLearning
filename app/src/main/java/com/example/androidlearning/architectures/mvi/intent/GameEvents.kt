package com.example.androidlearning.architectures.mvi.intent

sealed class GameEvents {
    data class CardClicked(val index: Int) : GameEvents()
}