package com.diegusmich.intouch.utils

import android.app.Activity
import android.graphics.Color
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.google.android.material.elevation.SurfaceColors

open class ActivityUtil {
    companion object {
        fun setFullScreen(activity: Activity) {
            // Forza la visualizzazione a finestra dell'activity
            WindowCompat.setDecorFitsSystemWindows(activity.window, false)
            // Imposta il colore della NavigationBar con quello della BottomNavMenu
            activity.window.navigationBarColor = SurfaceColors.SURFACE_2.getColor(activity)
            activity.window.statusBarColor = Color.TRANSPARENT
        }
    }
}