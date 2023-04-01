package com.diegusmich.intouch.ui.compounds

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.FrameLayout
import com.diegusmich.intouch.R
import kotlinx.coroutines.*

/**
 * Action button is a custom view that show a nice spinner loader when some function
 * is doing the magic in a coroutine :)
 *
 * @see FrameLayout
 * @author Michele Bevilacqua
 * @since 0.3.0
 */
class ActionButton(ctx: Context, attrs : AttributeSet) : FrameLayout(ctx, attrs) {

    private val btn : Button
    private val loadingSpinner : LoadingSpinner
    private lateinit var actionCallback : suspend () -> Unit

    init{
        //Inflate and automatically attach the view to root :)
        LayoutInflater.from(ctx).inflate(R.layout.com_action_button, this, true)

        //Init loadingSpinner view
        loadingSpinner = this.findViewById(R.id.com_actionbutton_loadingspinner)

        //Init button view and pass to it the text attribute :)
        btn = this.findViewById(R.id.com_actionbutton_btn)
        ctx.theme.obtainStyledAttributes(attrs, R.styleable.ActionButton, 0, 0).apply {
            try{
                btn.text = getString(R.styleable.ActionButton_actionText)
            } finally {
                recycle()
            }
        }

    }

    /**
     * Do the all stuff before exec the callback when the button is clicked
     */
    private fun active(){
        btn.isEnabled = false
        btn.visibility = GONE
        loadingSpinner.start()
    }

    /**
     * Add listener when the button is clicked!
     * @param f callback for listener
     */
    fun addOnActionClickListener(callback : suspend () -> Unit) {
        this.actionCallback = callback

        btn.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                active()
                this@ActionButton.actionCallback()
                reset()
            }
        }
    }

    /**
     * Notify button when related action task is finish.
     * It can be used at the end of button callback to refresh the state of button
     */
    private fun reset(){
        btn.isEnabled = true
        btn.visibility = VISIBLE
        loadingSpinner.stop()
    }
}