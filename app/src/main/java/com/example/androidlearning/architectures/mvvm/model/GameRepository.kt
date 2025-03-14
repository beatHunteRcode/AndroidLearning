package com.example.androidlearning.architectures.mvvm.model

import kotlinx.coroutines.delay

class GameRepository {

    suspend fun getGames(): List<GameModel> {
        // Fake data fetching
        delay(3000)

        return listOf(
            GameModel(
                1,
                "The Witcher 3: Wild Hunt",
                4.8f,
                "A masterpiece of storytelling and open-world design."
            ),
            GameModel(
                2,
                "Red Dead Redemption 2",
                4.9f,
                "An epic tale of life in America at the dawn of the modern age."
            ),
            GameModel(
                3,
                "Assassin's Creed Valhalla",
                4.5f,
                "Explore a dynamic and beautiful open world set against the brutal backdrop of England's Dark Ages."
            ),
            GameModel(
                4,
                "Cyberpunk 2077",
                4.2f,
                "An open-world action-adventure story set in Night City, a megalopolis obsessed with power, glamour, and body modification."
            ),
            GameModel(
                5,
                "The Legend of Zelda: Breath of the Wild",
                4.7f,
                "Step into a world of discovery, exploration, and adventure in The Legend of Zelda: Breath of the Wild."
            )
        )
    }

}