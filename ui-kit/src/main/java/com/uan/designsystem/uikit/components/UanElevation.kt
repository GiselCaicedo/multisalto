package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.semantics
import com.uan.designsystem.uikit.foundation.UanElevationLevel
import com.uan.designsystem.uikit.foundation.UanElevation
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Composable
fun UanElevation(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    level: UanElevationLevel = UanElevationLevel.Level3,
    contentDescription: String = text,
    content: (@Composable () -> Unit)? = null,
) {
    val tokens = UanThemeTokens.current
    val shape = RoundedCornerShape(UanElevationDefaults.cornerRadius)

    Box(
        modifier = modifier
            .defaultMinSize(
                minWidth = UanElevationDefaults.width,
                minHeight = UanElevationDefaults.height,
            )
            .UanElevation(
                level = level,
                shape = shape,
                enabled = enabled,
            )
            .clip(shape)
            .background(tokens.colors.surface, shape)
            .border(
                width = tokens.elevations.level1,
                color = tokens.colors.outline,
                shape = shape,
            )
            .alpha(if (enabled) 1f else tokens.colors.disabledAlpha)
            .padding(
                horizontal = UanElevationDefaults.horizontalPadding,
                vertical = UanElevationDefaults.verticalPadding,
            )
            .semantics {
                this.contentDescription = contentDescription
                if (!enabled) disabled()
            },
        contentAlignment = Alignment.Center,
    ) {
        if (content != null) {
            content()
        } else {
            Text(
                text = text,
                style = UanElevationDefaults.labelStyle,
                color = tokens.colors.onSurface,
            )
        }
    }
}

