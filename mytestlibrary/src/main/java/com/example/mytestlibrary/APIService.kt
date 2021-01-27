package com.example.mytestlibrary

import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {
    @POST("1jwob8g1")
    suspend fun send(@Body data: MutableMap<String, Any>)

}