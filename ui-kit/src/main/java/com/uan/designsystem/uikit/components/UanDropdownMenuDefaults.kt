package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.Dp
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanDropdownMenuDefaults {
    val cornerRadius: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.shapes.mediumRadius
    val borderWidth: Dp = UanInteractiveDefaults.borderWidth
    val minWidth: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.grid.touchTarget * 4
    val itemMinHeight: Dp = UanInteractiveDefaults.minTouchTarget
    val itemPaddingHorizontal: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.md
    val itemPaddingVertical: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.sm
    val itemSpacing: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.xs

    val itemTextStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.body
}
