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
                UanDropdownMenuItem("Opcion 1", "Abrir opcion 1", onClick = {}),
                UanDropdownMenuItem("Opcion 2", "Abrir opcion 2", onClick = {}),
                UanDropdownMenuItem("Opcion 3", "Abrir opcion 3", onClick = {}),
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
                    "Opcion A",
                    "Detalle de opcion A",
                    onClick = {},
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Default.WarningAmber,
                            contentDescription = "Icono decorativo",
                            tint = tokens.colors.critical,
                        )
                    },
                ),
                UanDropdownMenuItem("Opcion B", "Detalle de opcion B", onClick = {}),
                UanDropdownMenuItem("Opcion C", "Detalle de opcion C", onClick = {}),
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
                    "Opcion 1",
                    "Descripcion de opcion 1",
                    onClick = {},
                    trailingContent = {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Seleccionado",
                            tint = tokens.colors.success,
                        )
                    },
                ),
                UanDropdownMenuItem("Opcion 2", "Descripcion de opcion 2", onClick = {}),
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
                    "Opcion 1",
                    "Descripcion de opcion 1",
                    onClick = {},
                    trailingContent = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Abrir submenu",
                            tint = tokens.colors.onSurface,
                        )
                    },
                ),
                UanDropdownMenuItem("Opcion 2", "Descripcion de opcion 2", onClick = {}),
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
                UanDropdownMenuItem("Opcion 1", "Descripcion de opcion 1", enabled = false, onClick = {}),
                UanDropdownMenuItem("Opcion 2", "Descripcion de opcion 2", enabled = false, onClick = {}),
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

