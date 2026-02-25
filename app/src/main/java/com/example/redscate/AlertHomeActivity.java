package com.example.redscate;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AlertHomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_home);

        findViewById(R.id.alertNoButton).setOnClickListener(v -> finish());
        findViewById(R.id.alertYesButton).setOnClickListener(v ->
                startActivity(new Intent(this, ChatActivity.class)));

        findViewById(R.id.profileButton).setOnClickListener(v ->
                startActivity(new Intent(this, ProfileActivity.class)));
        findViewById(R.id.helpButton).setOnClickListener(v -> {
            // Already on the alert screen; avoid stacking the same dialog activity.
        });
        findViewById(R.id.bottomDocButton).setOnClickListener(v ->
                startActivity(new Intent(this, LibraryActivity.class)));
    }
}
