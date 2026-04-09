package com.uan.designsystem.uikit.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

private data class CarouselPreviewCard(val title: String)

private val CarouselSampleItems = listOf(
    CarouselPreviewCard("Elemento 1"),
    CarouselPreviewCard("Elemento 2"),
    CarouselPreviewCard("Elemento 3"),
    CarouselPreviewCard("Elemento 4"),
    CarouselPreviewCard("Elemento 5"),
)

/* ═══════════════════════════════════════════════════════════════
 * Preview — Carousel (Figma)
 * ═══════════════════════════════════════════════════════════════ */

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "Carousel (Figma)",
    widthDp = 380,
)
@Composable
private fun GenericCarouselPreview() {
    UanTheme {
        val tokens = UanThemeTokens.current
        val items = remember { CarouselSampleItems }

        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Carousel",
                style = tokens.typography.component,
                color = tokens.colors.onSurface,
                modifier = Modifier.fillMaxWidth(),
            )

            // Con acciones e indicadores
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                val pagerState = rememberPagerState(initialPage = 0) { items.size }
                UanCarousel(
                    items = items,
                    pagerState = pagerState,
                    tone = UanTone.Neutral,
                    modifier = Modifier.fillMaxWidth(),
                    itemContentDescription = { i, item -> "${item.title}, tarjeta ${i + 1}" },
                    bottomActions = listOf(
                        UanCarouselAction(
                            label = "GUARDAR",
                            contentDescription = "Guardar",
                            onClick = {},
                            leadingContent = {
                                Icon(
                                    imageVector = Icons.Default.Bookmark,
                                    contentDescription = null,
                                    tint = tokens.colors.onSurface,
                                )
                            },
                        ),
                        UanCarouselAction(
                            label = "COMPARTIR",
                            contentDescription = "Compartir",
                            onClick = {},
                            leadingContent = {
                                Icon(
                                    imageVector = Icons.Default.Share,
                                    contentDescription = null,
                                    tint = tokens.colors.onSurface,
                                )
                            },
                        ),
                    ),
                ) { _, _, _ ->
                    ForestPathIllustration()
                }

                // Indicadores de pagina
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    repeat(items.size) { index ->
                        val active = index == pagerState.currentPage
                        Box(
                            modifier = Modifier
                                .size(if (active) 8.dp else 6.dp)
                                .clip(CircleShape)
                                .background(
                                    if (active) tokens.colors.onSurface
                                    else tokens.colors.muted.copy(alpha = 0.35f),
                                ),
                        )
                    }
                }
            }

            // Sin acciones
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = "Sin acciones",
                    style = tokens.typography.supporting,
                    color = tokens.colors.muted,
                    modifier = Modifier.fillMaxWidth(),
                )
                val pagerState2 = rememberPagerState(initialPage = 1) { items.size }
                UanCarousel(
                    items = items,
                    pagerState = pagerState2,
                    tone = UanTone.Neutral,
                    modifier = Modifier.fillMaxWidth(),
                    itemContentDescription = { i, item -> "${item.title}, tarjeta ${i + 1}" },
                ) { _, _, _ ->
                    ForestPathIllustration()
                }
            }

            // Deshabilitado
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = "Deshabilitado",
                    style = tokens.typography.supporting,
                    color = tokens.colors.muted,
                    modifier = Modifier.fillMaxWidth(),
                )
                val pagerState3 = rememberPagerState(initialPage = 0) { items.size }
                UanCarousel(
                    items = items,
                    pagerState = pagerState3,
                    enabled = false,
                    tone = UanTone.Neutral,
                    modifier = Modifier.fillMaxWidth(),
                    itemContentDescription = { i, item -> "${item.title}, no disponible" },
                    bottomActions = listOf(
                        UanCarouselAction(
                            label = "ACCION",
                            contentDescription = "Deshabilitada",
                            onClick = {},
                        ),
                    ),
                ) { _, _, _ ->
                    ForestPathIllustration()
                }
            }
        }
    }
}

/** Ilustracion decorativa que llena el item del carrusel. */
@Composable
private fun ForestPathIllustration() {
    val colors = UanThemeTokens.current.colors
    Canvas(modifier = Modifier.fillMaxSize()) {
        val stroke = 4f
        val w = size.width
        val h = size.height
        val c = colors.onSurface

        fun tree(x: Float, y: Float) {
            drawLine(c, Offset(x, y + 14f), Offset(x, y + 28f), stroke)
            drawLine(c, Offset(x, y), Offset(x - 12f, y + 18f), stroke)
            drawLine(c, Offset(x, y), Offset(x + 12f, y + 18f), stroke)
            drawLine(c, Offset(x, y + 12f), Offset(x - 12f, y + 30f), stroke)
            drawLine(c, Offset(x, y + 12f), Offset(x + 12f, y + 30f), stroke)
        }

        tree(w * 0.25f, h * 0.25f)
        tree(w * 0.4f, h * 0.3f)
        tree(w * 0.68f, h * 0.24f)
        tree(w * 0.78f, h * 0.5f)
        tree(w * 0.18f, h * 0.52f)

        val pts = listOf(
            0.32f to 0.78f, 0.38f to 0.68f, 0.34f to 0.58f,
            0.52f to 0.52f, 0.66f to 0.6f, 0.56f to 0.68f, 0.76f to 0.78f,
        )
        for (i in 0 until pts.size - 1) {
            drawLine(
                c,
                Offset(w * pts[i].first, h * pts[i].second),
                Offset(w * pts[i + 1].first, h * pts[i + 1].second),
                stroke,
            )
        }
    }
}
