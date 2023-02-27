package com.example.myabsensi.retrofit

import com.example.myabsensi.pojo.*
import retrofit2.Call
import retrofit2.http.*

interface ApiEndpoint {
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email:String,
        @Field("password") password:String
    ):Call<LoginResponse>
}