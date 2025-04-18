package com.androidlearning.screens.initial

import com.androidlearning.arch.CoreEvent

sealed class InitialScreenEvents : CoreEvent {
    data object KotlinLearningButtonClicked : InitialScreenEvents()
    data object AndroidLearningButtonClicked : InitialScreenEvents()
}