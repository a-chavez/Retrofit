package com.example.retrofit.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {

    companion object{
        private const val URL_BASE = "https://android-kotlin-fun-mars-server.appspot.com/"
        //private val retro = RetrofitClient

        fun getRetrofitClient() : ApiInterface {
            val mRetrofitClient = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return mRetrofitClient.create(ApiInterface::class.java)
        }
    }
}