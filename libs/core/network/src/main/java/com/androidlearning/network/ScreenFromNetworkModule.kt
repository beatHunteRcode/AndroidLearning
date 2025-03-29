package com.androidlearning.network

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScreenFromNetworkModule() {
    Text(
        modifier = Modifier.padding(40.dp),
        text = "Text from :network module: Hello from the other module",
        fontSize = 50.sp
    )
}