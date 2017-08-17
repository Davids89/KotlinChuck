package com.example.david.kotlinchuck.favoriteJokes.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.david.kotlinchuck.R
import com.example.david.kotlinchuck.entities.Joke

/**
 * Created by david on 15/8/17.
 */
class JokesAdapter: RecyclerView.Adapter<JokeViewHolder>() {

    var jokeList: List<Joke> = listOf()

    override fun onBindViewHolder(holder: JokeViewHolder?, position: Int) {
        val joke = jokeList.get(position)
        holder!!.bindJoke(joke)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): JokeViewHolder {
        val view: View = LayoutInflater.from(parent!!.context).inflate(R.layout.item_saved_joke, parent, false)
        return JokeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return jokeList.size
    }

    fun setJokes(jokes: List<Joke>?){
        if(jokes != null){
            this.jokeList = jokes
            this.notifyDataSetChanged()
        }
    }
}