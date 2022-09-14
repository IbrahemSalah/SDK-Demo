package com.android.iolpayment.di.modules

import com.android.iolpayment.data.SessionManager
import org.koin.dsl.module

val appModule = module {
    single { SessionManager.getInstance(get()) }
}