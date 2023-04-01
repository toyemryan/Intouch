package com.diegusmich.intouch.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.widget.Toast
import com.diegusmich.intouch.IntouchApp
import com.diegusmich.intouch.R

/**
 * Deliver a companion object to observe a requested network from Connectivity Manager.
 *
 * @since 0.2.1
 */
class NetworkUtil{

    companion object{

        private lateinit var appRef : IntouchApp
        private lateinit var connectivityManager : ConnectivityManager
        private lateinit var networkRequest: NetworkRequest
        private lateinit var networkCallback : NetworkCallback

        /**
         * Build the entire service to observe a network.
         *
         * @param ctx context
         */
        fun buildService(ctx : Context) : Companion{

            //Get application reference
            appRef = ctx.applicationContext as IntouchApp

            //Get a connectivity manager API to observe network state
            connectivityManager = ctx.getSystemService(ConnectivityManager::class.java) as ConnectivityManager

            //Create a network request with custom capabilities
            networkRequest = NetworkRequest.Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .build()

            /**
             * Register a callback to handle network state.
             */
            networkCallback = object : NetworkCallback(){

                override fun onAvailable(network: Network) {
                    super.onAvailable(network)

                    showNetworkStatus(ctx, R.string.internet_online)
                }

                override fun onLost(network: Network) {
                    super.onLost(network)

                    showNetworkStatus(ctx, R.string.internet_offline)
                }
            }

            return Companion
        }

        /**
         * Start to observe the network connection.
         */
        fun observe(){
            connectivityManager.requestNetwork(networkRequest, networkCallback)
        }


        /**
         * Show a toast message with network status
         *
         * @param ctx Context
         * @param strRes string resource ID
         *
         * o show
         */
        private fun showNetworkStatus(ctx : Context, strRes : Int){
            if(appRef.isAppForeground())
                Toast.makeText(ctx, ctx.getString(strRes), Toast.LENGTH_SHORT).show()
        }
    }
}