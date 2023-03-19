package com.diegusmich.intouch.utils

import android.app.Activity
import android.graphics.Color
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.google.android.material.elevation.SurfaceColors


/**
 * Utility class for Activity
 *
 * @since 0.1.0
 */
class ActivityUtil {
    companion object {

        /**
         * Set edge-to-edge mode to activity
         * @param activity to display in fullscreen mode
         *
         * @since 0.1.0
         */
        fun setFullScreen(activity: Activity) {
            //Disable window-mode for activity
            WindowCompat.setDecorFitsSystemWindows(activity.window, false)
            //Set the color of navigation bar and statusbar with Material Colors
            activity.window.navigationBarColor = SurfaceColors.SURFACE_2.getColor(activity)
            activity.window.statusBarColor = Color.TRANSPARENT
        }
    }
}