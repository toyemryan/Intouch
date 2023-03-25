package com.diegusmich.intouch.domain.users

import com.diegusmich.intouch.IntouchApp
import com.diegusmich.intouch.data.model.User


class GetUser(){

    private val usersRepo = IntouchApp.Singletons.USERS_REPOSITORY

    suspend operator fun invoke(id : String) : User?{
        return usersRepo.find(id)
    }
}