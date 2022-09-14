package com.android.iolpayment.data.remote

import com.android.iolpayment.data.model.BaseAppResponse
import com.android.iolpayment.data.model.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface BaseAppAPI {


    @GET("https://api.themoviedb.org/3/discover/movie")
    suspend fun getDiscoverMovieList(@Query("api_key") apiKey: String): Response<MovieListResponse>


    @POST("dummy/getBaseAppResponse")
    suspend fun getBaseAppResponse(): Response<BaseAppResponse>
}