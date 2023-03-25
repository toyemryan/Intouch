package com.diegusmich.intouch

import android.app.Application
import com.diegusmich.intouch.data.repository.*
import com.google.firebase.FirebaseApp

class IntouchApp : Application() {

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
        //Init FirebaseApp to initialize singletons instances
        FirebaseApp.initializeApp(this)
        //Init singletons instances in level app container
        initSingletons()
    }
}