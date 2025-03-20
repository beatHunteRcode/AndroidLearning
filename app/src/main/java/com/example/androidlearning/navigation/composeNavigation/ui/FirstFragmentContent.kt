package com.example.androidlearning.navigation.composeNavigation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androidlearning.navigation.composeNavigation.navigation.NavFragment

@Composable
fun FirstFragmentContent(navController: NavController) {

    val text = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(all = 16.dp),
    ) {
        Text(text = "Navigation by Jetpack Compose Navigation",
            fontSize = 30.sp)
        Text(
            text = "FirstFragment",
            fontSize = 50.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = text.value,
            onValueChange = {
                text.value = it
            }
        )
        Button(
            onClick = {
                navController.navigate(NavFragment.SecondFragment.withArgs(text.value))
            }
        ) {
            Text("TO SecondFragment")
        }
    }
}