package com.diegusmich.intouch.data.repository

import com.diegusmich.intouch.data.model.Post
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class PostsRepository : FirebaseRepository<Post>(Post::class.java) {

    override val collectionRef = Firebase.firestore.collection("posts")
}