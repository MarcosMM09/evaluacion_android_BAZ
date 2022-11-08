package com.example.myapplication.Interfaces

import com.example.myapplication.retroData.retroDataRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url


interface APIService {
    val url: String
        get() = "api/users?page=2"

    @GET
    fun getId(@Url url: String): Call<retroDataRequest>
}