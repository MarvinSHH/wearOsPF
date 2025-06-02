package com.example.android.wearable.composeforwearos.repository

import com.example.android.wearable.composeforwearos.models.Blog
import com.example.android.wearable.composeforwearos.network.RetrofitClient

class BlogRepository {
    suspend fun getPublishedBlogs(): List<Blog> {
        return RetrofitClient.apiService.getPublishedBlogs()
    }
}