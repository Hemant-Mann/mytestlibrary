package com.example.mytestlibrary

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class SendRequest {
    private val client = OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://requestbin.offersoptimize.com/")
        .addConverterFactory(MoshiConverterFactory.create().asLenient())
        .client(client)
        .build()

    private val apiService: APIService

    init {
        apiService = retrofit.create(APIService::class.java)
    }

    suspend fun toRequestBin(body: MutableMap<String, Any>) {
        try {
            apiService.send(body)
        } catch (ex: Exception) {
            Log.d("mytestlibrary", "$ex")
        }

    }
}


