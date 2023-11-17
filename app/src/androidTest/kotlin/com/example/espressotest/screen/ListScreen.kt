package com.example.espressotest.screen

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import com.example.espressotest.R
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object ListScreen : KScreen<ListScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val rvUsers = KRecyclerView(
        builder = { withId(R.id.recyclerView) },
        itemTypeBuilder = { itemType(::UserItemElement) }
    )

    class UserItemElement(matcher: Matcher<View>) : KRecyclerItem<UserItemElement>(matcher) {
        val imageView = KImageView(matcher) { withId(R.id.imageview) }
        val userNameView = KTextView(matcher) { withId(R.id.textView) }
    }
}
