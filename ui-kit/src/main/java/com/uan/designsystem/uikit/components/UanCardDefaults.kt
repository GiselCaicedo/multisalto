package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.foundation.colorFor
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanCardDefaults {
    val cornerRadius: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.shapes.mediumRadius
    val borderWidth: Dp = 2.dp
    val horizontalPadding: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.md + UanThemeTokens.current.spacing.xs
    val verticalPadding: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.md + UanThemeTokens.current.spacing.xs
    val sectionSpacing: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.sm
    val accentWidth: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.xxs

    val titleStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.component

    val bodyStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.small

    @Composable
    @ReadOnlyComposable
    fun containerColor(enabled: Boolean): Color {
        val colors = UanThemeTokens.current.colors
        return if (enabled) colors.surface else colors.surface.copy(alpha = colors.disabledAlpha)
    }

    @Composable
    @ReadOnlyComposable
    fun borderColor(
        tone: UanTone,
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val base = if (tone == UanTone.Neutral) colors.outline else tone.colorFor(colors)
        return if (enabled) base else base.copy(alpha = colors.disabledAlpha)
    }
}

