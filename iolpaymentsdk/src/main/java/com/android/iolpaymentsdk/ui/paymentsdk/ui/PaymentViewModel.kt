package com.android.iolpaymentsdk.ui.paymentsdk.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.android.iolpaymentsdk.data.model.APIResult
import com.android.iolpaymentsdk.data.repositories.Repository
import com.android.iolpaymentsdk.ui.base.BaseViewModel
import com.android.iolpaymentsdk.ui.paymentsdk.IOLPaymentSDKHandler
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PaymentViewModel(
    private val repository: Repository,
) : BaseViewModel() {

    private var _paymentResponseState = Channel<PaymentResponseState>(Channel.BUFFERED)
    val paymentResponseState get() = _paymentResponseState.receiveAsFlow()


    fun onPrePayment() {
        IOLPaymentSDKHandler.mIOLPaymentSDKCallbacks.onPrePayment()
    }

    fun onPaymentFailure() {
        IOLPaymentSDKHandler.mIOLPaymentSDKCallbacks.onPaymentFailure()

    }

    fun onPaymentSuccess() {
        IOLPaymentSDKHandler.mIOLPaymentSDKCallbacks.onPaymentSuccess()
        getDiscoveryMovieListFromServer()

    }


    private fun getDiscoveryMovieListFromServer() {

        viewModelScope.launch(handler) {

            when (val response = repository.getDiscoverMovieList()) {
                is APIResult.Failure -> {
                    response.error?.message?.let {
                        _paymentResponseState.trySend(PaymentResponseState.Failure(response.error.message))
                    }
                }
                is APIResult.Success -> {
                    response.body?.results?.let {
                        _paymentResponseState.trySend(PaymentResponseState.Failure(response.body.results.size.toString()))
                    }
                }
            }
        }

    }

}