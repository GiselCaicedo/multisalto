package com.redscate.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.redscate.uikit.theme.RedscateThemeTokens
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

enum class RedscateDialogTone {
    Neutral,
    Success,
    Danger
}

data class RedscateDialogAction(
    val id: String,
    val label: String,
    val tone: RedscateDialogTone = RedscateDialogTone.Neutral,
    val enabled: Boolean = true
)

data class RedscateDialogConfig(
    val title: String,
    val message: String? = null,
    val tone: RedscateDialogTone = RedscateDialogTone.Neutral,
    val dismissible: Boolean = true,
    val actions: List<RedscateDialogAction> = emptyList()
)

@Composable
fun RedscateDialog(
    visible: Boolean,
    config: RedscateDialogConfig,
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    onActionClick: (actionId: String) -> Unit
) {
    if (!visible) return
    val tokens = RedscateThemeTokens.current
    Dialog(
        onDismissRequest = {
            if (config.dismissible) onDismissRequest()
        },
        properties = DialogProperties(
            dismissOnBackPress = config.dismissible,
            dismissOnClickOutside = config.dismissible
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .then(modifier),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .widthIn(min = 280.dp, max = 360.dp)
                    .background(tokens.colors.surface, RoundedCornerShape(tokens.shapes.mediumRadius))
                    .border(2.dp, tokens.colors.outline, RoundedCornerShape(tokens.shapes.mediumRadius))
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = config.title,
                    color = toneColor(config.tone),
                    style = tokens.typography.label
                )
                if (!config.message.isNullOrBlank()) {
                    Text(
                        text = config.message,
                        color = tokens.colors.onSurface,
                        style = tokens.typography.body
                    )
                }
                if (config.actions.isNotEmpty()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        config.actions.forEach { action ->
                            RedscateButton(
                                text = action.label,
                                onClick = { onActionClick(action.id) },
                                enabled = action.enabled,
                                style = when (action.tone) {
                                    RedscateDialogTone.Neutral -> RedscateButtonStyle.Neutral
                                    RedscateDialogTone.Success -> RedscateButtonStyle.Success
                                    RedscateDialogTone.Danger -> RedscateButtonStyle.Danger
                                },
                                widthMode = RedscateButtonWidthMode.Fill,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun toneColor(tone: RedscateDialogTone): androidx.compose.ui.graphics.Color {
    val tokens = RedscateThemeTokens.current
    return when (tone) {
        RedscateDialogTone.Neutral -> tokens.colors.onSurface
        RedscateDialogTone.Success -> tokens.colors.success
        RedscateDialogTone.Danger -> tokens.colors.error
    }
}
