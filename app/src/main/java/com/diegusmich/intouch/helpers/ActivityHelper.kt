package com.diegusmich.intouch.helpers

import android.graphics.Color
import android.view.Surface
import android.widget.inline.InlineContentView.SurfaceControlCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.diegusmich.intouch.R
import com.google.android.material.color.MaterialColors
import com.google.android.material.elevation.SurfaceColors

class ActivityHelper {

    companion object {

        fun setFullScreen(activity: AppCompatActivity) {
            // Forza la visualizzazione a finestra dell'activity
            WindowCompat.setDecorFitsSystemWindows(activity.window, true)
            // Imposta il colore della NavigationBar con quello della BottomNavMenu

        }
    }
}