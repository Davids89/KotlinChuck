package com.example.david.kotlinchuck.findJoke.presenter

import com.example.david.kotlinchuck.entities.Joke
import com.example.david.kotlinchuck.findJoke.repository.FindJokeRepository
import com.example.david.kotlinchuck.findJoke.repository.FindJokeRepositoryImpl
import com.example.david.kotlinchuck.findJoke.event.FindJokeEvent
import com.example.david.kotlinchuck.findJoke.event.SaveJokeEvent
import com.example.david.kotlinchuck.findJoke.ui.FindJokeView
import com.example.david.kotlinchuck.lib.base.EventBus
import com.example.david.kotlinchuck.lib.GreenRobotEventBus
import org.greenrobot.eventbus.Subscribe

/**
 * Created by david on 28/6/17.
 */
class FindJokePresenterImpl(view: FindJokeView) : FindJokePresenter {

    var view: FindJokeView? = view
    var eventBus: EventBus = GreenRobotEventBus.INSTANCE
    var repository: FindJokeRepository = FindJokeRepositoryImpl()


    override fun onCreate() {
        if(view != null){
            this.eventBus.register(this)
        }
    }

    override fun onDestroy() {
        this.eventBus.unregister(this)
        view = null
    }

    override fun findJoke(name: String, lastname: String) {

        var finalName: String = String()
        var finalLastName: String = String()

        if(!name.isEmpty())
            finalName = name

        if(!lastname.isEmpty())
            finalLastName = lastname

        repository.findJoke(finalName, finalLastName)
    }

    override fun saveJoke(joke: Joke) {
        if(view != null)
            repository.saveJoke(joke)
    }

    @Subscribe
    override fun onEventMainThread(event: FindJokeEvent) {
        when(event.type){
            FindJokeEvent.onSuccess -> {
                view?.jokeSuccess(event.joke!!)
                view?.showSaveJoke()
            }
            FindJokeEvent.onError -> view?.jokeError()
        }
    }

    @Subscribe
    override fun onSaveJokeEvent(event: SaveJokeEvent) {
        when(event.type){
            SaveJokeEvent.onSuccess ->{
                view?.saveJokeSuccess(event.message)
                findJoke("","")
            }
            SaveJokeEvent.onError -> view?.saveJokeError(event.message)
        }
    }

}