package com.android.iolpayment.data.offline

import com.android.iolpayment.data.model.APIResult

interface Offline {
    fun dummyOffline(): APIResult<String>
}