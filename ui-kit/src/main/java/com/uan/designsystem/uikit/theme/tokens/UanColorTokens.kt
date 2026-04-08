package com.uan.designsystem.uikit.theme.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Paleta de colores del sistema de diseno Uan.
 *
 * Cada tono semantico (Success, Info, Warning, Error, Critical) expone
 * tres variantes: color principal, color de contenido ([onX]) y color
 * de contenedor ([xContainer]).
 *
 * @property disabledAlpha Opacidad aplicada a elementos inhabilitados (Material 3: 0.38f).
 */
@Immutable
data class UanColors(
    val background: Color,
    val surface: Color,
    val outline: Color,
    val muted: Color,
    val onSurface: Color,
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val success: Color,
    val onSuccess: Color,
    val successContainer: Color,
    val info: Color,
    val onInfo: Color,
    val infoContainer: Color,
    val warning: Color,
    val onWarning: Color,
    val warningContainer: Color,
    val error: Color,
    val onError: Color,
    val errorContainer: Color,
    val critical: Color,
    val onCritical: Color,
    val criticalContainer: Color,
    val disabledAlpha: Float,
)

/** Paleta oscura por defecto de Uan (tema Dark). */
val UanDarkColors = UanColors(
    background       = Color(0xFF090B0F),
    surface          = Color(0xFF171C22),
    outline          = Color(0xFFF6F6F6),
    muted            = Color(0xFF888888),
    onSurface        = Color(0xFFF6F6F6),
    primary          = Color(0xFF37B2FF),
    onPrimary        = Color(0xFF090B0F),
    primaryContainer = Color(0xFF0D2A3D),
    success          = Color(0xFF0DB11B),
    onSuccess        = Color(0xFF090B0F),
    successContainer = Color(0xFF082B0B),
    info             = Color(0xFF00C8D4),
    onInfo           = Color(0xFF090B0F),
    infoContainer    = Color(0xFF052E31),
    warning          = Color(0xFFFFB300),
    onWarning        = Color(0xFF090B0F),
    warningContainer = Color(0xFF332400),
    error            = Color(0xFFFF2330),
    onError          = Color(0xFFF6F6F6),
    errorContainer   = Color(0xFF3D050A),
    critical         = Color(0xFFFF0033),
    onCritical       = Color(0xFFF6F6F6),
    criticalContainer = Color(0xFF4A0011),
    disabledAlpha    = 0.38f,
)

