package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

/* ═══════════════════════════════════════════════════════════════
 * Preview principal — Grilla 4×5 igual al Figma
 * ═══════════════════════════════════════════════════════════════ */

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "Buttons - Grilla (Figma)",
    widthDp = 600,
)
@Composable
private fun GenericButtonGridPreview() {
    val styles = listOf(
        UanButtonStyle.Secondary,
        UanButtonStyle.Primary,
        UanButtonStyle.Danger,
        UanButtonStyle.Success,
    )
    val sizes = listOf(
        UanButtonSize.XSmall,
        UanButtonSize.Compact,
        UanButtonSize.Regular,
        UanButtonSize.Large,
        UanButtonSize.XLarge,
    )
    ButtonPreviewContainer {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            sizes.forEach { size ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    styles.forEach { style ->
                        UanButton(
                            text = "Label",
                            onClick = {},
                            style = style,
                            size = size,
                            modifier = Modifier.weight(1f),
                            fillWidth = true,
                        )
                    }
                }
            }
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 2 — Estilos en lista vertical
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F, name = "Buttons - Estilos")
@Composable
private fun GenericButtonStylesPreview() {
    ButtonPreviewContainer {
        Text(
            text = "Estilos",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            UanButton(
                text = "Primario",
                onClick = {},
                style = UanButtonStyle.Primary,
                leadingIcon = Icons.Default.Check,
                fillWidth = true,
            )
            UanButton(
                text = "Secundario",
                onClick = {},
                style = UanButtonStyle.Secondary,
                leadingIcon = Icons.Default.Check,
                fillWidth = true,
            )
            UanButton(
                text = "Ghost",
                onClick = {},
                style = UanButtonStyle.Ghost,
                trailingIcon = Icons.AutoMirrored.Filled.ArrowForward,
                fillWidth = true,
            )
            UanButton(
                text = "Peligro",
                onClick = {},
                style = UanButtonStyle.Danger,
                leadingIcon = Icons.Default.WarningAmber,
                fillWidth = true,
            )
            UanButton(
                text = "Advertencia",
                onClick = {},
                style = UanButtonStyle.Warning,
                fillWidth = true,
            )
            UanButton(
                text = "Critico",
                onClick = {},
                style = UanButtonStyle.Critical,
                fillWidth = true,
            )
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 3 — Estados (normal, cargando, deshabilitado)
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F, name = "Buttons - Estados")
@Composable
private fun GenericButtonStatePreview() {
    ButtonPreviewContainer {
        Text(
            text = "Estados",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            UanButton(
                text = "Normal",
                onClick = {},
                leadingIcon = Icons.Default.Check,
                fillWidth = true,
            )
            UanButton(
                text = "Cargando",
                onClick = {},
                loading = true,
                leadingIcon = Icons.Default.Check,
                fillWidth = true,
            )
            UanButton(
                text = "Deshabilitado",
                onClick = {},
                enabled = false,
                leadingIcon = Icons.Default.Check,
                fillWidth = true,
            )
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 4 — Con iconos leading + trailing
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F, name = "Buttons - Con Iconos")
@Composable
private fun GenericButtonWithIconsPreview() {
    ButtonPreviewContainer {
        Text(
            text = "Con Iconos",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        UanButton(
            text = "Continuar",
            onClick = {},
            fillWidth = true,
            leadingIcon = Icons.Default.Check,
            trailingIcon = Icons.AutoMirrored.Filled.ArrowForward,
        )
    }
}

@Composable
private fun ButtonPreviewContainer(
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
