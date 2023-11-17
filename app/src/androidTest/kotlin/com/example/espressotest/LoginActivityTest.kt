package com.example.espressotest

import androidx.test.ext.junit.rules.activityScenarioRule
import com.example.espressotest.screen.LoginScreen
import com.example.espressotest.ui.list.ListActivity
import com.example.espressotest.ui.login.LoginActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class LoginActivityTest : TestCase() {

    @get:Rule
    val activityRule = activityScenarioRule<LoginActivity>()

    @Test
    fun loginWithValidCredentials() {
        run {
            step("Sign in with valid credentials") {
                LoginScreen {
                    emailEditText.replaceText("test@gmail.com")
                    passwordEditText.replaceText("psswrd")
                    signInOrRegisterButton.click()
                }
            }

            step("Check if List Screen is opened") {
                device.activities.isCurrent(ListActivity::class.java)
            }
        }
    }

    @Test
    fun loginWithInvalidPassword() {
        run {
            step("Enter invalid password") {
                LoginScreen {
                    emailEditText.replaceText("test@gmail.com")
                    passwordEditText.replaceText("4sym")
                }
            }

            step("Check if SIGN IN OR REGISTER button is disabled") {
                LoginScreen.signInOrRegisterButton.isDisabled()
            }

            step("Try to sign in with invalid password") {
                LoginScreen.signInOrRegisterButton.click()
            }

            step("Check if Login Screen is present") {
                device.activities.isCurrent(LoginActivity::class.java)
            }

        }

    }

    @Test
    fun loginWithInvalidEmail() {
        run {
            step("Enter invalid password") {
                LoginScreen {
                    emailEditText.replaceText("test@gmail")
                    passwordEditText.replaceText("psswrd")
                }
            }

            step("Check if SIGN IN OR REGISTER button is disabled") {
                LoginScreen.signInOrRegisterButton.isDisabled()
            }

            step("Try to sign in with invalid email") {
                LoginScreen.signInOrRegisterButton.click()
            }

            step("Check if Login Screen is present") {
                device.activities.isCurrent(LoginActivity::class.java)
            }

        }
    }
}