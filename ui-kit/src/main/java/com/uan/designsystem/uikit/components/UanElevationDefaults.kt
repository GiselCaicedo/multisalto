package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanElevationDefaults {
    val width: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.grid.touchTarget * 3
    val height: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.grid.touchTarget * 2 + UanThemeTokens.current.spacing.md
    val cornerRadius: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.shapes.largeRadius
    val horizontalPadding: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.lg
    val verticalPadding: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.md

    val labelStyle: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.component
}
