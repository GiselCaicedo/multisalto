package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.uan.designsystem.uikit.foundation.UanIconographyDefaults
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanButtonDefaults {

    /* ── Horizontal padding por tamano ──────────────────────────── */

    val xSmallHorizontalPadding: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.xs

    val compactHorizontalPadding: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.sm

    val regularHorizontalPadding: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.md

    val largeHorizontalPadding: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.lg

    val xLargeHorizontalPadding: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.xl

    /** @deprecated Usa el padding por tamano. */
    val horizontalPadding: Dp
        @Composable @ReadOnlyComposable
        get() = regularHorizontalPadding

    /* ── Vertical padding por tamano ───────────────────────────── */

    val xSmallVerticalPadding: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.xxxs

    val compactVerticalPadding: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.xxs

    val regularVerticalPadding: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.sm

    val largeVerticalPadding: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.md

    val xLargeVerticalPadding: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.lg

    /* ── Indicator sizes ───────────────────────────────────────── */

    val compactIndicatorSize: Dp
        @Composable @ReadOnlyComposable
        get() = UanIconographyDefaults.small

    val regularIndicatorSize: Dp
        @Composable @ReadOnlyComposable
        get() = UanIconographyDefaults.medium

    val largeIndicatorSize: Dp
        @Composable @ReadOnlyComposable
        get() = UanIconographyDefaults.large

    /* ── Icon sizes ────────────────────────────────────────────── */

    val xSmallIconSize: Dp
        @Composable @ReadOnlyComposable
        get() = UanIconographyDefaults.small

    val compactIconSize: Dp
        @Composable @ReadOnlyComposable
        get() = UanIconographyDefaults.small

    val iconSize: Dp
        @Composable @ReadOnlyComposable
        get() = UanIconographyDefaults.medium

    /* ── Otros ─────────────────────────────────────────────────── */

    val strokeWidth: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.elevations.level2

    val textStyle: TextStyle
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.button
}
