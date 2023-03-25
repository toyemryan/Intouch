package com.diegusmich.intouch.domain.auth

import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

/**
 * Perform login with email and password. This class can be
 * used with invoke() function.
 *
 * @since 0.2.0
 */

class PerformLoginEmailPassword @Inject constructor(){

    /**
     * Perform the login with email and password.
     * @return FirebaseUser?
     * @throws FirebaseNetworkException
     * @throws FirebaseAuthInvalidCredentialsException
     * @since 0.2.0
     */
    suspend operator fun invoke(email : String, password : String) : FirebaseUser? {
        val authResult = Firebase.auth.signInWithEmailAndPassword(email, password)
            .await()

        return authResult.user
    }
}