package com.android.iolpayment.data.database

import com.android.iolpayment.data.model.BaseAppResponse

interface DbDataSource {
    suspend fun getAllDataInTable(): BaseAppResponse
}