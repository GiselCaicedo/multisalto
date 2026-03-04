package com.example.redscate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<android.view.View>(R.id.profileButton).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
        findViewById<android.view.View>(R.id.helpButton).setOnClickListener {
            startActivity(Intent(this, AlertHomeActivity::class.java))
        }
        findViewById<android.view.View>(R.id.showcaseButton).setOnClickListener {
            startActivity(Intent(this, ComponentShowcaseActivity::class.java))
        }
        findViewById<android.view.View>(R.id.bottomDocButton).setOnClickListener {
            startActivity(Intent(this, ComponentShowcaseActivity::class.java))
        }
    }
}
