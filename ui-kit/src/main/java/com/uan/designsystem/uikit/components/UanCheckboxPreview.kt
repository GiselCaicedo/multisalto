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
private fun GenericCheckboxUncheckedPreview() {
    CheckboxPreviewContainer {
        UanCheckbox(
            state = UanCheckboxState.Unchecked,
            onStateChange = {},
            tone = UanTone.Neutral,
            checkedContentDescription = "Opcion verificada",
            uncheckedContentDescription = "Opcion pendiente",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericCheckboxSecondaryUncheckedPreview() {
    CheckboxPreviewContainer {
        UanCheckbox(
            state = UanCheckboxState.Unchecked,
            onStateChange = {},
            tone = UanTone.Info,
            checkedContentDescription = "Opcion verificada",
            uncheckedContentDescription = "Opcion pendiente",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericCheckboxCheckedPreview() {
    CheckboxPreviewContainer {
        val tokens = UanThemeTokens.current
        UanCheckbox(
            state = UanCheckboxState.Checked,
            onStateChange = {},
            tone = UanTone.Info,
            checkedContentDescription = "Opcion seleccionada",
            uncheckedContentDescription = "Opcion sin seleccionar",
            checkedContent = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Icono de seleccion",
                    tint = tokens.colors.onInfo,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericCheckboxIndeterminatePreview() {
    CheckboxPreviewContainer {
        val tokens = UanThemeTokens.current
        UanCheckbox(
            state = UanCheckboxState.Indeterminate,
            onStateChange = {},
            tone = UanTone.Warning,
            checkedContentDescription = "Opcion seleccionada",
            uncheckedContentDescription = "Opcion sin seleccionar",
            indeterminateContentDescription = "Estado intermedio",
            indeterminateContent = {
                Icon(
                    imageVector = Icons.Default.Remove,
                    contentDescription = "Icono de estado intermedio",
                    tint = tokens.colors.onWarning,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericCheckboxDisabledPreview() {
    CheckboxPreviewContainer {
        val tokens = UanThemeTokens.current
        UanCheckbox(
            state = UanCheckboxState.Checked,
            onStateChange = {},
            enabled = false,
            tone = UanTone.Critical,
            checkedContentDescription = "Opcion seleccionada",
            uncheckedContentDescription = "Opcion sin seleccionar",
            checkedContent = {
                Icon(
                    imageVector = Icons.Default.PriorityHigh,
                    contentDescription = "Icono de seleccion",
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

