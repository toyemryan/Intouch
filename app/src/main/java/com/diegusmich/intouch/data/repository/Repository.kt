package com.diegusmich.intouch.data.repository

import com.google.firebase.firestore.CollectionReference

/**
 * Declare basic CRUD methods to read and manage data from firebase collection.
 * It need to be extends by subclasses to define methods for each Model.
 *
 * @since 0.2.8
 */
abstract class Repository<T>{

    protected abstract val collectionRef : CollectionReference

    abstract suspend fun find(id : String) : T?

    abstract suspend fun all() : List<T>?

    abstract suspend fun update(id : String, values : Map<String, Any>)

    abstract suspend fun delete(id: String)
}