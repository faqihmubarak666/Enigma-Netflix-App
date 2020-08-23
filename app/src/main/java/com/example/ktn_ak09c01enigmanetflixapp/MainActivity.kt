package com.example.ktn_ak09c01enigmanetflixapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = (nav_host_fragment as NavHostFragment).navController
        NavigationUI.setupWithNavController(bottom_navigation, navController)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.showFilm -> {
                    navController.navigate(R.id.action_to_filmFragment)
                    true
                }
                R.id.createFilm -> {
                    navController.navigate(R.id.action_to_createFilmFragment)
                    true
                }
                else -> {
                    true
                }
            }
        }
    }
}