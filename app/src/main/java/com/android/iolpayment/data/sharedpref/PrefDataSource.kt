package com.android.iolpayment.data.sharedpref

import com.android.iolpayment.data.model.BaseAppResponse


interface PrefDataSource {

    fun getToken(): String
    fun setToken(token: String)

    fun getSharedPrefBaseAppResponse(): BaseAppResponse?
    fun setSharedPrefBaseAppResponse(baseAppResponse: BaseAppResponse)

    fun logOut()
}