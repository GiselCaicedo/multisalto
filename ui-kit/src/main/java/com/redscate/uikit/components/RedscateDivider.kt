package com.redscate.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.redscate.uikit.theme.RedscateThemeTokens

enum class RedscateDividerOrientation {
    Horizontal,
    Vertical
}

@Composable
fun RedscateDivider(
    modifier: Modifier = Modifier,
    orientation: RedscateDividerOrientation = RedscateDividerOrientation.Horizontal,
    emphasized: Boolean = false
) {
    val tokens = RedscateThemeTokens.current
    val color = if (emphasized) tokens.colors.outline else tokens.colors.muted
    Box(
        modifier = modifier
            .then(
                if (orientation == RedscateDividerOrientation.Horizontal) {
                    Modifier
                        .fillMaxWidth()
                        .height(if (emphasized) 2.dp else 1.dp)
                } else {
                    Modifier
                        .fillMaxHeight()
                        .width(if (emphasized) 2.dp else 1.dp)
                }
            )
            .background(color)
    )
}
