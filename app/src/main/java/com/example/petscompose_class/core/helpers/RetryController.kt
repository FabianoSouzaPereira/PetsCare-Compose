package com.example.petscompose_class.core.helpers

import kotlinx.coroutines.flow.StateFlow

interface RetryController {
    val isRetryEnabled: StateFlow<Boolean>
    val isRetryLimitReached: StateFlow<Boolean>

    fun incrementRetryCount()
    fun resetRetryCount()
    fun resetRetryLimitNotification()
}