package com.redscate.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.redscate.uikit.theme.RedscateThemeTokens

enum class RedscateCheckboxState {
    Inactive,
    Active,
    Checked
}

internal fun nextCheckboxState(state: RedscateCheckboxState): RedscateCheckboxState {
    return when (state) {
        RedscateCheckboxState.Inactive -> RedscateCheckboxState.Active
        RedscateCheckboxState.Active -> RedscateCheckboxState.Checked
        RedscateCheckboxState.Checked -> RedscateCheckboxState.Inactive
    }
}

@Composable
fun RedscateCheckbox(
    state: RedscateCheckboxState,
    onStateChange: (RedscateCheckboxState) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val tokens = RedscateThemeTokens.current
    val fill = when (state) {
        RedscateCheckboxState.Inactive -> tokens.colors.surface
        RedscateCheckboxState.Active -> tokens.colors.background
        RedscateCheckboxState.Checked -> tokens.colors.primary
    }
    val border = when (state) {
        RedscateCheckboxState.Inactive -> tokens.colors.muted
        RedscateCheckboxState.Active -> tokens.colors.outline
        RedscateCheckboxState.Checked -> tokens.colors.primary
    }

    Box(
        modifier = modifier
            .size(46.dp)
            .alpha(if (enabled) 1f else 0.45f)
            .background(fill, RoundedCornerShape(tokens.shapes.mediumRadius))
            .border(2.dp, border, RoundedCornerShape(tokens.shapes.mediumRadius))
            .clickable(enabled = enabled) { onStateChange(nextCheckboxState(state)) },
        contentAlignment = Alignment.Center
    ) {
        if (state == RedscateCheckboxState.Checked) {
            Text(
                text = "✓",
                color = tokens.colors.background,
                style = tokens.typography.label
            )
        }
    }
}
