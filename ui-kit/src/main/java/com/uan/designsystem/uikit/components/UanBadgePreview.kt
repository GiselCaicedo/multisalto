package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

/* ═══════════════════════════════════════════════════════════════
 * Preview — Badge (Figma)
 * ═══════════════════════════════════════════════════════════════ */

@OptIn(ExperimentalLayoutApi::class)
@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "Badge (Figma)",
    widthDp = 400,
)
@Composable
private fun GenericBadgePreview() {
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
                text = "Badge",
                style = tokens.typography.component,
                color = tokens.colors.onSurface,
            )

            // Solid
            Text(
                text = "Solid",
                style = tokens.typography.supporting,
                color = tokens.colors.muted,
            )
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                UanBadge(
                    text = "ACTIVO",
                    tone = UanTone.Success,
                    emphasis = UanBadgeEmphasis.Solid,
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = tokens.colors.onSuccess,
                        )
                    },
                )
                UanBadge(
                    text = "ALERTA",
                    tone = UanTone.Danger,
                    emphasis = UanBadgeEmphasis.Solid,
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Default.Error,
                            contentDescription = null,
                            tint = tokens.colors.onError,
                        )
                    },
                )
                UanBadge(
                    text = "INFO",
                    tone = UanTone.Info,
                    emphasis = UanBadgeEmphasis.Solid,
                )
            }

            // Tonal
            Text(
                text = "Tonal",
                style = tokens.typography.supporting,
                color = tokens.colors.muted,
            )
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                UanBadge(
                    text = "CONECTADO",
                    tone = UanTone.Success,
                    emphasis = UanBadgeEmphasis.Tonal,
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = tokens.colors.success,
                        )
                    },
                )
                UanBadge(
                    text = "PENDIENTE",
                    tone = UanTone.Warning,
                    emphasis = UanBadgeEmphasis.Tonal,
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Default.WarningAmber,
                            contentDescription = null,
                            tint = tokens.colors.warning,
                        )
                    },
                )
                UanBadge(
                    text = "SIN SENAL",
                    tone = UanTone.Neutral,
                    emphasis = UanBadgeEmphasis.Tonal,
                )
            }

            // Outline
            Text(
                text = "Outline",
                style = tokens.typography.supporting,
                color = tokens.colors.muted,
            )
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                UanBadge(
                    text = "v2.1.0",
                    tone = UanTone.Info,
                    emphasis = UanBadgeEmphasis.Outline,
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = tokens.colors.info,
                        )
                    },
                )
                UanBadge(
                    text = "BETA",
                    tone = UanTone.Neutral,
                    emphasis = UanBadgeEmphasis.Outline,
                )
                UanBadge(
                    text = "GPS",
                    tone = UanTone.Success,
                    emphasis = UanBadgeEmphasis.Outline,
                )
            }

            // Deshabilitado
            Text(
                text = "Deshabilitado",
                style = tokens.typography.supporting,
                color = tokens.colors.muted,
            )
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                UanBadge(
                    text = "SIN DATOS",
                    tone = UanTone.Neutral,
                    emphasis = UanBadgeEmphasis.Solid,
                    enabled = false,
                )
                UanBadge(
                    text = "OFFLINE",
                    tone = UanTone.Neutral,
                    emphasis = UanBadgeEmphasis.Tonal,
                    enabled = false,
                )
                UanBadge(
                    text = "N/A",
                    tone = UanTone.Neutral,
                    emphasis = UanBadgeEmphasis.Outline,
                    enabled = false,
                )
            }
        }
    }
}
