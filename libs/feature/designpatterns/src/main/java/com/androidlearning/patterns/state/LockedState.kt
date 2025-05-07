package com.androidlearning.patterns.state

internal class LockedState(override val audioPlayer: AudioPlayer) : AudioPlayerState() {

    init {
        audioPlayer.setPlaying(isPlaying = false)
    }

    override fun onLock(): String {
        if (audioPlayer.isPlaying()) {
            audioPlayer.changeState(ReadyState(audioPlayer))
            return "Stop playing"
        } else {
            return "Locked"
        }
    }

    override fun onPlay(): String {
        audioPlayer.changeState(ReadyState(audioPlayer))
        return "Ready to play"
    }

    override fun onNext(): String {
        return "Locked"
    }

    override fun onPrevious(): String {
        return "Locked"
    }
}