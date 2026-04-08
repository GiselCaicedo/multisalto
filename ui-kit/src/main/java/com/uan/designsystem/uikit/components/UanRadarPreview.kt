package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PriorityHigh
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

private val RadarStandardRanges = listOf(
    UanRadarRange(distanceMeters = 50f, label = "50m"),
    UanRadarRange(distanceMeters = 100f, label = "100m"),
    UanRadarRange(distanceMeters = 150f, label = "150m"),
    UanRadarRange(distanceMeters = 200f, label = "200m"),
)

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun BusquedaNocturnaInactivaPreview() {
    RadarPreviewContainer {
        val ranges = remember { RadarStandardRanges }
        UanRadar(
            distanceMeters = 120f,
            distanceRanges = ranges,
            state = UanRadarState.Inactive,
            tone = UanTone.Neutral,
            targetContentDescription = "Senal sin confirmacion",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun SenderistaUbicadoActivoPreview() {
    RadarPreviewContainer {
        val ranges = remember { RadarStandardRanges }
        UanRadar(
            distanceMeters = 85f,
            distanceRanges = ranges,
            state = UanRadarState.Active,
            tone = UanTone.Info,
            targetContentDescription = "Senderista ubicado",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun AproximacionConEscalasPreview() {
    RadarPreviewContainer {
        val ranges = remember { RadarStandardRanges }
        UanRadar(
            distanceMeters = 48f,
            distanceRanges = ranges,
            state = UanRadarState.Active,
            tone = UanTone.Info,
            showScaleLabels = true,
            targetContentDescription = "Victima a corta distancia",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun RiesgoInmediatoCriticoPreview() {
    RadarPreviewContainer {
        val ranges = remember { RadarStandardRanges }
        UanRadar(
            distanceMeters = 18f,
            distanceRanges = ranges,
            state = UanRadarState.Critical,
            tone = UanTone.Critical,
            targetContentDescription = "Gas toxico a proximidad critica",
            targetContent = {
                val tokens = UanThemeTokens.current
                Icon(
                    imageVector = Icons.Default.PriorityHigh,
                    contentDescription = "Amenaza critica",
                    tint = tokens.colors.onCritical,
                    modifier = Modifier.size(UanRadarDefaults.targetIconSize),
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun ZonaBloqueadaDeshabilitadaPreview() {
    RadarPreviewContainer {
        val ranges = remember { RadarStandardRanges }
        UanRadar(
            distanceMeters = 200f,
            distanceRanges = ranges,
            enabled = false,
            state = UanRadarState.Disabled,
            tone = UanTone.Warning,
            showScaleLabels = true,
            targetContentDescription = "Sensor fuera de servicio",
        )
    }
}

@Composable
private fun RadarPreviewContainer(
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
            Row(
                horizontalArrangement = Arrangement.Center,
            ) {
                content()
            }
        }
    }
}

