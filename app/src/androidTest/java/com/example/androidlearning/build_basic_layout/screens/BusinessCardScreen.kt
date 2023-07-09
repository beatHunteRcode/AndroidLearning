package com.example.androidlearning.build_basic_layout.screens

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.example.androidlearning.C
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class BusinessCardScreen(semanticProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<BusinessCardScreen>(
        semanticsProvider = semanticProvider,
        viewBuilderAction = { hasTestTag(C.Tag.business_card_screen) }
    ) {
    val businessCardBgImage: KNode = child {
        hasTestTag(C.Tag.business_card_bg_image)
    }
    val businessCardPersonAvatar: KNode = child {
        hasTestTag(C.Tag.business_card_person_avatar)
    }
    val businessCardPersonName : KNode = child {
        hasTestTag(C.Tag.business_card_person_name)
    }
    val businessCardPersonStatus : KNode = child {
        hasTestTag(C.Tag.business_card_person_status)
    }
    val businessCardContactsPhoneIcon : KNode = child {
        hasTestTag(C.Tag.business_card_contacts_phone_icon)
    }
    val businessCardContactsTelegramIcon : KNode = child {
        hasTestTag(C.Tag.business_card_contacts_telegram_icon)
    }
    val businessCardContactsEmailIcon : KNode = child {
        hasTestTag(C.Tag.business_card_contacts_email_icon)
    }
    val businessCardContactsPhoneText : KNode = child {
        hasTestTag(C.Tag.business_card_contacts_phone_text)
    }
    val businessCardContactsTelegramText : KNode = child {
        hasTestTag(C.Tag.business_card_contacts_telegram_text)
    }
    val businessCardContactsEmailText : KNode = child {
        hasTestTag(C.Tag.business_card_contacts_email_text)
    }
}