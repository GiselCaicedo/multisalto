package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.uan.designsystem.uikit.foundation.UanIconographyDefaults
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.foundation.colorFor
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanSheetDefaults {
    val minHeight: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.grid.touchTarget + UanThemeTokens.current.spacing.xxl
    val peekHeight: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.md
    val maxExpandedHeight: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.grid.touchTarget * 7
    val containerCornerRadius: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.shapes.largeRadius
    val handleSize: Dp = UanInteractiveDefaults.minTouchTarget
    val handleIconSize: Dp
        @Composable @ReadOnlyComposable get() = UanIconographyDefaults.medium
    val handleOffset: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.lg
    val borderWidth: Dp = UanInteractiveDefaults.borderWidth
    val contentPaddingHorizontal: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.lg
    val contentPaddingVertical: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.lg
    val contentSpacing: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.md

    val titleStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.component

    val bodyStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.body

    @Composable
    @ReadOnlyComposable
    fun containerColor(
        tone: UanTone,
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val baseColor = colors.surfaceContainer
        return if (enabled) baseColor else baseColor.copy(alpha = colors.disabledAlpha)
    }

    @Composable
    @ReadOnlyComposable
    fun borderColor(
        tone: UanTone,
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val accent = if (tone == UanTone.Neutral) colors.outlineVariant else tone.colorFor(colors)
        return if (enabled) accent else accent.copy(alpha = colors.disabledAlpha)
    }

    @Composable
    @ReadOnlyComposable
    fun handleContainerColor(
        tone: UanTone,
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val baseColor = colors.surfaceContainer
        return if (enabled) baseColor else baseColor.copy(alpha = colors.disabledAlpha)
    }
}
