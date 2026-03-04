package com.example.redscate

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val messagesContainer: LinearLayout = findViewById(R.id.messagesContainer)

        findViewById<View>(R.id.chipHola).setOnClickListener {
            addMessage(messagesContainer, getString(R.string.hola))
        }
        findViewById<View>(R.id.chipNeed).setOnClickListener {
            addMessage(messagesContainer, getString(R.string.chip_need))
        }
        findViewById<View>(R.id.chipEmergency).setOnClickListener {
            startActivity(Intent(this, ChatAlertActivity::class.java))
        }
        findViewById<View>(R.id.safeButton).setOnClickListener {
            startActivity(Intent(this, ChatAlertActivity::class.java))
        }
    }

    private fun addMessage(messagesContainer: LinearLayout, text: String) {
        val messageBlock = LayoutInflater.from(this)
            .inflate(R.layout.item_chat_message_self, messagesContainer, false)
        val messageText: TextView = messageBlock.findViewById(R.id.messageText)
        val messageTimeText: TextView = messageBlock.findViewById(R.id.messageTimeText)

        messageText.text = text
        val timestamp = SimpleDateFormat("HH:mm:ss dd/MM/yyyy", Locale.getDefault()).format(Date())
        messageTimeText.text = "${getString(R.string.send_time_prefix)} $timestamp"
        messagesContainer.addView(messageBlock)
    }
}
