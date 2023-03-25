package com.diegusmich.intouch.data.repository

import com.diegusmich.intouch.data.model.Event
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EventsRepository() : FirebaseRepository<Event>(Event::class.java){

    override val collectionRef = Firebase.firestore.collection("events")

}