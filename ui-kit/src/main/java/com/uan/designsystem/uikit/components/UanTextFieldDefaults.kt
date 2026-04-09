package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.uan.designsystem.uikit.foundation.UanIconographyDefaults
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.theme.UanThemeTokens

/**
 * Constantes y valores por defecto del componente [UanTextField].
 */
object UanTextFieldDefaults {

    /* ── Dimensiones ───────────────────────────────────────────── */

    /** Altura minima del campo (WCAG 2.5.5 — area tocable). */
    val minHeight: Dp = UanInteractiveDefaults.minTouchTarget

    /** Padding horizontal interno del campo. */
    val contentPaddingHorizontal: Dp
        @Composable get() = UanThemeTokens.current.spacing.sm

    /** Padding vertical interno del campo. */
    val contentPaddingVertical: Dp
        @Composable get() = UanThemeTokens.current.spacing.sm

    /** Radio de esquina del contenedor. */
    val cornerRadius: Dp
        @Composable get() = UanThemeTokens.current.shapes.smallRadius

    /** Ancho del borde (alto contraste para emergencias). */
    val borderWidth: Dp = UanInteractiveDefaults.borderWidth

    /** Espaciado entre el campo y el mensaje de error. */
    val errorMessageSpacing: Dp
        @Composable get() = UanThemeTokens.current.spacing.xxs

    /** Espaciado entre icono y texto. */
    val iconSpacing: Dp
        @Composable get() = UanThemeTokens.current.spacing.xs

    /** Tamano de iconos leading/trailing. */
    val iconSize: Dp
        @Composable get() = UanIconographyDefaults.medium

    /* ── Tipografia ────────────────────────────────────────────── */

    /** Estilo del texto de entrada. */
    val inputStyle
        @Composable get() = UanThemeTokens.current.typography.body

    /** Estilo del label/placeholder cuando esta en posicion de placeholder. */
    val placeholderStyle
        @Composable get() = UanThemeTokens.current.typography.body

    /** Estilo del label flotante (reducido arriba del campo). */
    val floatingLabelStyle
        @Composable get() = UanThemeTokens.current.typography.supporting

    /** Estilo del mensaje de error. */
    val errorStyle
        @Composable get() = UanThemeTokens.current.typography.supporting
}

