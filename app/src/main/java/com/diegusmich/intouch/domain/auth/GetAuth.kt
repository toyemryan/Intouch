package com.diegusmich.intouch.domain.auth

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class GetAuth{

    operator fun invoke() : FirebaseUser? {
        return Firebase.auth.currentUser
    }
}