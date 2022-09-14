package com.android.iolpaymentsdk.data.repositories


import com.android.iolpaymentsdk.data.model.APIError
import com.android.iolpaymentsdk.data.model.APIResult
import com.android.iolpaymentsdk.data.model.FailureException
import com.android.iolpaymentsdk.data.remote.RemoteDataSource
import retrofit2.Response

class RepositoryImp(
    private val remoteDataSource: RemoteDataSource
) : Repository {


    // ----------remote------------

    override suspend fun getBaseAppResponse() = safeAPIResult(remoteDataSource.getBaseAppResponse())

    override suspend fun getDiscoverMovieList() =
        safeAPIResult(remoteDataSource.getDiscoverMovieList("c50f5aa4e7c95a2a553d29b81aad6dd0"))


    // ---------- end remote------------


    private fun <T> safeAPIResult(response: Response<T>): APIResult<T> {
        return when {
            response.code() in 200..299 -> {
                APIResult.Success(response.body())
            }
            response.code() == 401 -> {
                throw  FailureException.InvalidUserException("", 401)
            }
            else -> {
                APIResult.Failure(APIError(response.raw().message, "", "", response.code()))
            }
        }
    }
}