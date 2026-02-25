package com.example.redscate;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.profileButton).setOnClickListener(v ->
                startActivity(new Intent(this, ProfileActivity.class)));
        findViewById(R.id.helpButton).setOnClickListener(v ->
                startActivity(new Intent(this, AlertHomeActivity.class)));
        findViewById(R.id.bottomDocButton).setOnClickListener(v ->
                startActivity(new Intent(this, LibraryActivity.class)));
    }
}
