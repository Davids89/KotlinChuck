package com.example.david.kotlinchuck.mainActivity.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.example.david.kotlinchuck.R
import com.example.david.kotlinchuck.entities.Joke
import com.example.david.kotlinchuck.mainActivity.FindJokePresenter
import com.example.david.kotlinchuck.mainActivity.FindJokePresenterImpl
import com.example.david.kotlinchuck.mainActivity.ui.FindJokeView
import kotlinx.android.synthetic.main.fragment_search.*
import org.jetbrains.anko.support.v4.find


/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment(), FindJokeView {

    val presenter: FindJokePresenter = FindJokePresenterImpl(this)
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_search, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
    }

    private fun setViews() {
        button = find(R.id.findJoke)

        button.setOnClickListener { presenter.findJoke(name.text.toString(), lastName.text.toString())  }
    }

    override fun jokeSuccess(joke: Joke) {
        chuckJoke.text = joke.joke
    }

    override fun jokeError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
