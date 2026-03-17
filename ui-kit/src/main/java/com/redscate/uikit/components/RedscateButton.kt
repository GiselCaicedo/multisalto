package com.redscate.uikit.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.redscate.uikit.theme.RedscateThemeTokens

enum class RedscateButtonStyle {
    Neutral,
    Primary,
    Success,
    Danger,
    Outline
}

enum class RedscateButtonSize {
    Compact,
    Regular
}

enum class RedscateButtonWidthMode {
    Wrap,
    Fill
}

@Composable
fun RedscateButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: RedscateButtonStyle = RedscateButtonStyle.Primary,
    size: RedscateButtonSize = RedscateButtonSize.Regular,
    widthMode: RedscateButtonWidthMode = RedscateButtonWidthMode.Wrap,
    leadingIcon: (@Composable () -> Unit)? = null
) {
    val tokens = RedscateThemeTokens.current
    val container = when (style) {
        RedscateButtonStyle.Primary -> tokens.colors.primary
        RedscateButtonStyle.Success -> tokens.colors.success
        RedscateButtonStyle.Danger -> tokens.colors.error
        RedscateButtonStyle.Outline -> Color.Transparent
        RedscateButtonStyle.Neutral -> tokens.colors.surface
    }
    val labelColor = when (style) {
        RedscateButtonStyle.Primary -> tokens.colors.onPrimary
        RedscateButtonStyle.Success -> tokens.colors.onSuccess
        RedscateButtonStyle.Danger -> tokens.colors.onPrimary
        RedscateButtonStyle.Outline -> tokens.colors.onSurface
        RedscateButtonStyle.Neutral -> tokens.colors.onSurface
    }
    val borderColor = when (style) {
        RedscateButtonStyle.Outline -> tokens.colors.outline
        RedscateButtonStyle.Neutral -> tokens.colors.muted
        else -> Color.Transparent
    }
    val verticalPadding = if (size == RedscateButtonSize.Compact) 6.dp else 9.dp

    Surface(
        color = container,
        shape = RoundedCornerShape(tokens.shapes.smallRadius),
        border = BorderStroke(2.dp, borderColor),
        modifier = modifier
            .then(if (widthMode == RedscateButtonWidthMode.Fill) Modifier.fillMaxWidth() else Modifier)
            .alpha(if (enabled) 1f else 0.55f)
            .clickable(enabled = enabled, onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = verticalPadding),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            leadingIcon?.invoke()
            Text(
                text = text,
                color = labelColor,
                style = tokens.typography.label
            )
        }
    }
}
