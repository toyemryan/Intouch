package com.diegusmich.intouch.ui.compounds

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import com.airbnb.lottie.LottieAnimationView
import com.diegusmich.intouch.R

class LoadingSpinner(ctx: Context, attrs : AttributeSet) : LottieAnimationView(ctx, attrs){

    init{
        this.visibility = GONE
        this.setAnimation(R.raw.loading_6)
        this.repeatCount = ValueAnimator.INFINITE
    }

    fun start() {
        this.visibility = VISIBLE
        this.playAnimation()
    }

    fun stop(){
        this.visibility = GONE
        this.clearAnimation()
    }
}