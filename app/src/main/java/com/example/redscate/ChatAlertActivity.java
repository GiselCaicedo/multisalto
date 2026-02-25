package com.example.redscate;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ChatAlertActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_alert);

        findViewById(R.id.dialogNoButton).setOnClickListener(v -> finish());
        findViewById(R.id.dialogYesButton).setOnClickListener(v ->
                startActivity(new Intent(this, HomeActivity.class)));
        findViewById(R.id.safeButton).setOnClickListener(v ->
                startActivity(new Intent(this, HomeActivity.class)));
    }
}
