package com.migulyaev.baseapplication.presentation.base.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.migulyaev.baseapplication.presentation.base.mvvm.utils.SingleReadEvent

abstract class BaseViewModel: ViewModel() {

    protected val errors = MutableLiveData<SingleReadEvent<String>>()

    fun observeErrors(): LiveData<SingleReadEvent<String>> = errors

    override fun onCleared() {
        disposables.clear()
    }

}