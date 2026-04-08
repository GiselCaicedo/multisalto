package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uan.designsystem.uikit.foundation.UanIconButton
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

/* ═══════════════════════════════════════════════════════════════
 * Preview 1 — Idle / Unfocused (placeholder visible)
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun TextFieldIdlePreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(tokens.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(tokens.spacing.md),
        ) {
            UanTextField(
                value = "",
                onValueChange = {},
                label = "Nombre",
            )
            UanTextField(
                value = "",
                onValueChange = {},
                label = "Apellido",
            )
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 2 — Focused with content + floating label
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun TextFieldFocusedPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(tokens.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(tokens.spacing.md),
        ) {
            UanTextField(
                value = "David Leal",
                onValueChange = {},
                label = "Nombre",
            )
            UanTextField(
                value = "",
                onValueChange = {},
                label = "Nombre",
                placeholder = "Escribe tu nombre",
            )
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 3 — Error state with message and trailing icon
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun TextFieldErrorPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(tokens.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(tokens.spacing.md),
        ) {
            UanTextField(
                value = "",
                onValueChange = {},
                label = "Nombre",
                isError = true,
                errorMessage = "Por favor completa la casilla",
                trailingIcon = {
                    UanIconButton(
                        contentDescription = "Limpiar error",
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
            )
            UanTextField(
                value = "",
                onValueChange = {},
                label = "Nombre",
                isError = true,
                errorMessage = "No Completado",
            )
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 4 — Disabled state
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun TextFieldDisabledPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(tokens.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(tokens.spacing.md),
        ) {
            UanTextField(
                value = "",
                onValueChange = {},
                label = "Nombre",
                enabled = false,
            )
            UanTextField(
                value = "David Leal",
                onValueChange = {},
                label = "Nombre",
                enabled = false,
            )
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 5 — With leading/trailing icons
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun TextFieldWithIconsPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(tokens.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(tokens.spacing.md),
        ) {
            UanTextField(
                value = "",
                onValueChange = {},
                label = "Buscar paciente",
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
                value = "clave123",
                onValueChange = {},
                label = "Contrasena",
                trailingIcon = {
                    UanIconButton(
                        contentDescription = "Mostrar contrasena",
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

