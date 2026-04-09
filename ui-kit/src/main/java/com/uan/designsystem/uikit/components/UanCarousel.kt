package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.semantics
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanThemeTokens

data class UanCarouselAction(
    val label: String,
    val contentDescription: String,
    val onClick: () -> Unit,
    val leadingContent: (@Composable () -> Unit)? = null,
)

@Composable
fun <T> UanCarousel(
    items: List<T>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    tone: UanTone = UanTone.Neutral,
    carouselDescription: String = "Carrusel",
    itemContentDescription: (index: Int, item: T) -> String,
    bottomActions: List<UanCarouselAction> = emptyList(),
    itemContent: @Composable BoxScope.(index: Int, item: T, selected: Boolean) -> Unit,
) {
    Column(
        modifier = modifier
            .semantics(mergeDescendants = false) {
                role = Role.Tab
                contentDescription = carouselDescription
                stateDescription = "${pagerState.currentPage + 1} de ${items.size}"
                if (!enabled) disabled()
            },
        verticalArrangement = Arrangement.spacedBy(
            UanCarouselDefaults.actionSpacing,
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            pageSpacing = UanCarouselDefaults.itemSpacing,
            userScrollEnabled = enabled,
        ) { index ->
            val item = items[index]
            val selected = pagerState.currentPage == index
            CarouselItem(
                enabled = enabled,
                tone = tone,
                selected = selected,
                itemDescription = itemContentDescription(index, item),
            ) {
                itemContent(index, item, selected)
            }
        }

        if (bottomActions.isNotEmpty()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    UanCarouselDefaults.actionSpacing,
                    Alignment.CenterHorizontally,
                ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                bottomActions.forEach { action ->
                    CarouselActionChip(
                        action = action,
                        enabled = enabled,
                        tone = tone,
                    )
                }
            }
        }
    }
}

@Composable
private fun CarouselItem(
    enabled: Boolean,
    tone: UanTone,
    selected: Boolean,
    itemDescription: String,
    content: @Composable BoxScope.() -> Unit,
) {
    val containerColor = UanCarouselDefaults.itemContainerColor(enabled)
    val borderColor = UanCarouselDefaults.itemBorderColor(
        tone = tone,
        selected = selected,
        enabled = enabled,
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(UanCarouselDefaults.itemHeight)
            .clip(RoundedCornerShape(UanCarouselDefaults.itemCornerRadius))
            .background(
                color = containerColor,
                shape = RoundedCornerShape(UanCarouselDefaults.itemCornerRadius),
            )
            .border(
                width = UanCarouselDefaults.itemBorderWidth,
                color = borderColor,
                shape = RoundedCornerShape(UanCarouselDefaults.itemCornerRadius),
            )
            .alpha(if (enabled) 1f else UanInteractiveDefaults.disabledAlpha)
            .semantics {
                role = Role.Tab
                this.selected = selected
                contentDescription = itemDescription
                stateDescription = if (selected) "seleccionado" else "disponible"
                if (!enabled) disabled()
            },
        contentAlignment = Alignment.Center,
        content = content,
    )
}

@Composable
private fun CarouselActionChip(
    action: UanCarouselAction,
    enabled: Boolean,
    tone: UanTone,
) {
    val containerColor = UanCarouselDefaults.actionContainerColor(enabled)
    val borderColor = UanCarouselDefaults.actionBorderColor(
        tone = tone,
        enabled = enabled,
    )
    val colors = UanThemeTokens.current.colors

    UanButton(
        onClick = action.onClick,
        enabled = enabled,
        modifier = Modifier
            .defaultMinSize(minHeight = UanCarouselDefaults.actionMinHeight)
            .clip(RoundedCornerShape(percent = 35))
            .background(
                color = containerColor,
                shape = RoundedCornerShape(percent = 35),
            )
            .border(
                width = UanInteractiveDefaults.borderWidth,
                color = borderColor,
                shape = RoundedCornerShape(percent = 35),
            ),
        style = UanButtonStyle.Ghost,
        size = UanButtonSize.Compact,
    ) {
        val leadingContent = action.leadingContent
        if (leadingContent != null) {
            Box(
                modifier = Modifier.size(UanCarouselDefaults.actionIconSize),
                contentAlignment = Alignment.Center,
            ) {
                leadingContent()
            }
        }
        Text(
            text = action.label,
            style = UanCarouselDefaults.actionLabelStyle,
            color = colors.onSurface,
        )
    }
}

