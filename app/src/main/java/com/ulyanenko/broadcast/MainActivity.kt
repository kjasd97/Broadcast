package com.ulyanenko.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MainActivity : AppCompatActivity() {

    private val localBroadcastManager by lazy {
        LocalBroadcastManager.getInstance(this)
    }

    private lateinit var progressBar: ProgressBar


    val receiver = object :BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent?.action=="loaded"){
                val percent = intent.getIntExtra("percent", 0)
                progressBar.progress = percent
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        findViewById<Button>(R.id.button).setOnClickListener {
        val intent = Intent(MyReceiver.ACTION_CLICKED)
          localBroadcastManager.sendBroadcast(intent)
        }


        val intentFilter = IntentFilter ().apply {
            addAction(Intent.ACTION_BATTERY_LOW)
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            addAction(MyReceiver.ACTION_CLICKED)
            addAction("loaded")
        }

       localBroadcastManager.registerReceiver(receiver, intentFilter )

        Intent(this, MyService::class.java).apply {
            startService(this)
        }

    }


    override fun onDestroy() {
        localBroadcastManager.unregisterReceiver(receiver)
        super.onDestroy()
    }
}