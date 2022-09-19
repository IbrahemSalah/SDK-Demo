package com.android.iolpaymentsdk.ui.paymentsdk

import com.google.android.gms.common.annotation.KeepForSdk

@KeepForSdk
interface IOLPaymentSDKCallbacks {

    fun onPrePayment()

    fun onPaymentSuccess()

    fun onPaymentFailure()
}