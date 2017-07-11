package com.example.david.kotlinchuck.mainActivity.presenter

import com.example.david.kotlinchuck.entities.Joke
import com.example.david.kotlinchuck.mainActivity.FindJokePresenter
import com.example.david.kotlinchuck.mainActivity.FindJokePresenterImpl
import com.example.david.kotlinchuck.mainActivity.FindJokeRepository
import com.example.david.kotlinchuck.mainActivity.event.FindJokeEvent
import com.example.david.kotlinchuck.mainActivity.ui.FindJokeView
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by dani on 11/7/17.
 */

@RunWith(MockitoJUnitRunner::class)
class FindJokePresenterTest {

    @Mock
    private val mFindJokeView: FindJokeView? = null

    @Mock
    private val mFindJokeRepository: FindJokeRepository? = null

    private var mFindJokePresenter: FindJokePresenter? = null

    @Before
    fun setupTest() {
        // EventBus is not mocked because it can't be tested on unit tests. Use instrumental test instead
        mFindJokePresenter = FindJokePresenterImpl(mFindJokeView, mFindJokeRepository!!, null)
    }

    @Test
    fun testFindJokeSucces() {
        val jokeName = "Joke"
        val lastName = "Lastname"
        val event: FindJokeEvent = FindJokeEvent()
        event.type = FindJokeEvent.onSuccess
        event.joke = Joke("1", "I'm Batman")

        assertNotEquals(jokeName.length, 0)
        assertNotEquals(lastName.length, 0)

        mFindJokePresenter!!.findJoke(jokeName, lastName)
        Mockito.verify(mFindJokeRepository)!!.findJoke(jokeName, lastName)
        mFindJokePresenter!!.onEventMainThread(event)
        Mockito.verify(mFindJokeView)!!.jokeSuccess(event.joke!!)
    }
}