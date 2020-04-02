package com.example.accenturerestapidemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.accenturerestapidemo.model.ListRepository
import com.example.accenturerestapidemo.model.ResponseData


import javax.inject.Inject

class MainActivityViewModel @Inject constructor( private var listRepository: ListRepository) :ViewModel(){

    fun getProjectResponse():LiveData<ResponseData>{
        return listRepository.getMutableLiveData()
    }


}