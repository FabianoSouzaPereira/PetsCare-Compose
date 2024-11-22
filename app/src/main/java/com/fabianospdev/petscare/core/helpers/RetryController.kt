package com.fabianospdev.petscare.core.helpers

import kotlinx.coroutines.flow.StateFlow

interface RetryController {
    val isRetryEnabled: StateFlow<Boolean>
    fun incrementRetryCount()
    fun resetRetryCount()
}