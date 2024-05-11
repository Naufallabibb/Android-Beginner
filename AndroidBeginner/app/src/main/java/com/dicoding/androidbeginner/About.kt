package com.dicoding.androidbeginner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // Menghilangkan label dari ActionBar atau toolbar
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
}
