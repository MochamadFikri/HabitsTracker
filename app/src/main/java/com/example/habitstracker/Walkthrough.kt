package com.mochamadfghd.habitstracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.walkthrough.*

class Walkthrough : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.walkthrough)

        viewpager.adapter = PagerAdapter(supportFragmentManager)

    }
}