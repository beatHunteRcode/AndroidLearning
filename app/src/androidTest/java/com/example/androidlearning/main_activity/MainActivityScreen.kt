package com.example.androidlearning.main_activity

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.example.androidlearning.C
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class MainActivityScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<MainActivityScreen>(
        semanticsProvider = semanticsProvider,
        viewBuilderAction = { hasTestTag(C.Tag.main_activity_screen) }
    ) {
        val goToBuildBasicLayoutActivityButton: KNode = child {
            hasTestTag(C.Tag.go_to_buildBasicLayoutActivity_button)
        }

        val goToComposeEssentialsActivityButton: KNode = child {
            hasTestTag(C.Tag.go_to_composeEssentialsActivity_button)
        }
}