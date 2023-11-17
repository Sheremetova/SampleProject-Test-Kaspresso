package com.example.espressotest.screen

import com.example.espressotest.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton

object LoginScreen : KScreen<LoginScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val signInOrRegisterButton = KButton { withId(R.id.login) }
    val emailEditText = KEditText { withId(R.id.username) }
    val passwordEditText = KEditText { withId(R.id.password) }
}