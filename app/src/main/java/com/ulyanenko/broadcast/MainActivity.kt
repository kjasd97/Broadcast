package com.ulyanenko.broadcast

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val receiver = MyReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
        val intent = Intent(MyReceiver.ACTION_CLICKED)
            sendBroadcast(intent)
        }


        val intentFilter = IntentFilter ().apply {
            addAction(Intent.ACTION_BATTERY_LOW)
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            addAction(MyReceiver.ACTION_CLICKED)
        }

        registerReceiver(receiver, intentFilter )

    }


    override fun onDestroy() {

        super.onDestroy()
    }
}