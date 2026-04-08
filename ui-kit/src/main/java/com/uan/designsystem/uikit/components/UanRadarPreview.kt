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

private val RadarSampleRanges = listOf(
    UanRadarRange(distanceMeters = 50f, label = "50m"),
    UanRadarRange(distanceMeters = 100f, label = "100m"),
    UanRadarRange(distanceMeters = 150f, label = "150m"),
    UanRadarRange(distanceMeters = 200f, label = "200m"),
)

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericRadarInactivePreview() {
    RadarPreviewContainer {
        val ranges = remember { RadarSampleRanges }
        UanRadar(
            distanceMeters = 120f,
            distanceRanges = ranges,
            state = UanRadarState.Inactive,
            tone = UanTone.Neutral,
            targetContentDescription = "Objetivo no confirmado",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericRadarActivePreview() {
    RadarPreviewContainer {
        val ranges = remember { RadarSampleRanges }
        UanRadar(
            distanceMeters = 85f,
            distanceRanges = ranges,
            state = UanRadarState.Active,
            tone = UanTone.Info,
            targetContentDescription = "Objetivo ubicado",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericRadarScalesPreview() {
    RadarPreviewContainer {
        val ranges = remember { RadarSampleRanges }
        UanRadar(
            distanceMeters = 48f,
            distanceRanges = ranges,
            state = UanRadarState.Active,
            tone = UanTone.Info,
            showScaleLabels = true,
            targetContentDescription = "Objetivo a corta distancia",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericRadarCriticalPreview() {
    RadarPreviewContainer {
        val ranges = remember { RadarSampleRanges }
        UanRadar(
            distanceMeters = 18f,
            distanceRanges = ranges,
            state = UanRadarState.Critical,
            tone = UanTone.Critical,
            targetContentDescription = "Objetivo a proximidad critica",
            targetContent = {
                val tokens = UanThemeTokens.current
                Icon(
                    imageVector = Icons.Default.PriorityHigh,
                    contentDescription = "Icono de amenaza",
                    tint = tokens.colors.onCritical,
                    modifier = Modifier.size(UanRadarDefaults.targetIconSize),
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericRadarDisabledPreview() {
    RadarPreviewContainer {
        val ranges = remember { RadarSampleRanges }
        UanRadar(
            distanceMeters = 200f,
            distanceRanges = ranges,
            enabled = false,
            state = UanRadarState.Disabled,
            tone = UanTone.Warning,
            showScaleLabels = true,
            targetContentDescription = "Objetivo fuera de servicio",
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

