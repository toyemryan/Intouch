package com.diegusmich.intouch.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.diegusmich.intouch.R
import com.diegusmich.intouch.databinding.ActivityAuthBinding
import com.diegusmich.intouch.utils.ActivityUtil

class AuthActivity : AppCompatActivity() {

    private lateinit var authActivityViewModel: AuthActivityViewModel
    private lateinit var binding: ActivityAuthBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityUtil.setFullScreen(this)
        //Init AuthActivityViewModel
        authActivityViewModel = ViewModelProvider(this)[AuthActivityViewModel::class.java]

        //Init binding
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topAppBar)

        navController = findNavController(R.id.nav_host_fragment_auth)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {

        if(authActivityViewModel.tasksRunningState.value!!)
            return false

        return navController.navigateUp()
                || super.onSupportNavigateUp()
    }

    /**
     * Handle go back gesture, preventing to open MainActivity.
     */
    override fun onBackPressed() {
        this.onSupportNavigateUp()
    }

    fun receiveTRS(state : Boolean) {
        authActivityViewModel.setTasksRunning(state)
    }
}