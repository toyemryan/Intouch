package com.diegusmich.intouch.domain.auth

import com.diegusmich.intouch.data.model.Auth
import com.diegusmich.intouch.domain.users.GetUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class GetAuth{

    private val getUser = GetUser()

    suspend operator fun invoke() : Auth? {

        if(Firebase.auth.currentUser == null)
            return null

        val user = getUser(Firebase.auth.uid.toString())

        return Auth(user)
    }
}