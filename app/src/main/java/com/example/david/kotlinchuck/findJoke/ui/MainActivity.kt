package com.example.david.kotlinchuck.findJoke.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.david.kotlinchuck.R
import com.example.david.kotlinchuck.entities.Joke
import com.example.david.kotlinchuck.findJoke.FindJokePresenter
import com.example.david.kotlinchuck.findJoke.FindJokePresenterImpl
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity(), FindJokeView {

    lateinit var presenter : FindJokePresenter
    var name: TextView? = null
    var lastName: TextView? = null
    var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setViews()

        presenter = FindJokePresenterImpl(this)
        presenter.onCreate()
    }

    private fun setViews() {
        button = find<Button>(R.id.findJoke)
        name = find<TextView>(R.id.name)
        lastName = find<TextView>(R.id.lastName)

        button?.onClick { searchJoke(name?.text.toString(), lastName?.text.toString()) }
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

    private fun searchJoke(name: String, lastName: String){
        presenter.findJoke(name, lastName)
    }
}
