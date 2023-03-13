package com.diegusmich.intouch.ui.profile

import androidx.lifecycle.*
import com.diegusmich.intouch.data.model.User
import com.diegusmich.intouch.data.repository.UserRepository

class ProfileViewModel : ViewModel() {

    private val userRepo = UserRepository()

    private val _user = MutableLiveData<User>().apply {
        value = User("Franco", "Franco")
    }

    private val _text = MutableLiveData<String>().apply {
        value = "Profile Fragment!"
    }

    val user : LiveData<User> = _user
}