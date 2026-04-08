package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.uan.designsystem.uikit.foundation.UanIconographyDefaults
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanButtonDefaults {
    val horizontalPadding: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.md

    val compactVerticalPadding: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.xxs

    val regularVerticalPadding: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.xs

    val largeVerticalPadding: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.sm

    val compactIndicatorSize: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanIconographyDefaults.small

    val regularIndicatorSize: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanIconographyDefaults.medium

    val largeIndicatorSize: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanIconographyDefaults.large

    val iconSize: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanIconographyDefaults.medium

    val strokeWidth: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.elevations.level1 + UanThemeTokens.current.elevations.level1

    val textStyle: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.button
}

