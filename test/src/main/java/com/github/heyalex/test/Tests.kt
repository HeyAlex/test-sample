package com.github.heyalex.test

import android.app.Activity
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.withResourceName
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class Tests {

    @get:Rule
    val activityRule =
        ActivityTestRule(Class.forName("com.github.heyalex.main.MainActivity") as Class<Activity>)

    @Test
    fun detailedTest() {
        onView(withResourceName("recycler_view")).perform(ScrollToBottomAction())
        onView(withResourceName("bottom_sheet"))
            .perform(setState(BottomSheetBehavior.STATE_COLLAPSED))
    }

    private fun setState(@BottomSheetBehavior.State state: Int): ViewAction? {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View?> {
                return isBottomSheet()
            }

            override fun getDescription(): String {
                return "set state to $state"
            }

            override fun perform(
                uiController: UiController,
                view: View
            ) {
                BottomSheetBehavior.from(view).state = state
            }
        }
    }

    private fun isBottomSheet(): TypeSafeMatcher<View?> {
        return object : TypeSafeMatcher<View?>() {
            override fun matchesSafely(view: View?): Boolean {
                return BottomSheetBehavior.from(view) != null
            }

            override fun describeTo(description: Description) {
                description.appendText("is a bottom sheet")
            }
        }
    }
}

//class Tests : ActivityInstrumentationTestCase2<Activity>(Class.forName("com.github.heyalex.main.MainActivity") as Class<Activity>) {
//
//    fun detailedTest() {
//        onView(withResourceName("id/recycler_view")).perform(ScrollToBottomAction())
//    }
//}