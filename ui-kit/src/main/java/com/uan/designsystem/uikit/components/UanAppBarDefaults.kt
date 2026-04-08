package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanAppBarDefaults {
    val minHeight: Dp = 64.dp
    val verticalPadding: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.sm
    val horizontalPadding: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.grid.screenMargin
    val contentSpacing: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.sm
    val actionsSpacing: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.xs

    val titleStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.component

    val subtitleStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.small
}

