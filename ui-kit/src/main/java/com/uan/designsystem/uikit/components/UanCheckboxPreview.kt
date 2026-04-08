package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.PriorityHigh
import androidx.compose.material.icons.filled.Remove
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
private fun RutaVerificadaUncheckedPreview() {
    CheckboxPreviewContainer {
        UanCheckbox(
            state = UanCheckboxState.Unchecked,
            onStateChange = {},
            tone = UanTone.Neutral,
            checkedContentDescription = "Ruta verificada",
            uncheckedContentDescription = "Ruta pendiente de verificar",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun BotiquinInspeccionUncheckedPreview() {
    CheckboxPreviewContainer {
        UanCheckbox(
            state = UanCheckboxState.Unchecked,
            onStateChange = {},
            tone = UanTone.Info,
            checkedContentDescription = "Botiquin inspeccionado",
            uncheckedContentDescription = "Botiquin sin inspeccionar",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun EvacuacionConfirmadaCheckedPreview() {
    CheckboxPreviewContainer {
        val tokens = UanThemeTokens.current
        UanCheckbox(
            state = UanCheckboxState.Checked,
            onStateChange = {},
            tone = UanTone.Info,
            checkedContentDescription = "Evacuacion confirmada",
            uncheckedContentDescription = "Evacuacion no confirmada",
            checkedContent = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Evacuacion confirmada",
                    tint = tokens.colors.onInfo,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun TriageParcialIndeterminatePreview() {
    CheckboxPreviewContainer {
        val tokens = UanThemeTokens.current
        UanCheckbox(
            state = UanCheckboxState.Indeterminate,
            onStateChange = {},
            tone = UanTone.Warning,
            checkedContentDescription = "Triage completo",
            uncheckedContentDescription = "Triage pendiente",
            indeterminateContentDescription = "Triage parcial",
            indeterminateContent = {
                Icon(
                    imageVector = Icons.Default.Remove,
                    contentDescription = "Triage parcial",
                    tint = tokens.colors.onWarning,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun PeligroElectricoCriticoPreview() {
    CheckboxPreviewContainer {
        val tokens = UanThemeTokens.current
        UanCheckbox(
            state = UanCheckboxState.Checked,
            onStateChange = {},
            enabled = false,
            tone = UanTone.Critical,
            checkedContentDescription = "Peligro electrico confirmado",
            uncheckedContentDescription = "Peligro electrico no confirmado",
            checkedContent = {
                Icon(
                    imageVector = Icons.Default.PriorityHigh,
                    contentDescription = "Peligro electrico",
                    tint = tokens.colors.onCritical,
                )
            },
        )
    }
}

@Composable
private fun CheckboxPreviewContainer(
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

