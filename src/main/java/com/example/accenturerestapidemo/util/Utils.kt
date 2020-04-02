package com.example.accenturerestapidemo.util

import android.content.Context
import android.net.ConnectivityManager


object Utils {

    fun isNetworkAvailable(context: Context):Boolean{

       // ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)
        val c :ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

       return c.activeNetworkInfo!=null&&c.activeNetworkInfo.isConnected

    }
}