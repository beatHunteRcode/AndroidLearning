package com.androidlearning.screens.kotlinlearning.designpatterns.builder

import com.androidlearning.arch.CoreState
import com.androidlearning.patterns.builder.Creature

data class BuilderPatternScreenState(
    val creatures: List<Creature>,
    val isCreating: Boolean
) : CoreState