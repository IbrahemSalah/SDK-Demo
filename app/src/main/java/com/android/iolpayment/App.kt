package com.android.iolpayment

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.akexorcist.localizationactivity.core.LocalizationApplicationDelegate
import com.android.iolpayment.di.modules.*
import com.android.iolpaymentsdk.di.IOLPaymentSDK
import com.android.iolpaymentsdk.ui.paymentsdk.IOLPaymentSDKHandler
import com.android.iolpaymentsdk.util.NetworkMonitoringUtil
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class App : Application() {
    private val localizationDelegate = LocalizationApplicationDelegate()

    private var mNetworkMonitoringUtil: NetworkMonitoringUtil? = null

    override fun onCreate() {
        super.onCreate()
        initKoin()

        mNetworkMonitoringUtil =
            NetworkMonitoringUtil(this@App)
        mNetworkMonitoringUtil!!.checkNetworkState()
        mNetworkMonitoringUtil!!.registerNetworkCallbackEvents()
    }


    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                appModule,
                networkModule,
                viewModelModule,
                repositoryModule,
                offlineModule,
                dbModule
            )
        }

        IOLPaymentSDK.start(this@App)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(localizationDelegate.attachBaseContext(base))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        localizationDelegate.onConfigurationChanged(this)
    }

    override fun getApplicationContext(): Context {
        return localizationDelegate.getApplicationContext(super.getApplicationContext())
    }
}