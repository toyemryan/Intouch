package com.diegusmich.intouch

import android.graphics.Color
import android.os.Bundle
import android.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.diegusmich.intouch.databinding.ActivityMainBinding
import com.diegusmich.intouch.helpers.ActivityHelper
import com.google.android.material.elevation.SurfaceColors

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Simula la modalità edge-to-edge dell'app
        ActivityHelper.setFullScreen(this)

        // Binding e setContentView
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //setSupportActionBar(findViewById(R.id.topAppBar))


        //Inizializza il bottomNavView con il navcontroller dei Fragment
        val bottNavView : BottomNavigationView = binding.bottNavView
        val navController = findNavController(R.id.nav_host_fragment_container)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_my_events, R.id.navigation_profile
            )
        )

        //setupActionBarWithNavController(navController, appBarConfiguration)
        bottNavView.setupWithNavController(navController)
    }
}