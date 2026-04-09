package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uan.designsystem.uikit.foundation.UanIconButton
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "TextField - Estados (Figma)",
    widthDp = 400,
)
@Composable
private fun GenericTextFieldAllStatesPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(tokens.colors.background)
                .padding(tokens.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(tokens.spacing.lg),
        ) {
            Text(
                text = "Campos de Texto",
                style = tokens.typography.component,
                color = tokens.colors.onSurface,
            )

            // Fila 1: Idle (ancho y estrecho como en Figma)
            Text(
                text = "Idle",
                style = tokens.typography.supporting,
                color = tokens.colors.muted,
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(tokens.spacing.md),
                modifier = Modifier.fillMaxWidth(),
            ) {
                UanTextField(
                    value = "",
                    onValueChange = {},
                    label = "Nombre",
                    modifier = Modifier.weight(1.5f),
                )
                UanTextField(
                    value = "",
                    onValueChange = {},
                    label = "Nombre",
                    modifier = Modifier.weight(1f),
                )
            }

            // Fila 2: Diferentes tamanos
            Row(
                horizontalArrangement = Arrangement.spacedBy(tokens.spacing.md),
                modifier = Modifier.fillMaxWidth(),
            ) {
                UanTextField(
                    value = "",
                    onValueChange = {},
                    label = "Nombre",
                    modifier = Modifier.weight(1.5f),
                )
                UanTextField(
                    value = "",
                    onValueChange = {},
                    label = "Nombre",
                    modifier = Modifier.weight(1f),
                )
            }

            // Fila 3: Focused con contenido
            Text(
                text = "Enfocado / Con contenido",
                style = tokens.typography.supporting,
                color = tokens.colors.muted,
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(tokens.spacing.md),
                modifier = Modifier.fillMaxWidth(),
            ) {
                UanTextField(
                    value = "David Leal",
                    onValueChange = {},
                    label = "Nombre",
                    modifier = Modifier.weight(1.5f),
                )
                UanTextField(
                    value = "",
                    onValueChange = {},
                    label = "Nombre",
                    placeholder = "Escribe un valor",
                    modifier = Modifier.weight(1f),
                )
            }

            // Fila 4: Error
            Text(
                text = "Error",
                style = tokens.typography.supporting,
                color = tokens.colors.muted,
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(tokens.spacing.md),
                modifier = Modifier.fillMaxWidth(),
            ) {
                UanTextField(
                    value = "",
                    onValueChange = {},
                    label = "Campo",
                    isError = true,
                    errorMessage = "Por favor completa la casilla",
                    trailingIcon = {
                        UanIconButton(
                            contentDescription = "Limpiar campo",
                            onClick = {},
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null,
                                tint = tokens.colors.error,
                                modifier = Modifier.size(UanTextFieldDefaults.iconSize),
                            )
                        }
                    },
                    modifier = Modifier.weight(1.5f),
                )
                UanTextField(
                    value = "",
                    onValueChange = {},
                    label = "Campo",
                    isError = true,
                    errorMessage = "No Completado",
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "TextField - Deshabilitado",
)
@Composable
private fun GenericTextFieldDisabledPreview() {
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
                text = "Deshabilitado",
                style = tokens.typography.component,
                color = tokens.colors.onSurface,
            )
            UanTextField(
                value = "",
                onValueChange = {},
                label = "Campo",
                enabled = false,
            )
            UanTextField(
                value = "Texto",
                onValueChange = {},
                label = "Campo",
                enabled = false,
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "TextField - Con Iconos",
)
@Composable
private fun GenericTextFieldIconsPreview() {
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
                text = "Con Iconos",
                style = tokens.typography.component,
                color = tokens.colors.onSurface,
            )
            UanTextField(
                value = "",
                onValueChange = {},
                label = "Buscar",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = tokens.colors.muted,
                        modifier = Modifier.size(UanTextFieldDefaults.iconSize),
                    )
                },
            )
            UanTextField(
                value = "texto123",
                onValueChange = {},
                label = "Campo",
                trailingIcon = {
                    UanIconButton(
                        contentDescription = "Mostrar valor",
                        onClick = {},
                    ) {
                        Icon(
                            imageVector = Icons.Default.Visibility,
                            contentDescription = null,
                            tint = tokens.colors.muted,
                            modifier = Modifier.size(UanTextFieldDefaults.iconSize),
                        )
                    }
                },
            )
        }
    }
}
