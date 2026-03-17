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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.redscate.uikit.theme.RedscateThemeTokens

data class RedscateAppBarAction(
    val id: String,
    val label: String? = null,
    val icon: (@Composable () -> Unit)? = null,
    val enabled: Boolean = true
)

data class RedscateAppBarConfig(
    val title: String,
    val subtitle: String? = null,
    val leading: RedscateAppBarAction? = null,
    val trailing: List<RedscateAppBarAction> = emptyList(),
    val enabled: Boolean = true
)

@Composable
fun RedscateAppBar(
    config: RedscateAppBarConfig,
    modifier: Modifier = Modifier,
    onActionClick: (actionId: String) -> Unit
) {
    val tokens = RedscateThemeTokens.current
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(tokens.colors.background)
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (config.leading != null) {
            AppBarActionChip(
                action = config.leading,
                barEnabled = config.enabled,
                onActionClick = onActionClick
            )
        } else {
            Box(modifier = Modifier.size(40.dp))
        }

        Box(contentAlignment = Alignment.Center) {
            if (!config.subtitle.isNullOrBlank()) {
                Text(
                    text = config.subtitle,
                    color = tokens.colors.muted,
                    style = tokens.typography.supporting,
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
            Text(
                text = config.title,
                color = tokens.colors.onSurface,
                style = tokens.typography.label,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }

        if (config.trailing.isNotEmpty()) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                config.trailing.take(2).forEach { action ->
                    AppBarActionChip(
                        action = action,
                        barEnabled = config.enabled,
                        onActionClick = onActionClick
                    )
                }
            }
        } else {
            Box(modifier = Modifier.size(40.dp))
        }
    }
}

@Composable
private fun AppBarActionChip(
    action: RedscateAppBarAction,
    barEnabled: Boolean,
    onActionClick: (actionId: String) -> Unit
) {
    val tokens = RedscateThemeTokens.current
    val enabled = barEnabled && action.enabled
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(tokens.colors.surface, CircleShape)
            .border(2.dp, tokens.colors.outline, CircleShape)
            .alpha(if (enabled) 1f else 0.55f)
            .clickable(enabled = enabled) { onActionClick(action.id) },
        contentAlignment = Alignment.Center
    ) {
        if (action.icon != null) {
            action.icon.invoke()
        } else {
            Text(
                text = action.label ?: "•",
                color = tokens.colors.onSurface,
                style = tokens.typography.body
            )
        }
    }
}
