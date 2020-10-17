package com.example.demodatabasephp.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ServiceFactory constructor(private val retrofit : Retrofit) {

    companion object ServiceFactory {

        private val client = OkHttpClient.Builder().build()

        private val baseUrl = "http://192.168.1.3/User/"

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .client(client)
                .build()

        fun <T> build(service : Class<T>): T{
            return retrofit.create(service)
        }


    }


}