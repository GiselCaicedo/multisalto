package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness2
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.NotificationsOff
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
private fun VisionNocturnaActivaPreview() {
    SwitchPreviewContainer {
        UanSwitch(
            checked = true,
            onCheckedChange = {},
            tone = UanTone.Info,
            checkedContentDescription = "Vision nocturna activada",
            uncheckedContentDescription = "Vision nocturna desactivada",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun IluminacionManualDesactivadaPreview() {
    SwitchPreviewContainer {
        UanSwitch(
            checked = false,
            onCheckedChange = {},
            tone = UanTone.Info,
            checkedContentDescription = "Iluminacion manual activada",
            uncheckedContentDescription = "Iluminacion manual desactivada",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun AlertaQuimicaCriticaPreview() {
    SwitchPreviewContainer {
        val tokens = UanThemeTokens.current
        UanSwitch(
            checked = true,
            onCheckedChange = {},
            tone = UanTone.Critical,
            checkedContentDescription = "Alerta quimica activa",
            uncheckedContentDescription = "Alerta quimica inactiva",
            checkedContent = {
                Icon(
                    imageVector = Icons.Default.WarningAmber,
                    contentDescription = "Alerta critica",
                    tint = tokens.colors.critical,
                )
            },
            uncheckedContent = {
                Icon(
                    imageVector = Icons.Default.WarningAmber,
                    contentDescription = "Alerta critica inactiva",
                    tint = tokens.colors.muted,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun RadioOperativaActivaPreview() {
    SwitchPreviewContainer {
        val tokens = UanThemeTokens.current
        UanSwitch(
            checked = true,
            onCheckedChange = {},
            tone = UanTone.Success,
            checkedContentDescription = "Radio operativa activada",
            uncheckedContentDescription = "Radio operativa desactivada",
            checkedContent = {
                Icon(
                    imageVector = Icons.Default.NotificationsActive,
                    contentDescription = "Radio activa",
                    tint = tokens.colors.success,
                )
            },
            uncheckedContent = {
                Icon(
                    imageVector = Icons.Default.NotificationsOff,
                    contentDescription = "Radio inactiva",
                    tint = tokens.colors.muted,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun SensorDeshabilitadoPreview() {
    SwitchPreviewContainer {
        val tokens = UanThemeTokens.current
        UanSwitch(
            checked = false,
            onCheckedChange = {},
            enabled = false,
            tone = UanTone.Warning,
            checkedContentDescription = "Sensor secundario activado",
            uncheckedContentDescription = "Sensor secundario desactivado",
            checkedContent = {
                Icon(
                    imageVector = Icons.Default.Brightness2,
                    contentDescription = "Sensor activo",
                    tint = tokens.colors.warning,
                )
            },
            uncheckedContent = {
                Icon(
                    imageVector = Icons.Default.LightMode,
                    contentDescription = "Sensor inactivo",
                    tint = tokens.colors.muted,
                )
            },
        )
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
                .background(tokens.colors.background)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            content()
        }
    }
}

