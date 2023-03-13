package com.diegusmich.intouch.utils

import kotlinx.coroutines.CoroutineExceptionHandler

/**
 * This class throw all exceptions in coroutines to handle in UI with try-catch block
 *
 * @since 0.2.0
 */
class CoExHandler {
    companion object{
        val handler = CoroutineExceptionHandler { _, exception ->
            throw exception
        }
    }
}