package com.uan.designsystem.uikit.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.triStateToggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.foundation.rememberUanReduceMotion
import com.uan.designsystem.uikit.theme.UanThemeTokens

enum class UanCheckboxState {
    Unchecked,
    Checked,
    Indeterminate,
}

@Composable
fun UanCheckbox(
    state: UanCheckboxState,
    onStateChange: (UanCheckboxState) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    tone: UanTone = UanTone.Info,
    checkedContentDescription: String = "Seleccionado",
    uncheckedContentDescription: String = "No seleccionado",
    indeterminateContentDescription: String = "Seleccion parcial",
    checkedContent: (@Composable () -> Unit)? = null,
    indeterminateContent: (@Composable () -> Unit)? = null,
) {
    val tokens = UanThemeTokens.current
    val reduceMotion = rememberUanReduceMotion()
    val motionDuration = if (reduceMotion) 0 else tokens.motion.durationShort
    val interactionSource = remember { MutableInteractionSource() }

    val containerColor by animateColorAsState(
        targetValue = UanCheckboxDefaults.containerColor(
            state = state,
            enabled = enabled,
            tone = tone,
        ),
        animationSpec = tween(motionDuration),
        label = "checkboxContainer",
    )
    val borderColor by animateColorAsState(
        targetValue = UanCheckboxDefaults.borderColor(
            state = state,
            enabled = enabled,
            tone = tone,
        ),
        animationSpec = tween(motionDuration),
        label = "checkboxBorder",
    )
    val contentColor by animateColorAsState(
        targetValue = UanCheckboxDefaults.contentColor(
            state = state,
            enabled = enabled,
            tone = tone,
        ),
        animationSpec = tween(motionDuration),
        label = "checkboxContent",
    )

    val nextState = when (state) {
        UanCheckboxState.Unchecked -> UanCheckboxState.Checked
        UanCheckboxState.Checked -> UanCheckboxState.Unchecked
        UanCheckboxState.Indeterminate -> UanCheckboxState.Checked
    }

    Box(
        modifier = modifier
            .defaultMinSize(
                minWidth = UanInteractiveDefaults.minTouchTarget,
                minHeight = UanInteractiveDefaults.minTouchTarget,
            )
            .triStateToggleable(
                state = state.toToggleableState(),
                enabled = enabled,
                role = Role.Checkbox,
                interactionSource = interactionSource,
                indication = null,
                onClick = { onStateChange(nextState) },
            )
            .semantics {
                role = Role.Checkbox
                contentDescription = when (state) {
                    UanCheckboxState.Checked -> checkedContentDescription
                    UanCheckboxState.Unchecked -> uncheckedContentDescription
                    UanCheckboxState.Indeterminate -> indeterminateContentDescription
                }
                stateDescription = when (state) {
                    UanCheckboxState.Checked -> "seleccionado"
                    UanCheckboxState.Unchecked -> "no seleccionado"
                    UanCheckboxState.Indeterminate -> "indeterminado"
                }
                if (!enabled) disabled()
            },
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .size(UanCheckboxDefaults.containerSize)
                .clip(RoundedCornerShape(6.dp))
                .background(
                    color = containerColor,
                    shape = RoundedCornerShape(6.dp),
                )
                .border(
                    width = UanCheckboxDefaults.borderWidth,
                    color = borderColor,
                    shape = RoundedCornerShape(6.dp),
                )
                .alpha(if (enabled) 1f else UanInteractiveDefaults.disabledAlpha),
            contentAlignment = Alignment.Center,
        ) {
            when (state) {
                UanCheckboxState.Checked -> {
                    if (checkedContent != null) {
                        checkedContent()
                    } else {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = checkedContentDescription,
                            tint = contentColor,
                            modifier = Modifier.size(UanCheckboxDefaults.iconSize),
                        )
                    }
                }

                UanCheckboxState.Indeterminate -> {
                    if (indeterminateContent != null) {
                        indeterminateContent()
                    } else {
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = indeterminateContentDescription,
                            tint = contentColor,
                            modifier = Modifier.size(UanCheckboxDefaults.iconSize),
                        )
                    }
                }

                UanCheckboxState.Unchecked -> Unit
            }
        }
    }
}

private fun UanCheckboxState.toToggleableState(): ToggleableState = when (this) {
    UanCheckboxState.Unchecked -> ToggleableState.Off
    UanCheckboxState.Checked -> ToggleableState.On
    UanCheckboxState.Indeterminate -> ToggleableState.Indeterminate
}

