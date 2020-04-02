package com.example.accenturerestapidemo.service


import com.example.accenturerestapidemo.model.ResponseData

import retrofit2.Call
import retrofit2.http.GET


interface APIService {
    @GET("facts.json")
    fun getList(): Call<ResponseData>
}