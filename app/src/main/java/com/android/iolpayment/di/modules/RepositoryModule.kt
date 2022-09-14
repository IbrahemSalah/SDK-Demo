package com.android.iolpayment.di.modules

import com.google.gson.Gson
import com.android.iolpayment.data.raw.RawDataSource
import com.android.iolpayment.data.raw.RawDataSourceImp
import com.android.iolpayment.data.remote.RemoteDataSource
import com.android.iolpayment.data.remote.RemoteDataSourceImp
import com.android.iolpayment.data.sharedpref.PrefDataSource
import com.android.iolpayment.data.sharedpref.PrefDataSourceImp
import com.android.iolpayment.data.repositories.Repository
import com.android.iolpayment.data.repositories.RepositoryImp
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val repositoryModule = module {
    single<RemoteDataSource> {
        return@single RemoteDataSourceImp(get())
    }
    single<RawDataSource> { RawDataSourceImp(androidContext(), Gson()) }
    single<PrefDataSource> { PrefDataSourceImp(androidApplication()) }

    single<Repository> {
        RepositoryImp(
            remoteDataSource = get(),
            prefDataSource = get(),
            offline = get(),
            dbDataSource = get(),
            rawDataSource = get()
        )
    }
}
