package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun PacienteCardPreview() {
    CardPreviewContainer {
        UanCard(
            title = "Paciente estabilizado",
            body = "Pulso regular y saturacion estable. Preparar traslado inmediato.",
            tone = UanTone.Success,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun RutaEvacuacionCardPreview() {
    CardPreviewContainer {
        UanCard(
            title = "Ruta de evacuacion",
            body = "El corredor este permanece libre. Evite la salida sur.",
            tone = UanTone.Info,
            footer = {
                UanBadge(
                    text = "ACTIVA",
                    tone = UanTone.Info,
                    emphasis = UanBadgeEmphasis.Tonal,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun RiesgoElectricoCardPreview() {
    CardPreviewContainer {
        val tokens = UanThemeTokens.current
        UanCard(
            title = "Peligro electrico",
            body = "No avanzar hasta desconectar el suministro del tablero principal.",
            tone = UanTone.Critical,
            supportingContent = {
                Icon(
                    imageVector = Icons.Default.WarningAmber,
                    contentDescription = "Peligro electrico",
                    tint = tokens.colors.critical,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun ChecklistOperativoCardPreview() {
    CardPreviewContainer {
        val tokens = UanThemeTokens.current
        UanCard(
            title = "Checklist operativo",
            body = "Verifique radio, linterna, guantes y botiquin antes de salir.",
            tone = UanTone.Neutral,
            supportingContent = {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Checklist completado",
                    tint = tokens.colors.success,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun SensorInactivoCardPreview() {
    CardPreviewContainer {
        UanCard(
            title = "Sensor desconectado",
            body = "No hay lectura del modulo secundario. Revise el cableado.",
            enabled = false,
            tone = UanTone.Warning,
        )
    }
}

@Composable
private fun CardPreviewContainer(
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
        ) {
            content()
        }
    }
}

