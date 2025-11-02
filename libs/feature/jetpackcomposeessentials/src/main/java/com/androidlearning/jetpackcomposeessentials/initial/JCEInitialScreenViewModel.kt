package com.androidlearning.jetpackcomposeessentials.initial

import com.androidlearning.arch.CoreViewModel
import com.androidlearning.arch.EmptyScreenState
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination

internal class JCEInitialScreenViewModel(
    private val appNavigator: AppNavigator
) : CoreViewModel<EmptyScreenState, JCEInitialScreenEvents>() {

    override fun createInitialScreenState(): EmptyScreenState = EmptyScreenState()

    override fun handleEvent(screenEvent: JCEInitialScreenEvents) {
        when (screenEvent) {
            is JCEInitialScreenEvents.JCEChapterButtonClicked -> {
                navigateToChapterScreen(screenEvent.chapter)
            }
        }
    }

    private fun navigateToChapterScreen(chapter: JCEChapter) {
        appNavigator.navigateTo(
            route = when (chapter) {
                JCEChapter.CHAPTER_4 -> Destination.JCEChapter4Screen.fullRoute
                JCEChapter.CHAPTER_20 -> Destination.JCEChapter20Screen.fullRoute
                JCEChapter.CHAPTER_21 -> Destination.JCEChapter21Screen.fullRoute
                JCEChapter.CHAPTER_22 -> Destination.JCEChapter22Screen.fullRoute
                JCEChapter.CHAPTER_35 -> Destination.JCEChapter35Screen.fullRoute
                JCEChapter.CHAPTER_36 -> Destination.JCEChapter36Screen.fullRoute
            }
        )
    }

}