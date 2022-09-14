package com.android.iolpaymentsdk.ui.paymentsdk.ui

sealed class PaymentResponseState {
    data class Failure(val error: String) : PaymentResponseState()
    data class Success(val response: String) : PaymentResponseState()

}