package com.example.david.kotlinchuck.favoriteJokes.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.david.kotlinchuck.entities.Joke
import kotlinx.android.synthetic.main.item_saved_joke.view.*

/**
 * Created by david on 15/8/17.
 */
class JokeViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun bindJoke(joke: Joke){
        itemView.jokeText.text = joke.joke
    }
}