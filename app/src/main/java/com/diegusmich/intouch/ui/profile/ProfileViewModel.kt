package com.diegusmich.intouch.ui.profile

import androidx.lifecycle.*
import com.diegusmich.intouch.data.model.User
import com.diegusmich.intouch.domain.auth.GetAuth
import com.diegusmich.intouch.domain.users.GetUser
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    private val getAuth = GetAuth()

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
            _user.value = getAuth()?.user
        }
    }
}