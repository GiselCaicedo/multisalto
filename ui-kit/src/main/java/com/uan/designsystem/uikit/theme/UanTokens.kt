package com.uan.designsystem.uikit.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uan.designsystem.uikit.theme.tokens.UanColors
import com.uan.designsystem.uikit.theme.tokens.UanDarkColors
import com.uan.designsystem.uikit.theme.tokens.UanDefaultElevations
import com.uan.designsystem.uikit.theme.tokens.UanDefaultGrid
import com.uan.designsystem.uikit.theme.tokens.UanDefaultIconography
import com.uan.designsystem.uikit.theme.tokens.UanDefaultMotion
import com.uan.designsystem.uikit.theme.tokens.UanDefaultSpacing
import com.uan.designsystem.uikit.theme.tokens.UanElevations
import com.uan.designsystem.uikit.theme.tokens.UanGrid
import com.uan.designsystem.uikit.theme.tokens.UanIconography
import com.uan.designsystem.uikit.theme.tokens.UanMotion
import com.uan.designsystem.uikit.theme.tokens.UanSpacing

/** Estilos tipograficos del sistema Uan. */
@Immutable
data class UanTypography(
    val label: TextStyle,
    val body: TextStyle,
    val supporting: TextStyle,
    val notification: TextStyle,
    val general: TextStyle,
    val small: TextStyle,
    val distance: TextStyle,
    val sos: TextStyle,
    val alert: TextStyle,
    val section: TextStyle,
    val component: TextStyle,
    val subtitle: TextStyle,
    val button: TextStyle,
)

/** Radios de borde del sistema Uan. */
@Immutable
data class UanShapes(
    val smallRadius: Dp,
    val mediumRadius: Dp,
    val largeRadius: Dp,
    val pillRadius: Dp,
)

/**
 * Contenedor inmutable de todos los tokens de diseno.
 *
 * Personalizable mediante [copy] sin modificar el codigo fuente:
 * ```kotlin
 * UanTokens.Default.copy(
 *     colors = UanDarkColors.copy(primary = Color.Magenta)
 * )
 * ```
 */
@Immutable
data class UanTokens(
    val colors: UanColors,
    val typography: UanTypography,
    val shapes: UanShapes,
    val spacing: UanSpacing,
    val grid: UanGrid,
    val iconography: UanIconography,
    val elevations: UanElevations,
    val motion: UanMotion,
) {
    companion object {
        /** Configuracion oscura por defecto. */
        val Default = UanTokens(
            colors = UanDarkColors,
            typography = UanTypography(
                label = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 20.sp,
                    letterSpacing = 0.1.sp,
                ),
                body = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 20.sp,
                    letterSpacing = 0.25.sp,
                ),
                supporting = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 16.sp,
                    letterSpacing = 0.4.sp,
                ),
                notification = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 28.sp,
                    letterSpacing = 0.sp,
                ),
                general = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 24.sp,
                    letterSpacing = 0.5.sp,
                ),
                small = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 20.sp,
                    letterSpacing = 0.25.sp,
                ),
                distance = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 16.sp,
                    letterSpacing = 0.5.sp,
                ),
                sos = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 44.sp,
                    letterSpacing = 0.sp,
                ),
                alert = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 36.sp,
                    letterSpacing = 0.sp,
                ),
                section = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 28.sp,
                    letterSpacing = 0.sp,
                ),
                component = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 28.sp,
                    letterSpacing = 0.sp,
                ),
                subtitle = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 22.sp,
                    letterSpacing = 0.15.sp,
                ),
                button = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 20.sp,
                    letterSpacing = 0.4.sp,
                ),
            ),
            shapes = UanShapes(
                smallRadius  = 8.dp,
                mediumRadius = 12.dp,
                largeRadius  = 16.dp,
                pillRadius   = 999.dp,
            ),
            spacing = UanDefaultSpacing,
            grid = UanDefaultGrid,
            iconography = UanDefaultIconography,
            elevations = UanDefaultElevations,
            motion = UanDefaultMotion,
        )
    }
}

