package com.diegusmich.intouch

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.diegusmich.intouch.databinding.ActivityMainBinding
import com.diegusmich.intouch.domain.auth.GetAuth
import com.diegusmich.intouch.ui.auth.AuthActivity
import com.diegusmich.intouch.utils.ActivityUtil


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Launch login activity if user isn't logged
        if(GetAuth().invoke() == null){
            startActivity(Intent(this@MainActivity, AuthActivity::class.java))
            this.finish()
        }

        ActivityUtil.setFullScreen(this)

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