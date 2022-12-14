package com.android.iolpayment.data

import com.android.iolpayment.data.repositories.Repository


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

    fun hasCachedUser(): Boolean {
        return (repository.getToken().isNotEmpty())
    }

    fun setActiveSession(loginResponse: String) {
    }

    fun logout() {
        repository.logOut()
    }

}