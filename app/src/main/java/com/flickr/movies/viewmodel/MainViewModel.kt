package com.flickr.movies.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import com.flickr.movies.api.RetrofitInstance
import com.flickr.movies.utils.Resource
import com.flickr.movies.repository.Repository
import kotlinx.coroutines.Dispatchers

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository: Repository = Repository(RetrofitInstance.apiService)

    fun getData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val data = repository.getData()
            //data = response.data
            emit(Resource.success(data = data.results))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}