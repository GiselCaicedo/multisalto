package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
 * Preview 1 — Alert Modal (Danger tone)
 * Escenario: Ejemplo de alerta.
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun AlertDangerModalPreview() {
    UanTheme {
        UanModalContentPreview(
            title = "Titulo",
            body = "Texto de ejemplo para validar el modal y sus acciones.",
            tone = UanTone.Danger,
            primaryAction = UanModalAction(
                label = "ACCION 1",
                onClick = {},
                style = UanButtonStyle.Danger,
            ),
            secondaryAction = UanModalAction(
                label = "ACCION 2",
                onClick = {},
                style = UanButtonStyle.Secondary,
            ),
        )
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 2 — Alert Modal (Success tone)
 * Escenario: Ejemplo de confirmacion.
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun AlertSuccessModalPreview() {
    UanTheme {
        UanModalContentPreview(
            title = "Titulo",
            body = "Texto de ejemplo para validar el modal y sus acciones.",
            tone = UanTone.Success,
            primaryAction = UanModalAction(
                label = "CONTINUAR",
                onClick = {},
                style = UanButtonStyle.Primary,
            ),
            secondaryAction = UanModalAction(
                label = "DETALLES",
                onClick = {},
                style = UanButtonStyle.Secondary,
            ),
        )
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 3 — Content Modal with close button, media & navigation
 * Escenario: Contenido con media y navegacion.
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun ContentModalWithDismissPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        UanModalContentPreview(
            title = "Titulo",
            subtitle = "Subtitulo",
            body = "Texto de ejemplo con subtitulo y contenido principal.",
            tone = UanTone.Neutral,
            showCloseButton = true,
            media = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(tokens.grid.touchTarget * 3 + tokens.spacing.md)
                        .clip(RoundedCornerShape(UanModalDefaults.mediaCornerRadius))
                        .background(tokens.colors.muted.copy(alpha = 0.3f)),
                )
            },
            navigationAction = {
                UanIconButton(
                    contentDescription = "Icono de volver",
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
                label = "ACCION",
                onClick = {},
                style = UanButtonStyle.Secondary,
            ),
        )
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 4 — Media Carousel Modal
 * Escenario: Galeria de contenido.
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun MediaCarouselModalPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        val pageCount = 4
        val pagerState = rememberPagerState(initialPage = 2) { pageCount }

        UanModalContentPreview(
            title = "Titulo",
            tone = UanTone.Neutral,
            media = {
                Box(modifier = Modifier.fillMaxWidth()) {
                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(tokens.grid.touchTarget * 3 + tokens.spacing.xl)
                            .clip(
                                RoundedCornerShape(UanModalDefaults.mediaCornerRadius),
                            ),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(tokens.colors.muted.copy(alpha = 0.3f)),
                        )
                    }
                }
            },
            navigationAction = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    UanIconButton(
                        contentDescription = "Pagina anterior",
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
                    // Indicadores de pagina
                    repeat(pageCount) { index ->
                        val isActive = index == pagerState.currentPage
                        Box(
                            modifier = Modifier
                                .size(
                                    if (isActive) {
                                        UanModalDefaults.pageIndicatorActiveSize
                                    } else {
                                        UanModalDefaults.pageIndicatorSize
                                    },
                                )
                                .clip(CircleShape)
                                .background(
                                    if (isActive) {
                                        tokens.colors.onSurface
                                    } else {
                                        tokens.colors.muted.copy(alpha = 0.5f)
                                    },
                                ),
                        )
                        if (index < pageCount - 1) {
                            Spacer(
                                Modifier.width(UanModalDefaults.pageIndicatorSpacing),
                            )
                        }
                    }
                    Spacer(Modifier.width(tokens.spacing.sm))
                    UanIconButton(
                        contentDescription = "Pagina siguiente",
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
 * Preview 5 — Critical Alert (full urgency)
 * Escenario: Alerta de prioridad alta.
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun CriticalAlertModalPreview() {
    UanTheme {
        UanModalContentPreview(
            title = "Titulo",
            body = "Texto de ejemplo para validar una alerta critica.",
            tone = UanTone.Critical,
            primaryAction = UanModalAction(
                label = "ACCION 1",
                onClick = {},
                style = UanButtonStyle.Critical,
            ),
            secondaryAction = UanModalAction(
                label = "ACCION 2",
                onClick = {},
                style = UanButtonStyle.Danger,
            ),
        )
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 6 — Disabled actions state
 * Escenario: Modal con acciones deshabilitadas.
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun DisabledActionsModalPreview() {
    UanTheme {
        UanModalContentPreview(
            title = "Confirmar accion",
            body = "Debe aceptar los terminos antes de continuar.",
            tone = UanTone.Warning,
            primaryAction = UanModalAction(
                label = "ACEPTAR",
                onClick = {},
                style = UanButtonStyle.Primary,
                enabled = false,
            ),
            secondaryAction = UanModalAction(
                label = "CANCELAR",
                onClick = {},
                style = UanButtonStyle.Secondary,
            ),
        )
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 7 — Loading action state
 * Escenario: Accion primaria en estado de carga.
 * ═══════════════════════════════════════════════════════════════ */

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun LoadingActionModalPreview() {
    UanTheme {
        UanModalContentPreview(
            title = "Cargando",
            body = "Texto de ejemplo mientras se procesa la accion.",
            tone = UanTone.Info,
            primaryAction = UanModalAction(
                label = "CARGANDO",
                onClick = {},
                style = UanButtonStyle.Primary,
                loading = true,
            ),
            secondaryAction = UanModalAction(
                label = "CANCELAR",
                onClick = {},
                style = UanButtonStyle.Secondary,
            ),
        )
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Helper — renderiza el contenido del modal sin el Dialog wrapper
 * para que las previews de Android Studio funcionen correctamente.
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

