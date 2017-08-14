package com.example.david.kotlinchuck.entities

import io.realm.RealmObject

/**
 * Created by david on 28/6/17.
 */

open class Joke: RealmObject(){

    var id: String? = null
    var joke: String? = null
    var saved: Boolean = false
}