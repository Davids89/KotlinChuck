package com.example.david.kotlinchuck.mainActivity.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.example.david.kotlinchuck.R
import org.jetbrains.anko.find
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBottomNavigationBar()
    }

    private fun setBottomNavigationBar() {
        bottomNavigation = find(R.id.bottom_navigation)

        bottomNavigation.setOnNavigationItemSelectedListener{

            val intent = when(it.itemId){
                R.id.action_search -> println("Search")
                R.id.action_favorite -> println("Favorite")
                R.id.action_settings -> println("Settings")
                else -> null
            }

            true
        }
    }
}
