package com.diegusmich.intouch.data.repository

import com.diegusmich.intouch.data.model.User
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

/**
 * Define repository for Users collection of Firestore.
 * Extends Repository abstract class.
 *
 * @see com.diegusmich.intouch.data.repository.Repository
 * @since 0.2.8
 */
class UserRepository : Repository<User>() {

    override val collectionRef: CollectionReference = Firebase.firestore.collection("users")

    override suspend fun find(id : String) : User? {
        try{
            val _snapshot = collectionRef.document(id).get().await()

            return User().fromData(_snapshot.data)
        }
        catch (e : Exception){
            return null
        }
    }

    override suspend fun all() : List<User>? {
        val usersList : MutableList<User> = mutableListOf()

        try{
            val querySnapshots = collectionRef.get().await()

            for (doc in querySnapshots){
                usersList.add(User().fromData(doc.data))
            }

            return usersList
        }
        catch (e : Exception){
            return null
        }
    }

    override suspend fun update(id: String, values: Map<String, Any>) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String) {
        TODO("Not yet implemented")
    }
}