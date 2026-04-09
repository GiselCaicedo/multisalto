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

object UanCarouselDefaults {
    val itemWidth: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.grid.touchTarget * 3
    val itemHeight: Dp
        @Composable @ReadOnlyComposable get() = itemWidth
    val itemCornerRadius: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.shapes.mediumRadius
    val itemBorderWidth: Dp = UanInteractiveDefaults.borderWidth
    val itemSpacing: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.md
    val actionSpacing: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.md
    val actionMinHeight: Dp = UanInteractiveDefaults.minTouchTarget
    val actionHorizontalPadding: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.md
    val actionIconSize: Dp
        @Composable @ReadOnlyComposable get() = UanIconographyDefaults.small

    val actionLabelStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.label

    @Composable
    @ReadOnlyComposable
    fun itemContainerColor(
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val base = colors.surfaceContainer
        return if (enabled) base else base.copy(alpha = colors.disabledAlpha)
    }

    @Composable
    @ReadOnlyComposable
    fun itemBorderColor(
        tone: UanTone,
        selected: Boolean,
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val base = if (selected) tone.colorFor(colors) else colors.outlineVariant
        return if (enabled) base else base.copy(alpha = colors.disabledAlpha)
    }

    @Composable
    @ReadOnlyComposable
    fun actionContainerColor(
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val base = colors.surfaceContainer
        return if (enabled) base else base.copy(alpha = colors.disabledAlpha)
    }

    @Composable
    @ReadOnlyComposable
    fun actionBorderColor(
        tone: UanTone,
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val base = tone.colorFor(colors)
        return if (enabled) base else base.copy(alpha = colors.disabledAlpha)
    }
}
