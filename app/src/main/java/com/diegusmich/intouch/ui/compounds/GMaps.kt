package com.diegusmich.intouch.ui.compounds

import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.diegusmich.intouch.R
import java.net.URI

class GMaps private constructor(view : WebView) {

    private val webView = view
    private var onLocationChangeCallback : ((String) -> Unit)? =  null

    private val webViewClient = object : WebViewClient() {
        override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean, ) {
           // val location = parseCurrentLocation()

            //onLocationChangeCallback?.invoke("")
            super.doUpdateVisitedHistory(view, url, isReload)
        }
    }

    init{
        webView.webViewClient = webViewClient
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.google.it/maps/")
    }

    companion object{
        fun compose(layoutInflater: LayoutInflater, view : ViewGroup) : GMaps {
            val composableView = layoutInflater.inflate(R.layout.gmaps_layout, view, false)
            view.addView(composableView)

            return GMaps(composableView as WebView)
        }
    }

    private fun parseCurrentLocation() : String{
        val url = URI(webView.url)
        return url.toString()

        TODO("Da completare")
    }

    fun setOnLocationChange(f : (String) -> Unit){
        onLocationChangeCallback = f
    }
}