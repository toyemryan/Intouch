package com.diegusmich.intouch.domain.users

import com.diegusmich.intouch.data.model.User
import com.diegusmich.intouch.data.repository.UserRepository

class GetUser{

    var userRepo = UserRepository()

    suspend operator fun invoke(id : String) : User?{
        return userRepo.find(id)
    }
}