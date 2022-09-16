package com.android.iolpaymentsdk.ui.paymentsdk

import androidx.annotation.Keep

@Keep
interface IOLPaymentSDKCallbacks {

    fun onPrePayment()

    fun onPaymentSuccess()

    fun onPaymentFailure()
}