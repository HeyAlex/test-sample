package com.github.heyalex.main

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.card.MaterialCardView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        if (findViewById<AppBarLayout>(R.id.material_card).isLiftOnScroll) {
            recyclerView.isAnimating
        }

//        val bottomSheetBehavior = BottomSheetBehavior.from<LinearLayout>(findViewById(R.id.bottom_sheet))
//        bottomSheetBehavior.isHideable = true
//        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

}