package com.diegusmich.intouch.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthActivityViewModel : ViewModel() {

    private var _tasksRunningState = MutableLiveData<Boolean>().apply {
        value = false
    }

    val tasksRunningState : LiveData<Boolean> = _tasksRunningState

    fun setTasksRunning(state : Boolean){
        _tasksRunningState.value = state
    }
}