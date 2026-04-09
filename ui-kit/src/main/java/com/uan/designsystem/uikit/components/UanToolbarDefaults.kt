package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.Dp
import com.uan.designsystem.uikit.foundation.UanIconographyDefaults
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.theme.UanThemeTokens

/**
 * Constantes y valores por defecto del componente [UanToolbar].
 */
object UanToolbarDefaults {

    /** Altura de la barra. */
    val height: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.grid.touchTarget + UanThemeTokens.current.spacing.xs

    /** Radio de esquina del contenedor. */
    val containerCornerRadius: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.shapes.mediumRadius

    /** Ancho del borde del contenedor. */
    val containerBorderWidth: Dp
        @Composable @ReadOnlyComposable
        get() = UanThemeTokens.current.elevations.level1

    /** Tamano del indicador circular de seleccion. */
    val indicatorSize: Dp = UanInteractiveDefaults.iconButtonSize

    /** Padding horizontal interno de la barra. */
    val contentPaddingHorizontal: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.grid.screenMargin

    /** Tamano del icono dentro de cada item. */
    val iconSize: Dp
        @Composable
        @ReadOnlyComposable
        get() = UanIconographyDefaults.medium
}
