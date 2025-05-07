package com.androidlearning.patterns.state

class PlayingState(override val audioPlayer: AudioPlayer) : AudioPlayerState() {

    override fun onLock(): String {
        audioPlayer.changeState(LockedState(audioPlayer))
        return "Stop playing"
    }

    override fun onPlay(): String {
        audioPlayer.changeState(ReadyState(audioPlayer))
        return "Paused"
    }

    override fun onNext(): String {
        return audioPlayer.nextTrack()
    }

    override fun onPrevious(): String {
        return audioPlayer.previousTrack()
    }

}