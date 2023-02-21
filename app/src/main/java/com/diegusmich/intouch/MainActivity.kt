package com.diegusmich.intouch

import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Simula la modalità edge-to-edge dell'app
        ActivityHelper.setWindowParams(this)
 
        // Binding e setContentView
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Inizializza il bottomNavView con il navcontroller dei Fragment
        val bottNavView : BottomNavigationView = binding.bottNavView
        val navController = findNavController(R.id.nav_host_fragment_container)

        bottNavView.setupWithNavController(navController)

        // Imposta un comportamento differente per il tasto centrale del menu.
        // Lancia l'activity per creare un evento o un post!
        bottNavView.menu.getItem(2).setOnMenuItemClickListener {
            Toast.makeText(this, "Launch: ${it.title} activity", Toast.LENGTH_SHORT).show()
            true
        }
    }
}