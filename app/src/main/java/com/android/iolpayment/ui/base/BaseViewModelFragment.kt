package com.android.iolpayment.ui.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.android.iolpaymentsdk.R
import com.android.iolpaymentsdk.data.model.FailureException
import com.android.iolpaymentsdk.util.CustomProgressDialog
import com.android.iolpaymentsdk.util.NetworkStateManager
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

open class BaseViewModelFragment<VB : ViewBinding> : BaseFragment<VB>() {


    private val progressdialog = CustomProgressDialog()

    private val activeNetworkStateObserver =
        Observer { isConnected: Boolean ->
            networkStatusChanged(isConnected)
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        registerNetworkStatusChangeObserver()
    }

    open fun initObservers() {


    }

    private fun registerNetworkStatusChangeObserver() {
        NetworkStateManager.getInstance().getNetworkConnectivityStatus()
            .observe(requireActivity(), activeNetworkStateObserver)
    }

    fun showDialog(loadingMessage: String) {
        progressdialog.show(
            requireContext(),
            loadingMessage
        )
    }

    fun dismissDialog() {
        progressdialog.dialog?.dismiss()
    }

    open fun reAuthenticate() {
    }

    open fun networkStatusChanged(isConnected: Boolean) {

    }
}
