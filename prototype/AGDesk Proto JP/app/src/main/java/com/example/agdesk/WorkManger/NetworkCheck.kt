package com.example.agdesk.WorkManger

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.widget.Toast

class NetworkCheck(private val context: Context, workMangerHelper: WorkManagerHelper) {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


    private val networkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .build()

    private val workMangerHelper = WorkManagerHelper

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            // Trigger the sync immediately when network is available
            workMangerHelper.triggerImmediateSync(context)
            showToast("Online")
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            // Optionally, stop syncing or flag that the device is offline
            showToast("Offline")
        }

        override fun onCapabilitiesChanged(
            network: Network,
            networkCapabilities: NetworkCapabilities
        ) {
            super.onCapabilitiesChanged(network, networkCapabilities)
            val unmetered =
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED)
            if (unmetered) {
                showToast("Unmetered Network")
            }
        }
    }

    fun startNetworkCallback() {
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
    }

    fun stopNetworkCallback() {
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }




}