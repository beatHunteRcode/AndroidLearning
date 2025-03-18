package com.example.androidlearning.architectures.mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewModelScope
import com.example.androidlearning.architectures.mvvm.model.GameRepository
import com.example.androidlearning.architectures.mvvm.view.GameScreen
import com.example.androidlearning.architectures.mvvm.viewmodel.GameViewModel
import kotlinx.coroutines.launch

/**
 * Reference: [MVVM Architectural Pattern in Android](https://dev.to/mohammed_57/mvvm-architectural-pattern-in-android-j03)
 *
 * Difference between MVVM and MVI: [MVVM vs. MVI - Understand the Difference Once and for All](https://youtu.be/b2z1jvD4VMQ)
 *
 * Before run App, change activity in AndroidManifest to [MainActivityMVVM]
 *
 * - Model: Represents the data and business logic of the application, typically does not have any direct knowledge of the user interface. Represented by [GameRepository] handling logic and data.
 * - View: This layer represents the user interface elements. It focuses on displaying data and handling user interactions without any logic or knowledge about the data itself. The UI elements represented by Composable functions in [GameScreen].
 * - ViewModel: Acts as a bridge between the View and the Model. It exposes data to the View through a StateFlow mechanism represented by [GameViewModel.stateFlow]. It also manages the lifecycle of the data and ensures the View only receives relevant updates.
 */
class MainActivityMVVM : ComponentActivity() {

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
                    viewModel = viewModel,
                    onCardClicked = { cardIndex ->
                        viewModel.cardClicked(cardIndex)
                    }
                )
            }
        }
    }

}