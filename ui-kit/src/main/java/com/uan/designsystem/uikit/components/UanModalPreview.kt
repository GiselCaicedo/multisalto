package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.uan.designsystem.uikit.foundation.UanIconButton
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

/* ═══════════════════════════════════════════════════════════════
 * Preview 1 — Alerta de peligro
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F, name = "Modal - Alerta Peligro")
@Composable
private fun GenericModalDangerPreview() {
    UanTheme {
        UanModalContentPreview(
            title = "Zona de Riesgo",
            body = "Te encuentras cerca de una zona con actividad sismica reciente. Mantente alerta y sigue las indicaciones de emergencia.",
            tone = UanTone.Danger,
            primaryAction = UanModalAction(
                label = "EVACUAR",
                onClick = {},
                style = UanButtonStyle.Danger,
            ),
            secondaryAction = UanModalAction(
                label = "IGNORAR",
                onClick = {},
                style = UanButtonStyle.Secondary,
            ),
        )
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 2 — Confirmacion de exito
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F, name = "Modal - Exito")
@Composable
private fun GenericModalSuccessPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        UanModalContentPreview(
            title = "Ubicacion Segura",
            body = "Has llegado al punto de encuentro. Tu equipo ha sido notificado.",
            tone = UanTone.Success,
            media = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(tokens.grid.touchTarget * 2)
                        .clip(RoundedCornerShape(UanModalDefaults.mediaCornerRadius))
                        .background(tokens.colors.success.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = Icons.Default.Shield,
                        contentDescription = null,
                        tint = tokens.colors.success,
                        modifier = Modifier.size(tokens.iconography.large),
                    )
                }
            },
            primaryAction = UanModalAction(
                label = "CONTINUAR",
                onClick = {},
                style = UanButtonStyle.Primary,
            ),
        )
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 3 — Contenido con media y navegacion
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F, name = "Modal - Contenido")
@Composable
private fun GenericModalContentPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        UanModalContentPreview(
            title = "Protocolo de Emergencia",
            subtitle = "Paso 1 de 3",
            body = "Revisa las instrucciones antes de proceder con la evacuacion del area.",
            tone = UanTone.Neutral,
            showCloseButton = true,
            media = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(tokens.grid.touchTarget * 3)
                        .clip(RoundedCornerShape(UanModalDefaults.mediaCornerRadius))
                        .background(tokens.colors.muted.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = Icons.Default.WarningAmber,
                        contentDescription = null,
                        tint = tokens.colors.muted,
                        modifier = Modifier.size(tokens.iconography.large),
                    )
                }
            },
            navigationAction = {
                UanIconButton(
                    contentDescription = "Volver",
                    onClick = {},
                    borderColor = tokens.colors.outline,
                    shape = RoundedCornerShape(tokens.shapes.smallRadius),
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = tokens.colors.onSurface,
                    )
                }
            },
            secondaryAction = UanModalAction(
                label = "SIGUIENTE",
                onClick = {},
                style = UanButtonStyle.Primary,
            ),
        )
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 4 — Galeria con paginacion
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F, name = "Modal - Galeria")
@Composable
private fun GenericModalCarouselPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        val pageCount = 4
        val pagerState = rememberPagerState(initialPage = 2) { pageCount }

        UanModalContentPreview(
            title = "Evidencias",
            tone = UanTone.Info,
            media = {
                Box(modifier = Modifier.fillMaxWidth()) {
                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(tokens.grid.touchTarget * 3)
                            .clip(RoundedCornerShape(UanModalDefaults.mediaCornerRadius)),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(tokens.colors.muted.copy(alpha = 0.2f)),
                        )
                    }
                }
            },
            navigationAction = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    UanIconButton(
                        contentDescription = "Anterior",
                        onClick = {},
                        borderColor = tokens.colors.outline,
                        shape = RoundedCornerShape(tokens.shapes.smallRadius),
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null,
                            tint = tokens.colors.onSurface,
                        )
                    }
                    Spacer(Modifier.width(tokens.spacing.sm))
                    repeat(pageCount) { index ->
                        val isActive = index == pagerState.currentPage
                        Box(
                            modifier = Modifier
                                .size(
                                    if (isActive) UanModalDefaults.pageIndicatorActiveSize
                                    else UanModalDefaults.pageIndicatorSize,
                                )
                                .clip(CircleShape)
                                .background(
                                    if (isActive) tokens.colors.onSurface
                                    else tokens.colors.muted.copy(alpha = 0.4f),
                                ),
                        )
                        if (index < pageCount - 1) {
                            Spacer(Modifier.width(UanModalDefaults.pageIndicatorSpacing))
                        }
                    }
                    Spacer(Modifier.width(tokens.spacing.sm))
                    UanIconButton(
                        contentDescription = "Siguiente",
                        onClick = {},
                        borderColor = tokens.colors.outline,
                        shape = RoundedCornerShape(tokens.shapes.smallRadius),
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            tint = tokens.colors.onSurface,
                        )
                    }
                }
            },
        )
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 5 — Alerta critica
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F, name = "Modal - Critico")
@Composable
private fun GenericModalCriticalPreview() {
    UanTheme {
        UanModalContentPreview(
            title = "SOS Activado",
            body = "Se ha enviado una senal de emergencia a los servicios de rescate. Mantente en tu ubicacion actual.",
            tone = UanTone.Critical,
            primaryAction = UanModalAction(
                label = "CANCELAR SOS",
                onClick = {},
                style = UanButtonStyle.Critical,
            ),
            secondaryAction = UanModalAction(
                label = "MANTENER",
                onClick = {},
                style = UanButtonStyle.Secondary,
            ),
        )
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 6 — Estado de carga
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F, name = "Modal - Cargando")
@Composable
private fun GenericModalLoadingPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        UanModalContentPreview(
            title = "Enviando ubicacion",
            body = "Transmitiendo coordenadas GPS al equipo de rescate...",
            tone = UanTone.Info,
            media = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(tokens.grid.touchTarget),
                    contentAlignment = Alignment.Center,
                ) {
                    androidx.compose.material3.CircularProgressIndicator(
                        color = tokens.colors.info,
                        strokeWidth = tokens.elevations.level2,
                    )
                }
            },
            primaryAction = UanModalAction(
                label = "ENVIANDO...",
                onClick = {},
                style = UanButtonStyle.Primary,
                loading = true,
            ),
        )
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Helper — renderiza sin Dialog wrapper para previews
 * ═══════════════════════════════════════════════════════════════ */

@Composable
private fun UanModalContentPreview(
    title: String,
    tone: UanTone = UanTone.Neutral,
    subtitle: String? = null,
    body: String? = null,
    showCloseButton: Boolean = false,
    primaryAction: UanModalAction? = null,
    secondaryAction: UanModalAction? = null,
    media: (@Composable () -> Unit)? = null,
    navigationAction: (@Composable () -> Unit)? = null,
) {
    val tokens = UanThemeTokens.current

    Box(
        modifier = Modifier
            .background(tokens.colors.background)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        UanModalContent(
            modifier = Modifier,
            title = title,
            subtitle = subtitle,
            body = body,
            tone = tone,
            showCloseButton = showCloseButton,
            onDismissRequest = {},
            primaryAction = primaryAction,
            secondaryAction = secondaryAction,
            media = media,
            navigationAction = navigationAction,
        )
    }
}
