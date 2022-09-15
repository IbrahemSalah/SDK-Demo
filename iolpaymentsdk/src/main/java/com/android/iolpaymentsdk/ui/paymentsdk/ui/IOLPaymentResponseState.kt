package com.android.iolpaymentsdk.ui.paymentsdk.ui

sealed class IOLPaymentResponseState {
    data class Failure(val error: String) : IOLPaymentResponseState()
    data class Success(val response: String) : IOLPaymentResponseState()

}