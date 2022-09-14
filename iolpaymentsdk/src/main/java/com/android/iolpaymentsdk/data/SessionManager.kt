package com.android.iolpaymentsdk.data

import com.android.iolpaymentsdk.data.repositories.Repository


class SessionManager(val repository: Repository) {

    companion object {
        private var instance: SessionManager? = null
        fun getInstance(repository: Repository) = synchronized(this) {
            if (instance == null)
                instance = SessionManager(repository)
            instance
        }
    }

    //dummy return
    fun current(): String? {
        return null
    }
}