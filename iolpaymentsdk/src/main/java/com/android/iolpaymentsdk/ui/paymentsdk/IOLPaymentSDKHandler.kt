package com.android.iolpaymentsdk.ui.paymentsdk

import android.app.Activity
import android.content.Intent
import com.android.iolpaymentsdk.ui.paymentsdk.ui.IOLPaymentActivity

object IOLPaymentSDKHandler {

    lateinit var mIOLPaymentSDKCallbacks: IOLPaymentSDKCallbacks

    fun initializeIOLPaymentSDK(context: Activity, iolPaymentSDKCallbacks: IOLPaymentSDKCallbacks) {
        val intent = Intent(context, IOLPaymentActivity::class.java)
        context.startActivity(intent)

        mIOLPaymentSDKCallbacks = iolPaymentSDKCallbacks
    }
}