package com.example.david.kotlinchuck.findJoke.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.david.kotlinchuck.R
import com.example.david.kotlinchuck.entities.Joke

class MainActivity : AppCompatActivity(), FindJokeView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun jokeSuccess(joke: Joke) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun jokeError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
