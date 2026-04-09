package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.material3.Text
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Composable
fun UanLists(
    title: String,
    modifier: Modifier = Modifier,
    supportingText: String? = null,
    enabled: Boolean = true,
    itemDescription: String = title,
    onClick: (() -> Unit)? = null,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
) {
    val colors = UanThemeTokens.current.colors
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = UanListsDefaults.itemMinHeight)
            .background(colors.background)
            .then(
                if (onClick != null) {
                    Modifier.clickable(
                        enabled = enabled,
                        interactionSource = interactionSource,
                        indication = null,
                        role = Role.Button,
                        onClick = onClick,
                    )
                } else {
                    Modifier
                }
            )
            .alpha(if (enabled) 1f else UanInteractiveDefaults.disabledAlpha)
            .padding(
                horizontal = UanListsDefaults.horizontalPadding,
                vertical = UanListsDefaults.verticalPadding,
            )
            .semantics {
                contentDescription = itemDescription
                if (onClick != null) {
                    role = Role.Button
                }
                if (!enabled) disabled()
            },
        horizontalArrangement = Arrangement.spacedBy(UanListsDefaults.contentSpacing),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (leadingContent != null) {
            Box(contentAlignment = Alignment.Center) {
                leadingContent()
            }
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(UanListsDefaults.sectionSpacing),
        ) {
            Text(
                text = title,
                style = UanListsDefaults.titleStyle,
                color = colors.onSurface,
            )
            if (supportingText != null) {
                Text(
                    text = supportingText,
                    style = UanListsDefaults.supportingStyle,
                    color = colors.muted,
                )
            }
        }

        if (trailingContent != null) {
            Box(contentAlignment = Alignment.Center) {
                trailingContent()
            }
        }
    }
}

