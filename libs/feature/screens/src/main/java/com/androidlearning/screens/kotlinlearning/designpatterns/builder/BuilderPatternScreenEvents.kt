package com.androidlearning.screens.kotlinlearning.designpatterns.builder

import com.androidlearning.arch.CoreEvent

sealed class BuilderPatternScreenEvents : CoreEvent {
    data class AddName(val name: String) : BuilderPatternScreenEvents()
    data class AddAge(val age: Int) : BuilderPatternScreenEvents()
    data class AddArms(val arms: Int) : BuilderPatternScreenEvents()
    data class AddLegs(val legs: Int) : BuilderPatternScreenEvents()
    data class AddVoice(val voice: String) : BuilderPatternScreenEvents()
    data object BuildCreature : BuilderPatternScreenEvents()
    data object StartCreatingCreature : BuilderPatternScreenEvents()
}