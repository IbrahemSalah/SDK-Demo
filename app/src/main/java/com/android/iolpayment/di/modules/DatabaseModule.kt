package com.android.iolpayment.di.modules

import com.android.iolpayment.data.database.AppDatabase
import com.android.iolpayment.data.database.DbDataSource
import com.android.iolpayment.data.database.DbDataSourceImpl

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {
    single { AppDatabase.getInstance(androidContext()) }

    single<DbDataSource> { DbDataSourceImpl(get()) }
}