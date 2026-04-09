package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
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
    name = "Sheet - Expandido (Figma)",
    heightDp = 400,
)
@Composable
private fun GenericSheetExpandedPreview() {
    SheetPreviewContainer {
        Text(
            text = "Expandido",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        Box(modifier = Modifier.height(300.dp).fillMaxWidth()) {
            UanSheet(
                expanded = true,
                onExpandedChange = {},
                tone = UanTone.Info,
                collapsedContent = {
                    UanSheetBody("Texto colapsado.")
                },
            ) {
                UanSheetTitle("Titulo de hoja")
                UanSheetBody("Texto de ejemplo para validar el contenido expandido de la hoja.")
                PreviewPanel(height = 80.dp)
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "Sheet - Colapsado",
    heightDp = 200,
)
@Composable
private fun GenericSheetCollapsedPreview() {
    SheetPreviewContainer {
        Text(
            text = "Colapsado",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        Box(modifier = Modifier.height(120.dp).fillMaxWidth()) {
            UanSheet(
                expanded = false,
                onExpandedChange = {},
                tone = UanTone.Neutral,
                collapsedContent = {
                    PreviewPanel(height = 20.dp)
                },
            ) {
                UanSheetTitle("Titulo de hoja")
                UanSheetBody("Contenido expandido.")
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "Sheet - Tonos",
    heightDp = 500,
)
@Composable
private fun GenericSheetTonesPreview() {
    SheetPreviewContainer {
        Text(
            text = "Tonos",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        // Warning
        Box(modifier = Modifier.height(180.dp).fillMaxWidth()) {
            UanSheet(
                expanded = true,
                onExpandedChange = {},
                tone = UanTone.Warning,
            ) {
                UanSheetTitle("Advertencia")
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.WarningAmber,
                        contentDescription = null,
                        tint = UanThemeTokens.current.colors.warning,
                        modifier = Modifier.size(24.dp),
                    )
                    UanSheetBody("Revise la configuracion del dispositivo.")
                }
            }
        }
        // Success
        Box(modifier = Modifier.height(180.dp).fillMaxWidth()) {
            UanSheet(
                expanded = true,
                onExpandedChange = {},
                tone = UanTone.Success,
            ) {
                UanSheetTitle("Operacion exitosa")
                UanSheetBody("Los datos fueron guardados correctamente.")
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "Sheet - Deshabilitado",
    heightDp = 200,
)
@Composable
private fun GenericSheetDisabledPreview() {
    SheetPreviewContainer {
        Text(
            text = "Deshabilitado",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        Box(modifier = Modifier.height(120.dp).fillMaxWidth()) {
            UanSheet(
                expanded = false,
                onExpandedChange = {},
                enabled = false,
                tone = UanTone.Critical,
                collapsedContent = {
                    PreviewPanel(height = 16.dp)
                },
            ) {
                UanSheetTitle("Titulo")
                UanSheetBody("Contenido.")
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "SheetTitle y SheetBody",
)
@Composable
private fun GenericSheetTitleBodyPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(tokens.colors.surfaceContainer)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            UanSheetTitle("Titulo de ejemplo")
            UanSheetBody("Este es el texto del body de la hoja. Puede contener varias lineas de informacion complementaria para el usuario.")
            UanSheetTitle("Otro titulo")
            UanSheetBody("Texto secundario breve.")
        }
    }
}

@Composable
private fun SheetPreviewContainer(
    content: @Composable () -> Unit,
) {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(24.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            content()
        }
    }
}

@Composable
private fun PreviewPanel(
    height: androidx.compose.ui.unit.Dp,
) {
    val colors = UanThemeTokens.current.colors
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .background(colors.background)
            .padding(1.dp),
    )
}
