package com.android.iolpayment.ui.prepayment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akexorcist.localizationactivity.core.LocaleParser
import com.akexorcist.localizationactivity.core.LocalizationActivityDelegate
import com.android.iolpayment.databinding.FragmentPrePaymentBinding
import com.android.iolpayment.ui.base.BaseViewModelFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class PrePaymentFragment :
    BaseViewModelFragment<FragmentPrePaymentBinding>() {

    private val viewModel by viewModel<PrePaymentViewModel>()

    private val localizationDelegate by lazy {
        LocalizationActivityDelegate(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPrePaymentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initViews() {
        super.initViews()

        binding.btnSwitchToEn.setOnClickListener {
            localizationDelegate.setLanguage(requireContext(), LocaleParser.EN)

        }

        binding.btnSwitchToIt.setOnClickListener {
            localizationDelegate.setLanguage(requireContext(), LocaleParser.IT)

        }

        binding.btnStartPayment.setOnClickListener {
            viewModel.startPaymentSDK(requireActivity())
        }
    }

    override fun initObservers() {
        super.initObservers()
    }
}