package com.migulyaev.baseapplication.presentation.base.mvvm.utils

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
class SingleReadEvent<out T>(
    private val value: T
) {

    private var hasBeenHandled = false

    /**
     * Returns the content and prevents its use again.
     */
    @Synchronized
    fun tryGetValue(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            value
        }
    }

}