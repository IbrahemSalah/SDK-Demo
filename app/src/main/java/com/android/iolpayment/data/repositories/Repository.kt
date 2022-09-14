package com.android.iolpayment.data.repositories


import com.android.iolpayment.data.database.DbDataSource
import com.android.iolpayment.data.model.APIResult
import com.android.iolpayment.data.model.BaseAppResponse
import com.android.iolpayment.data.model.MovieListResponse
import com.android.iolpayment.data.raw.RawDataSource
import com.android.iolpayment.data.sharedpref.PrefDataSource

interface Repository : PrefDataSource, DbDataSource, RawDataSource {

    suspend fun getDiscoverMovieList(): APIResult<MovieListResponse>

    suspend fun getBaseAppResponse(): APIResult<BaseAppResponse>
    fun dummyOffline(): APIResult<String>
}
