package com.fabianospdev.petscare.presenter.ui.login

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.fabianospdev.petscare.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class LoginScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()


    @Test
    fun testLoginScreen_displayedCorrectly() {
        composeTestRule.waitForIdle()
        //composeTestRule.onNodeWithText("login", useUnmergedTree = true).assertIsDisplayed()
        composeTestRule.onNodeWithText("email@email.com").assertIsDisplayed()
        composeTestRule.onNodeWithText("Q@nm#44u").assertIsDisplayed()
    }

    @Test
    fun testTextFields_acceptInput() {
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("email@email.com").performTextInput("testuser@example.com")
        composeTestRule.onNodeWithText("Q@nm#44u").performTextInput("password123")
        composeTestRule.onNodeWithText("testuser@example.com").assertExists()
        composeTestRule.onNodeWithText("password123").assertExists()
    }

    @Test
    fun testLoginButton_navigation() {
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("email@email.com").performTextInput("testuser@example.com")
        composeTestRule.onNodeWithText("Q@nm#44u").performTextInput("password123")
       // composeTestRule.onNodeWithText("login", useUnmergedTree = true).performClick()
    }

    @Test
    fun testPasswordVisibilityToggle() {

    }

    @Test
    fun testLoginButton_disabled_whenFieldsAreEmpty() {
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("email@email.com").performTextInput("testuser@example.com")
        composeTestRule.onNodeWithText("Q@nm#44u").performTextInput("password123")
    }
}
