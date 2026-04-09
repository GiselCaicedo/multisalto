package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.theme.UanThemeTokens

/**
 * Constantes y valores por defecto del componente [UanModal].
 *
 * Todos los valores dimensionales y tipograficos se centralizan aqui
 * para facilitar la personalizacion sin modificar la implementacion.
 */
object UanModalDefaults {

    /* ── Dimensiones ───────────────────────────────────────────── */

    /** Ancho maximo del modal. */
    val maxWidth: Dp = 340.dp

    /** Padding interno horizontal. */
    val contentPaddingHorizontal: Dp
        @Composable get() = UanThemeTokens.current.spacing.lg

    /** Padding interno vertical. */
    val contentPaddingVertical: Dp
        @Composable get() = UanThemeTokens.current.spacing.lg

    /** Espaciado entre titulo y subtitulo. */
    val titleSubtitleSpacing: Dp
        @Composable get() = UanThemeTokens.current.spacing.xxs

    /** Espaciado entre subtitulo/titulo y cuerpo de texto. */
    val bodySpacing: Dp
        @Composable get() = UanThemeTokens.current.spacing.xs

    /** Espaciado entre cuerpo y area de media. */
    val mediaSpacing: Dp
        @Composable get() = UanThemeTokens.current.spacing.md

    /** Espaciado entre media y botones de accion. */
    val actionsSpacing: Dp
        @Composable get() = UanThemeTokens.current.spacing.md

    /** Espaciado horizontal entre botones de accion. */
    val actionButtonSpacing: Dp
        @Composable get() = UanThemeTokens.current.spacing.sm

    /** Altura maxima para el area de media/imagen. */
    val mediaMaxHeight: Dp = 220.dp

    /** Ancho del acento lateral semantico. */
    val toneAccentWidth: Dp = 4.dp

    /** Radio de esquina del contenedor del modal. */
    val containerCornerRadius: Dp
        @Composable get() = UanThemeTokens.current.shapes.largeRadius

    /** Radio de esquina del area de media. */
    val mediaCornerRadius: Dp
        @Composable get() = UanThemeTokens.current.shapes.smallRadius

    /* ── Indicadores de pagina (carrusel) ─────────────────────── */

    /** Tamano del indicador de pagina inactivo. */
    val pageIndicatorSize: Dp = 10.dp

    /** Tamano del indicador de pagina activo. */
    val pageIndicatorActiveSize: Dp = 12.dp

    /** Espaciado entre indicadores de pagina. */
    val pageIndicatorSpacing: Dp
        @Composable get() = UanThemeTokens.current.spacing.xs

    /* ── Scrim ─────────────────────────────────────────────────── */

    /** Opacidad del scrim detras del modal. */
    const val scrimAlpha: Float = 0.65f

    /* ── Tipografia ────────────────────────────────────────────── */

    /** Estilo del titulo del modal. */
    val titleStyle
        @Composable get() = UanThemeTokens.current.typography.component

    /** Estilo del subtitulo del modal. */
    val subtitleStyle
        @Composable get() = UanThemeTokens.current.typography.subtitle

    /** Estilo del cuerpo de texto del modal. */
    val bodyStyle
        @Composable get() = UanThemeTokens.current.typography.body
}

