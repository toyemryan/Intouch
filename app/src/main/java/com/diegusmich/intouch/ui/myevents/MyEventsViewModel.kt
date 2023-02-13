package com.diegusmich.intouch.ui.myevents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyEventsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "My Events Fragment"
    }
    val text: LiveData<String> = _text
}