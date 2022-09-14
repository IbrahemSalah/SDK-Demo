package com.android.iolpayment.ui.prepayment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.iolpayment.databinding.FragmentPrePaymentBinding
import com.android.iolpayment.ui.base.BaseViewModelFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class PrePaymentFragment :
    BaseViewModelFragment<FragmentPrePaymentBinding>() {

    private val viewModel by viewModel<PrePaymentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPrePaymentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initViews() {
        super.initViews()

        binding.btnStartPayment.setOnClickListener {
            viewModel.startPaymentSDK(requireActivity())
        }
    }

    override fun initObservers() {
        super.initObservers()
    }
}