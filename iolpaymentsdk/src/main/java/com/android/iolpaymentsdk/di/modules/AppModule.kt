package com.android.iolpaymentsdk.di.modules

import com.android.iolpaymentsdk.data.SessionManager
import org.koin.dsl.module

val appModule = module {
    single  { SessionManager.getInstance(get()) }
}