package com.flickr.movies.repository

import com.flickr.movies.api.ApiService

class Repository(private val apiService: ApiService) {

    suspend fun getData() = apiService.getData("The+Lion+King", "movie", 5)

}