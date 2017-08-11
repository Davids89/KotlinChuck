package com.example.david.kotlinchuck.mainActivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.example.david.kotlinchuck.MyApp
import com.example.david.kotlinchuck.R
import com.example.david.kotlinchuck.favoriteJokes.ui.FavoriteFragment
import com.example.david.kotlinchuck.findJoke.ui.SearchFragment
import com.example.david.kotlinchuck.mainActivity.di.DaggerMainActivityComponent
import com.example.david.kotlinchuck.mainActivity.di.MainActivityModule
import com.example.david.kotlinchuck.settings.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(MainActivityModule(this))
                .build()

        activityComponent.inject(this)

        setInitialFragment()
        setBottomNavigationBar()
    }

    private fun setInitialFragment() {
        val searchFragment: SearchFragment = SearchFragment()
        val transaction : FragmentTransaction = fragmentManager.beginTransaction()
        transaction.add(R.id.main_container, searchFragment).commit()
    }

    private fun setBottomNavigationBar() {
        var fragment: Fragment = Fragment()

        bottom_navigation.setOnNavigationItemSelectedListener{

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
