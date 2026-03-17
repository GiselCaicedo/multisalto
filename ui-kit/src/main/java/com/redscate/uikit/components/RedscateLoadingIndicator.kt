package com.redscate.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.redscate.uikit.theme.RedscateThemeTokens

enum class RedscateIndicatorState {
    Inactive,
    Warning,
    Success
}

internal fun coerceIndicatorStep(currentStep: Int, totalSteps: Int): Int {
    if (totalSteps <= 0) return 0
    return currentStep.coerceIn(0, totalSteps)
}

@Composable
fun RedscateLoadingIndicator(
    states: List<RedscateIndicatorState>,
    modifier: Modifier = Modifier
) {
    val tokens = RedscateThemeTokens.current
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        states.forEach { state ->
            val color = when (state) {
                RedscateIndicatorState.Inactive -> tokens.colors.muted
                RedscateIndicatorState.Warning -> tokens.colors.error
                RedscateIndicatorState.Success -> tokens.colors.success
            }
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .border(2.dp, color, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                when (state) {
                    RedscateIndicatorState.Success -> Text("✓", color = color, style = tokens.typography.label)
                    RedscateIndicatorState.Warning -> Text("!", color = color, style = tokens.typography.label)
                    RedscateIndicatorState.Inactive -> Unit
                }
            }
        }
    }
}

@Composable
fun RedscateStepIndicator(
    totalSteps: Int,
    currentStep: Int,
    modifier: Modifier = Modifier
) {
    val tokens = RedscateThemeTokens.current
    val safeStep = coerceIndicatorStep(currentStep, totalSteps)
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(totalSteps) { index ->
            val active = index < safeStep
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(
                        color = if (active) tokens.colors.success else tokens.colors.background,
                        shape = CircleShape
                    )
                    .border(
                        width = 2.dp,
                        color = if (active) tokens.colors.success else tokens.colors.muted,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = (index + 1).toString(),
                    color = if (active) tokens.colors.onSuccess else tokens.colors.muted,
                    style = tokens.typography.supporting
                )
            }
        }
    }
}
