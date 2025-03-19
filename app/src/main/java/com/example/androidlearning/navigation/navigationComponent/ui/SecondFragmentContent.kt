package com.example.androidlearning.navigation.navigationComponent.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androidlearning.R

@Composable
fun SecondFragmentContent(navController: NavController) {
    Column(
        modifier = Modifier.padding(all = 16.dp),
    ) {
        Text(
            text = "SecondFragment",
            fontSize = 60.sp
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = {
                navController.navigate(R.id.action_firstFragment)
            }
        ) {
            Text("TO FirstFragment")
        }
    }
}