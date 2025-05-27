package com.androidlearning.screens.kotlinlearning

import com.androidlearning.arch.CoreEvent

sealed class KotlinLearningScreenEvents : CoreEvent {
    data object DesignPatternsButtonClicked : KotlinLearningScreenEvents()
    data object CoroutinesButtonClicked : KotlinLearningScreenEvents()
}