package com.ulyanenko.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        when (intent?.action){

            ACTION_CLICKED->{
                Toast.makeText(context, "You clicked", Toast.LENGTH_SHORT).show()
            }

            Intent.ACTION_BATTERY_LOW -> {
                Toast.makeText(context, "Battery is low", Toast.LENGTH_SHORT).show()
            }

            Intent.ACTION_AIRPLANE_MODE_CHANGED->{
                Toast.makeText(context, "Airplane mode changed", Toast.LENGTH_SHORT).show()
            }

        }

    }

    companion object{
        const val ACTION_CLICKED = "CLICKED"
    }
}