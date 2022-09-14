package com.android.iolpaymentsdk.di

import android.content.Context
import com.android.iolpaymentsdk.di.modules.appModule
import com.android.iolpaymentsdk.di.modules.networkModule
import com.android.iolpaymentsdk.di.modules.repositoryModule
import com.android.iolpaymentsdk.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.dsl.koinApplication

object IOLPaymentSDK {
    internal var app: KoinApplication? = null

    @JvmStatic
    fun start(applicationContext: Context) {
        app = buildKoinApplication(applicationContext)
    }

    @JvmStatic
    fun stop() = synchronized(this) {
        app?.close()
        app = null
    }

    @JvmStatic
    fun get(): KoinApplication = app
        ?: error("KoinApplication for CustomSDK has not been started")

    private fun buildKoinApplication(applicationContext: Context): KoinApplication {
        return koinApplication {
            androidContext(applicationContext)
            modules(modulesList)
        }
    }
}

val modulesList = arrayListOf(
    appModule,
    networkModule,
    viewModelModule,
    repositoryModule
)

// Custom KoinComponent
interface SDKKoinComponent : KoinComponent {
    override fun getKoin(): Koin = IOLPaymentSDK.get().koin
}
