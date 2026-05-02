package com.fourgauteau.os.helper

import androidx.lifecycle.MutableLiveData

class SingleLiveEvent<T> : MutableLiveData<T?>() {
    fun call() {
        postValue(null)
    }
}
