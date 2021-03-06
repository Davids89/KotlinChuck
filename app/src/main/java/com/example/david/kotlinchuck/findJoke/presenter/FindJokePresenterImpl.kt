package com.example.david.kotlinchuck.findJoke.presenter

import com.example.david.kotlinchuck.MyApp
import com.example.david.kotlinchuck.entities.Joke
import com.example.david.kotlinchuck.findJoke.repository.FindJokeRepository
import com.example.david.kotlinchuck.findJoke.event.FindJokeEvent
import com.example.david.kotlinchuck.findJoke.event.SaveJokeEvent
import com.example.david.kotlinchuck.findJoke.ui.FindJokeView
import com.example.david.kotlinchuck.lib.base.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

/**
 * Created by david on 28/6/17.
 */
class FindJokePresenterImpl(var view: FindJokeView?) : FindJokePresenter {

    @Inject
    lateinit var eventBus: EventBus

    @Inject
    lateinit var repository: FindJokeRepository

    override fun onCreate() {

        MyApp.presenterComponent().inject(this)

        if(view != null){
            this.eventBus.register(this)
        }
    }

    override fun onDestroy() {
        this.eventBus.unregister(this)
        view = null
    }

    override fun findJoke() {
        repository.findJoke()
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
                findJoke()
            }
            SaveJokeEvent.onError -> view?.saveJokeError(event.message)
        }
    }

}