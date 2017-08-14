package com.example.david.kotlinchuck

import android.app.Application
import android.content.Context
import com.example.david.kotlinchuck.di.app.DaggerMyAppComponent
import com.example.david.kotlinchuck.di.app.MyAppComponent
import com.example.david.kotlinchuck.di.app.MyAppModule
import com.example.david.kotlinchuck.di.presenter.DaggerPresentersComponent
import com.example.david.kotlinchuck.di.presenter.PresentersComponent
import com.example.david.kotlinchuck.di.presenter.PresentersModule
import com.example.david.kotlinchuck.di.repository.DaggerRepositoryComponent
import com.example.david.kotlinchuck.di.repository.RepositoryComponent
import com.example.david.kotlinchuck.di.repository.RepositoryModule
import com.example.david.kotlinchuck.favoriteJokes.di.DaggerFavoriteComponent
import com.example.david.kotlinchuck.favoriteJokes.di.FavoriteComponent
import com.example.david.kotlinchuck.favoriteJokes.di.FavoriteModule
import com.example.david.kotlinchuck.favoriteJokes.ui.FavoriteView
import com.example.david.kotlinchuck.findJoke.di.DaggerFindJokeComponent
import com.example.david.kotlinchuck.findJoke.di.FindJokeComponent
import com.example.david.kotlinchuck.findJoke.di.FindJokeModule
import com.example.david.kotlinchuck.findJoke.ui.FindJokeView
import com.example.david.kotlinchuck.mainActivity.MainActivity
import com.example.david.kotlinchuck.mainActivity.di.DaggerMainActivityComponent
import com.example.david.kotlinchuck.mainActivity.di.MainActivityComponent
import com.example.david.kotlinchuck.mainActivity.di.MainActivityModule
import io.realm.Realm

/**
 * Created by david on 9/7/17.
 */
class MyApp: Application() {
    companion object {
        lateinit var context: Context
        lateinit var component: MyAppComponent

        fun mainActivityComponent(mainActivity: MainActivity): MainActivityComponent{
            return DaggerMainActivityComponent.builder()
                    .mainActivityModule(MainActivityModule(mainActivity))
                    .build()
        }

        fun searchFragmentComponent(view: FindJokeView): FindJokeComponent{
            return DaggerFindJokeComponent.builder()
                    .findJokeModule(FindJokeModule(view))
                    .build()
        }

        fun favoriteFragmentComponent(view : FavoriteView): FavoriteComponent{
            return DaggerFavoriteComponent.builder()
                    .favoriteModule(FavoriteModule(view))
                    .build()
        }

        fun presenterComponent(): PresentersComponent {
            return DaggerPresentersComponent.builder()
                    .presentersModule(PresentersModule())
                    .build()
        }

        fun repositoryComponent(): RepositoryComponent {
            return DaggerRepositoryComponent.builder()
                    .repositoryModule(RepositoryModule())
                    .build()
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        component = DaggerMyAppComponent.builder()
                .myAppModule(MyAppModule(context))
                .build()

        initializeRealm()
    }

    private fun initializeRealm() {
        Realm.init(this)
    }
}