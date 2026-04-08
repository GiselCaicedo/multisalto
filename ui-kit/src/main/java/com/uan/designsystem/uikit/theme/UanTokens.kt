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
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 22.sp,
                ),
                body = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 20.sp,
                ),
                supporting = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 16.sp,
                ),
                notification = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 28.sp,
                ),
                general = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 26.sp,
                ),
                small = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 24.sp,
                ),
                distance = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 20.sp,
                ),
                sos = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 42.sp,
                ),
                alert = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 38.sp,
                ),
                section = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 30.sp,
                ),
                component = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 28.sp,
                ),
                subtitle = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 26.sp,
                ),
                button = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 28.sp,
                ),
            ),
            shapes = UanShapes(
                smallRadius  = 8.dp,
                mediumRadius = 10.dp,
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

