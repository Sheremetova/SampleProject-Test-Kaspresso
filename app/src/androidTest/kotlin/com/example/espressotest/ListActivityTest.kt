package com.example.espressotest

import androidx.test.ext.junit.rules.activityScenarioRule
import com.example.espressotest.screen.ListScreen
import com.example.espressotest.ui.list.ListActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class ListActivityTest : TestCase() {

    companion object {
        const val EXPECTED_USERS_COUNT = 20
    }

    @get:Rule
    val activityRule = activityScenarioRule<ListActivity>()

    @Test
    fun checkUsersList() {
        run {
            step("Check number of Users on List Screen") {
                ListScreen {
                    Assert.assertEquals(EXPECTED_USERS_COUNT, rvUsers.getSize())
                }
            }

            step("Check if the last user's name and image are visible after scrolling") {
                ListScreen.rvUsers {
                    childAt<ListScreen.UserItemElement>(EXPECTED_USERS_COUNT - 1) {
                        imageView.isVisible()
                        userNameView.isVisible()
                    }
                }
            }
        }
    }
}