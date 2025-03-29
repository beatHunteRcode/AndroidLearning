package com.example.androidlearning

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidlearning.network.ScreenFromNetworkModule

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                Text(
                    modifier = Modifier.padding(40.dp),
                    text = "Text from :app module: ABOBA",
                    fontSize = 50.sp
                )
                ScreenFromNetworkModule()
            }
        }
    }

}