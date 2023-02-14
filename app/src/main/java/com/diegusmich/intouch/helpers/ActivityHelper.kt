package com.diegusmich.intouch.helpers

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.google.android.material.elevation.SurfaceColors

class ActivityHelper {

    companion object {

        fun setFullScreen(activity: AppCompatActivity) {

            // Mostra a schermo intero l'activity
            WindowCompat.setDecorFitsSystemWindows(activity.window, true)

            // Rende trasparente la status bar e la navigation bar
            //activity.window.statusBarColor = Color.TRANSPARENT
            // Set color of system statusBar same as ActionBar
            activity.window.navigationBarColor = SurfaceColors.SURFACE_2.getColor(activity)
        }
    }
}