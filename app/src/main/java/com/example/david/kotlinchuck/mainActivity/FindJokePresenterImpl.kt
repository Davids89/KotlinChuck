package com.example.david.kotlinchuck.mainActivity

import com.example.david.kotlinchuck.mainActivity.event.FindJokeEvent
import com.example.david.kotlinchuck.mainActivity.ui.FindJokeView
import com.example.david.kotlinchuck.lib.EventBus
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

        var finalName: String? = null
        var finalLastName: String? = null

        if(!name.isEmpty())
            finalName = name

        if(!lastname.isEmpty())
            finalLastName = lastname

        repository.findJoke(name, lastname)
    }

    @Subscribe
    override fun onEventMainThread(event: FindJokeEvent) {

        when(event.type){
            FindJokeEvent.onSuccess -> view?.jokeSuccess(event.joke!!)
        }
    }

}