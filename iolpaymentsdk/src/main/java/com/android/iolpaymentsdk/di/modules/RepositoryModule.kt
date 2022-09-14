package com.android.iolpaymentsdk.di.modules

import com.android.iolpaymentsdk.data.remote.RemoteDataSource
import com.android.iolpaymentsdk.data.remote.RemoteDataSourceImp
import com.android.iolpaymentsdk.data.repositories.Repository
import com.android.iolpaymentsdk.data.repositories.RepositoryImp
import org.koin.dsl.module


val repositoryModule = module {
    single<RemoteDataSource> {
        return@single RemoteDataSourceImp(get())
    }

    single<Repository> {
        RepositoryImp(
            remoteDataSource = get()
        )
    }
}
