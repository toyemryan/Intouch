package com.diegusmich.intouch.ui.profile

import androidx.lifecycle.*
import com.diegusmich.intouch.data.model.User
import com.diegusmich.intouch.data.model.decorators.asModel
import com.diegusmich.intouch.domain.auth.GetAuth
import com.diegusmich.intouch.domain.users.GetUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

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

    fun loadContent() {
        viewModelScope.launch {
            _user.value = Firebase.auth.currentUser?.asModel()
        }
    }
}