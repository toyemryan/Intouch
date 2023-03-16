package com.diegusmich.intouch.utils

import android.app.Activity
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.widget.Toast
import com.diegusmich.intouch.R

class NetworkUtil{

    companion object{

        private lateinit var connectivityManager : ConnectivityManager
        private lateinit var networkRequest: NetworkRequest
        private lateinit var networkCallback : NetworkCallback


        fun buildService(ctx : Activity) : Companion{

            //Get a connectivity manager API to observe network state
            connectivityManager = ctx.getSystemService(ConnectivityManager::class.java) as ConnectivityManager

            //Create a network request with custom capabilities
            networkRequest = NetworkRequest.Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .build()

            //Register a callback to handle network state
            networkCallback = object : ConnectivityManager.NetworkCallback(){


                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    Toast.makeText(ctx, ctx.getString(R.string.internet_online), Toast.LENGTH_SHORT).show()

                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    Toast.makeText(ctx, ctx.getString(R.string.internet_offline), Toast.LENGTH_SHORT).show()
                }
            }

            return Companion
        }

        fun observe(){
            connectivityManager.requestNetwork(networkRequest, networkCallback)
        }
    }
}