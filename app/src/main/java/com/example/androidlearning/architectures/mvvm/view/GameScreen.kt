package com.example.androidlearning.architectures.mvvm.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidlearning.architectures.mvvm.model.GameModel
import com.example.androidlearning.architectures.mvvm.viewmodel.GameViewModel

@Composable
fun GameScreen(
    viewModel: GameViewModel,
    onCardClicked: (Int) -> Unit
) {
    val screenState by viewModel.getState().collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "MVVM",
            fontSize = 50.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        when {
            screenState.isLoading -> {
                // Display a loading indicator
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Color.Blue)
                }
            }

            screenState.errorText != null -> {
                // Display an error message
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    val errorMessage = screenState.errorText
                    Text(text = "Error: $errorMessage", color = Color.Red, fontSize = 18.sp)
                }
            }

            else -> {
                // Display the list of games
                GameList(
                    screenState.games,
                    onCardClicked = onCardClicked
                )
            }
        }
    }
}

@Composable
fun GameList(
    games: List<GameModel>,
    onCardClicked: (Int) -> Unit
) {
    LazyColumn {
        itemsIndexed(games) { index, game ->
            GameListItem(
                game = game,
                cardIndex = index,
                onCardClicked = onCardClicked
            )
        }
    }
}

@Composable
fun GameListItem(
    game: GameModel,
    cardIndex: Int,
    onCardClicked: (Int) -> Unit
) {
    // Display a game item
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp))
            .clickable {
                onCardClicked(cardIndex)
            }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {

            Text(
                text = game.title,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = game.review,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = " Rating: ${game.rating}",
                color = Color.Gray,
                style = TextStyle(
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}