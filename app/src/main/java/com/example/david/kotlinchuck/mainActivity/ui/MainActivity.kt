package com.example.david.kotlinchuck.mainActivity.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.example.david.kotlinchuck.R
import com.example.david.kotlinchuck.mainActivity.ui.fragments.FavoriteFragment
import com.example.david.kotlinchuck.mainActivity.ui.fragments.SearchFragment
import com.example.david.kotlinchuck.mainActivity.ui.fragments.SettingsFragment
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigation: BottomNavigationView
    val fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setInitialFragment()
        setBottomNavigationBar()
    }

    private fun setInitialFragment() {
        val searchFragment: SearchFragment = SearchFragment()
        val transaction : FragmentTransaction = fragmentManager.beginTransaction()
        transaction.add(R.id.main_container, searchFragment).commit()
    }

    private fun setBottomNavigationBar() {
        bottomNavigation = find(R.id.bottom_navigation)
        var fragment: Fragment = Fragment()

        bottomNavigation.setOnNavigationItemSelectedListener{

            when(it.itemId){
                R.id.action_search -> fragment = SearchFragment()
                R.id.action_favorite -> fragment = FavoriteFragment()
                R.id.action_settings -> fragment = SettingsFragment()
            }

            val transaction: FragmentTransaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.main_container, fragment).commit()

            true
        }
    }
}
