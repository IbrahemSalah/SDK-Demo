package com.android.iolpayment.data.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteDataSourceImp(private val remoteApi: BaseAppAPI) : RemoteDataSource {

    override suspend fun getDiscoverMovieList(apiKey: String) = withContext(Dispatchers.IO) {
        remoteApi.getDiscoverMovieList(apiKey)
    }

    override suspend fun getBaseAppResponse() = withContext(Dispatchers.IO) {
        remoteApi.getBaseAppResponse()
    }
}