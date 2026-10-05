package com.zain.i230855

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Espresso instrumented tests for critical user workflows:
 * Test 1: Multi-step path Home -> Comments -> Back to Home
 * Test 2: Multi-step path Log in -> Home -> Menu -> Log out returning to Log in (Clearing back stack)
 */
@RunWith(AndroidJUnit4::class)
class KinnectWorkflowTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    /**
     * Test Case 1: Multi-step user workflow: Home -> Comments -> Type Reply -> Back to Home
     */
    @Test
    fun testHomeToCommentsAndBackWorkflow() {
        // Step 1: Log in to reach Home
        onView(withId(R.id.et_username)).perform(typeText("jacob.west@mail.com"), closeSoftKeyboard())
        onView(withId(R.id.btn_login)).perform(click())

        // Step 2: Verify Home screen is displayed
        onView(withId(R.id.home_root)).check(matches(isDisplayed()))

        // Step 3: Click Comment button on Home feed to open Comments screen
        onView(withId(R.id.btn_comment)).perform(click())

        // Step 4: Verify Comments screen is displayed
        onView(withId(R.id.comments_root)).check(matches(isDisplayed()))

        // Step 5: Type a comment reply in the comment input box
        onView(withId(R.id.et_comment_input)).perform(typeText("Great photo!"), closeSoftKeyboard())
        onView(withId(R.id.btn_send_comment)).perform(click())

        // Step 6: Click Back button on Comments screen
        onView(withId(R.id.btn_comments_back)).perform(click())

        // Step 7: Verify returning to Home screen
        onView(withId(R.id.home_root)).check(matches(isDisplayed()))
    }

    /**
     * Test Case 2: Multi-step user workflow: Log in -> Home -> Menu -> Log out -> Returning to Log in
     */
    @Test
    fun testLoginToMenuToLogoutWorkflow() {
        // Step 1: Verify Login screen is displayed initially
        onView(withId(R.id.login_root)).check(matches(isDisplayed()))

        // Step 2: Perform Login
        onView(withId(R.id.et_username)).perform(typeText("jacob.west@mail.com"), closeSoftKeyboard())
        onView(withId(R.id.btn_login)).perform(click())

        // Step 3: Verify Home screen is displayed
        onView(withId(R.id.home_root)).check(matches(isDisplayed()))

        // Step 4: Click Menu tab to navigate to Menu screen
        onView(withId(R.id.tab_menu)).perform(click())

        // Step 5: Verify Menu screen is displayed
        onView(withId(R.id.menu_root)).check(matches(isDisplayed()))

        // Step 6: Click Log out button on Menu screen
        onView(withId(R.id.btn_logout)).perform(click())

        // Step 7: Verify returning to Login screen with cleared back stack
        onView(withId(R.id.login_root)).check(matches(isDisplayed()))
    }
}