package com.diegusmich.intouch.util

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.google.android.material.elevation.SurfaceColors

class ActivityUtil {
    companion object {
        fun setFullScreen(activity: AppCompatActivity) {
            // Forza la visualizzazione a finestra dell'activity
            WindowCompat.setDecorFitsSystemWindows(activity.window, false)
            // Imposta il colore della NavigationBar con quello della BottomNavMenu
            activity.window.navigationBarColor = SurfaceColors.SURFACE_2.getColor(activity)
            activity.window.statusBarColor = Color.TRANSPARENT
        }
    }
}