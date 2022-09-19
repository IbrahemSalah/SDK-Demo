package com.android.iolpaymentsdk.ui.paymentsdk

import androidx.annotation.Keep
import com.google.android.gms.common.annotation.KeepName

@Keep
@KeepName
interface IOLPaymentSDKCallbacks {

    fun onPrePayment()

    fun onPaymentSuccess()

    fun onPaymentFailure()
}