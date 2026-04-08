package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.paneTitle
import androidx.compose.ui.semantics.semantics
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Composable
fun UanAppBar(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    navigationIcon: (@Composable () -> Unit)? = null,
    actions: (@Composable RowScope.() -> Unit)? = null,
) {
    val colors = UanThemeTokens.current.colors

    Row(
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = UanAppBarDefaults.minHeight)
            .background(colors.background)
            .padding(
                horizontal = UanAppBarDefaults.horizontalPadding,
                vertical = UanAppBarDefaults.verticalPadding,
            )
            .semantics {
                paneTitle = title
            },
        horizontalArrangement = Arrangement.spacedBy(UanAppBarDefaults.contentSpacing),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (navigationIcon != null) {
            Box(contentAlignment = Alignment.Center) {
                navigationIcon()
            }
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = title,
                style = UanAppBarDefaults.titleStyle,
                color = colors.onSurface,
                modifier = Modifier.semantics { heading() },
            )
            if (subtitle != null) {
                Text(
                    text = subtitle,
                    style = UanAppBarDefaults.subtitleStyle,
                    color = colors.muted,
                )
            }
        }

        if (actions != null) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    UanAppBarDefaults.actionsSpacing,
                ),
                verticalAlignment = Alignment.CenterVertically,
                content = actions,
            )
        }
    }
}

