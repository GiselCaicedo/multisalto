package com.redscate.uikit.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Immutable
data class RedscateColors(
    val background: Color,
    val surface: Color,
    val onSurface: Color,
    val primary: Color,
    val onPrimary: Color,
    val success: Color,
    val onSuccess: Color,
    val outline: Color,
    val muted: Color,
    val error: Color
)

@Immutable
data class RedscateTypography(
    val label: TextStyle,
    val body: TextStyle,
    val supporting: TextStyle
)

@Immutable
data class RedscateShapes(
    val smallRadius: androidx.compose.ui.unit.Dp,
    val mediumRadius: androidx.compose.ui.unit.Dp,
    val pillRadius: androidx.compose.ui.unit.Dp
)

@Immutable
data class RedscateTokens(
    val colors: RedscateColors,
    val typography: RedscateTypography,
    val shapes: RedscateShapes
) {
    companion object {
        val Default = RedscateTokens(
            colors = RedscateColors(
                background = Color(0xFF090B0F),
                surface = Color(0xFF171C22),
                onSurface = Color(0xFFF6F6F6),
                primary = Color(0xFF37B2FF),
                onPrimary = Color(0xFFF6F6F6),
                success = Color(0xFF0DB11B),
                onSuccess = Color(0xFFF6F6F6),
                outline = Color(0xFFF6F6F6),
                muted = Color(0xFF888888),
                error = Color(0xFFFF2330)
            ),
            typography = RedscateTypography(
                label = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                body = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                supporting = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            ),
            shapes = RedscateShapes(
                smallRadius = 8.dp,
                mediumRadius = 10.dp,
                pillRadius = 999.dp
            )
        )
    }
}
