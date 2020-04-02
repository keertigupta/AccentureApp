package com.example.wiproassignmentproject.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.accenturerestapidemo.viewmodel.MainActivityViewModel


import javax.inject.Inject
import javax.inject.Provider

class MyViewModelfactory @Inject constructor(private var myviewmodelProvider:
                                             Provider<MainActivityViewModel>)
    :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return myviewmodelProvider.get() as T
    }
}