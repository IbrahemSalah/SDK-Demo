package com.android.iolpayment.data.remote

import com.android.iolpayment.data.model.BaseAppResponse
import com.android.iolpayment.data.model.MovieListResponse
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getDiscoverMovieList(apiKey: String): Response<MovieListResponse>

    suspend fun getBaseAppResponse(): Response<BaseAppResponse>
}