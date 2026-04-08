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
private fun GenericTextFieldIdlePreview() {
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
                label = "Campo",
            )
            UanTextField(
                value = "",
                onValueChange = {},
                label = "Campo",
            )
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 2 — Focused with content + floating label
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericTextFieldFocusedPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(tokens.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(tokens.spacing.md),
        ) {
            UanTextField(
                value = "Texto",
                onValueChange = {},
                label = "Campo",
            )
            UanTextField(
                value = "",
                onValueChange = {},
                label = "Campo",
                placeholder = "Escribe un valor",
            )
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 3 — Error state with message and trailing icon
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericTextFieldErrorPreview() {
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
                label = "Campo",
                isError = true,
                errorMessage = "Campo requerido",
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
            )
            UanTextField(
                value = "",
                onValueChange = {},
                label = "Campo",
                isError = true,
                errorMessage = "Campo no completado",
            )
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 4 — Disabled state
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericTextFieldDisabledPreview() {
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

/* ═══════════════════════════════════════════════════════════════
 * Preview 5 — With leading/trailing icons
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericTextFieldIconsPreview() {
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

