package com.example.david.kotlinchuck.favoriteJokes.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.david.kotlinchuck.MyApp

import com.example.david.kotlinchuck.R
import com.example.david.kotlinchuck.favoriteJokes.presenter.FavoriteJokesPresenter
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class FavoriteFragment : Fragment(), FavoriteView {

    @Inject
    lateinit var presenter: FavoriteJokesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MyApp.favoriteFragmentComponent(this).inject(this)

        presenter.onCreate()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_favorite, container, false)
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
