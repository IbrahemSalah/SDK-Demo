package com.android.iolpaymentsdk.ui.paymentsdk.ui

import android.os.Bundle
import com.android.iolpaymentsdk.R
import com.android.iolpaymentsdk.ui.base.BaseActivity

class PaymentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
    }
}