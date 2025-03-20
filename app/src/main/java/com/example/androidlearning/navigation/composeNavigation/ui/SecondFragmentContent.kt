package com.example.androidlearning.navigation.composeNavigation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androidlearning.navigation.composeNavigation.navigation.NavFragment

@Composable
fun SecondFragmentContent(
    navController: NavController,
    inputText: String
) {
    Column(
        modifier = Modifier.padding(all = 16.dp),
    ) {
        Text(text = "Navigation by Jetpack Compose Navigation",
            fontSize = 30.sp)
        Text(
            text = "SecondFragment",
            fontSize = 50.sp
        )
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            text = inputText,
            textDecoration = TextDecoration.Underline,
            fontSize = 50.sp
        )
        Button(
            onClick = {
                navController.navigate(NavFragment.FirstFragment.route)
            }
        ) {
            Text("TO FirstFragment")
        }
    }
}