package com.example.espressotest

import androidx.test.ext.junit.rules.activityScenarioRule
import com.example.espressotest.screen.LoginScreen
import com.example.espressotest.ui.list.ListActivity
import com.example.espressotest.ui.login.LoginActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class LoginActivityTest(
    private val testName: String,
    private val email: String,
    private val password: String,
    private val expectedSuccess: Boolean
) : TestCase() {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("valid credentials", "test@gmail.com", "strong", true),
                arrayOf("invalid password (less than 6 symbols)", "test@gmail.com", "weak", false),
                arrayOf("invalid email", "test@gmail", "strong", false)
            )
        }
    }

    @get:Rule
    val activityRule = activityScenarioRule<LoginActivity>()

    @Test
    fun loginWithDifferentCredentials() {
        run {
            step("Try to sign in with $testName: $email / $password") {
                LoginScreen {
                    emailEditText.replaceText(email)
                    passwordEditText.replaceText(password)
                    signInOrRegisterButton.click()
                }
            }

            step("Check result for $testName") {
                if (expectedSuccess) {
                    device.activities.isCurrent(ListActivity::class.java)
                } else {
                    device.activities.isCurrent(LoginActivity::class.java)
                }
            }
        }
    }
}