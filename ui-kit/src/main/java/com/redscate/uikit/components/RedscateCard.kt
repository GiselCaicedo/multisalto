package com.redscate.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.redscate.uikit.theme.RedscateThemeTokens

enum class RedscateCardTone {
    Neutral,
    Accent,
    Success
}

data class RedscateCardMetric(
    val label: String,
    val value: String,
    val supporting: String? = null
)

data class RedscateCardAction(
    val id: String,
    val label: String,
    val enabled: Boolean = true,
    val style: RedscateButtonStyle = RedscateButtonStyle.Neutral
)

data class RedscateCardConfig(
    val title: String,
    val leadingValue: String? = null,
    val leadingLabel: String? = null,
    val headlineMetric: RedscateCardMetric? = null,
    val detailMetrics: List<RedscateCardMetric> = emptyList(),
    val footerAction: RedscateCardAction? = null,
    val tone: RedscateCardTone = RedscateCardTone.Neutral
)

@Composable
fun RedscateCard(
    config: RedscateCardConfig,
    modifier: Modifier = Modifier,
    onActionClick: (actionId: String) -> Unit = {}
) {
    val tokens = RedscateThemeTokens.current
    val accent = when (config.tone) {
        RedscateCardTone.Neutral -> tokens.colors.outline
        RedscateCardTone.Accent -> tokens.colors.primary
        RedscateCardTone.Success -> tokens.colors.success
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(tokens.colors.surface, RoundedCornerShape(tokens.shapes.mediumRadius))
            .border(2.dp, accent, RoundedCornerShape(tokens.shapes.mediumRadius))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (!config.leadingValue.isNullOrBlank() || !config.leadingLabel.isNullOrBlank()) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            color = if (config.tone == RedscateCardTone.Neutral) tokens.colors.background else accent,
                            shape = CircleShape
                        )
                        .border(2.dp, accent, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = config.leadingValue ?: config.leadingLabel.orEmpty(),
                        color = if (config.tone == RedscateCardTone.Neutral) tokens.colors.onSurface else tokens.colors.onPrimary,
                        style = tokens.typography.label
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .heightIn(min = 48.dp)
                    .background(tokens.colors.background, RoundedCornerShape(tokens.shapes.smallRadius))
                    .border(2.dp, tokens.colors.outline, RoundedCornerShape(tokens.shapes.smallRadius))
                    .padding(horizontal = 10.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = config.title,
                    color = tokens.colors.onSurface,
                    style = tokens.typography.label
                )
                if (!config.leadingLabel.isNullOrBlank() && config.leadingValue != null) {
                    Text(
                        text = config.leadingLabel,
                        color = tokens.colors.muted,
                        style = tokens.typography.supporting
                    )
                }
            }
        }

        if (config.detailMetrics.isNotEmpty() || config.headlineMetric != null) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    config.detailMetrics.forEach { metric ->
                        MetricBlock(metric)
                    }
                }
                config.headlineMetric?.let { metric ->
                    MetricChip(metric = metric, modifier = Modifier.weight(0.8f))
                }
            }
        }

        config.footerAction?.let { action ->
            RedscateButton(
                text = action.label,
                onClick = { onActionClick(action.id) },
                enabled = action.enabled,
                style = action.style,
                widthMode = RedscateButtonWidthMode.Fill
            )
        }
    }
}

@Composable
private fun MetricBlock(metric: RedscateCardMetric) {
    val tokens = RedscateThemeTokens.current
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(
            text = metric.label,
            color = tokens.colors.muted,
            style = tokens.typography.supporting
        )
        Text(
            text = metric.value,
            color = tokens.colors.onSurface,
            style = tokens.typography.body
        )
        if (!metric.supporting.isNullOrBlank()) {
            Text(
                text = metric.supporting,
                color = tokens.colors.muted,
                style = tokens.typography.supporting
            )
        }
    }
}

@Composable
private fun MetricChip(
    metric: RedscateCardMetric,
    modifier: Modifier = Modifier
) {
    val tokens = RedscateThemeTokens.current
    Column(
        modifier = modifier
            .background(tokens.colors.background, RoundedCornerShape(tokens.shapes.smallRadius))
            .border(2.dp, tokens.colors.outline, RoundedCornerShape(tokens.shapes.smallRadius))
            .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = metric.label,
            color = tokens.colors.muted,
            style = tokens.typography.supporting,
            textAlign = TextAlign.Center
        )
        Text(
            text = metric.value,
            color = tokens.colors.onSurface,
            style = tokens.typography.label,
            textAlign = TextAlign.Center
        )
        if (!metric.supporting.isNullOrBlank()) {
            Text(
                text = metric.supporting,
                color = tokens.colors.muted,
                style = tokens.typography.supporting,
                textAlign = TextAlign.Center
            )
        }
    }
}
