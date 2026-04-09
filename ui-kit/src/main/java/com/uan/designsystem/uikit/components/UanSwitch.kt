package com.uan.designsystem.uikit.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness2
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.uan.designsystem.uikit.foundation.rememberUanReduceMotion
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Composable
fun UanSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    tone: UanTone = UanTone.Info,
    checkedContentDescription: String = "Activado",
    uncheckedContentDescription: String = "Desactivado",
    checkedContent: (@Composable () -> Unit)? = null,
    uncheckedContent: (@Composable () -> Unit)? = null,
) {
    val tokens = UanThemeTokens.current
    val reduceMotion = rememberUanReduceMotion()
    val motionDuration = if (reduceMotion) 0 else tokens.motion.durationShort
    val interactionSource = MutableInteractionSource()

    val trackBorderColor by animateColorAsState(
        targetValue = UanSwitchDefaults.trackBorderColor(
            checked = checked,
            enabled = enabled,
            tone = tone,
        ),
        animationSpec = tween(motionDuration),
        label = "switchTrackBorder",
    )
    val trackContainerColor by animateColorAsState(
        targetValue = UanSwitchDefaults.trackContainerColor(
            checked = checked,
            enabled = enabled,
            tone = tone,
        ),
        animationSpec = tween(motionDuration),
        label = "switchTrackContainer",
    )
    val thumbContainerColor by animateColorAsState(
        targetValue = UanSwitchDefaults.thumbContainerColor(
            checked = checked,
            enabled = enabled,
            tone = tone,
        ),
        animationSpec = tween(motionDuration),
        label = "switchThumbContainer",
    )
    val activeIconColor by animateColorAsState(
        targetValue = UanSwitchDefaults.activeIconColor(
            enabled = enabled,
            tone = tone,
        ),
        animationSpec = tween(motionDuration),
        label = "switchActiveIcon",
    )
    val inactiveIconColor by animateColorAsState(
        targetValue = UanSwitchDefaults.inactiveIconColor(
            enabled = enabled,
        ),
        animationSpec = tween(motionDuration),
        label = "switchInactiveIcon",
    )

    val thumbOffset by animateDpAsState(
        targetValue = if (checked) {
            (UanSwitchDefaults.trackWidth -
                UanSwitchDefaults.thumbSize -
                UanSwitchDefaults.trackPadding * 2)
        } else {
            0.dp
        },
        animationSpec = tween(motionDuration),
        label = "switchThumbOffset",
    )

    Box(
        modifier = modifier
            .defaultMinSize(
                minWidth = UanInteractiveDefaults.minTouchTarget,
                minHeight = UanInteractiveDefaults.minTouchTarget,
            )
            .toggleable(
                value = checked,
                enabled = enabled,
                role = Role.Switch,
                interactionSource = interactionSource,
                indication = null,
                onValueChange = onCheckedChange,
            )
            .semantics {
                role = Role.Switch
                contentDescription = if (checked) {
                    checkedContentDescription
                } else {
                    uncheckedContentDescription
                }
                stateDescription = if (checked) "activado" else "desactivado"
                if (!enabled) disabled()
            },
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .size(
                    width = UanSwitchDefaults.trackWidth,
                    height = UanSwitchDefaults.trackHeight,
                )
                .clip(RoundedCornerShape(percent = 50))
                .background(
                    color = trackContainerColor,
                    shape = RoundedCornerShape(percent = 50),
                )
                .border(
                    width = UanSwitchDefaults.borderWidth,
                    color = trackBorderColor,
                    shape = RoundedCornerShape(percent = 50),
                )
                .alpha(if (enabled) 1f else UanInteractiveDefaults.disabledAlpha),
            contentAlignment = Alignment.CenterStart,
        ) {
            // Icons layer (behind the thumb)
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = UanSwitchDefaults.trackPadding + UanSwitchDefaults.iconInset),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                val leftContent = uncheckedContent
                if (leftContent != null) {
                    Box(
                        modifier = Modifier.size(UanSwitchDefaults.iconSize),
                        contentAlignment = Alignment.Center,
                    ) {
                        leftContent()
                    }
                } else {
                    Icon(
                        imageVector = Icons.Default.LightMode,
                        contentDescription = uncheckedContentDescription,
                        tint = if (checked) inactiveIconColor else activeIconColor,
                        modifier = Modifier.size(UanSwitchDefaults.iconSize),
                    )
                }

                val rightContent = checkedContent
                if (rightContent != null) {
                    Box(
                        modifier = Modifier.size(UanSwitchDefaults.iconSize),
                        contentAlignment = Alignment.Center,
                    ) {
                        rightContent()
                    }
                } else {
                    Icon(
                        imageVector = Icons.Default.Brightness2,
                        contentDescription = checkedContentDescription,
                        tint = if (checked) activeIconColor else inactiveIconColor,
                        modifier = Modifier.size(UanSwitchDefaults.iconSize),
                    )
                }
            }

            // Thumb layer (on top of icons, vertically centered via parent contentAlignment)
            Box(
                modifier = Modifier
                    .padding(horizontal = UanSwitchDefaults.trackPadding)
                    .offset(x = thumbOffset)
                    .size(UanSwitchDefaults.thumbSize)
                    .clip(CircleShape)
                    .background(thumbContainerColor, CircleShape),
            )
        }
    }
}

