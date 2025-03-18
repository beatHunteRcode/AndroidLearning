package com.example.androidlearning.architectures.mvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewModelScope
import com.example.androidlearning.architectures.mvi.model.GameRepository
import com.example.androidlearning.architectures.mvi.view.GameScreen
import com.example.androidlearning.architectures.mvi.intent.GameViewModel
import kotlinx.coroutines.launch

/**
 * Reference: [MVI Architecture in Android](https://www.scaler.com/topics/android/mvi-architecture-android/)
 *
 * Difference between MVVM and MVI: [MVVM vs. MVI - Understand the Difference Once and for All](https://youtu.be/b2z1jvD4VMQ)
 *
 * Before run App, change activity in AndroidManifest to [MainActivityMVI]
 *
 * - Model: Represents the data and business logic of the application, typically does not have any direct knowledge of the user interface. Represented by [GameRepository] handling logic and data.
 * - View: This layer represents the user interface elements. It focuses on displaying data and handling user interactions without any logic or knowledge about the data itself. The UI elements represented by Composable functions in [GameScreen].
 * - Intent: The Intent component represents the user's intention or action within the application. It encapsulates the user interactions captured by the View and serves as a signal to the Model for state updates or other operations. Intents are stored in [GameEvents] and handled by [GameViewModel.handleScreenEvents]
 */
class MainActivityMVI : ComponentActivity() {

    private val viewModel = GameViewModel(repository = GameRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.viewModelScope.launch {
            viewModel.getGames()
        }

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                GameScreen(
                    viewModel = viewModel
                )
            }
        }
    }

}