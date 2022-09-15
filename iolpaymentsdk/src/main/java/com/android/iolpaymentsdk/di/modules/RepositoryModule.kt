package com.android.iolpaymentsdk.di.modules

import com.android.iolpaymentsdk.data.remote.RemoteDataSource
import com.android.iolpaymentsdk.data.remote.RemoteDataSourceImp
import com.android.iolpaymentsdk.data.repositories.Repository
import com.android.iolpaymentsdk.data.repositories.RepositoryImp
import org.koin.core.qualifier.named
import org.koin.dsl.module


val repositoryModule = module {
    single<RemoteDataSource>  (named("iol-RemoteDataSource")) {
        return@single RemoteDataSourceImp(get(named("iol-provideApiService")))
    }

    single<Repository> (named("iol-Repository")) {
        RepositoryImp(
            remoteDataSource = get(named("iol-RemoteDataSource"))
        )
    }
}
