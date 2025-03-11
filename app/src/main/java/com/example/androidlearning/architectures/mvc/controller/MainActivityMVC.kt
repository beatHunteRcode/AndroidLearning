package com.example.androidlearning.architectures.mvc.controller

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlearning.R
import com.example.androidlearning.architectures.mvc.model.LootTableModel
import kotlinx.serialization.json.Json

/**
 * Reference: [Android Presentation Patterns: MVC](https://dev.to/asvid/android-presentation-patterns-mvc-2o9)
 *
 *
 * Before run App, change activity in AndroidManifest to [MainActivityMVC]
 *
 * - Model: Represented by [LootTableModel], handling data and logic.
 * - View: The UI elements in res/layout/mvc_screen.xml.
 * - Controller: The logic within [MainActivityMVC] that binds the Model and View together, responding to user interactions and updating the UI accordingly.
 */
class MainActivityMVC : Activity() {

    private lateinit var lootTableModel: LootTableModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.mvc_screen)

        lootTableModel = loadLootTable()

        val rollButton = findViewById<Button>(R.id.mvc_but_rollOnTable)
        val outputTextView = findViewById<TextView>(R.id.mvc_tv_output)

        rollButton.setOnClickListener {
            val selectedItem = lootTableModel.getRandomItem()
            outputTextView.text = selectedItem
        }
    }

    private fun loadLootTable(): LootTableModel {
        val jsonString = assets.open("database.json").bufferedReader().use { it.readText() }
        return Json.decodeFromString(LootTableModel.serializer(), jsonString)
    }

}