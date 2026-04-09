package com.uan.designsystem.uikit.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.PriorityHigh
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.semantics
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.foundation.colorFor
import com.uan.designsystem.uikit.foundation.contentColorFor
import com.uan.designsystem.uikit.foundation.rememberUanReduceMotion
import com.uan.designsystem.uikit.theme.UanThemeTokens

/**
 * Variante visual del indicador de progreso.
 */
enum class UanProgressIndicatorVariant {
    Numbered,
    Status,
}

/**
 * Estado semantico de un paso.
 */
enum class UanProgressStepState {
    Pending,
    Current,
    Completed,
    Loading,
    Warning,
    Critical,
    Disabled,
}

/**
 * Modelo stateless de cada paso.
 */
@Immutable
data class UanProgressStep(
    val label: String,
    val state: UanProgressStepState,
    val contentDescription: String,
)

/**
 * Estado legado soportado por compatibilidad.
 */
@Deprecated(
    message = "Usa UanProgressStepState para estados semanticos ampliados.",
    replaceWith = ReplaceWith("UanProgressStepState"),
)
enum class UanStepState {
    Pending,
    InProgress,
    Completed,
}

/**
 * Indicador de progreso principal del sistema Uan.
 *
 * Renderiza pasos horizontales de alto contraste en dos variantes:
 * numerada e iconografica.
 */
@Composable
fun UanProgressIndicator(
    steps: List<UanProgressStep>,
    variant: UanProgressIndicatorVariant,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    currentTone: UanTone = UanTone.Primary,
    connectorCompletedTone: UanTone = UanTone.Success,
    statusIcon: @Composable ((step: UanProgressStep) -> Unit)? = null,
) {
    val tokens = UanThemeTokens.current
    val colors = tokens.colors
    val reduceMotion = rememberUanReduceMotion()
    val motionDuration = if (reduceMotion) 0 else tokens.motion.durationShort

    val completedConnectorColor = connectorCompletedTone.colorFor(colors)
    val stateDesc = buildString {
        append("${steps.size} pasos")
        val currentIndex = steps.indexOfFirst {
            it.state == UanProgressStepState.Current || it.state == UanProgressStepState.Loading
        }
        if (currentIndex >= 0) {
            append(", paso ${currentIndex + 1} activo")
        }
        val completedCount = steps.count { it.state == UanProgressStepState.Completed }
        append(", $completedCount completados")
    }

    Row(
        modifier = modifier
            .alpha(if (enabled) 1f else UanInteractiveDefaults.disabledAlpha)
            .semantics(mergeDescendants = false) {
                contentDescription = "Indicador de progreso"
                stateDescription = stateDesc
                if (!enabled) disabled()
            },
        horizontalArrangement = Arrangement.spacedBy(
            UanProgressIndicatorDefaults.stepGroupSpacing,
        ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        steps.forEachIndexed { index, step ->
            val resolvedColors = progressStepColors(
                stepState = step.state,
                enabled = enabled,
                currentTone = currentTone,
            )

            StepNode(
                index = index,
                totalSteps = steps.size,
                step = step,
                variant = variant,
                enabled = enabled,
                motionDuration = motionDuration,
                colors = resolvedColors,
                statusIcon = statusIcon,
            )

            val hasConnector = index < steps.lastIndex
            if (hasConnector) {
                val connectorColor = connectorColorFor(
                    currentStep = step.state,
                    nextStep = steps[index + 1].state,
                    enabled = enabled,
                    completedColor = completedConnectorColor,
                    colors = colors,
                )
                ConnectorDots(
                    color = connectorColor,
                )
            }
        }
    }
}

/**
 * Wrapper numerico ergonomico para casos donde el contenido de cada paso
 * es simplemente su numero.
 */
@Composable
fun UanNumberedProgress(
    totalSteps: Int,
    currentStep: Int,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    warningSteps: Set<Int> = emptySet(),
    criticalSteps: Set<Int> = emptySet(),
    disabledSteps: Set<Int> = emptySet(),
    currentTone: UanTone = UanTone.Success,
) {
    val steps = List(totalSteps) { index ->
        val stepNumber = index + 1
        val state = when {
            disabledSteps.contains(stepNumber) -> UanProgressStepState.Disabled
            criticalSteps.contains(stepNumber) -> UanProgressStepState.Critical
            warningSteps.contains(stepNumber) -> UanProgressStepState.Warning
            stepNumber < currentStep -> UanProgressStepState.Completed
            stepNumber == currentStep -> UanProgressStepState.Current
            else -> UanProgressStepState.Pending
        }
        UanProgressStep(
            label = stepNumber.toString(),
            state = state,
            contentDescription = "Paso $stepNumber de $totalSteps, ${stepStateDescription(state)}",
        )
    }

    UanProgressIndicator(
        steps = steps,
        variant = UanProgressIndicatorVariant.Numbered,
        modifier = modifier,
        enabled = enabled,
        currentTone = currentTone,
    )
}

/**
 * Wrapper iconografico para compatibilidad con la API inicial.
 */
@Composable
@Suppress("DEPRECATION")
fun UanIconProgress(
    steps: List<UanStepState>,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    currentTone: UanTone = UanTone.Warning,
) {
    val mappedSteps = steps.mapIndexed { index, step ->
        val state = when (step) {
            UanStepState.Pending -> UanProgressStepState.Pending
            UanStepState.InProgress -> UanProgressStepState.Loading
            UanStepState.Completed -> UanProgressStepState.Completed
        }
        UanProgressStep(
            label = "${index + 1}",
            state = state,
            contentDescription = "Paso ${index + 1} de ${steps.size}, ${stepStateDescription(state)}",
        )
    }

    UanProgressIndicator(
        steps = mappedSteps,
        variant = UanProgressIndicatorVariant.Status,
        modifier = modifier,
        enabled = enabled,
        currentTone = currentTone,
    )
}

@Composable
private fun StepNode(
    index: Int,
    totalSteps: Int,
    step: UanProgressStep,
    variant: UanProgressIndicatorVariant,
    enabled: Boolean,
    motionDuration: Int,
    colors: UanProgressStepColors,
    statusIcon: @Composable ((step: UanProgressStep) -> Unit)?,
) {
    val containerColor by animateColorAsState(
        targetValue = colors.containerColor,
        animationSpec = tween(motionDuration),
        label = "progressContainer$index",
    )
    val borderColor by animateColorAsState(
        targetValue = colors.borderColor,
        animationSpec = tween(motionDuration),
        label = "progressBorder$index",
    )
    val contentColor by animateColorAsState(
        targetValue = colors.contentColor,
        animationSpec = tween(motionDuration),
        label = "progressContent$index",
    )

    Box(
        modifier = Modifier
            .defaultMinSize(
                minWidth = UanProgressIndicatorDefaults.stepTouchTarget,
                minHeight = UanProgressIndicatorDefaults.stepTouchTarget,
            )
            .semantics {
                contentDescription = step.contentDescription
                stateDescription = "Paso ${index + 1} de $totalSteps, ${stepStateDescription(step.state)}"
                if (!enabled || step.state == UanProgressStepState.Disabled) disabled()
            },
        contentAlignment = Alignment.Center,
    ) {
        val circleSize = when (variant) {
            UanProgressIndicatorVariant.Numbered ->
                UanProgressIndicatorDefaults.numberedStepSize
            UanProgressIndicatorVariant.Status ->
                UanProgressIndicatorDefaults.statusStepSize
        }

        Box(
            modifier = Modifier
                .size(circleSize)
                .clip(CircleShape)
                .background(containerColor, CircleShape)
                .border(
                    width = UanProgressIndicatorDefaults.stepBorderWidth,
                    color = borderColor,
                    shape = CircleShape,
                ),
            contentAlignment = Alignment.Center,
        ) {
            when (variant) {
                UanProgressIndicatorVariant.Numbered -> {
                    Text(
                        text = step.label,
                        style = UanProgressIndicatorDefaults.numberStyle,
                        color = contentColor,
                    )
                }

                UanProgressIndicatorVariant.Status -> {
                    if (statusIcon != null) {
                        statusIcon(step)
                    } else {
                        DefaultStatusIcon(
                            step = step,
                            tint = contentColor,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DefaultStatusIcon(
    step: UanProgressStep,
    tint: Color,
) {
    val icon = when (step.state) {
        UanProgressStepState.Completed -> Icons.Default.Check
        UanProgressStepState.Current,
        UanProgressStepState.Loading -> Icons.Default.AccessTime
        UanProgressStepState.Warning -> Icons.Default.WarningAmber
        UanProgressStepState.Critical -> Icons.Default.PriorityHigh
        UanProgressStepState.Pending,
        UanProgressStepState.Disabled -> null
    }

    if (icon != null) {
        Icon(
            imageVector = icon,
            contentDescription = step.contentDescription,
            tint = tint,
            modifier = Modifier.size(UanProgressIndicatorDefaults.iconSize),
        )
    }
}

@Composable
private fun ConnectorDots(
    color: Color,
) {
    Row(
        modifier = Modifier.height(UanProgressIndicatorDefaults.connectorHeight),
        horizontalArrangement = Arrangement.spacedBy(
            UanProgressIndicatorDefaults.connectorDotSpacing,
        ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier.width(UanProgressIndicatorDefaults.connectorSideSpacing),
        )
        repeat(UanProgressIndicatorDefaults.connectorDotCount) {
            Box(
                modifier = Modifier
                    .size(UanProgressIndicatorDefaults.connectorDotSize)
                    .clip(CircleShape)
                    .background(color, CircleShape),
            )
        }
        Box(
            modifier = Modifier.width(UanProgressIndicatorDefaults.connectorSideSpacing),
        )
    }
}

@Composable
private fun progressStepColors(
    stepState: UanProgressStepState,
    enabled: Boolean,
    currentTone: UanTone,
): UanProgressStepColors {
    val colors = UanThemeTokens.current.colors
    val disabledBorder = colors.muted.copy(alpha = colors.disabledAlpha)
    val disabledContent = colors.muted.copy(alpha = colors.disabledAlpha)
    val inactiveContainer = colors.background

    val tone = when (stepState) {
        UanProgressStepState.Pending,
        UanProgressStepState.Disabled -> null
        UanProgressStepState.Current,
        UanProgressStepState.Loading -> currentTone
        UanProgressStepState.Completed -> UanTone.Success
        UanProgressStepState.Warning -> UanTone.Warning
        UanProgressStepState.Critical -> UanTone.Critical
    }

    val resolvedColors = if (tone != null) {
        UanProgressStepColors(
            containerColor = inactiveContainer,
            borderColor = tone.colorFor(colors),
            contentColor = tone.contentColorFor(colors),
        )
    } else {
        UanProgressStepColors(
            containerColor = inactiveContainer,
            borderColor = colors.muted,
            contentColor = colors.muted,
        )
    }

    val shouldDisable = !enabled || stepState == UanProgressStepState.Disabled

    return if (shouldDisable) {
        resolvedColors.copy(
            borderColor = disabledBorder,
            contentColor = disabledContent,
        )
    } else if (
        stepState == UanProgressStepState.Completed ||
        stepState == UanProgressStepState.Current
    ) {
        resolvedColors.copy(
            containerColor = resolvedColors.borderColor,
            contentColor = when (stepState) {
                UanProgressStepState.Completed -> UanTone.Success.contentColorFor(colors)
                else -> currentTone.contentColorFor(colors)
            },
        )
    } else {
        resolvedColors
    }
}

private fun connectorColorFor(
    currentStep: UanProgressStepState,
    nextStep: UanProgressStepState,
    enabled: Boolean,
    completedColor: Color,
    colors: com.uan.designsystem.uikit.theme.tokens.UanColors,
): Color {
    val disabledColor = colors.muted.copy(alpha = colors.disabledAlpha)
    return when {
        !enabled ||
            currentStep == UanProgressStepState.Disabled ||
            nextStep == UanProgressStepState.Disabled -> disabledColor
        currentStep == UanProgressStepState.Completed &&
            nextStep == UanProgressStepState.Completed -> completedColor
        currentStep == UanProgressStepState.Completed &&
            nextStep == UanProgressStepState.Current -> completedColor
        currentStep == UanProgressStepState.Completed &&
            nextStep == UanProgressStepState.Loading -> colors.warning
        currentStep == UanProgressStepState.Warning ||
            nextStep == UanProgressStepState.Warning -> colors.warning
        currentStep == UanProgressStepState.Critical ||
            nextStep == UanProgressStepState.Critical -> colors.critical
        else -> colors.muted
    }
}

private fun stepStateDescription(
    state: UanProgressStepState,
): String = when (state) {
    UanProgressStepState.Pending -> "pendiente"
    UanProgressStepState.Current -> "actual"
    UanProgressStepState.Completed -> "completado"
    UanProgressStepState.Loading -> "en progreso"
    UanProgressStepState.Warning -> "advertencia"
    UanProgressStepState.Critical -> "critico"
    UanProgressStepState.Disabled -> "inhabilitado"
}

@Immutable
private data class UanProgressStepColors(
    val containerColor: Color,
    val borderColor: Color,
    val contentColor: Color,
)

