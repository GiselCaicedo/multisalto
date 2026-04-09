package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanIconographyDefaults
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.theme.UanThemeTokens

/**
 * Valores por defecto del componente de progreso Uan.
 *
 * Los colores y tipografias se resuelven desde [UanThemeTokens.current].
 * Las dimensiones se centralizan aqui para mantener consistencia interna.
 */
object UanProgressIndicatorDefaults {

    val stepTouchTarget: Dp = UanInteractiveDefaults.minTouchTarget
    val numberedStepSize: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.lg
    val statusStepSize: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.xxl - UanThemeTokens.current.spacing.xxs
    val stepBorderWidth: Dp = UanInteractiveDefaults.borderWidth
    val connectorDotSize: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.xxs
    val connectorDotSpacing: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.xxs
    val connectorSideSpacing: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.xs
    val connectorHeight: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.spacing.xs
    val connectorDotCount: Int = 3
    val stepGroupSpacing: Dp = 0.dp
    val iconSize: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanIconographyDefaults.small

    val numberStyle: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.supporting
}

