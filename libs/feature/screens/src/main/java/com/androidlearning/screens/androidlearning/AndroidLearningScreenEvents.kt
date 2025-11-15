package com.androidlearning.screens.androidlearning

import com.androidlearning.arch.CoreEvent

sealed class AndroidLearningScreenEvents : CoreEvent {
    data object JetpackComposeEssentialsButtonClicked : AndroidLearningScreenEvents()
    data object ANRExampleButtonClicked : AndroidLearningScreenEvents()
}