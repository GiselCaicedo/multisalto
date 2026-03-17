package com.redscate.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.redscate.uikit.theme.RedscateThemeTokens

data class RedscateCarouselItem(
    val id: String,
    val title: String,
    val subtitle: String? = null,
    val badge: String? = null
)

data class RedscateCarouselConfig(
    val showIndicators: Boolean = true,
    val loop: Boolean = true
)

internal fun coerceCarouselIndex(currentIndex: Int, size: Int): Int {
    if (size <= 0) return 0
    return currentIndex.coerceIn(0, size - 1)
}

@Composable
fun RedscateCarousel(
    items: List<RedscateCarouselItem>,
    currentIndex: Int,
    onIndexChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    config: RedscateCarouselConfig = RedscateCarouselConfig(),
    itemContent: @Composable (item: RedscateCarouselItem) -> Unit = { item ->
        DefaultCarouselCard(item)
    }
) {
    val safeIndex = coerceCarouselIndex(currentIndex, items.size)
    val hasItems = items.isNotEmpty()
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RedscateButton(
                text = "<",
                onClick = {
                    if (!hasItems) return@RedscateButton
                    val next = when {
                        safeIndex > 0 -> safeIndex - 1
                        config.loop -> items.lastIndex
                        else -> 0
                    }
                    onIndexChange(next)
                },
                enabled = hasItems,
                style = RedscateButtonStyle.Neutral
            )

            Box(modifier = Modifier.weight(1f)) {
                if (hasItems) {
                    itemContent(items[safeIndex])
                } else {
                    DefaultCarouselCard(
                        item = RedscateCarouselItem(
                            id = "empty",
                            title = "Sin elementos",
                            subtitle = "No hay datos para mostrar"
                        )
                    )
                }
            }

            RedscateButton(
                text = ">",
                onClick = {
                    if (!hasItems) return@RedscateButton
                    val next = when {
                        safeIndex < items.lastIndex -> safeIndex + 1
                        config.loop -> 0
                        else -> items.lastIndex
                    }
                    onIndexChange(next)
                },
                enabled = hasItems,
                style = RedscateButtonStyle.Neutral
            )
        }

        if (config.showIndicators && hasItems) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                items.forEachIndexed { index, _ ->
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 3.dp)
                            .width(if (index == safeIndex) 16.dp else 8.dp)
                            .height(8.dp)
                            .background(
                                color = if (index == safeIndex) RedscateThemeTokens.current.colors.primary
                                else RedscateThemeTokens.current.colors.muted,
                                shape = CircleShape
                            )
                    )
                }
            }
        }
    }
}

@Composable
private fun DefaultCarouselCard(item: RedscateCarouselItem) {
    val tokens = RedscateThemeTokens.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp)
            .background(tokens.colors.surface, RoundedCornerShape(tokens.shapes.mediumRadius))
            .border(2.dp, tokens.colors.outline, RoundedCornerShape(tokens.shapes.mediumRadius))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (!item.badge.isNullOrBlank()) {
            Text(
                text = item.badge,
                color = tokens.colors.primary,
                style = tokens.typography.supporting
            )
        }
        Text(
            text = item.title,
            color = tokens.colors.onSurface,
            style = tokens.typography.label
        )
        if (!item.subtitle.isNullOrBlank()) {
            Text(
                text = item.subtitle,
                color = tokens.colors.muted,
                style = tokens.typography.body
            )
        }
    }
}
