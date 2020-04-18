package com.github.heyalex.test

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import com.google.android.material.appbar.AppBarLayout
import org.hamcrest.Matcher
import org.hamcrest.Matchers


class MaterialCheck : ViewAction {
    override fun getDescription(): String {
        return "scroll RecyclerView to bottom"
    }

    override fun getConstraints(): Matcher<View> {
        return Matchers.allOf<View>(
            ViewMatchers.isAssignableFrom(AppBarLayout::class.java),
            ViewMatchers.isDisplayed()
        )
    }

    override fun perform(uiController: UiController?, view: View?) {
        val recyclerView = view as AppBarLayout
        recyclerView.isLiftOnScroll
        uiController?.loopMainThreadUntilIdle()
    }
}