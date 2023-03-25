package com.diegusmich.intouch

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.diegusmich.intouch.databinding.ActivityMainBinding
import com.diegusmich.intouch.domain.auth.PerformLoginEmailPassword
import com.diegusmich.intouch.domain.users.GetUser
import com.diegusmich.intouch.exceptions.AppExceptionHandler
import com.diegusmich.intouch.utils.ActivityUtil
import com.diegusmich.intouch.utils.NetworkUtil
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth : FirebaseAuth
    private val performLoginEmailPassword = PerformLoginEmailPassword()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityUtil.setFullScreen(this)
        NetworkUtil.buildService(this).observe()


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

    fun processAuth() {
        MainScope().launch(AppExceptionHandler.coroutineExThrower){
            var result : String?

            try{
                val user = performLoginEmailPassword("test@intouchtest.com", "testtest")
                result = "Utente autenticato"
            }
            catch (e : FirebaseNetworkException){
                result = getString(R.string.internet_offline)
            }
            catch (e : FirebaseAuthInvalidCredentialsException){
                result = getString(R.string.login_failed)
            }
            catch (e : FirebaseTooManyRequestsException){
                result = "Blocco temporaneo per attività insolite. Riprova più tardi"
            }

            Snackbar.make(binding.root, result.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}