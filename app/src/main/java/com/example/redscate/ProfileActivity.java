package com.example.redscate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private static final float THUMB_TRAVEL_DP = 50f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        View themeToggle = findViewById(R.id.themeToggle);
        FrameLayout themeThumb = findViewById(R.id.themeThumb);
        ImageView themeThumbIcon = findViewById(R.id.themeThumbIcon);
        ImageView themeTrackLeftIcon = findViewById(R.id.themeTrackLeftIcon);
        ImageView themeTrackRightIcon = findViewById(R.id.themeTrackRightIcon);

        boolean isDark = ThemeManager.isDarkMode(this);
        updateThemeToggleUi(isDark, themeToggle, themeThumb, themeThumbIcon, themeTrackLeftIcon, themeTrackRightIcon);

        themeToggle.setOnClickListener(v -> {
            boolean newDarkMode = !ThemeManager.isDarkMode(this);
            updateThemeToggleUi(newDarkMode, themeToggle, themeThumb, themeThumbIcon, themeTrackLeftIcon, themeTrackRightIcon);
            ThemeManager.setDarkMode(this, newDarkMode);
        });

        findViewById(R.id.helpButton).setOnClickListener(v ->
                startActivity(new Intent(this, AlertHomeActivity.class)));
        findViewById(R.id.bottomDocButton).setOnClickListener(v ->
                startActivity(new Intent(this, ChatActivity.class)));
    }

    private void updateThemeToggleUi(
            boolean isDark,
            View toggle,
            FrameLayout thumb,
            ImageView thumbIcon,
            ImageView leftIcon,
            ImageView rightIcon
    ) {
        toggle.setBackgroundResource(isDark ? R.drawable.bg_theme_track_dark : R.drawable.bg_theme_track_light);

        if (isDark) {
            leftIcon.setImageResource(R.drawable.ic_theme_clear_figma);
            rightIcon.setImageResource(R.drawable.ic_theme_dark_figma);
            thumbIcon.setImageResource(R.drawable.ic_theme_dark_figma);
            thumb.setTranslationX(dpToPx(THUMB_TRAVEL_DP));
        } else {
            leftIcon.setImageResource(R.drawable.ic_theme_clear_figma_blue);
            rightIcon.setImageResource(R.drawable.ic_theme_dark_figma_gray);
            thumbIcon.setImageResource(R.drawable.ic_theme_clear_figma_blue);
            thumb.setTranslationX(0f);
        }
    }

    private float dpToPx(float dp) {
        return dp * getResources().getDisplayMetrics().density;
    }
}
