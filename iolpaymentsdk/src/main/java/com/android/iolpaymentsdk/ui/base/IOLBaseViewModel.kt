package com.android.iolpaymentsdk.ui.base

import androidx.lifecycle.ViewModel
import com.android.iolpaymentsdk.data.model.FailureException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

open class IOLBaseViewModel : ViewModel() {

    private val mutableIOLLoading = Channel<IOLLoading>(Channel.BUFFERED)
    val loading get() = mutableIOLLoading.receiveAsFlow()

    private val _error = Channel<FailureException>(Channel.BUFFERED)
    val error get() = _error.receiveAsFlow()

    internal val handler = CoroutineExceptionHandler { _, e ->
        mutableIOLLoading.offer(IOLLoading.OnError)
        when (e) {
            is FailureException.NetworkException -> {
                _error.offer(e)
            }
            is FailureException.InvalidUserException -> {
                _error.offer(e)
            }
            else -> {
                _error.offer(FailureException.FailedToConnectException("", -1))
            }
        }
    }
}