package com.uan.designsystem.uikit.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

private data class CarouselPreviewCard(
    val title: String,
)

private val CarouselSampleItems = listOf(
    CarouselPreviewCard("Elemento 1"),
    CarouselPreviewCard("Elemento 2"),
    CarouselPreviewCard("Elemento 3"),
)

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericCarouselActionsPreview() {
    CarouselPreviewContainer {
        val items = remember { CarouselSampleItems }
        val pagerState = rememberPagerState(initialPage = 0) { items.size }
        UanCarousel(
            items = items,
            pagerState = pagerState,
            tone = UanTone.Neutral,
            itemContentDescription = { index, item -> "${item.title}, tarjeta ${index + 1}" },
            bottomActions = listOf(
                UanCarouselAction(
                    label = "ACCION",
                    contentDescription = "Ver detalle",
                    onClick = {},
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Default.WbSunny,
                            contentDescription = "Icono decorativo",
                            tint = UanThemeTokens.current.colors.onSurface,
                        )
                    },
                ),
                UanCarouselAction(
                    label = "ACCION",
                    contentDescription = "Abrir vista",
                    onClick = {},
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Default.WbSunny,
                            contentDescription = "Icono decorativo",
                            tint = UanThemeTokens.current.colors.onSurface,
                        )
                    },
                ),
            ),
        ) { _, _, _ ->
            ForestPathIllustration()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericCarouselPagerPreview() {
    CarouselPreviewContainer {
        val items = remember { CarouselSampleItems }
        val pagerState = rememberPagerState(initialPage = 1) { items.size }
        UanCarousel(
            items = items,
            pagerState = pagerState,
            tone = UanTone.Info,
            itemContentDescription = { index, item -> "${item.title}, referencia ${index + 1}" },
        ) { _, _, _ ->
            ForestPathIllustration()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericCarouselConfirmationPreview() {
    CarouselPreviewContainer {
        val items = remember { CarouselSampleItems }
        val pagerState = rememberPagerState(initialPage = 2) { items.size }
        UanCarousel(
            items = items,
            pagerState = pagerState,
            tone = UanTone.Success,
            itemContentDescription = { index, item -> "${item.title}, confirmada ${index + 1}" },
            bottomActions = listOf(
                UanCarouselAction(
                    label = "ACCION",
                    contentDescription = "Confirmar",
                    onClick = {},
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Default.WbSunny,
                            contentDescription = "Icono decorativo",
                            tint = UanThemeTokens.current.colors.onSurface,
                        )
                    },
                ),
            ),
        ) { _, _, _ ->
            ForestPathIllustration()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericCarouselAlertPreview() {
    CarouselPreviewContainer {
        val items = remember { CarouselSampleItems }
        val pagerState = rememberPagerState(initialPage = 0) { items.size }
        UanCarousel(
            items = items,
            pagerState = pagerState,
            tone = UanTone.Warning,
            itemContentDescription = { index, item -> "${item.title}, alerta ${index + 1}" },
            bottomActions = listOf(
                UanCarouselAction(
                    label = "ACCION",
                    contentDescription = "Mostrar alerta",
                    onClick = {},
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Default.WbSunny,
                            contentDescription = "Icono decorativo",
                            tint = UanThemeTokens.current.colors.onSurface,
                        )
                    },
                ),
            ),
        ) { _, _, _ ->
            ForestPathIllustration()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericCarouselDisabledPreview() {
    CarouselPreviewContainer {
        val items = remember { CarouselSampleItems }
        val pagerState = rememberPagerState(initialPage = 0) { items.size }
        UanCarousel(
            items = items,
            pagerState = pagerState,
            enabled = false,
            tone = UanTone.Critical,
            itemContentDescription = { index, item -> "${item.title}, no disponible ${index + 1}" },
            bottomActions = listOf(
                UanCarouselAction(
                    label = "ACCION",
                    contentDescription = "Accion deshabilitada",
                    onClick = {},
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Default.WbSunny,
                            contentDescription = "Accion",
                            tint = UanThemeTokens.current.colors.onSurface,
                        )
                    },
                ),
            ),
        ) { _, _, _ ->
            ForestPathIllustration()
        }
    }
}

@Composable
private fun CarouselPreviewContainer(
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
private fun ForestPathIllustration() {
    val colors = UanThemeTokens.current.colors
    Canvas(
        modifier = Modifier.size(
            width = UanCarouselDefaults.itemWidth,
            height = UanCarouselDefaults.itemHeight,
        ),
    ) {
        val stroke = 4f
        val width = size.width
        val height = size.height
        val treeColor = colors.onSurface

        fun drawTree(x: Float, y: Float) {
            drawLine(
                color = treeColor,
                start = Offset(x, y + 14f),
                end = Offset(x, y + 28f),
                strokeWidth = stroke,
            )
            drawLine(
                color = treeColor,
                start = Offset(x, y),
                end = Offset(x - 12f, y + 18f),
                strokeWidth = stroke,
            )
            drawLine(
                color = treeColor,
                start = Offset(x, y),
                end = Offset(x + 12f, y + 18f),
                strokeWidth = stroke,
            )
            drawLine(
                color = treeColor,
                start = Offset(x, y + 12f),
                end = Offset(x - 12f, y + 30f),
                strokeWidth = stroke,
            )
            drawLine(
                color = treeColor,
                start = Offset(x, y + 12f),
                end = Offset(x + 12f, y + 30f),
                strokeWidth = stroke,
            )
        }

        drawTree(width * 0.25f, height * 0.25f)
        drawTree(width * 0.4f, height * 0.3f)
        drawTree(width * 0.68f, height * 0.24f)
        drawTree(width * 0.78f, height * 0.5f)
        drawTree(width * 0.18f, height * 0.52f)

        drawLine(
            color = treeColor,
            start = Offset(width * 0.32f, height * 0.78f),
            end = Offset(width * 0.38f, height * 0.68f),
            strokeWidth = stroke,
        )
        drawLine(
            color = treeColor,
            start = Offset(width * 0.38f, height * 0.68f),
            end = Offset(width * 0.34f, height * 0.58f),
            strokeWidth = stroke,
        )
        drawLine(
            color = treeColor,
            start = Offset(width * 0.34f, height * 0.58f),
            end = Offset(width * 0.52f, height * 0.52f),
            strokeWidth = stroke,
        )
        drawLine(
            color = treeColor,
            start = Offset(width * 0.52f, height * 0.52f),
            end = Offset(width * 0.66f, height * 0.6f),
            strokeWidth = stroke,
        )
        drawLine(
            color = treeColor,
            start = Offset(width * 0.66f, height * 0.6f),
            end = Offset(width * 0.56f, height * 0.68f),
            strokeWidth = stroke,
        )
        drawLine(
            color = treeColor,
            start = Offset(width * 0.56f, height * 0.68f),
            end = Offset(width * 0.76f, height * 0.78f),
            strokeWidth = stroke,
        )
    }
}

