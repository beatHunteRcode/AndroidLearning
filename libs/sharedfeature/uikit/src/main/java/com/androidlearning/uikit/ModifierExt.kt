package com.androidlearning.uikit

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier

fun Modifier.fillMaxWidthWithEdgeOffset() = this
    .fillMaxWidth()
    .padding(horizontal = ScreenLayoutSize.dp16)