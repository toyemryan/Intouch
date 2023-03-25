package com.diegusmich.intouch.data.repository

import com.diegusmich.intouch.data.model.DataModel
import com.diegusmich.intouch.data.model.decorators.toModel
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.tasks.await
/**
 * Define a Repository object that manage data
 * from a Firebase remote collection.
 *
 * @since 0.2.8
 */
abstract class FirebaseRepository<T : DataModel> (private val clazz: Class<T>) {

    /**
     * Reference of Firestore collection associated.
     */
    protected abstract val collectionRef : CollectionReference

    /**
     * Fetch document data from collection by id.
     *
     * @param id document id to fetch
     * @return object of type T
     */
    open suspend fun find(id: String): T? {

        val data : DocumentSnapshot

        try {
            data = collectionRef.document(id).get().await()
        }
        catch (e: Exception) {
            return null
        }

        return data.toModel(clazz)
    }

    /**
     * Fetch all documents data from a collection.
     *
     * @return List<T> All data as model
     */
    open suspend fun all(): List<T>? {
        val usersList: MutableList<T> = mutableListOf()
        val data : QuerySnapshot

        try {
            val data = collectionRef.get().await()

            for (doc in data) {
                usersList.add(doc.toModel(clazz))
            }

        } catch (e: Exception) {
            return null
        }

        return usersList.toList()
    }

    /**
     * Update data of document in collection
     *
     * @param id document id to update
     * @param values map of values to update
     * @return Unit
     */
    open suspend fun update(id : String, values : Map<String, Any>){
        TODO("Da implementare")
    }

    /**
     * Fetch all documents data from a collection.
     *
     * @param id document id to delete
     * @return List<T> All data as model
     */
    open suspend fun delete(id: String){
        TODO("Da implementare")
    }
}