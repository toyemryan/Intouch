package com.diegusmich.intouch.domain.auth

import android.app.Activity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * Perform logout of logged user. This class can be
 * used with invoke() function.
 *
 * @since 0.2.0
 */
class PerformLogout(){

    /**
     * Perform the logout of Firebase logged user.
     * Relaunch the task stack
     *
     * @since 0.2.0
     */
    operator fun invoke(ctx : Activity){
        Firebase.auth.signOut()
        ctx.finish()
    }
}