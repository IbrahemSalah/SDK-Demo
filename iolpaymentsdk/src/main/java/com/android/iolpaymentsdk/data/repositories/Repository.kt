package com.android.iolpaymentsdk.data.repositories

import com.android.iolpaymentsdk.data.model.APIResult
import com.android.iolpaymentsdk.data.model.BaseAppResponse
import com.android.iolpaymentsdk.data.model.MovieListResponse


interface Repository  {

    suspend fun getDiscoverMovieList(): APIResult<MovieListResponse>

    suspend fun getBaseAppResponse(): APIResult<BaseAppResponse>
}
