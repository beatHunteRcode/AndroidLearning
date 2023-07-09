package com.example.androidlearning

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidlearning.activities.BuildBasicLayoutActivity
import com.example.androidlearning.build_basic_layout.screens.BirthdayCardScreen
import com.example.androidlearning.build_basic_layout.screens.BuildBasicLayoutScreen
import com.example.androidlearning.build_basic_layout.screens.BusinessCardScreen
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.compose.node.element.ComposeScreen.Companion.onComposeScreen
import io.github.kakaocup.kakao.common.utilities.getResourceString
import io.qameta.allure.kotlin.Allure.step
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
    fun testBirthdayCardScreen() = run {
        step("Open BirthdayCard Screen") {
            onComposeScreen<BirthdayCardScreen>(composeTestRule) {
                birthdayCardMessageText {
                    assertTextContains(getResourceString(R.string.happy_birthday_text))
                }
            }
        }
    }

    @Test
    fun testBottomBar() = run {
        step("Check BuildBasicLayout Screen Bottom Bar") {
            onComposeScreen<BuildBasicLayoutScreen>(composeTestRule) {
                buildBasicLayoutActivityBottomBarBusinessCardItem {
                    performClick()
                }
                buildBasicLayoutActivityBottomBarBirthdayCardItem {
                    performClick()
                }
                buildBasicLayoutActivityBottomBarComposeArticleItem {
                    performClick()
                }
                buildBasicLayoutActivityBottomBarTaskManagerItem {
                    performClick()
                }
                buildBasicLayoutActivityBottomBarComposeQuadrantItem {
                    performClick()
                }
            }
        }
    }


}