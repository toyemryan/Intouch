package com.diegusmich.intouch.data.model

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Auth(user : User?){

    val email : String? = Firebase.auth.currentUser?.email
    val uid : String? = Firebase.auth.uid
    val user : User? = user
}