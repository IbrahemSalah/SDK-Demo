package com.android.iolpaymentsdk.ui.base

sealed class IOLLoading {
    object OnIOLLoading : IOLLoading()
    object OnSuccess : IOLLoading()
    object OnError : IOLLoading()
}
