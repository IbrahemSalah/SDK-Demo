package com.android.iolpayment.ui.base

sealed class Loading {
    object OnLoading : Loading()
    object OnSuccess : Loading()
    object OnError : Loading()
}
