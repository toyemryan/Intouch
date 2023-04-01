package com.diegusmich.intouch.exceptions

import kotlinx.coroutines.CoroutineExceptionHandler

/**
 * This class throw all exceptions in coroutines to handle in UI with try-catch block
 *
 * @since 0.2.0
 */
class AppExceptionHandler{

    companion object{
        val coroutineThrower = CoroutineExceptionHandler{ _, exception ->
            throw exception
        }
    }
}