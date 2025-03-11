package com.example.androidlearning.architectures.mvp

import android.content.res.AssetManager
import com.example.androidlearning.architectures.mvp.model.LootTableDTO

sealed interface Contract {

    interface Model {
        fun loadLootTable(assetManager: AssetManager): LootTableDTO
    }

    interface View {
        fun updateTextView(text: String)
    }

    interface Presenter {
        fun onRollButtonClick(assetManager: AssetManager)
    }

}