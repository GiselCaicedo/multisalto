package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.foundation.colorFor
import com.uan.designsystem.uikit.theme.UanThemeTokens

data class UanDropdownMenuItem(
    val label: String,
    val contentDescription: String,
    val enabled: Boolean = true,
    val onClick: () -> Unit,
    val leadingContent: (@Composable () -> Unit)? = null,
    val trailingContent: (@Composable () -> Unit)? = null,
)

@Composable
fun UanDropdownMenu(
    expanded: Boolean,
    items: List<UanDropdownMenuItem>,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    tone: UanTone = UanTone.Neutral,
) {
    val colors = UanThemeTokens.current.colors
    val borderColor = if (tone == UanTone.Neutral) colors.outlineVariant else tone.colorFor(colors)
    val shape = RoundedCornerShape(UanDropdownMenuDefaults.cornerRadius)

    if (expanded) {
        Column(
            modifier = modifier
                .defaultMinSize(minWidth = UanDropdownMenuDefaults.minWidth)
                .clip(shape)
                .background(colors.surfaceContainer, shape)
                .border(
                    width = UanDropdownMenuDefaults.borderWidth,
                    color = borderColor,
                    shape = shape,
                )
                .alpha(if (enabled) 1f else UanInteractiveDefaults.disabledAlpha)
                .semantics {
                    role = Role.DropdownList
                    stateDescription = "expandido"
                    if (!enabled) disabled()
                },
            verticalArrangement = Arrangement.spacedBy(0.dp),
        ) {
            items.forEach { item ->
                DropdownMenuRow(
                    item = item,
                    enabled = enabled && item.enabled,
                )
            }
        }
    }
}

@Composable
private fun DropdownMenuRow(
    item: UanDropdownMenuItem,
    enabled: Boolean,
) {
    val colors = UanThemeTokens.current.colors
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = UanDropdownMenuDefaults.itemMinHeight)
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = null,
                role = Role.Button,
                onClick = item.onClick,
            )
            .padding(
                horizontal = UanDropdownMenuDefaults.itemPaddingHorizontal,
                vertical = UanDropdownMenuDefaults.itemPaddingVertical,
            )
            .semantics {
                role = Role.Button
                contentDescription = item.contentDescription
                if (!enabled) disabled()
            },
        horizontalArrangement = Arrangement.spacedBy(
            UanDropdownMenuDefaults.itemSpacing,
        ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (item.leadingContent != null) {
            Box(contentAlignment = Alignment.Center) {
                item.leadingContent.invoke()
            }
        }
        Text(
            text = item.label,
            style = UanDropdownMenuDefaults.itemTextStyle,
            color = if (enabled) colors.onSurface else colors.muted,
            modifier = Modifier.weight(1f),
        )
        if (item.trailingContent != null) {
            Box(contentAlignment = Alignment.Center) {
                item.trailingContent.invoke()
            }
        }
    }
}

