package com.diegusmich.intouch.ui.auth.signin

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.diegusmich.intouch.R
import com.diegusmich.intouch.domain.auth.PerformLoginEmailPassword
import com.diegusmich.intouch.ui.auth.AuthActivity
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException


/**
 * ViewModel for SignIn Fragment
 *
 * @since 0.3.0
 */
class SignInViewModel() : ViewModel() {

    suspend fun performLogin(
        ctx: Activity,
        email: String,
        password: String,
        callback: ((authResult: AuthResult?, ex: Exception?) -> Unit)?
    ) {
            var authResult: AuthResult? = null
            var ex: Exception? = null

            try {
                (ctx as AuthActivity).receiveTRS(true)
                authResult = PerformLoginEmailPassword().invoke(email, password)
            } catch (e: FirebaseNetworkException) {
                ex = Exception(ctx.getString(R.string.internet_offline))
            } catch (e: FirebaseAuthInvalidCredentialsException) {
                ex = Exception(ctx.getString(R.string.login_failed))
            } catch (e: FirebaseAuthInvalidUserException) {
                ex = Exception(ctx.getString(R.string.invalid_user))
            } catch (e: FirebaseTooManyRequestsException) {
                ex = Exception(ctx.getString(R.string.login_temp_banned))
            } catch (e: FirebaseException) {
                ex = Exception(ctx.getString(R.string.generic_error))
            }

            (ctx as AuthActivity).receiveTRS(false)

            callback?.invoke(authResult, ex)
    }
}