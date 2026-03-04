package com.example.redscate

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class AlertHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_home)

        findViewById<View>(R.id.alertNoButton).setOnClickListener { finish() }
        findViewById<View>(R.id.alertYesButton).setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java))
        }

        findViewById<View>(R.id.profileButton).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
        findViewById<View>(R.id.helpButton).setOnClickListener {
            // Already on the alert screen; avoid stacking the same dialog activity.
        }
        findViewById<View>(R.id.bottomDocButton).setOnClickListener {
            startActivity(Intent(this, LibraryActivity::class.java))
        }
    }
}
