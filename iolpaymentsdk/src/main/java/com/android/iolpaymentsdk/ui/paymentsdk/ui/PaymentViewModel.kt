package com.android.iolpaymentsdk.ui.paymentsdk.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.android.iolpaymentsdk.data.model.APIResult
import com.android.iolpaymentsdk.data.repositories.Repository
import com.android.iolpaymentsdk.ui.base.BaseViewModel
import com.android.iolpaymentsdk.ui.paymentsdk.IOLPaymentSDKHandler
import kotlinx.coroutines.launch

class PaymentViewModel(
    private val repository: Repository,
) : BaseViewModel() {

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

                    val result = response

                }
                is APIResult.Success -> {

                    Log.i("API Response", response.body?.results.toString())
                }
            }
        }

    }

}