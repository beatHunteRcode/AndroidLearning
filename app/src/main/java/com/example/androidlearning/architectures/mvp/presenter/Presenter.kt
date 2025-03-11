package com.example.androidlearning.architectures.mvp.presenter

import android.content.res.AssetManager
import com.example.androidlearning.architectures.mvp.Contract
import com.example.androidlearning.architectures.mvp.model.LootTableRepository

class Presenter(private val view: Contract.View) : Contract.Presenter {

    private var model: Contract.Model = LootTableRepository()

    override fun onRollButtonClick(assetManager: AssetManager) {
        val selectedItem = model.loadLootTable(assetManager).getRandomItem()
        view.updateTextView(text = selectedItem)
    }

}