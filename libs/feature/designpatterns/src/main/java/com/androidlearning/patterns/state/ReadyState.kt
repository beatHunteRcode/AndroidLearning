package com.androidlearning.patterns.state

class ReadyState(override val audioPlayer: AudioPlayer) : AudioPlayerState() {

    override fun onLock(): String {
        audioPlayer.changeState(LockedState(audioPlayer))
        return "Locked"
    }

    override fun onPlay(): String {
        val playActionOnReadyState = audioPlayer.startPlayback()
        audioPlayer.changeState(PlayingState(audioPlayer))
        return playActionOnReadyState
    }

    override fun onNext(): String {
        return "Start playback first"
    }

    override fun onPrevious(): String {
        return "Start playback first"
    }

}