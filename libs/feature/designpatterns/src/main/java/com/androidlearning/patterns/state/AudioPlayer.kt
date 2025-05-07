package com.androidlearning.patterns.state

class AudioPlayer {

    private var state: AudioPlayerState = ReadyState(this)
    private var isPlaying: Boolean = false
    private val playlist = listOf(
        "Deus Ex - Main Theme",
        "Limp Bizkit - Just Like This",
        "Marcin Przybylowicz - V",
        "Michael Van den Bos - Foregone Destruction",
        "Sonic Mayhem - Quake II OST"
    )
    private var currentTrackIndex = 0


    fun changeState(newState: AudioPlayerState) {
        this.state = newState
    }

    fun getState() = state

    fun setPlaying(isPlaying: Boolean) {
        this.isPlaying = isPlaying
    }

    fun isPlaying() = isPlaying

    fun startPlayback(): String {
        return "Playing: ${playlist[currentTrackIndex]}"
    }

    fun nextTrack() : String {
        currentTrackIndex++
        if (currentTrackIndex > playlist.size - 1) {
            currentTrackIndex = 0
        }
        return "Playing: ${playlist[currentTrackIndex]}"
    }

    fun previousTrack() : String {
        currentTrackIndex--
        if (currentTrackIndex < 0) {
            currentTrackIndex = playlist.size - 1
        }
        return "Playing: ${playlist[currentTrackIndex]}"
    }

    fun setCurrentTrackAfterStop() {
        this.currentTrackIndex = 0
    }

}