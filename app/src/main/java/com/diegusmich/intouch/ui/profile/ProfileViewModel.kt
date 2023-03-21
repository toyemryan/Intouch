package com.diegusmich.intouch.ui.profile

import androidx.lifecycle.*
import com.diegusmich.intouch.data.model.User
import com.diegusmich.intouch.data.model.decorators.toModel
import com.diegusmich.intouch.data.repository.UserRepository
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ProfileViewModel : ViewModel() {

    private val userRepo = UserRepository()

    private val _user = MutableLiveData<User>().apply {
        value = User()
    }

    private val _text = MutableLiveData<String>().apply {
        value = "Profile Fragment!"
    }

    val user : LiveData<User> = _user

    init{
        loadContent()
    }
    fun loadContent(){
        viewModelScope.launch {
            _user.value = loadUser()
        }
    }
    suspend fun loadUser() : User?{
        val docRef = Firebase.firestore.collection("utenti")
            .document("6OcZOlXXpOVfFtgrCZlJ")
            .get().await()

        return docRef.toModel<User>()
    }
}