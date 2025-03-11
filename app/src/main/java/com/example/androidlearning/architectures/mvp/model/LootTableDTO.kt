package com.example.androidlearning.architectures.mvp.model

import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
data class LootTableDTO(
    val tableName: String,
    val description: String,
    val results: List<String>
) {

    fun getRandomItem(): String = results[Random.nextInt(results.size)]

}