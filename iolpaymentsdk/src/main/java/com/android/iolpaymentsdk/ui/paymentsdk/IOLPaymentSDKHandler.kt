package com.android.iolpaymentsdk.ui.paymentsdk

import android.app.Activity
import android.content.Intent
import androidx.annotation.Keep
import com.android.iolpaymentsdk.ui.paymentsdk.ui.IOLPaymentActivity
import com.google.android.gms.common.annotation.KeepName

@Keep
@KeepName
object IOLPaymentSDKHandler {

    lateinit var mIOLPaymentSDKCallbacks: IOLPaymentSDKCallbacks

    fun initializeIOLPaymentSDK(context: Activity, iolPaymentSDKCallbacks: IOLPaymentSDKCallbacks) {
        val intent = Intent(context, IOLPaymentActivity::class.java)
        context.startActivity(intent)

        mIOLPaymentSDKCallbacks = iolPaymentSDKCallbacks
    }
}