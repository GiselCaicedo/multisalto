package com.example.redscate

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val themeToggle: View = findViewById(R.id.themeToggle)
        val themeThumb: FrameLayout = findViewById(R.id.themeThumb)
        val themeThumbIcon: ImageView = findViewById(R.id.themeThumbIcon)
        val themeTrackLeftIcon: ImageView = findViewById(R.id.themeTrackLeftIcon)
        val themeTrackRightIcon: ImageView = findViewById(R.id.themeTrackRightIcon)

        val isDark = ThemeManager.isDarkMode(this)
        updateThemeToggleUi(
            isDark,
            themeToggle,
            themeThumb,
            themeThumbIcon,
            themeTrackLeftIcon,
            themeTrackRightIcon
        )

        themeToggle.setOnClickListener {
            val newDarkMode = !ThemeManager.isDarkMode(this)
            updateThemeToggleUi(
                newDarkMode,
                themeToggle,
                themeThumb,
                themeThumbIcon,
                themeTrackLeftIcon,
                themeTrackRightIcon
            )
            ThemeManager.setDarkMode(this, newDarkMode)
        }

        findViewById<View>(R.id.helpButton).setOnClickListener {
            startActivity(Intent(this, AlertHomeActivity::class.java))
        }
        findViewById<View>(R.id.bottomDocButton).setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java))
        }
    }

    private fun updateThemeToggleUi(
        isDark: Boolean,
        toggle: View,
        thumb: FrameLayout,
        thumbIcon: ImageView,
        leftIcon: ImageView,
        rightIcon: ImageView
    ) {
        toggle.setBackgroundResource(
            if (isDark) R.drawable.bg_theme_track_dark else R.drawable.bg_theme_track_light
        )

        if (isDark) {
            leftIcon.setImageResource(R.drawable.ic_theme_clear_figma)
            rightIcon.setImageResource(R.drawable.ic_theme_dark_figma)
            thumbIcon.setImageResource(R.drawable.ic_theme_dark_figma)
            thumb.translationX = dpToPx(THUMB_TRAVEL_DP)
        } else {
            leftIcon.setImageResource(R.drawable.ic_theme_clear_figma_blue)
            rightIcon.setImageResource(R.drawable.ic_theme_dark_figma_gray)
            thumbIcon.setImageResource(R.drawable.ic_theme_clear_figma_blue)
            thumb.translationX = 0f
        }
    }

    private fun dpToPx(dp: Float): Float {
        return dp * resources.displayMetrics.density
    }

    companion object {
        private const val THUMB_TRAVEL_DP = 50f
    }
}
