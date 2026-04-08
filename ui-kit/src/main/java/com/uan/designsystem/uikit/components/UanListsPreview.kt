package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericListPreview() {
    ListsPreviewContainer {
        val tokens = UanThemeTokens.current
        UanLists(
            title = "Elemento 1",
            supportingText = "Texto secundario de ejemplo",
            onClick = {},
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Icono de elemento",
                    tint = tokens.colors.info,
                )
            },
            trailingContent = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Abrir detalle",
                    tint = tokens.colors.onSurface,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericListTonalPreview() {
    ListsPreviewContainer {
        val tokens = UanThemeTokens.current
        UanLists(
            title = "Elemento 2",
            supportingText = "Texto secundario de ejemplo",
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Icono de estado",
                    tint = tokens.colors.success,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericListAlertPreview() {
    ListsPreviewContainer {
        val tokens = UanThemeTokens.current
        UanLists(
            title = "Elemento 3",
            supportingText = "Texto secundario de ejemplo",
            onClick = {},
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.WarningAmber,
                    contentDescription = "Icono de alerta",
                    tint = tokens.colors.critical,
                )
            },
            trailingContent = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Abrir detalle",
                    tint = tokens.colors.onSurface,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericListActionPreview() {
    ListsPreviewContainer {
        val tokens = UanThemeTokens.current
        UanLists(
            title = "Elemento 4",
            supportingText = "Texto secundario de ejemplo",
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Icono de elemento",
                    tint = tokens.colors.warning,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericListDisabledPreview() {
    ListsPreviewContainer {
        UanLists(
            title = "Elemento 5",
            supportingText = "Texto secundario de ejemplo",
            enabled = false,
        )
    }
}

@Composable
private fun ListsPreviewContainer(
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

