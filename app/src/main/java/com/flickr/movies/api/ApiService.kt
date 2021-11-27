package com.flickr.movies.api

import com.flickr.movies.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    suspend fun getData (
        @Query("term") term: String,
        @Query("media") media: String,
        @Query("limit") limit: Int,
    ): Response

}