package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.foundation.colorFor
import com.uan.designsystem.uikit.foundation.containerColorFor
import com.uan.designsystem.uikit.foundation.contentColorFor
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanBadgeDefaults {
    val horizontalPadding: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.sm
    val verticalPadding: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.xxs
    val cornerRadius: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.shapes.pillRadius

    val labelStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.distance

    @Composable
    @ReadOnlyComposable
    fun containerColor(
        tone: UanTone,
        emphasis: UanBadgeEmphasis,
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val base = when (emphasis) {
            UanBadgeEmphasis.Solid -> tone.colorFor(colors)
            UanBadgeEmphasis.Tonal -> tone.containerColorFor(colors)
            UanBadgeEmphasis.Outline -> colors.background
        }
        return if (enabled) base else base.copy(alpha = colors.disabledAlpha)
    }

    @Composable
    @ReadOnlyComposable
    fun contentColor(
        tone: UanTone,
        emphasis: UanBadgeEmphasis,
        enabled: Boolean,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val base = when (emphasis) {
            UanBadgeEmphasis.Solid -> tone.contentColorFor(colors)
            UanBadgeEmphasis.Tonal -> tone.colorFor(colors)
            UanBadgeEmphasis.Outline -> tone.colorFor(colors)
        }
        return if (enabled) base else base.copy(alpha = colors.disabledAlpha)
    }
}

