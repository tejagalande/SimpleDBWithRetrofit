package com.example.demodatabasephp.service

import retrofit2.Call
import retrofit2.http.*

interface UserService {



    @Headers("Content-Type: application/json")
    @POST("registerUser.php")
    @FormUrlEncoded
    fun create(
     //   @Body user : User
        @Field("name") name : String,
        @Field("email") email : String,
        @Field("username") username : String,
        @Field("password") password : String


    ): Call<User>

}


