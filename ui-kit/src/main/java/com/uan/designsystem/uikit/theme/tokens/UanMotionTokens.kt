package com.uan.designsystem.uikit.theme.tokens

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.runtime.Immutable

/**
 * Tokens de movimiento del sistema Uan.
 *
 * Define duraciones estandar y curvas de easing para mantener
 * coherencia en todas las animaciones del UI Kit.
 */
@Immutable
data class UanMotion(
    val durationShort: Int,
    val durationMedium: Int,
    val durationLong: Int,
    val durationEmphasis: Int,
    val durationActivation: Int,
    val easingStandard: Easing,
    val easingEmphasized: Easing,
    val easingDecelerate: Easing,
    val easingLinear: Easing,
)

/** Valores de movimiento por defecto de Uan. */
val UanDefaultMotion = UanMotion(
    durationShort      = 150,
    durationMedium     = 300,
    durationLong       = 500,
    durationEmphasis   = 1200,
    durationActivation = 3000,
    easingStandard     = CubicBezierEasing(0.2f, 0f, 0f, 1f),
    easingEmphasized   = CubicBezierEasing(0.05f, 0.7f, 0.1f, 1f),
    easingDecelerate   = CubicBezierEasing(0f, 0f, 0.2f, 1f),
    easingLinear       = LinearEasing,
)

