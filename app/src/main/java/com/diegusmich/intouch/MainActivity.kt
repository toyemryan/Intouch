package com.diegusmich.intouch

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.diegusmich.intouch.databinding.ActivityMainBinding
import com.diegusmich.intouch.util.ActivityUtil
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

        auth = Firebase.auth
    }

    override fun onStart() {
        super.onStart()
        processAuth()
    }

    fun processAuth(){
        if(auth.currentUser != null){
            Snackbar.make(binding.root, "User already logged", Toast.LENGTH_SHORT).show()
            return
        }

        auth.signInWithEmailAndPassword("test@intouchtest.com", "testtest")
            .addOnCompleteListener(this) { task ->
                if(task.isSuccessful && auth.currentUser != null)
                    Snackbar.make(binding.root, "User ${auth.currentUser?.email.toString()}", Snackbar.LENGTH_LONG).show()
                else
                    Snackbar.make(binding.root, "User not logged", Toast.LENGTH_SHORT).show()
            }
    }
}