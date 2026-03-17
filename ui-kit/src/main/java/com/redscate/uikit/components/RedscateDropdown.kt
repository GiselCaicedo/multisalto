package com.redscate.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.redscate.uikit.theme.RedscateThemeTokens

data class RedscateOption(
    val key: String,
    val label: String,
    val enabled: Boolean = true
)

internal fun resolveSelectedOption(selectedKey: String, options: List<RedscateOption>): RedscateOption? {
    return options.firstOrNull { it.key == selectedKey }
}

@Composable
fun RedscateDropdown(
    selectedKey: String,
    options: List<RedscateOption>,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onOptionSelected: (RedscateOption) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String? = null
) {
    val tokens = RedscateThemeTokens.current
    val selected = resolveSelectedOption(selectedKey, options)
    val displayLabel = selected?.label ?: options.firstOrNull()?.label.orEmpty()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        if (!label.isNullOrBlank()) {
            Text(
                text = label,
                color = tokens.colors.muted,
                style = tokens.typography.supporting,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
        DropdownHeader(
            text = displayLabel,
            expanded = expanded,
            enabled = enabled,
            onClick = { onExpandedChange(!expanded) }
        )
        if (expanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(tokens.colors.background, RoundedCornerShape(tokens.shapes.smallRadius))
                    .border(2.dp, tokens.colors.primary, RoundedCornerShape(tokens.shapes.smallRadius))
            ) {
                options.filter { it.key != selected?.key }.forEach { option ->
                    Text(
                        text = option.label,
                        color = if (option.enabled) tokens.colors.onSurface else tokens.colors.muted,
                        style = tokens.typography.body,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(enabled = option.enabled) {
                                onOptionSelected(option)
                                onExpandedChange(false)
                            }
                            .padding(horizontal = 10.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun DropdownHeader(
    text: String,
    expanded: Boolean,
    enabled: Boolean,
    onClick: () -> Unit
) {
    val tokens = RedscateThemeTokens.current
    val borderColor = if (expanded) tokens.colors.primary else tokens.colors.outline
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(tokens.colors.background, RoundedCornerShape(tokens.shapes.smallRadius))
            .border(2.dp, borderColor, RoundedCornerShape(tokens.shapes.smallRadius))
            .clickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text, color = tokens.colors.onSurface, style = tokens.typography.label)
        Text(
            text = if (expanded) "^" else "v",
            color = tokens.colors.muted,
            style = tokens.typography.label
        )
    }
}
