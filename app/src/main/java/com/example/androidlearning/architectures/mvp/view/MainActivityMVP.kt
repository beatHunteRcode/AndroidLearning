package com.example.androidlearning.architectures.mvp.view

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.androidlearning.R
import com.example.androidlearning.architectures.mvp.Contract
import com.example.androidlearning.architectures.mvp.model.LootTableRepository
import com.example.androidlearning.architectures.mvp.model.LootTableDTO
import com.example.androidlearning.architectures.mvp.presenter.Presenter

/**
 * Reference: [MVP в Android для самых маленьких](https://javarush.com/groups/posts/505-mvp-v-android-dlja-samihkh-malenjhkikh)
 *
 *
 * Before run App, change activity in AndroidManifest to [MainActivityMVP]
 *
 * - Model: Represented by [LootTableRepository] handling logic and [LootTableDTO] handling data.
 * - View: The UI elements in res/layout/mvp_screen.xml.
 * - Presenter: The logic within [Presenter] that binds the Model and View together, responding to user interactions and updating the UI accordingly.
 */
class MainActivityMVP: Activity(), Contract.View {

    private val presenter: Contract.Presenter = Presenter(view = this)

    private lateinit var rollButton: Button
    private lateinit var outputTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.mvp_screen)

        rollButton = findViewById(R.id.mvp_but_rollOnTable)
        outputTextView = findViewById(R.id.mvp_tv_output)

        rollButton.setOnClickListener {
            presenter.onRollButtonClick(assets)
        }

    }

    override fun updateTextView(text: String) {
        outputTextView.text = text
    }

}