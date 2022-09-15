package com.android.iolpaymentsdk.di.modules

import com.android.iolpaymentsdk.ui.paymentsdk.ui.PaymentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { PaymentViewModel(get(named("iol-Repository"))) }
}