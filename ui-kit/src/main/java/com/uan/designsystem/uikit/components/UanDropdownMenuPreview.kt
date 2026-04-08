package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun EvacuacionDropdownPreview() {
    DropdownMenuPreviewContainer {
        val items = remember {
            listOf(
                UanDropdownMenuItem("Ruta norte", "Abrir ruta norte", onClick = {}),
                UanDropdownMenuItem("Ruta oeste", "Abrir ruta oeste", onClick = {}),
                UanDropdownMenuItem("Punto seguro", "Abrir punto seguro", onClick = {}),
            )
        }
        UanDropdownMenu(expanded = true, items = items, tone = UanTone.Info)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun TriageDropdownPreview() {
    DropdownMenuPreviewContainer {
        val tokens = UanThemeTokens.current
        val items = remember {
            listOf(
                UanDropdownMenuItem(
                    "Rojo",
                    "Paciente rojo",
                    onClick = {},
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Default.WarningAmber,
                            contentDescription = "Paciente rojo",
                            tint = tokens.colors.critical,
                        )
                    },
                ),
                UanDropdownMenuItem("Amarillo", "Paciente amarillo", onClick = {}),
                UanDropdownMenuItem("Verde", "Paciente verde", onClick = {}),
            )
        }
        UanDropdownMenu(expanded = true, items = items, tone = UanTone.Warning)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun PacienteDropdownPreview() {
    DropdownMenuPreviewContainer {
        val tokens = UanThemeTokens.current
        val items = remember {
            listOf(
                UanDropdownMenuItem(
                    "Estable",
                    "Estado estable",
                    onClick = {},
                    trailingContent = {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Seleccionado",
                            tint = tokens.colors.success,
                        )
                    },
                ),
                UanDropdownMenuItem("Traslado", "Estado traslado", onClick = {}),
            )
        }
        UanDropdownMenu(expanded = true, items = items, tone = UanTone.Success)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun RiesgoDropdownPreview() {
    DropdownMenuPreviewContainer {
        val tokens = UanThemeTokens.current
        val items = remember {
            listOf(
                UanDropdownMenuItem(
                    "Aislar zona",
                    "Aislar zona critica",
                    onClick = {},
                    trailingContent = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Abrir submenu",
                            tint = tokens.colors.onSurface,
                        )
                    },
                ),
                UanDropdownMenuItem("Llamar apoyo", "Llamar apoyo", onClick = {}),
            )
        }
        UanDropdownMenu(expanded = true, items = items, tone = UanTone.Critical)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun DisabledDropdownPreview() {
    DropdownMenuPreviewContainer {
        val items = remember {
            listOf(
                UanDropdownMenuItem("Sin red", "Sin red", enabled = false, onClick = {}),
                UanDropdownMenuItem("Sincronizar", "Sincronizar", enabled = false, onClick = {}),
            )
        }
        UanDropdownMenu(expanded = true, items = items, enabled = false)
    }
}

@Composable
private fun DropdownMenuPreviewContainer(
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

