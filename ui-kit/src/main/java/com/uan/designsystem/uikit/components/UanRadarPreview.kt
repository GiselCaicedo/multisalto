package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PriorityHigh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

private val RadarSampleRanges = listOf(
    UanRadarRange(distanceMeters = 50f, label = "50m"),
    UanRadarRange(distanceMeters = 100f, label = "100m"),
    UanRadarRange(distanceMeters = 150f, label = "150m"),
    UanRadarRange(distanceMeters = 200f, label = "200m"),
)

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "Radar - Estados (Figma)",
    widthDp = 420,
)
@Composable
private fun GenericRadarAllStatesPreview() {
    RadarPreviewContainer {
        Text(
            text = "Radar",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        val ranges = remember { RadarSampleRanges }
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            // Inactivo
            UanRadar(
                distanceMeters = 120f,
                distanceRanges = ranges,
                state = UanRadarState.Inactive,
                tone = UanTone.Neutral,
                targetContentDescription = "Inactivo",
                modifier = Modifier.weight(1f).size(120.dp),
            )
            // Activo
            UanRadar(
                distanceMeters = 85f,
                distanceRanges = ranges,
                state = UanRadarState.Active,
                tone = UanTone.Info,
                targetContentDescription = "Activo",
                modifier = Modifier.weight(1f).size(120.dp),
            )
            // Con escalas
            UanRadar(
                distanceMeters = 48f,
                distanceRanges = ranges,
                state = UanRadarState.Active,
                tone = UanTone.Info,
                showScaleLabels = true,
                targetContentDescription = "Con escalas",
                modifier = Modifier.weight(1f).size(140.dp),
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F, name = "Radar - Critico")
@Composable
private fun GenericRadarCriticalPreview() {
    RadarPreviewContainer {
        Text(
            text = "Estado Critico",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        val ranges = remember { RadarSampleRanges }
        UanRadar(
            distanceMeters = 18f,
            distanceRanges = ranges,
            state = UanRadarState.Critical,
            tone = UanTone.Critical,
            targetContentDescription = "Proximidad critica",
            targetContent = {
                val tokens = UanThemeTokens.current
                Icon(
                    imageVector = Icons.Default.PriorityHigh,
                    contentDescription = "Amenaza",
                    tint = tokens.colors.onCritical,
                    modifier = Modifier.size(UanRadarDefaults.targetIconSize),
                )
            },
            modifier = Modifier.size(200.dp),
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F, name = "Radar - Deshabilitado")
@Composable
private fun GenericRadarDisabledPreview() {
    RadarPreviewContainer {
        Text(
            text = "Deshabilitado",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        val ranges = remember { RadarSampleRanges }
        UanRadar(
            distanceMeters = 200f,
            distanceRanges = ranges,
            enabled = false,
            state = UanRadarState.Disabled,
            tone = UanTone.Warning,
            showScaleLabels = true,
            targetContentDescription = "Fuera de servicio",
            modifier = Modifier.size(200.dp),
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
                .fillMaxWidth()
                .background(tokens.colors.background)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            content()
        }
    }
}
