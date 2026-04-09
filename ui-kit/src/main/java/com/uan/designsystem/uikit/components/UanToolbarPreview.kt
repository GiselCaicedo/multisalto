package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "Toolbar - Todos los estados (Figma)",
)
@Composable
private fun GenericToolbarAllStatesPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(tokens.colors.background)
                .padding(tokens.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(tokens.spacing.md),
        ) {
            Text(
                text = "Toolbar",
                style = tokens.typography.component,
                color = tokens.colors.onSurface,
            )
            // Base (ninguno seleccionado)
            Text(
                text = "Sin seleccion",
                style = tokens.typography.supporting,
                color = tokens.colors.muted,
            )
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
            Text(
                text = "Accion seleccionada",
                style = tokens.typography.supporting,
                color = tokens.colors.muted,
            )
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
            Text(
                text = "Info seleccionada",
                style = tokens.typography.supporting,
                color = tokens.colors.muted,
            )
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
            // Deshabilitado
            Text(
                text = "Deshabilitado",
                style = tokens.typography.supporting,
                color = tokens.colors.muted,
            )
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
