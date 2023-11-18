package com.example.espressotest.screen

import com.example.espressotest.R
import com.example.espressotest.ui.login.LoginActivity
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton

object LoginScreen : KScreen<LoginScreen>() {
    override val layoutId: Int = R.layout.activity_login
    override val viewClass: Class<*> = LoginActivity::class.java

    val signInOrRegisterButton = KButton { withId(R.id.login) }
    val emailEditText = KEditText { withId(R.id.username) }
    val passwordEditText = KEditText { withId(R.id.password) }
}