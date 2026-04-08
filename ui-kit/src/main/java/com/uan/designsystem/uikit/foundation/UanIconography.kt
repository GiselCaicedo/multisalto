package com.uan.designsystem.uikit.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.Dp
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanIconographyDefaults {
    val strokeWidth: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.iconography.strokeWidth

    val small: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.iconography.small

    val medium: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.iconography.medium

    val large: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.iconography.large
}

