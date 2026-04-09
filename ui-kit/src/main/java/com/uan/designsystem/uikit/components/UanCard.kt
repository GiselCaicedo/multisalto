package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.semantics
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Composable
fun UanCard(
    title: String,
    modifier: Modifier = Modifier,
    body: String? = null,
    enabled: Boolean = true,
    tone: UanTone = UanTone.Neutral,
    contentDescription: String = title,
    footer: (@Composable () -> Unit)? = null,
    supportingContent: (@Composable () -> Unit)? = null,
) {
    val tokens = UanThemeTokens.current
    val colors = tokens.colors
    val containerColor = UanCardDefaults.containerColor(enabled)
    val borderColor = UanCardDefaults.borderColor(tone = tone, enabled = enabled)
    val shape = RoundedCornerShape(UanCardDefaults.cornerRadius)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = UanInteractiveDefaults.minTouchTarget)
            .clip(shape)
            .background(containerColor, shape)
            .border(
                width = UanCardDefaults.borderWidth,
                color = borderColor,
                shape = shape,
            )
            .alpha(if (enabled) 1f else UanInteractiveDefaults.disabledAlpha)
            .semantics {
                this.contentDescription = contentDescription
                if (!enabled) disabled()
            },
    ) {
        if (tone != UanTone.Neutral) {
            Box(
                modifier = Modifier
                    .width(UanCardDefaults.accentWidth)
                    .background(borderColor),
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(
                    horizontal = UanCardDefaults.horizontalPadding,
                    vertical = UanCardDefaults.verticalPadding,
                ),
            verticalArrangement = Arrangement.spacedBy(UanCardDefaults.sectionSpacing),
        ) {
            Text(
                text = title,
                style = UanCardDefaults.titleStyle,
                color = colors.onSurface,
            )
            if (body != null) {
                Text(
                    text = body,
                    style = UanCardDefaults.bodyStyle,
                    color = colors.muted,
                )
            }
            if (supportingContent != null) {
                supportingContent()
            }
            if (footer != null) {
                footer()
            }
        }
    }
}

