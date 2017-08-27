package com.example.david.kotlinchuck.favoriteJokes.presenter

import com.example.david.kotlinchuck.MyApp
import com.example.david.kotlinchuck.favoriteJokes.event.DeleteEvent
import com.example.david.kotlinchuck.favoriteJokes.event.FavoriteEvent
import com.example.david.kotlinchuck.favoriteJokes.repository.FavoriteJokesRepository
import com.example.david.kotlinchuck.favoriteJokes.ui.FavoriteView
import com.example.david.kotlinchuck.lib.base.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

/**
 * Created by david on 10/7/17.
 */
class FavoriteJokesPresenterImpl(var view: FavoriteView?): FavoriteJokesPresenter {


    @Inject
    lateinit var eventBus: EventBus

    @Inject
    lateinit var repository: FavoriteJokesRepository

    override fun onCreate() {

        MyApp.presenterComponent().inject(this)

        if(view != null){
            eventBus.register(this)
            repository.getJokes()
        }
    }

    override fun onDestroy() {
        eventBus.unregister(this)
        view = null
    }

    override fun deleteJoke(text: String) {
        repository.deleteJoke(text)
    }

    @Subscribe
    override fun onEventMainThread(event: FavoriteEvent) {
        when(event.type){
            FavoriteEvent.onSuccess -> view?.onListJokesSuccess(event.jokes)
            FavoriteEvent.onError -> view?.onListJokesError()
        }
    }

    @Subscribe
    override fun onDeleteEvent(event: DeleteEvent) {
        when(event.type){
            DeleteEvent.onSuccess -> view?.onDeleteSuccess(event.jokes)
            DeleteEvent.onError -> view?.onDeleteError()
        }
    }

}