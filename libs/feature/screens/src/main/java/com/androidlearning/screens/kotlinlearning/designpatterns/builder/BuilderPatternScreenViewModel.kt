package com.androidlearning.screens.kotlinlearning.designpatterns.builder

import com.androidlearning.arch.CoreViewModel
import com.androidlearning.patterns.builder.Creature

class BuilderPatternScreenViewModel :
    CoreViewModel<BuilderPatternScreenState, BuilderPatternScreenEvents>() {
    override fun createInitialScreenState(): BuilderPatternScreenState =
        BuilderPatternScreenState(
            creatures = listOf(),
            isCreating = false
        )

    private var currentCreature: Creature = Creature.Builder().build()

    override fun handleEvent(screenEvent: BuilderPatternScreenEvents) {
        when (screenEvent) {
            is BuilderPatternScreenEvents.AddName -> {
                currentCreature = Creature.Builder(currentCreature)
                    .name(screenEvent.name)
                    .build()
            }

            is BuilderPatternScreenEvents.AddAge -> {
                currentCreature = Creature.Builder(currentCreature)
                    .age(screenEvent.age)
                    .build()
            }

            is BuilderPatternScreenEvents.AddArms -> {
                currentCreature = Creature.Builder(currentCreature)
                    .arms(screenEvent.arms)
                    .build()
            }

            is BuilderPatternScreenEvents.AddLegs -> {
                currentCreature = Creature.Builder(currentCreature)
                    .legs(screenEvent.legs)
                    .build()
            }

            is BuilderPatternScreenEvents.AddVoice -> {
                currentCreature = Creature.Builder(currentCreature)
                    .voice(screenEvent.voice)
                    .build()
            }

            BuilderPatternScreenEvents.BuildCreature -> {
                val updatedCreatures = stateData().creatures.toMutableList()
                updatedCreatures.add(currentCreature)
                updateState(
                    stateData().copy(
                        creatures = updatedCreatures,
                        isCreating = false
                    )
                )
            }

            BuilderPatternScreenEvents.StartCreatingCreature -> {
                updateState(
                    stateData().copy(
                        isCreating = true
                    )
                )
            }
        }
    }
}