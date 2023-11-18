package com.example.espressotest.screen

import android.view.View
import com.example.espressotest.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object ListScreen : KScreen<ListScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val usersRecyclerView = KRecyclerView(
        builder = { withId(R.id.recyclerView) },
        itemTypeBuilder = { itemType(::UserItemElement) }
    )

    class UserItemElement(matcher: Matcher<View>) : KRecyclerItem<UserItemElement>(matcher) {
        val userAvatarImageView = KImageView(matcher) { withId(R.id.imageview) }
        val userNameTextView = KTextView(matcher) { withId(R.id.textView) }
    }
}
