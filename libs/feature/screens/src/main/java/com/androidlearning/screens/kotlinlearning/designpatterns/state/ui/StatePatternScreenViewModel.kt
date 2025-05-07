package com.androidlearning.screens.kotlinlearning.designpatterns.state.ui

import com.androidlearning.arch.CoreViewModel
import com.androidlearning.patterns.state.AudioPlayer

class StatePatternScreenViewModel : CoreViewModel<StatePatternScreenState, StatePatternScreenEvents>() {

    private val audioPlayer: AudioPlayer = AudioPlayer()

    override fun createInitialScreenState() = StatePatternScreenState(
        audioPlayerString = ""
    )

    override fun handleEvent(screenEvent: StatePatternScreenEvents) {
        when (screenEvent) {
            StatePatternScreenEvents.LockClicked -> {
                updateState(
                    stateData().copy(
                        audioPlayerString = audioPlayer.getState().onLock()
                    )
                )
            }

            StatePatternScreenEvents.NextClicked -> {
                updateState(
                    stateData().copy(
                        audioPlayerString = audioPlayer.getState().onNext()
                    )
                )
            }

            StatePatternScreenEvents.PlayClicked -> {
                updateState(
                    stateData().copy(
                        audioPlayerString = audioPlayer.getState().onPlay()
                    )
                )
            }

            StatePatternScreenEvents.PreviousClicked -> {
                updateState(
                    stateData().copy(
                        audioPlayerString = audioPlayer.getState().onPrevious()
                    )
                )
            }
        }
    }

}