package com.uan.designsystem.uikit.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

/* ═══════════════════════════════════════════════════════════════
 * Preview 1 — Todos los estados
 * ═══════════════════════════════════════════════════════════════ */

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "IconButton - Estados",
)
@Composable
private fun GenericIconButtonStatesPreview() {
    IconButtonPreviewContainer {
        Text(
            text = "Estados",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text("Default", style = UanThemeTokens.current.typography.distance, color = UanThemeTokens.current.colors.muted)
                UanIconButton(
                    contentDescription = "Volver",
                    onClick = {},
                    borderColor = UanThemeTokens.current.colors.outline,
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = UanThemeTokens.current.colors.onSurface,
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text("Selected", style = UanThemeTokens.current.typography.distance, color = UanThemeTokens.current.colors.muted)
                UanIconButton(
                    contentDescription = "Notificaciones",
                    onClick = {},
                    selected = true,
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null,
                        tint = UanThemeTokens.current.colors.onPrimary,
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text("Disabled", style = UanThemeTokens.current.typography.distance, color = UanThemeTokens.current.colors.muted)
                UanIconButton(
                    contentDescription = "Cerrado",
                    enabled = false,
                    borderColor = UanThemeTokens.current.colors.outline,
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = UanThemeTokens.current.colors.onSurface,
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text("Filled", style = UanThemeTokens.current.typography.distance, color = UanThemeTokens.current.colors.muted)
                UanIconButton(
                    contentDescription = "Agregar",
                    onClick = {},
                    containerColor = UanThemeTokens.current.colors.primary,
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = UanThemeTokens.current.colors.onPrimary,
                    )
                }
            }
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 2 — Formas y variantes
 * ═══════════════════════════════════════════════════════════════ */

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "IconButton - Formas",
)
@Composable
private fun GenericIconButtonShapesPreview() {
    IconButtonPreviewContainer {
        Text(
            text = "Formas",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text("Circle", style = UanThemeTokens.current.typography.distance, color = UanThemeTokens.current.colors.muted)
                UanIconButton(
                    contentDescription = "Circulo",
                    onClick = {},
                    shape = CircleShape,
                    borderColor = UanThemeTokens.current.colors.outline,
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = UanThemeTokens.current.colors.onSurface,
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text("Rounded", style = UanThemeTokens.current.typography.distance, color = UanThemeTokens.current.colors.muted)
                UanIconButton(
                    contentDescription = "Redondeado",
                    onClick = {},
                    shape = RoundedCornerShape(UanThemeTokens.current.shapes.smallRadius),
                    borderColor = UanThemeTokens.current.colors.outline,
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = UanThemeTokens.current.colors.onSurface,
                    )
                }
            }
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 3 — Uso contextual (como en Toolbar/Sheet)
 * ═══════════════════════════════════════════════════════════════ */

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "IconButton - Uso contextual",
)
@Composable
private fun GenericIconButtonContextPreview() {
    IconButtonPreviewContainer {
        Text(
            text = "Uso contextual",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // Handle de sheet
            UanIconButton(
                contentDescription = "Expandir",
                onClick = {},
                shape = RoundedCornerShape(UanThemeTokens.current.shapes.smallRadius),
                containerColor = UanThemeTokens.current.colors.surfaceContainer,
                borderColor = UanThemeTokens.current.colors.outlineVariant,
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = null,
                    tint = UanThemeTokens.current.colors.onSurface,
                )
            }
            UanIconButton(
                contentDescription = "Colapsar",
                onClick = {},
                shape = RoundedCornerShape(UanThemeTokens.current.shapes.smallRadius),
                containerColor = UanThemeTokens.current.colors.surfaceContainer,
                borderColor = UanThemeTokens.current.colors.outlineVariant,
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = UanThemeTokens.current.colors.onSurface,
                )
            }
            // Toolbar info
            UanIconButton(
                contentDescription = "Info",
                onClick = {},
                selected = true,
            ) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = null,
                    tint = UanThemeTokens.current.colors.onPrimary,
                    modifier = Modifier.size(20.dp),
                )
            }
            // Search
            UanIconButton(
                contentDescription = "Buscar",
                onClick = {},
                borderColor = UanThemeTokens.current.colors.outline,
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = UanThemeTokens.current.colors.onSurface,
                )
            }
        }
    }
}

@Composable
private fun IconButtonPreviewContainer(
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
