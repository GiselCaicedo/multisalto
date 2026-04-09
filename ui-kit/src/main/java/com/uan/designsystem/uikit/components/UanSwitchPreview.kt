package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness2
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.NotificationsOff
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "Switch - On / Off (Figma)",
)
@Composable
private fun GenericSwitchOnOffPreview() {
    SwitchPreviewContainer {
        Text(
            text = "Switch (Figma)",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                UanSwitch(
                    checked = true,
                    onCheckedChange = {},
                    tone = UanTone.Info,
                )
                UanSwitch(
                    checked = false,
                    onCheckedChange = {},
                    tone = UanTone.Info,
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "Switch - Tonos",
)
@Composable
private fun GenericSwitchTonesPreview() {
    SwitchPreviewContainer {
        Text(
            text = "Tonos",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val tokens = UanThemeTokens.current
            // Critical
            UanSwitch(
                checked = true,
                onCheckedChange = {},
                tone = UanTone.Critical,
                checkedContent = {
                    Icon(
                        imageVector = Icons.Default.WarningAmber,
                        contentDescription = null,
                        tint = tokens.colors.critical,
                    )
                },
                uncheckedContent = {
                    Icon(
                        imageVector = Icons.Default.WarningAmber,
                        contentDescription = null,
                        tint = tokens.colors.muted,
                    )
                },
            )
            // Success
            UanSwitch(
                checked = true,
                onCheckedChange = {},
                tone = UanTone.Success,
                checkedContent = {
                    Icon(
                        imageVector = Icons.Default.NotificationsActive,
                        contentDescription = null,
                        tint = tokens.colors.success,
                    )
                },
                uncheckedContent = {
                    Icon(
                        imageVector = Icons.Default.NotificationsOff,
                        contentDescription = null,
                        tint = tokens.colors.muted,
                    )
                },
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "Switch - Deshabilitado",
)
@Composable
private fun GenericSwitchDisabledPreview() {
    SwitchPreviewContainer {
        Text(
            text = "Deshabilitado",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            UanSwitch(
                checked = false,
                onCheckedChange = {},
                enabled = false,
                tone = UanTone.Warning,
            )
            UanSwitch(
                checked = true,
                onCheckedChange = {},
                enabled = false,
                tone = UanTone.Info,
            )
        }
    }
}

@Composable
private fun SwitchPreviewContainer(
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
