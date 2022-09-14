package com.android.iolpayment.di.modules

import com.android.iolpayment.data.offline.Offline
import com.android.iolpayment.data.offline.OfflineImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val offlineModule = module{
    single<Offline> { OfflineImpl(androidApplication()) }
}