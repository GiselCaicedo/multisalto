package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanIconographyDefaults
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.foundation.colorFor
import com.uan.designsystem.uikit.foundation.contentColorFor
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanRadarDefaults {
    val minSize: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.grid.touchTarget * 4 + UanThemeTokens.current.spacing.md
    val ringStrokeWidth: Dp = 2.dp
    val ringSpacing: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.lg
    val targetSize: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.grid.touchTarget - UanThemeTokens.current.spacing.md
    val targetIconSize: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanIconographyDefaults.small
    val labelHorizontalPadding: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.xs
    val labelVerticalPadding: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.xxs
    val labelSpacingFromRing: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.xs
    val labelCornerRadius: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.shapes.pillRadius
    val labelMinHeight: Dp = UanInteractiveDefaults.minTouchTarget

    val labelTextStyle: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.distance

    @Composable
    @ReadOnlyComposable
    fun ringColor(
        tone: UanTone,
        state: UanRadarState,
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val baseColor = when (state) {
            UanRadarState.Inactive -> colors.muted
            UanRadarState.Active -> tone.colorFor(colors)
            UanRadarState.Critical -> colors.critical
            UanRadarState.Disabled -> colors.muted.copy(alpha = colors.disabledAlpha)
        }
        return if (enabled) baseColor else colors.muted.copy(alpha = colors.disabledAlpha)
    }

    @Composable
    @ReadOnlyComposable
    fun targetContainerColor(
        tone: UanTone,
        state: UanRadarState,
        enabled: Boolean,
    ): Color {
        val ring = ringColor(tone = tone, state = state, enabled = enabled)
        return ring
    }

    @Composable
    @ReadOnlyComposable
    fun targetContentColor(
        tone: UanTone,
        state: UanRadarState,
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        return when (state) {
            UanRadarState.Inactive -> colors.background
            UanRadarState.Active -> tone.contentColorFor(colors)
            UanRadarState.Critical -> colors.onCritical
            UanRadarState.Disabled -> colors.background.copy(alpha = colors.disabledAlpha)
        }
    }

    @Composable
    @ReadOnlyComposable
    fun labelContainerColor(
        tone: UanTone,
        state: UanRadarState,
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        return if (enabled && state != UanRadarState.Disabled) {
            colors.surface
        } else {
            colors.surface.copy(alpha = colors.disabledAlpha)
        }
    }

    @Composable
    @ReadOnlyComposable
    fun labelContentColor(
        tone: UanTone,
        state: UanRadarState,
        enabled: Boolean,
    ): Color = ringColor(tone = tone, state = state, enabled = enabled)
}

