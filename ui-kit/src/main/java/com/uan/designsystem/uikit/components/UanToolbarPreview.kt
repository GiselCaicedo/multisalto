package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

/* ═══════════════════════════════════════════════════════════════
 * Preview 1 — Ninguno seleccionado
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun ToolbarNoneSelectedPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(tokens.spacing.lg),
        ) {
            UanToolbar(
                selectedIndex = -1,
                onItemSelected = {},
                startContentDescription = "Informacion",
                endContentDescription = "SOS",
                startContent = {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = null,
                        tint = tokens.colors.muted,
                        modifier = Modifier.size(UanToolbarDefaults.iconSize),
                    )
                },
                endContent = {
                    Text(
                        text = "SOS",
                        color = tokens.colors.muted,
                        style = tokens.typography.distance,
                    )
                },
            )
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 2 — SOS seleccionado (item fin)
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun ToolbarEndSelectedPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(tokens.spacing.lg),
        ) {
            UanToolbar(
                selectedIndex = 1,
                onItemSelected = {},
                startContentDescription = "Informacion",
                endContentDescription = "SOS",
                startContent = {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = null,
                        tint = tokens.colors.muted,
                        modifier = Modifier.size(UanToolbarDefaults.iconSize),
                    )
                },
                endContent = {
                    Text(
                        text = "SOS",
                        color = tokens.colors.onPrimary,
                        style = tokens.typography.distance,
                    )
                },
            )
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 3 — Info seleccionado (item inicio)
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun ToolbarStartSelectedPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(tokens.spacing.lg),
        ) {
            UanToolbar(
                selectedIndex = 0,
                onItemSelected = {},
                startContentDescription = "Informacion",
                endContentDescription = "SOS",
                startContent = {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = null,
                        tint = tokens.colors.onPrimary,
                        modifier = Modifier.size(UanToolbarDefaults.iconSize),
                    )
                },
                endContent = {
                    Text(
                        text = "SOS",
                        color = tokens.colors.muted,
                        style = tokens.typography.distance,
                    )
                },
            )
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 4 — Disabled
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun ToolbarDisabledPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(tokens.spacing.lg),
        ) {
            UanToolbar(
                selectedIndex = 0,
                onItemSelected = {},
                enabled = false,
                startContentDescription = "Informacion",
                endContentDescription = "SOS",
                startContent = {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = null,
                        tint = tokens.colors.onPrimary,
                        modifier = Modifier.size(UanToolbarDefaults.iconSize),
                    )
                },
                endContent = {
                    Text(
                        text = "SOS",
                        color = tokens.colors.muted,
                        style = tokens.typography.distance,
                    )
                },
            )
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 5 — Todos los estados en columna
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun ToolbarAllStatesPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(tokens.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(tokens.spacing.md),
        ) {
            // Ninguno
            UanToolbar(
                selectedIndex = -1,
                onItemSelected = {},
                startContentDescription = "Informacion",
                endContentDescription = "SOS",
                startContent = {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = null,
                        tint = tokens.colors.muted,
                        modifier = Modifier.size(UanToolbarDefaults.iconSize),
                    )
                },
                endContent = {
                    Text(
                        text = "SOS",
                        color = tokens.colors.muted,
                        style = tokens.typography.distance,
                    )
                },
            )
            // SOS seleccionado
            UanToolbar(
                selectedIndex = 1,
                onItemSelected = {},
                startContentDescription = "Informacion",
                endContentDescription = "SOS",
                startContent = {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = null,
                        tint = tokens.colors.muted,
                        modifier = Modifier.size(UanToolbarDefaults.iconSize),
                    )
                },
                endContent = {
                    Text(
                        text = "SOS",
                        color = tokens.colors.onPrimary,
                        style = tokens.typography.distance,
                    )
                },
            )
            // Info seleccionado
            UanToolbar(
                selectedIndex = 0,
                onItemSelected = {},
                startContentDescription = "Informacion",
                endContentDescription = "SOS",
                startContent = {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = null,
                        tint = tokens.colors.onPrimary,
                        modifier = Modifier.size(UanToolbarDefaults.iconSize),
                    )
                },
                endContent = {
                    Text(
                        text = "SOS",
                        color = tokens.colors.muted,
                        style = tokens.typography.distance,
                    )
                },
            )
        }
    }
}

