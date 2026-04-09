package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanElevationLevel
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericElevationSolidPreview() {
    ElevationPreviewContainer {
        UanElevation(
            text = "Nivel 1",
            level = UanElevationLevel.Level3,
            contentDescription = "Superficie elevada de ejemplo",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericElevationSurfacePreview() {
    ElevationPreviewContainer {
        UanElevation(
            text = "Nivel 2",
            level = UanElevationLevel.Level1,
            contentDescription = "Superficie elevada de ejemplo",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericElevationMutedPreview() {
    ElevationPreviewContainer {
        UanElevation(
            text = "Nivel 3",
            level = UanElevationLevel.Level4,
            contentDescription = "Superficie elevada de ejemplo",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericElevationCardPreview() {
    ElevationPreviewContainer {
        UanElevation(
            text = "Nivel 4",
            level = UanElevationLevel.Level2,
            contentDescription = "Superficie elevada de ejemplo",
            content = {
                Text(
                    text = "Nivel 4",
                    style = UanElevationDefaults.labelStyle,
                    color = UanThemeTokens.current.colors.success,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericElevationDisabledPreview() {
    ElevationPreviewContainer {
        UanElevation(
            text = "Deshabilitado",
            enabled = false,
            level = UanElevationLevel.Level3,
            contentDescription = "Superficie inhabilitada de ejemplo",
        )
    }
}

@Composable
private fun ElevationPreviewContainer(
    content: @Composable () -> Unit,
) {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            content()
        }
    }
}

