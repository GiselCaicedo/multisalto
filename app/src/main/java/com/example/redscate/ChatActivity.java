package com.example.redscate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ChatActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        LinearLayout messagesContainer = findViewById(R.id.messagesContainer);

        findViewById(R.id.chipHola).setOnClickListener(v ->
                addMessage(messagesContainer, getString(R.string.hola)));
        findViewById(R.id.chipNeed).setOnClickListener(v ->
                addMessage(messagesContainer, getString(R.string.chip_need)));
        findViewById(R.id.chipEmergency).setOnClickListener(v ->
                startActivity(new Intent(this, ChatAlertActivity.class)));
        findViewById(R.id.safeButton).setOnClickListener(v ->
                startActivity(new Intent(this, ChatAlertActivity.class)));
    }

    private void addMessage(LinearLayout messagesContainer, String text) {
        View messageBlock = LayoutInflater.from(this)
                .inflate(R.layout.item_chat_message_self, messagesContainer, false);
        TextView messageText = messageBlock.findViewById(R.id.messageText);
        TextView messageTimeText = messageBlock.findViewById(R.id.messageTimeText);

        messageText.setText(text);
        String timestamp = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy", Locale.getDefault()).format(new Date());
        messageTimeText.setText(getString(R.string.send_time_prefix) + " " + timestamp);
        messagesContainer.addView(messageBlock);
    }
}
