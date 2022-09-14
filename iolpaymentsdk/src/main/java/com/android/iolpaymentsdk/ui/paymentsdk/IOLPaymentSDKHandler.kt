package com.android.iolpaymentsdk.ui.paymentsdk

import android.app.Activity
import android.content.Intent
import com.android.iolpaymentsdk.di.modules.appModule
import com.android.iolpaymentsdk.di.modules.networkModule
import com.android.iolpaymentsdk.di.modules.repositoryModule
import com.android.iolpaymentsdk.di.modules.viewModelModule
import com.android.iolpaymentsdk.ui.paymentsdk.ui.PaymentActivity
import org.koin.core.context.loadKoinModules
import org.koin.dsl.koinApplication

object IOLPaymentSDKHandler {

    lateinit var mIOLPaymentSDKCallbacks: IOLPaymentSDKCallbacks

    fun initializeIOLPaymentSDK(context: Activity, iolPaymentSDKCallbacks: IOLPaymentSDKCallbacks) {
        val intent = Intent(context, PaymentActivity::class.java)
        context.startActivity(intent)

        mIOLPaymentSDKCallbacks = iolPaymentSDKCallbacks
    }
}