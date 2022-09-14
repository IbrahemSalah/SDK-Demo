package com.android.iolpayment.data.database

import androidx.room.*
import com.android.iolpayment.data.model.BaseAppResponse

@Dao
interface BaseAppDao {

    @Query("SELECT * FROM cereal_table ORDER BY dbId DESC LIMIT 1")
    fun getAllDataInTable(): BaseAppResponse
}