package com.uan.designsystem.uikit.foundation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.uan.designsystem.uikit.theme.UanThemeTokens

enum class UanElevationLevel {
    Level0,
    Level1,
    Level2,
    Level3,
    Level4,
}

@Composable
fun Modifier.UanElevation(
    level: UanElevationLevel,
    shape: Shape,
    enabled: Boolean = true,
    ambientColor: Color = UanThemeTokens.current.colors.outline.copy(alpha = 0.18f),
    spotColor: Color = UanThemeTokens.current.colors.outline.copy(alpha = 0.32f),
): Modifier {
    val elevations = UanThemeTokens.current.elevations
    val elevation = when (level) {
        UanElevationLevel.Level0 -> elevations.level0
        UanElevationLevel.Level1 -> elevations.level1
        UanElevationLevel.Level2 -> elevations.level2
        UanElevationLevel.Level3 -> elevations.level3
        UanElevationLevel.Level4 -> elevations.level4
    }
    return if (enabled) {
        shadow(
            elevation = elevation,
            shape = shape,
            clip = false,
            ambientColor = ambientColor,
            spotColor = spotColor,
        )
    } else {
        this
    }
}

