package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericCardPreview() {
    CardPreviewContainer {
        UanCard(
            title = "Tarjeta informativa",
            body = "Texto de ejemplo para revisar la composicion, el espaciado y la jerarquia.",
            tone = UanTone.Success,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericCardWithFooterPreview() {
    CardPreviewContainer {
        UanCard(
            title = "Tarjeta con etiqueta",
            body = "Ejemplo de contenido secundario con un estado visible y un footer opcional.",
            tone = UanTone.Info,
            footer = {
                UanBadge(
                    text = "ACTIVA",
                    tone = UanTone.Info,
                    emphasis = UanBadgeEmphasis.Tonal,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericCardAlertPreview() {
    CardPreviewContainer {
        val tokens = UanThemeTokens.current
        UanCard(
            title = "Tarjeta de alerta",
            body = "Ejemplo de una tarjeta destacada con contenido preventivo.",
            tone = UanTone.Critical,
            supportingContent = {
                Icon(
                    imageVector = Icons.Default.WarningAmber,
                    contentDescription = "Icono de alerta",
                    tint = tokens.colors.critical,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericCardChecklistPreview() {
    CardPreviewContainer {
        val tokens = UanThemeTokens.current
        UanCard(
            title = "Tarjeta de checklist",
            body = "Ejemplo de tarjeta con icono de confirmacion y cuerpo de texto.",
            tone = UanTone.Neutral,
            supportingContent = {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Icono de confirmacion",
                    tint = tokens.colors.success,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericCardDisabledPreview() {
    CardPreviewContainer {
        UanCard(
            title = "Tarjeta deshabilitada",
            body = "Estado inactivo para validar contraste, opacidad y legibilidad.",
            enabled = false,
            tone = UanTone.Warning,
        )
    }
}

@Composable
private fun CardPreviewContainer(
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

