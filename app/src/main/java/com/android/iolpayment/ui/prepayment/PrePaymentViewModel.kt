package com.android.iolpayment.ui.prepayment

import android.app.Activity
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import com.android.iolpayment.data.model.APIResult
import com.android.iolpayment.data.repositories.Repository
import com.android.iolpayment.ui.base.BaseViewModel
import com.android.iolpaymentsdk.ui.paymentsdk.IOLPaymentSDKCallbacks
import com.android.iolpaymentsdk.ui.paymentsdk.IOLPaymentSDKHandler
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PrePaymentViewModel(
    private val repository: Repository,
) : BaseViewModel() {

    private var _prePaymentResponseState = Channel<PrePaymentResponseState>(Channel.BUFFERED)
    val movieListResponseState get() = _prePaymentResponseState.receiveAsFlow()


    fun startPaymentSDK(context: Activity) {
        IOLPaymentSDKHandler.initializeIOLPaymentSDK(
            context,
            object : IOLPaymentSDKCallbacks {
                override fun onPrePayment() {
                    Toast.makeText(context, "Pre Payment Called", Toast.LENGTH_SHORT).show()
                    getDiscoveryMovieListFromServer()
                }

                override fun onPaymentSuccess() {
                    Toast.makeText(context, "Payment Success Called", Toast.LENGTH_SHORT).show()
                }

                override fun onPaymentFailure() {
                    Toast.makeText(context, "Payment Failure Called", Toast.LENGTH_SHORT).show()
                }

            }
        )
    }

    private fun getDiscoveryMovieListFromServer() {

        viewModelScope.launch(handler) {

            when (val response = repository.getDiscoverMovieList()) {
                is APIResult.Failure -> {

                    val result = response

                }
                is APIResult.Success -> {
                    val result = response

                }
            }
        }

    }
}