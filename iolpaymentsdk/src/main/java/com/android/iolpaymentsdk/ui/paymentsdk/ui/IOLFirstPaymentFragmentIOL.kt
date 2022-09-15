package com.android.iolpaymentsdk.ui.paymentsdk.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.android.iolpaymentsdk.databinding.IolFragmentFirstPaymentBinding
import com.android.iolpaymentsdk.di.SDKKoinComponent
import com.android.iolpaymentsdk.ui.base.IOLBaseViewModelFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel


class IOLFirstPaymentFragmentIOL :
    IOLBaseViewModelFragment<IolFragmentFirstPaymentBinding>(), SDKKoinComponent {

    private val viewModel by viewModel<IOLPaymentViewModelIOL>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = IolFragmentFirstPaymentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initViews() {
        super.initViews()

        binding.btnPrePayment.setOnClickListener { viewModel.onPrePayment() }

        binding.btnPaymentSuccess.setOnClickListener { viewModel.onPaymentSuccess() }

        binding.btnPaymentFailure.setOnClickListener { viewModel.onPaymentFailure() }
    }

    override fun initObservers() {
        super.initObservers()

        viewModel.paymentResponseState.onEach {
            when (it) {
                is IOLPaymentResponseState.Failure -> {
                    Toast.makeText(context, it.error, Toast.LENGTH_SHORT).show()
                }
                is IOLPaymentResponseState.Success -> {
                    Toast.makeText(context, it.response, Toast.LENGTH_SHORT).show()
                }
            }
        }.launchIn(lifecycleScope)
    }
}