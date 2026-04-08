package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
private fun RutaSeguraBadgePreview() {
    BadgePreviewContainer {
        UanBadge(
            text = "RUTA SEGURA",
            tone = UanTone.Success,
            emphasis = UanBadgeEmphasis.Solid,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun PacienteMonitorizadoBadgePreview() {
    BadgePreviewContainer {
        val tokens = UanThemeTokens.current
        UanBadge(
            text = "MONITOREO",
            tone = UanTone.Info,
            emphasis = UanBadgeEmphasis.Tonal,
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Monitoreo activo",
                    tint = tokens.colors.info,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun EvacuacionPendienteBadgePreview() {
    BadgePreviewContainer {
        UanBadge(
            text = "PENDIENTE",
            tone = UanTone.Warning,
            emphasis = UanBadgeEmphasis.Outline,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun RiesgoQuimicoBadgePreview() {
    BadgePreviewContainer {
        val tokens = UanThemeTokens.current
        UanBadge(
            text = "RIESGO QUIMICO",
            tone = UanTone.Critical,
            emphasis = UanBadgeEmphasis.Solid,
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.WarningAmber,
                    contentDescription = "Riesgo quimico",
                    tint = tokens.colors.onCritical,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun ConexionCaidaBadgePreview() {
    BadgePreviewContainer {
        UanBadge(
            text = "SIN RED",
            enabled = false,
            tone = UanTone.Danger,
            emphasis = UanBadgeEmphasis.Tonal,
        )
    }
}

@Composable
private fun BadgePreviewContainer(
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

