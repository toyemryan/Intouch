package com.diegusmich.intouch.data.model.decorators

import com.diegusmich.intouch.data.model.User
import com.diegusmich.intouch.domain.users.GetUser
import com.google.firebase.auth.FirebaseUser

suspend fun FirebaseUser.asModel() : User? {
    return GetUser().invoke(this.uid)
}