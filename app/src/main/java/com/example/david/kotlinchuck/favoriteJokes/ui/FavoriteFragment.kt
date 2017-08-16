package com.example.david.kotlinchuck.favoriteJokes.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.david.kotlinchuck.MyApp

import com.example.david.kotlinchuck.R
import com.example.david.kotlinchuck.entities.Joke
import com.example.david.kotlinchuck.favoriteJokes.presenter.FavoriteJokesPresenter
import com.example.david.kotlinchuck.favoriteJokes.ui.adapter.JokesAdapter
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.find
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class FavoriteFragment : Fragment(), FavoriteView {

    @Inject
    lateinit var presenter: FavoriteJokesPresenter
    lateinit var adapter: JokesAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MyApp.favoriteFragmentComponent(this).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_favorite, container, false)

        setupAdapter()
        setupRecyclerView(view)
        presenter.onCreate()

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onListJokesSuccess(jokeList: List<Joke>?) {
        adapter.setJokes(jokeList)
    }

    override fun onListJokesError() {
        snackbar(favoriteContext, "Error")
    }

    private fun setupRecyclerView(view: View?) {
        recyclerView = view!!.find(R.id.savedJokesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    private fun setupAdapter() {
        adapter = JokesAdapter()
    }
}
