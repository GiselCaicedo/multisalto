package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanIconographyDefaults
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.foundation.colorFor
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanCarouselDefaults {
    val itemWidth: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.grid.touchTarget * 2 + UanThemeTokens.current.spacing.xl - UanThemeTokens.current.spacing.xxs
    val itemHeight: Dp
        @Composable @ReadOnlyComposable get() = itemWidth
    val itemCornerRadius: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.shapes.mediumRadius + UanThemeTokens.current.spacing.xxs
    val itemBorderWidth: Dp = UanInteractiveDefaults.borderWidth
    val itemSpacing: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.md + UanThemeTokens.current.spacing.xxs
    val actionSpacing: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.md
    val actionMinHeight: Dp = 48.dp
    val actionHorizontalPadding: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.md + UanThemeTokens.current.spacing.xxs
    val actionIconSize: Dp
        @Composable @ReadOnlyComposable get() = UanIconographyDefaults.small

    val actionLabelStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.small

    @Composable
    @ReadOnlyComposable
    fun itemContainerColor(
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val base = colors.surface
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
        val base = if (selected) tone.colorFor(colors) else colors.outline
        return if (enabled) base else base.copy(alpha = colors.disabledAlpha)
    }

    @Composable
    @ReadOnlyComposable
    fun actionContainerColor(
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val base = colors.surface
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

