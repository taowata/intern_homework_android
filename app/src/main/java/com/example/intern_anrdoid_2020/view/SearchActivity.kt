package com.example.intern_anrdoid_2020.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.intern_anrdoid_2020.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation)
        bottomNavigationView.setupWithNavController(Navigation.findNavController(this, R.id.nav_fragment))
    }

    companion object {
        fun createIntent(context: Context?): Intent {
            return Intent(context, SearchActivity::class.java)
        }
    }
}
