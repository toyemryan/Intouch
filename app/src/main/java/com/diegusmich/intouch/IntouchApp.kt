package com.diegusmich.intouch

import android.app.Application
import androidx.lifecycle.*
import com.diegusmich.intouch.data.repository.*
import com.diegusmich.intouch.utils.NetworkUtil
import com.google.firebase.FirebaseApp

class IntouchApp : Application(), LifecycleEventObserver {

    private var isAppForeground : Boolean = false

    /**
     * App container for manual Dependency Injection.
     * It serves singleton instances.
     */
    companion object Singletons
    {
        lateinit var USERS_REPOSITORY : UsersRepository
        lateinit var EVENTS_REPOSITORY : EventsRepository
        lateinit var POSTS_REPOSITORY : PostsRepository
        lateinit var CATEGORIES_REPOSITORY : CategoriesRepository
        lateinit var NOTIFICATIONS_REPOSITORY : NotificationsRepository

        private fun initSingletons(){
            USERS_REPOSITORY = UsersRepository()
            EVENTS_REPOSITORY = EventsRepository()
            POSTS_REPOSITORY = PostsRepository()
            CATEGORIES_REPOSITORY = CategoriesRepository()
            NOTIFICATIONS_REPOSITORY = NotificationsRepository()
        }
    }

    override fun onCreate() {
        super.onCreate()

        //Init an observer for application lifecycle
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        //Init network service to observe network status
        NetworkUtil.buildService(this).observe()
        //Init FirebaseApp to initialize singletons instances
        FirebaseApp.initializeApp(this)
        //Init singletons instances in level app container
        initSingletons()
    }

    /**
     * Handle status changes of application lifecycle.
     * Override from LifecycleEventObserver
     */
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        isAppForeground = when(event){
            Lifecycle.Event.ON_START -> true
            Lifecycle.Event.ON_STOP -> false
            else -> return
        }
    }

    fun isAppForeground() : Boolean{
        return isAppForeground
    }
}