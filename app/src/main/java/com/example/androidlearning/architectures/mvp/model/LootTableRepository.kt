package com.example.androidlearning.architectures.mvp.model

import android.content.res.AssetManager
import com.example.androidlearning.architectures.mvp.Contract
import kotlinx.serialization.json.Json

class LootTableRepository : Contract.Model {

    override fun loadLootTable(assetManager: AssetManager): LootTableDTO {
        val jsonString = assetManager.open("database.json").bufferedReader().use { it.readText() }
        return Json.decodeFromString(LootTableDTO.serializer(), jsonString)
    }

}