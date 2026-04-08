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
private fun ElevacionParoCardiacoPreview() {
    ElevationPreviewContainer {
        UanElevation(
            text = "DEA",
            level = UanElevationLevel.Level3,
            contentDescription = "Superficie elevada para DEA",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun ElevacionEvacuacionPreview() {
    ElevationPreviewContainer {
        UanElevation(
            text = "RUTA",
            level = UanElevationLevel.Level1,
            contentDescription = "Superficie elevada de ruta",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun ElevacionBusquedaPreview() {
    ElevationPreviewContainer {
        UanElevation(
            text = "RADAR",
            level = UanElevationLevel.Level4,
            contentDescription = "Superficie elevada de radar",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun ElevacionPacientePreview() {
    ElevationPreviewContainer {
        UanElevation(
            text = "ESTABLE",
            level = UanElevationLevel.Level2,
            contentDescription = "Superficie elevada de estado del paciente",
            content = {
                Text(
                    text = "ESTABLE",
                    style = UanElevationDefaults.labelStyle,
                    color = UanThemeTokens.current.colors.success,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun ElevacionDisabledPreview() {
    ElevationPreviewContainer {
        UanElevation(
            text = "SIN RED",
            enabled = false,
            level = UanElevationLevel.Level3,
            contentDescription = "Superficie inhabilitada",
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

