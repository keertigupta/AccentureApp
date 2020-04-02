package com.example.accenturerestapidemo.model
import androidx.lifecycle.MutableLiveData
import com.example.accenturerestapidemo.service.APIService
import com.example.accenturerestapidemo.service.RetrofitInstance


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class ListRepository @Inject constructor(){

    private val mutableLiveResponse: MutableLiveData<ResponseData> = MutableLiveData()


    fun getData():String{
        return "this is string"
    }
     fun getMutableLiveData():MutableLiveData<ResponseData> {
         val apiRes: APIService = RetrofitInstance.service
         val call: Call<ResponseData> = apiRes.getList()
         call?.enqueue(object : Callback<ResponseData?> {
             override fun onFailure(call: Call<ResponseData?>, t: Throwable) {

             }

             override fun onResponse(
                 call: Call<ResponseData?>,
                 response: Response<ResponseData?>
             ) {
                 val apiResponse: ResponseData? = response.body()
                 if (apiResponse != null) {
                     mutableLiveResponse.value = apiResponse

                 }

             }
         })

         return mutableLiveResponse
     }
}