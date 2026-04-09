package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

/* ═══════════════════════════════════════════════════════════════
 * Preview — Dropdown Menu (Figma)
 * ═══════════════════════════════════════════════════════════════ */

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "Dropdown Menu (Figma)",
    widthDp = 460,
)
@Composable
private fun GenericDropdownPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(24.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Text(
                text = "Dropdown Menu",
                style = tokens.typography.component,
                color = tokens.colors.onSurface,
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth(),
            ) {
                // Default con iconos
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    Text(
                        text = "Default",
                        style = tokens.typography.supporting,
                        color = tokens.colors.muted,
                    )
                    val items = remember {
                        listOf(
                            UanDropdownMenuItem("Editar", "Editar elemento", onClick = {},
                                leadingContent = {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = null,
                                        tint = tokens.colors.onSurface,
                                    )
                                },
                            ),
                            UanDropdownMenuItem("Copiar", "Copiar elemento", onClick = {},
                                leadingContent = {
                                    Icon(
                                        imageVector = Icons.Default.ContentCopy,
                                        contentDescription = null,
                                        tint = tokens.colors.onSurface,
                                    )
                                },
                            ),
                            UanDropdownMenuItem("Compartir", "Compartir", onClick = {},
                                leadingContent = {
                                    Icon(
                                        imageVector = Icons.Default.Share,
                                        contentDescription = null,
                                        tint = tokens.colors.onSurface,
                                    )
                                },
                                trailingContent = {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                        contentDescription = null,
                                        tint = tokens.colors.muted,
                                    )
                                },
                            ),
                        )
                    }
                    UanDropdownMenu(expanded = true, items = items, tone = UanTone.Neutral)
                }

                // Con seleccion
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    Text(
                        text = "Con seleccion",
                        style = tokens.typography.supporting,
                        color = tokens.colors.muted,
                    )
                    val items = remember {
                        listOf(
                            UanDropdownMenuItem("Opcion A", "Opcion A", onClick = {},
                                trailingContent = {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = "Seleccionado",
                                        tint = tokens.colors.primary,
                                    )
                                },
                            ),
                            UanDropdownMenuItem("Opcion B", "Opcion B", onClick = {}),
                            UanDropdownMenuItem("Opcion C", "Opcion C", onClick = {}),
                        )
                    }
                    UanDropdownMenu(expanded = true, items = items, tone = UanTone.Neutral)
                }
            }

            // Peligroso y Deshabilitado
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth(),
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    Text(
                        text = "Con accion peligrosa",
                        style = tokens.typography.supporting,
                        color = tokens.colors.muted,
                    )
                    val items = remember {
                        listOf(
                            UanDropdownMenuItem("Editar", "Editar", onClick = {},
                                leadingContent = {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = null,
                                        tint = tokens.colors.onSurface,
                                    )
                                },
                            ),
                            UanDropdownMenuItem("Eliminar", "Eliminar", onClick = {},
                                leadingContent = {
                                    Icon(
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = null,
                                        tint = tokens.colors.error,
                                    )
                                },
                            ),
                        )
                    }
                    UanDropdownMenu(expanded = true, items = items, tone = UanTone.Neutral)
                }

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    Text(
                        text = "Deshabilitado",
                        style = tokens.typography.supporting,
                        color = tokens.colors.muted,
                    )
                    val items = remember {
                        listOf(
                            UanDropdownMenuItem("Opcion 1", "No disponible", enabled = false, onClick = {}),
                            UanDropdownMenuItem("Opcion 2", "No disponible", enabled = false, onClick = {}),
                        )
                    }
                    UanDropdownMenu(expanded = true, items = items, enabled = false)
                }
            }
        }
    }
}
