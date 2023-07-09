package com.example.androidlearning.build_basic_layout.screens

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.example.androidlearning.C
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class BirthdayCardScreen(semanticProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<BirthdayCardScreen>(
        semanticsProvider = semanticProvider,
        viewBuilderAction = { hasTestTag(C.Tag.birthday_card_screen) }
    ) {
    val birthdayCardMessageText: KNode = child {
        hasTestTag(C.Tag.birthday_card_message_text)
    }
    val birthdayCardFromText: KNode = child {
        hasTestTag(C.Tag.birthday_card_from_text)
    }
    val birthdayCardImage: KNode = child {
        hasTestTag(C.Tag.birthday_card_bg_image)
    }
}