package com.diegusmich.intouch.data.repository

import com.diegusmich.intouch.data.model.Category
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class CategoriesRepository : FirebaseRepository<Category>(Category::class.java){

    override val collectionRef = Firebase.firestore.collection("categories")

    override suspend fun delete(id: String) {
        return
    }

    override suspend fun update(id : String, values : Map<String, Any>){
        return
    }

}