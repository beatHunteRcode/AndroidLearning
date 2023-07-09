package com.example.androidlearning.build_basic_layout.screens

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.example.androidlearning.C
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class BuildBasicLayoutScreen(semanticProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<BuildBasicLayoutScreen>(
        semanticsProvider = semanticProvider,
        viewBuilderAction = { hasTestTag(C.Tag.build_basic_layout_screen) }
    ) {
    val buildBasicLayoutActivityBottomBarBusinessCardItem: KNode = child {
        hasTestTag(C.Tag.buildBasicLayoutActivity_bottom_bar_business_card_item)
    }
    val buildBasicLayoutActivityBottomBarBirthdayCardItem : KNode = child {
        hasTestTag(C.Tag.buildBasicLayoutActivity_bottom_bar_birthday_card_item)
    }
    val buildBasicLayoutActivityBottomBarComposeArticleItem : KNode = child {
        hasTestTag(C.Tag.buildBasicLayoutActivity_bottom_bar_birthday_card_item)
    }
    val buildBasicLayoutActivityBottomBarTaskManagerItem : KNode = child {
        hasTestTag(C.Tag.buildBasicLayoutActivity_bottom_bar_task_manager_item)
    }
    val buildBasicLayoutActivityBottomBarComposeQuadrantItem : KNode = child {
        hasTestTag(C.Tag.buildBasicLayoutActivity_bottom_bar_compose_quadrant_item)
    }
}