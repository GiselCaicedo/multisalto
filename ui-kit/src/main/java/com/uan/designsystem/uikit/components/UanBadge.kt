package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.foundation.UanTone

enum class UanBadgeEmphasis {
    Solid,
    Tonal,
    Outline,
}

@Composable
fun UanBadge(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    tone: UanTone = UanTone.Info,
    emphasis: UanBadgeEmphasis = UanBadgeEmphasis.Tonal,
    contentDescription: String = text,
    leadingContent: (@Composable () -> Unit)? = null,
) {
    val containerColor = UanBadgeDefaults.containerColor(
        tone = tone,
        emphasis = emphasis,
        enabled = enabled,
    )
    val contentColor = UanBadgeDefaults.contentColor(
        tone = tone,
        emphasis = emphasis,
        enabled = enabled,
    )
    val shape = RoundedCornerShape(UanBadgeDefaults.cornerRadius)

    Row(
        modifier = modifier
            .defaultMinSize(minHeight = UanInteractiveDefaults.minTouchTarget)
            .clip(shape)
            .background(containerColor, shape)
            .then(
                if (emphasis == UanBadgeEmphasis.Outline) {
                    Modifier.border(
                        width = UanInteractiveDefaults.borderWidth,
                        color = contentColor,
                        shape = shape,
                    )
                } else {
                    Modifier
                }
            )
            .alpha(if (enabled) 1f else UanInteractiveDefaults.disabledAlpha)
            .padding(
                horizontal = UanBadgeDefaults.horizontalPadding,
                vertical = UanBadgeDefaults.verticalPadding,
            )
            .semantics {
                this.contentDescription = contentDescription
                if (!enabled) disabled()
            },
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (leadingContent != null) {
            androidx.compose.foundation.layout.Box(
                modifier = Modifier.size(16.dp),
                contentAlignment = Alignment.Center,
            ) {
                leadingContent()
            }
        }
        Text(
            text = text,
            style = UanBadgeDefaults.labelStyle,
            color = contentColor,
        )
    }
}

