package com.android.iolpaymentsdk.ui.paymentsdk.ui

import android.os.Bundle
import com.android.iolpaymentsdk.R
import com.android.iolpaymentsdk.ui.base.IOLBaseActivity


class IOLPaymentActivity : IOLBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iol_activity_payment)
    }
}