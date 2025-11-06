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
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidlearning.architectures.mvvm.model.GameModel

@Composable
fun GameScreen(
    isLoading: State<Boolean>,
    games: State<List<GameModel>>,
    errorText: State<String>,
    onCardClicked: (Int) -> Unit
) {
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
            isLoading.value -> {
                // Display a loading indicator
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Color.Blue)
                }
            }

            errorText.value.isNotBlank() -> {
                // Display an error message
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Error: $errorText", color = Color.Red, fontSize = 18.sp)
                }
            }

            else -> {
                // Display the list of games
                GameList(
                    games = games.value,
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