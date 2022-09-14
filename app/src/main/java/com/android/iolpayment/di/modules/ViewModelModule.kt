package com.android.iolpayment.di.modules

import com.android.iolpayment.ui.prepayment.PrePaymentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { PrePaymentViewModel(get()) }
}