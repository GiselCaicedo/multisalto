package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanDropdownMenuDefaults {
    val cornerRadius: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.shapes.mediumRadius + UanThemeTokens.current.spacing.xs
    val borderWidth: Dp = 2.dp
    val minWidth: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.grid.touchTarget * 4 + UanThemeTokens.current.spacing.xxs
    val itemMinHeight: Dp = 48.dp
    val itemPaddingHorizontal: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.grid.screenMargin
    val itemPaddingVertical: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.sm
    val itemSpacing: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.xs

    val itemTextStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.general
}

