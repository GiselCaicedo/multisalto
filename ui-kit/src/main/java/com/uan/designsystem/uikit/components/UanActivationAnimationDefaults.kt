package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanIconographyDefaults
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanActivationAnimationDefaults {
    val minSize: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.grid.touchTarget * 2 + UanThemeTokens.current.spacing.xxl
    val ringStrokeWidth: Dp = 2.dp
    val centerSize: Dp
        @Composable @ReadOnlyComposable get() = UanIconographyDefaults.medium - UanThemeTokens.current.spacing.xxs
    val centerIconSize: Dp
        @Composable @ReadOnlyComposable get() = UanIconographyDefaults.small

    val labelStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.supporting
}
