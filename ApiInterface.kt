package com.example.retrofitapi

import android.widget.ImageView
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("photos")
    fun getPhotos(): Response<ImageView>
}