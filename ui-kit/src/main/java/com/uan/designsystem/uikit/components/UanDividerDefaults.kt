package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.foundation.colorFor
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanDividerDefaults {
    val thickness: Dp = 1.dp
    val inset: Dp = 0.dp

    @Composable
    @ReadOnlyComposable
    fun color(
        tone: UanTone,
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val base = if (tone == UanTone.Neutral) colors.outline.copy(alpha = 0.4f) else {
            tone.colorFor(colors).copy(alpha = 0.7f)
        }
        return if (enabled) base else base.copy(alpha = colors.disabledAlpha)
    }
}

