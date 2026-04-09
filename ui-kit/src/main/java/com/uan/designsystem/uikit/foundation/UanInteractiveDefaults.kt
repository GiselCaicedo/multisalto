package com.uan.designsystem.uikit.foundation

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Constantes centralizadas para componentes interactivos.
 *
 * Todas las primitivas y componentes del Uan UI Kit referencian
 * estos valores para garantizar consistencia visual y conformidad
 * WCAG 2.2 nivel AA.
 */
object UanInteractiveDefaults {

    /** Opacidad para estado inhabilitado (Material 3). */
    const val disabledAlpha: Float = 0.38f

    /** Ancho de borde para bordes interactivos. */
    val borderWidth: Dp = 2.dp

    /** Area minima tocable (WCAG 2.5.5). */
    val minTouchTarget: Dp = 48.dp

    /** Padding horizontal para campos de entrada. */
    val inputHorizontalPadding: Dp = 12.dp

    /** Padding vertical para campos de entrada. */
    val inputVerticalPadding: Dp = 10.dp

    /** Espaciado entre elementos adyacentes. */
    val itemSpacing: Dp = 8.dp

    /** Tamano de boton de icono. */
    val iconButtonSize: Dp = 40.dp

    /** Grosor del divisor. */
    val dividerThickness: Dp = 1.dp
}

