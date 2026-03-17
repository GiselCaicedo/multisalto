package com.redscate.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.redscate.uikit.theme.RedscateThemeTokens

enum class RedscateBadgeTone {
    Neutral,
    Primary,
    Success,
    Danger
}

enum class RedscateBadgeStyle {
    Solid,
    Outline,
    Dot
}

internal fun formatBadgeCount(count: Int?): String? {
    if (count == null || count <= 0) return null
    return if (count > 99) "99+" else count.toString()
}

@Composable
fun RedscateBadge(
    modifier: Modifier = Modifier,
    text: String? = null,
    count: Int? = null,
    tone: RedscateBadgeTone = RedscateBadgeTone.Danger,
    style: RedscateBadgeStyle = if (text.isNullOrBlank() && count == null) RedscateBadgeStyle.Dot else RedscateBadgeStyle.Solid
) {
    val tokens = RedscateThemeTokens.current
    val content = text ?: formatBadgeCount(count)
    val toneColor = when (tone) {
        RedscateBadgeTone.Neutral -> tokens.colors.outline
        RedscateBadgeTone.Primary -> tokens.colors.primary
        RedscateBadgeTone.Success -> tokens.colors.success
        RedscateBadgeTone.Danger -> tokens.colors.error
    }

    if (style == RedscateBadgeStyle.Dot) {
        Box(
            modifier = modifier
                .size(12.dp)
                .background(toneColor, CircleShape)
        )
        return
    }

    Row(
        modifier = modifier
            .background(
                color = if (style == RedscateBadgeStyle.Outline) tokens.colors.background else toneColor,
                shape = RoundedCornerShape(tokens.shapes.pillRadius)
            )
            .border(2.dp, toneColor, RoundedCornerShape(tokens.shapes.pillRadius))
            .padding(horizontal = 8.dp, vertical = 3.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .background(toneColor, CircleShape)
        )
        Text(
            text = content.orEmpty(),
            color = if (style == RedscateBadgeStyle.Outline) tokens.colors.onSurface else tokens.colors.onPrimary,
            style = tokens.typography.supporting
        )
    }
}
