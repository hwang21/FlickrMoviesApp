package com.flickr.movies.model

data class Response(
    val resultCount: Int,
    val results: List<Movie>
)