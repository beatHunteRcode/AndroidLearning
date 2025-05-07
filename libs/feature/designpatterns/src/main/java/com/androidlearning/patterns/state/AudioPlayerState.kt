package com.androidlearning.patterns.state

abstract class AudioPlayerState {

    abstract val audioPlayer : AudioPlayer

    abstract fun onLock(): String
    abstract fun onPlay(): String
    abstract fun onNext(): String
    abstract fun onPrevious(): String

}