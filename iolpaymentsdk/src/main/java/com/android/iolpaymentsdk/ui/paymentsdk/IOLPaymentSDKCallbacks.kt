package com.android.iolpaymentsdk.ui.paymentsdk


interface IOLPaymentSDKCallbacks {

    fun onPrePayment()

    fun onPaymentSuccess()

    fun onPaymentFailure()
}