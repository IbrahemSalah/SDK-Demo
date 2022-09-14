package com.android.iolpayment.data.offline

import android.content.Context
import com.android.iolpayment.data.model.APIResult

class OfflineImpl(private val context: Context) : Offline {

    override fun dummyOffline(): APIResult<String> {
        val dummyString = "dummy"
        return APIResult.success(dummyString)
    }
}