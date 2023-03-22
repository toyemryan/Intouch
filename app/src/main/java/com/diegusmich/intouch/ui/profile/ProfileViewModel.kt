package com.diegusmich.intouch.ui.profile

import androidx.lifecycle.*
import com.diegusmich.intouch.data.model.User
import com.diegusmich.intouch.data.model.decorators.toModel
import com.diegusmich.intouch.data.repository.UserRepository
import com.diegusmich.intouch.domain.users.GetUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ProfileViewModel : ViewModel() {

    private val getUser = GetUser()

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
            _user.value = getUser("yC0AlZtIpuPq9BMoeSGK4AelZzu1")
        }
    }
}