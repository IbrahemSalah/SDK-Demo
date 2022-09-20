package com.android.iolpaymentsdk.di.modules

import com.android.iolpaymentsdk.ui.paymentsdk.ui.IOLPaymentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val iolViewModelModule = module {
    viewModel { IOLPaymentViewModel(get(named("iol-Repository"))) }
}