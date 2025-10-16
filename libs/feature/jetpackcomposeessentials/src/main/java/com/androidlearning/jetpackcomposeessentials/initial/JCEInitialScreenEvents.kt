package com.androidlearning.jetpackcomposeessentials.initial

import com.androidlearning.arch.CoreEvent

internal sealed class JCEInitialScreenEvents : CoreEvent {
    data object JCEChapter4ButtonClicked : JCEInitialScreenEvents()
    data object JCEChapter20ButtonClicked : JCEInitialScreenEvents()
}