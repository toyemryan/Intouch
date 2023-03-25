package com.diegusmich.intouch.data.repository

import com.diegusmich.intouch.data.model.Notification
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class NotificationsRepository : FirebaseRepository<Notification>(Notification::class.java) {

    override val collectionRef = Firebase.firestore.collection("notifications")
}