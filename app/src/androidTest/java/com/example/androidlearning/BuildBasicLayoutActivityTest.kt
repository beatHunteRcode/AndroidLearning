package com.example.androidlearning

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidlearning.activities.BuildBasicLayoutActivity
import com.example.androidlearning.navigation.screens.Utils
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.common.utilities.getResourceString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BuildBasicLayoutActivityTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withComposeSupport()
) {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<BuildBasicLayoutActivity>()

    @Test
    fun testBuildBasicLayoutActivity() = run {
        step("Test BuildBasicLayout Activity") {
            testBusinessCardScreen()
            testBirthdayCardScreen()
            testComposeArticleScreen()
            testTaskManagerScreen()
            testComposeQuadrantScreen()
        }
    }

    @Test
    fun testBusinessCardScreen() = run {
        step("Testing BusinessCard Screen") {
            composeTestRule.onNodeWithTag(C.Tag.buildBasicLayoutActivity_bottom_bar_business_card_item)
                .performClick()

            composeTestRule.onNodeWithTag(C.Tag.business_card_bg_image)
                .assertIsDisplayed()
            composeTestRule.onNodeWithTag(C.Tag.business_card_person_avatar)
                .assertIsDisplayed()
            composeTestRule.onNodeWithTag(C.Tag.business_card_person_name)
                .assertIsDisplayed()
                .assertTextContains(getResourceString(R.string.business_card_person_name_text))
            composeTestRule.onNodeWithTag(C.Tag.business_card_person_status)
                .assertIsDisplayed()
                .assertTextContains(getResourceString(R.string.business_card_person_status_text))
            composeTestRule.onNodeWithTag(C.Tag.business_card_contacts_phone_icon)
                .assertIsDisplayed()
            composeTestRule.onNodeWithTag(C.Tag.business_card_contacts_telegram_icon)
                .assertIsDisplayed()
            composeTestRule.onNodeWithTag(C.Tag.business_card_contacts_email_icon)
                .assertIsDisplayed()
            composeTestRule.onNodeWithTag(C.Tag.business_card_contacts_phone_text)
                .assertIsDisplayed()
                .assertTextContains(getResourceString(R.string.business_card_contacts_phone_text))
            composeTestRule.onNodeWithTag(C.Tag.business_card_contacts_telegram_text)
                .assertIsDisplayed()
                .assertTextContains(getResourceString(R.string.business_card_contacts_telegram_text))
            composeTestRule.onNodeWithTag(C.Tag.business_card_contacts_email_text)
                .assertIsDisplayed()
                .assertTextContains(getResourceString(R.string.business_card_contacts_email_text))
        }
    }

    @Test
    fun testBirthdayCardScreen() = run {
        step("Testing BirthdayCard Screen") {
            composeTestRule.onNodeWithTag(C.Tag.buildBasicLayoutActivity_bottom_bar_birthday_card_item)
                .performClick()

            composeTestRule.onNodeWithTag(C.Tag.birthday_card_bg_image)
                .assertIsDisplayed()
            composeTestRule.onNodeWithTag(C.Tag.birthday_card_message_text)
                .assertIsDisplayed()
                .assertTextContains(getResourceString(R.string.birthday_card_message_text))
            composeTestRule.onNodeWithTag(C.Tag.birthday_card_from_text)
                .assertIsDisplayed()
                .assertTextContains(getResourceString(R.string.birthday_card_from_text))
        }
    }

    @Test
    fun testComposeArticleScreen() = run {
        step("Testing ComposeArticle Screen") {
            composeTestRule.onNodeWithTag(C.Tag.buildBasicLayoutActivity_bottom_bar_compose_article_item)
                .performClick()

            composeTestRule.onNodeWithTag(C.Tag.compose_article_image)
                .assertIsDisplayed()
            composeTestRule.onNodeWithTag(C.Tag.compose_article_topic)
                .assertIsDisplayed()
                .assertTextContains(Utils.ARTICLE_TOPIC_STRING)
            composeTestRule.onNodeWithTag(C.Tag.compose_article_first_paragraph)
                .assertIsDisplayed()
                .assertTextContains(Utils.ARTICLE_FIRST_PARAGRAPH_STRING)
            composeTestRule.onNodeWithTag(C.Tag.compose_article_second_paragraph)
                .assertIsDisplayed()
                .assertTextContains(Utils.ARTICLE_SECOND_PARAGRAPH_STRING)
        }
    }

    @Test
    fun testTaskManagerScreen() = run {
        step("Testing TaskManager Screen") {
            composeTestRule.onNodeWithTag(C.Tag.buildBasicLayoutActivity_bottom_bar_task_manager_item)
                .performClick()

            composeTestRule.onNodeWithTag(C.Tag.task_manager_image)
                .assertIsDisplayed()
            composeTestRule.onNodeWithTag(C.Tag.task_manager_first_text)
                .assertIsDisplayed()
                .assertTextContains(Utils.TASK_MANAGER_FIRST_TEXT)
            composeTestRule.onNodeWithTag(C.Tag.task_manager_second_text)
                .assertIsDisplayed()
                .assertTextContains(Utils.TASK_MANAGER_SECOND_TEXT)

            //TODO(): Need to add waiting logic. Need to wait until 4 buttons appears

//            composeTestRule.onNodeWithTag(C.Tag.task_manager_first_button)
//                .assertIsDisplayed()
//                .performClick()
//            composeTestRule.onNodeWithTag(C.Tag.task_manager_second_button)
//                .assertIsDisplayed()
//                .performClick()
//            composeTestRule.onNodeWithTag(C.Tag.task_manager_third_button)
//                .assertIsDisplayed()
//                .performClick()
//            composeTestRule.onNodeWithTag(C.Tag.task_manager_fourth_button)
//                .assertIsDisplayed()
//                .performClick()
        }
    }

    @Test
    fun testComposeQuadrantScreen() = run {
        step("Testing ComposeQuadrant Screen") {
            composeTestRule.onNodeWithTag(C.Tag.buildBasicLayoutActivity_bottom_bar_compose_quadrant_item)
                .performClick()

            composeTestRule.onNodeWithTag(C.Tag.compose_quadrant_text_composable_title_text)
                .assertIsDisplayed()
                .assertTextContains(Utils.QUADRANT_TEXT_COMPOSABLE_TITLE)
            composeTestRule.onNodeWithTag(C.Tag.compose_quadrant_text_composable_text)
                .assertIsDisplayed()
                .assertTextContains(Utils.QUADRANT_TEXT_COMPOSABLE_TEXT)
            composeTestRule.onNodeWithTag(C.Tag.compose_quadrant_image_composable_title_text)
                .assertIsDisplayed()
                .assertTextContains(Utils.QUADRANT_IMAGE_COMPOSABLE_TITLE)
            composeTestRule.onNodeWithTag(C.Tag.compose_quadrant_image_composable_text)
                .assertIsDisplayed()
                .assertTextContains(Utils.QUADRANT_IMAGE_COMPOSABLE_TEXT)
            composeTestRule.onNodeWithTag(C.Tag.compose_quadrant_row_composable_title_text)
                .assertIsDisplayed()
                .assertTextContains(Utils.QUADRANT_ROW_COMPOSABLE_TITLE)
            composeTestRule.onNodeWithTag(C.Tag.compose_quadrant_row_composable_text)
                .assertIsDisplayed()
                .assertTextContains(Utils.QUADRANT_ROW_COMPOSABLE_TEXT)
            composeTestRule.onNodeWithTag(C.Tag.compose_quadrant_column_composable_title_text)
                .assertIsDisplayed()
                .assertTextContains(Utils.QUADRANT_COLUMN_COMPOSABLE_TITLE)
            composeTestRule.onNodeWithTag(C.Tag.compose_quadrant_column_composable_text)
                .assertIsDisplayed()
                .assertTextContains(Utils.QUADRANT_COLUMN_COMPOSABLE_TEXT)
        }
    }

}