package com.example.accenturerestapidemo.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private var retrofit: Retrofit? = null
  //  https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json
    const val BASE_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/"

    val service: APIService
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(APIService::class.java)
        }
}