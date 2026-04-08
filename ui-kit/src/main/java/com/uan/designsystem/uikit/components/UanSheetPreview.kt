package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
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
private fun EvacuacionExpandidaPreview() {
    SheetPreviewContainer {
        UanSheet(
            expanded = true,
            onExpandedChange = {},
            tone = UanTone.Info,
            collapsedContent = {
                UanSheetBody("Detalles de evacuacion disponibles")
            },
        ) {
            UanSheetTitle("Ruta de evacuacion")
            UanSheetBody("Salida norte despejada. Tiempo estimado al punto seguro: 3 minutos.")
            PreviewPanel(height = 132.dp)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun TriageColapsadoPreview() {
    SheetPreviewContainer {
        UanSheet(
            expanded = false,
            onExpandedChange = {},
            tone = UanTone.Neutral,
            collapsedContent = {
                PreviewPanel(height = 20.dp)
            },
        ) {
            UanSheetTitle("Clasificacion de pacientes")
            UanSheetBody("Panel con prioridades clinicas del incidente.")
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun RiesgoQuimicoAdvertenciaPreview() {
    SheetPreviewContainer {
        UanSheet(
            expanded = true,
            onExpandedChange = {},
            tone = UanTone.Warning,
            collapsedContent = {
                UanSheetBody("Concentracion elevada detectada")
            },
        ) {
            UanSheetTitle("Riesgo quimico")
            UanSheetBody("Mantenga distancia operativa y confirme uso de mascara con filtro.")
            Icon(
                imageVector = Icons.Default.WarningAmber,
                contentDescription = "Advertencia quimica",
                tint = UanThemeTokens.current.colors.warning,
                modifier = Modifier.size(32.dp),
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun PacienteEstabilizadoInfoPreview() {
    SheetPreviewContainer {
        UanSheet(
            expanded = true,
            onExpandedChange = {},
            tone = UanTone.Success,
            collapsedContent = {
                UanSheetBody("Signos vitales estables")
            },
        ) {
            UanSheetTitle("Paciente estabilizado")
            UanSheetBody("Saturacion 97%, pulso 82 lpm. Preparar entrega a ambulancia.")
            PreviewPanel(height = 96.dp)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun SensorFueraDeServicioPreview() {
    SheetPreviewContainer {
        UanSheet(
            expanded = false,
            onExpandedChange = {},
            enabled = false,
            tone = UanTone.Critical,
            collapsedContent = {
                PreviewPanel(height = 16.dp)
            },
        ) {
            UanSheetTitle("Sensor fuera de servicio")
            UanSheetBody("Reconecte la unidad antes de continuar el monitoreo.")
        }
    }
}

@Composable
private fun SheetPreviewContainer(
    content: @Composable () -> Unit,
) {
    UanTheme {
        val tokens = UanThemeTokens.current
        Box(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(24.dp)
                .fillMaxWidth(),
        ) {
            content()
        }
    }
}

@Composable
private fun PreviewPanel(
    height: androidx.compose.ui.unit.Dp,
) {
    val colors = UanThemeTokens.current.colors
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .background(colors.background)
            .padding(1.dp),
    )
}

