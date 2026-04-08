package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanIconButton
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun EvacuacionAppBarPreview() {
    AppBarPreviewContainer {
        val tokens = UanThemeTokens.current
        UanAppBar(
            title = "Titulo",
            subtitle = "Subtitulo",
            navigationIcon = {
                UanIconButton(
                    contentDescription = "Icono de volver",
                    borderColor = tokens.colors.outline,
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Icono de volver",
                        tint = tokens.colors.onSurface,
                    )
                }
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun ParoCardiacoAppBarPreview() {
    AppBarPreviewContainer {
        val tokens = UanThemeTokens.current
        UanAppBar(
            title = "Titulo",
            subtitle = "Subtitulo",
            actions = {
                UanIconButton(
                    contentDescription = "Icono de cerrar",
                    borderColor = tokens.colors.outline,
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Icono de cerrar",
                        tint = tokens.colors.onSurface,
                    )
                }
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun BusquedaAppBarPreview() {
    AppBarPreviewContainer {
        val tokens = UanThemeTokens.current
        UanAppBar(
            title = "Titulo",
            subtitle = "Subtitulo",
            navigationIcon = {
                UanIconButton(
                    contentDescription = "Icono de volver",
                    borderColor = tokens.colors.outline,
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Icono de volver",
                        tint = tokens.colors.onSurface,
                    )
                }
            },
            actions = {
                UanIconButton(
                    contentDescription = "Icono de notificaciones",
                    borderColor = tokens.colors.outline,
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Icono de notificaciones",
                        tint = tokens.colors.onSurface,
                    )
                }
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun PacienteEstableAppBarPreview() {
    AppBarPreviewContainer {
        UanAppBar(
            title = "Titulo",
            subtitle = "Subtitulo",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun RiesgoQuimicoAppBarPreview() {
    AppBarPreviewContainer {
        val tokens = UanThemeTokens.current
        UanAppBar(
            title = "Titulo",
            subtitle = "Subtitulo",
            actions = {
                UanIconButton(
                    contentDescription = "Icono de notificaciones",
                    borderColor = tokens.colors.outline,
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Icono de notificaciones",
                        tint = tokens.colors.onSurface,
                    )
                }
                UanIconButton(
                    contentDescription = "Icono de cerrar",
                    borderColor = tokens.colors.outline,
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Icono de cerrar",
                        tint = tokens.colors.onSurface,
                    )
                }
            },
        )
    }
}

@Composable
private fun AppBarPreviewContainer(
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

