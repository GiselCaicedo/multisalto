package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanListsDefaults {
    val itemMinHeight: Dp = 64.dp
    val horizontalPadding: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.grid.screenMargin
    val verticalPadding: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.sm
    val contentSpacing: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.sm
    val sectionSpacing: Dp
        @Composable @ReadOnlyComposable get() = UanThemeTokens.current.spacing.xxs

    val titleStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.general

    val supportingStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.small
}

