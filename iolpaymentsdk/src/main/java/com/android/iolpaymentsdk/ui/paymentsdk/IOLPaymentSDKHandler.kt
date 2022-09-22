package com.android.iolpaymentsdk.ui.paymentsdk

import android.app.Activity
import android.content.Intent
import androidx.annotation.Keep
import com.android.iolpaymentsdk.ui.paymentsdk.ui.IOLPaymentActivity
import com.android.iolpaymentsdk.util.Constants
import java.util.*

@Keep
object IOLPaymentSDKHandler {

    lateinit var mIOLPaymentSDKCallbacks: IOLPaymentSDKCallbacks

    fun initializeIOLPaymentSDK(
        context: Activity,
        iolPaymentSDKCallbacks: IOLPaymentSDKCallbacks
    ) {
        val intent = Intent(context, IOLPaymentActivity::class.java)
        context.startActivity(intent)

        mIOLPaymentSDKCallbacks = iolPaymentSDKCallbacks
    }
}