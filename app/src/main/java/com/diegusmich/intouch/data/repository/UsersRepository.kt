package com.diegusmich.intouch.data.repository

import com.diegusmich.intouch.data.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * Define repository for Users collection of Firestore.
 * Extends Repository abstract class.
 *
 * @since 0.2.8
 */
class UsersRepository : FirebaseRepository<User>(User::class.java){

    override val collectionRef = Firebase.firestore.collection("users")
}