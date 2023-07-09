package com.example.androidlearning.main_activity

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidlearning.R
import com.example.androidlearning.activities.MainActivity
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.compose.node.element.ComposeScreen.Companion.onComposeScreen
import io.github.kakaocup.kakao.common.utilities.getResourceString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withComposeSupport()
) {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testMainActivityButtonsCheck() = run {
        step("Open MainActivity screen") {
            onComposeScreen<MainActivityScreen>(composeTestRule) {
                goToBuildBasicLayoutActivityButton {
                    assertIsDisplayed()
                    assertHasClickAction()
                    assertTextContains(getResourceString(R.string.go_to_build_basic_layout_activity))
                }
                goToComposeEssentialsActivityButton {
                    assertIsDisplayed()
                    assertHasClickAction()
                    assertTextContains(getResourceString(R.string.go_to_compose_essentials_activity))
                }
            }
        }
    }
}