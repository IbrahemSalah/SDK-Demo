package com.android.iolpaymentsdk.data.remote

import com.android.iolpaymentsdk.data.model.BaseAppResponse
import com.android.iolpaymentsdk.data.model.MovieListResponse
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getDiscoverMovieList(apiKey: String): Response<MovieListResponse>


    suspend fun getBaseAppResponse(): Response<BaseAppResponse>
}