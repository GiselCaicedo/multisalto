package com.uan.designsystem.uikit.foundation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanGridDefaults {
    val columns: Int
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.grid.columns

    val gutter
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.grid.gutter

    val screenMargin
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.grid.screenMargin

    val touchTarget
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.grid.touchTarget

    val screenPadding: PaddingValues
        @Composable
        @ReadOnlyComposable
        get() = PaddingValues(horizontal = screenMargin)
}

