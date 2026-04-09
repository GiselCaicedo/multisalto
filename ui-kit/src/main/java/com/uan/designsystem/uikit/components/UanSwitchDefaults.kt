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

object UanSwitchDefaults {
    val trackWidth: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.grid.touchTarget + UanThemeTokens.current.spacing.xl
    val trackHeight: Dp = UanInteractiveDefaults.minTouchTarget
    val thumbSize: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.grid.touchTarget - UanThemeTokens.current.spacing.md
    val iconSize: Dp
        @Composable @ReadOnlyComposable get() = UanIconographyDefaults.small
    val trackPadding: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.xxs
    val iconInset: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.xxs
    val borderWidth: Dp = UanInteractiveDefaults.borderWidth

    @Composable
    @ReadOnlyComposable
    fun trackBorderColor(
        checked: Boolean,
        enabled: Boolean,
        tone: UanTone,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val base = if (checked) tone.colorFor(colors) else colors.outlineVariant
        return if (enabled) base else base.copy(alpha = colors.disabledAlpha)
    }

    @Composable
    @ReadOnlyComposable
    fun trackContainerColor(
        checked: Boolean,
        enabled: Boolean,
        tone: UanTone,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val base = colors.background
        return if (enabled) base else base.copy(alpha = colors.disabledAlpha)
    }

    @Composable
    @ReadOnlyComposable
    fun thumbContainerColor(
        checked: Boolean,
        enabled: Boolean,
        tone: UanTone,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val base = if (checked) colors.onSurface else colors.surface
        return if (enabled) base else base.copy(alpha = colors.disabledAlpha)
    }

    @Composable
    @ReadOnlyComposable
    fun activeIconColor(
        enabled: Boolean,
        tone: UanTone,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val base = tone.colorFor(colors)
        return if (enabled) base else base.copy(alpha = colors.disabledAlpha)
    }

    @Composable
    @ReadOnlyComposable
    fun inactiveIconColor(
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val base = colors.muted
        return if (enabled) base else base.copy(alpha = colors.disabledAlpha)
    }
}

