package com.example.androidlearning.navigation.composeNavigation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlearning.navigation.composeNavigation.navigation.Navigation

/**
 * Reference: [Jetpack Compose Navigation for Beginners - Android Studio Tutorial](https://youtu.be/4gUeyNkGE3g)
 *
 * Before run App, change activity in AndroidManifest to [MainActivityComposeNavigation]
 */
class MainActivityComposeNavigation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }

}