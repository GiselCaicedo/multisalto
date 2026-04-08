package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun EvacuacionListPreview() {
    ListsPreviewContainer {
        val tokens = UanThemeTokens.current
        UanLists(
            title = "Ruta norte",
            supportingText = "Salida recomendada por brigada",
            onClick = {},
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Ruta norte",
                    tint = tokens.colors.info,
                )
            },
            trailingContent = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Abrir ruta",
                    tint = tokens.colors.onSurface,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun PacienteListPreview() {
    ListsPreviewContainer {
        val tokens = UanThemeTokens.current
        UanLists(
            title = "Paciente 04",
            supportingText = "Saturacion 97%, traslado pendiente",
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Paciente estable",
                    tint = tokens.colors.success,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun RiesgoListPreview() {
    ListsPreviewContainer {
        val tokens = UanThemeTokens.current
        UanLists(
            title = "Gas inflamable",
            supportingText = "Zona restringida en radio de 30 metros",
            onClick = {},
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.WarningAmber,
                    contentDescription = "Gas inflamable",
                    tint = tokens.colors.critical,
                )
            },
            trailingContent = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Abrir detalle",
                    tint = tokens.colors.onSurface,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun RadioListPreview() {
    ListsPreviewContainer {
        val tokens = UanThemeTokens.current
        UanLists(
            title = "Canal operativo",
            supportingText = "Frecuencia secundaria activa",
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Canal operativo",
                    tint = tokens.colors.warning,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun DisabledListPreview() {
    ListsPreviewContainer {
        UanLists(
            title = "Sincronizacion",
            supportingText = "Servidor no disponible",
            enabled = false,
        )
    }
}

@Composable
private fun ListsPreviewContainer(
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

