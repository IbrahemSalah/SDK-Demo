package com.android.iolpaymentsdk.ui.base

sealed class Loading {
    object OnLoading : Loading()
    object OnSuccess : Loading()
    object OnError : Loading()
}
