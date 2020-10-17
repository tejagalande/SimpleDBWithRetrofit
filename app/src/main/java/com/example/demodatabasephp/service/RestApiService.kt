package com.example.demodatabasephp.service

import com.example.demodatabasephp.service.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {

    fun addUser(userData : User, onResult :(User?) -> Unit) {
        val retrofit = ServiceFactory.build(UserService::class.java)
//        retrofit.create(userData).enqueue(
//            object :Callback<Users>{
//                override fun onResponse(call: Call<Users>, response: Response<Users>) {
//                    val addedUser = response.body()
//                    onResult(addedUser)
//                }
//
//                override fun onFailure(call: Call<Users>, t: Throwable) {
//                    onResult(null)
//                }
//
//            }
//        )

    }

}