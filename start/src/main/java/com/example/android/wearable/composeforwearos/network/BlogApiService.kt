package com.example.android.wearable.composeforwearos.network

import com.example.android.wearable.composeforwearos.models.Blog
import retrofit2.http.GET

interface BlogApiService {
    @GET("blog/published")
    suspend fun getPublishedBlogs(): List<Blog>
}