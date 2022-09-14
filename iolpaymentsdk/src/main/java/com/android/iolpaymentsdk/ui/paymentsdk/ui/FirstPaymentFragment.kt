package com.android.iolpaymentsdk.ui.paymentsdk.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.android.iolpaymentsdk.databinding.FragmentFirstPaymentBinding
import com.android.iolpaymentsdk.di.SDKKoinComponent
import com.android.iolpaymentsdk.ui.base.BaseViewModelFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel


class FirstPaymentFragment :
    BaseViewModelFragment<FragmentFirstPaymentBinding>(), SDKKoinComponent {

    private val viewModel by viewModel<PaymentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstPaymentBinding.inflate(layoutInflater)
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
                is PaymentResponseState.Failure -> {
                    Toast.makeText(context, it.error, Toast.LENGTH_SHORT).show()
                }
                is PaymentResponseState.Success -> {
                    Toast.makeText(context, it.response, Toast.LENGTH_SHORT).show()
                }
            }
        }.launchIn(lifecycleScope)
    }
}