package com.redscate.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.redscate.uikit.theme.RedscateThemeTokens

enum class RedscateToolbarItemState {
    Active,
    Inactive,
    Disabled
}

data class RedscateToolbarItem(
    val id: String,
    val label: String,
    val icon: (@Composable () -> Unit)? = null,
    val state: RedscateToolbarItemState = RedscateToolbarItemState.Inactive
)

@Composable
fun RedscateToolbar(
    items: List<RedscateToolbarItem>,
    modifier: Modifier = Modifier,
    onItemClick: (itemId: String) -> Unit
) {
    val tokens = RedscateThemeTokens.current
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(tokens.colors.surface, RoundedCornerShape(tokens.shapes.smallRadius))
            .border(2.dp, tokens.colors.outline, RoundedCornerShape(tokens.shapes.smallRadius))
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { item ->
            ToolbarItemChip(item = item, onItemClick = onItemClick)
        }
    }
}

@Composable
private fun ToolbarItemChip(
    item: RedscateToolbarItem,
    onItemClick: (itemId: String) -> Unit
) {
    val tokens = RedscateThemeTokens.current
    val active = item.state == RedscateToolbarItemState.Active
    val disabled = item.state == RedscateToolbarItemState.Disabled
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(
                if (active) tokens.colors.primary else tokens.colors.background,
                RoundedCornerShape(10.dp)
            )
            .border(
                2.dp,
                if (active) tokens.colors.primary else tokens.colors.muted,
                RoundedCornerShape(10.dp)
            )
            .alpha(if (disabled) 0.45f else 1f)
            .clickable(enabled = !disabled) { onItemClick(item.id) },
        contentAlignment = Alignment.Center
    ) {
        if (item.icon != null) {
            item.icon.invoke()
        } else {
            Text(
                text = item.label.take(3),
                color = if (active) tokens.colors.onPrimary else tokens.colors.onSurface,
                style = tokens.typography.supporting
            )
        }
    }
}
