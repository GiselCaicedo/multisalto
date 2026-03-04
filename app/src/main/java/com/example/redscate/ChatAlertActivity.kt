package com.example.redscate

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ChatAlertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_alert)

        findViewById<View>(R.id.dialogNoButton).setOnClickListener { finish() }
        findViewById<View>(R.id.dialogYesButton).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        findViewById<View>(R.id.safeButton).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}
