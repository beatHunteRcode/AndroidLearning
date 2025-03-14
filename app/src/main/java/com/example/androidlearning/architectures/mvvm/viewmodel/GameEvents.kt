package com.example.androidlearning.architectures.mvvm.viewmodel

sealed class GameEvents {
    data class CardClicked(val index: Int) : GameEvents()
}