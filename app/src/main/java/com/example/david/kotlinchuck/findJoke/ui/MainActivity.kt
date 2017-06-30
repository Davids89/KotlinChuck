package com.example.david.kotlinchuck.findJoke.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.david.kotlinchuck.R
import com.example.david.kotlinchuck.entities.Joke
import com.example.david.kotlinchuck.findJoke.FindJokePresenter
import com.example.david.kotlinchuck.findJoke.FindJokePresenterImpl

class MainActivity : AppCompatActivity(), FindJokeView {

    lateinit var presenter : FindJokePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = FindJokePresenterImpl(this)
        presenter.onCreate()
    }

    override fun jokeSuccess(joke: Joke) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun jokeError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
