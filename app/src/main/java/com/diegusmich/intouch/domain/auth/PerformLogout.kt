package com.diegusmich.intouch.domain.auth

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * Perform logout of logged user. This class can be
 * used with invoke() function.
 *
 * @since 0.2.0
 */
sealed class PerformLogout() {

    /**
     * Perform the logout of Firebase logged user.
     *
     * @throws FirebaseNetworkException
     * @since 0.2.0
     */
    suspend operator fun invoke(callback : (() -> Unit)? = null){
        Firebase.auth.signOut()
        callback?.invoke()
    }
}