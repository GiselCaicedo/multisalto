package com.uan.designsystem.uikit.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.foundation.rememberUanReduceMotion
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Composable
fun UanSheet(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    tone: UanTone = UanTone.Neutral,
    peekHeight: androidx.compose.ui.unit.Dp = UanSheetDefaults.peekHeight,
    maxExpandedHeight: androidx.compose.ui.unit.Dp = UanSheetDefaults.maxExpandedHeight,
    handleContentDescription: String = if (expanded) "Colapsar panel" else "Expandir panel",
    collapsedContent: (@Composable ColumnScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    val tokens = UanThemeTokens.current
    val reduceMotion = rememberUanReduceMotion()
    val motionDuration = if (reduceMotion) 0 else tokens.motion.durationMedium
    val animatedHeight by animateDpAsState(
        targetValue = if (expanded) maxExpandedHeight else peekHeight,
        animationSpec = tween(motionDuration),
        label = "sheetHeight",
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .semantics(mergeDescendants = false) {
                contentDescription = "Sheet contextual"
                stateDescription = if (expanded) "expandido" else "colapsado"
                if (!enabled) disabled()
            },
        contentAlignment = Alignment.BottomCenter,
    ) {
        UanSheetContent(
            expanded = expanded,
            onExpandedChange = onExpandedChange,
            enabled = enabled,
            tone = tone,
            animatedHeight = animatedHeight,
            maxExpandedHeight = maxExpandedHeight,
            handleContentDescription = handleContentDescription,
            collapsedContent = collapsedContent,
            content = content,
        )
    }
}

@Composable
internal fun BoxScope.UanSheetContent(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    enabled: Boolean,
    tone: UanTone,
    animatedHeight: androidx.compose.ui.unit.Dp,
    maxExpandedHeight: androidx.compose.ui.unit.Dp,
    handleContentDescription: String,
    collapsedContent: (@Composable ColumnScope.() -> Unit)?,
    content: @Composable ColumnScope.() -> Unit,
) {
    val containerColor = UanSheetDefaults.containerColor(
        tone = tone,
        enabled = enabled,
    )
    val borderColor = UanSheetDefaults.borderColor(
        tone = tone,
        enabled = enabled,
    )
    val handleContainerColor = UanSheetDefaults.handleContainerColor(
        tone = tone,
        enabled = enabled,
    )
    val colors = UanThemeTokens.current.colors
    val interactionSource = remember { MutableInteractionSource() }
    val shape = RoundedCornerShape(
        topStart = UanSheetDefaults.containerCornerRadius,
        topEnd = UanSheetDefaults.containerCornerRadius,
    )

    Box(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(
                    min = UanSheetDefaults.minHeight,
                    max = maxExpandedHeight,
                )
                .height(animatedHeight + UanSheetDefaults.handleOffset)
                .padding(top = UanSheetDefaults.handleOffset)
                .clip(shape)
                .background(containerColor, shape)
                .border(
                    width = UanSheetDefaults.borderWidth,
                    color = borderColor,
                    shape = shape,
                )
                .alpha(if (enabled) 1f else UanInteractiveDefaults.disabledAlpha),
            verticalArrangement = Arrangement.Top,
        ) {
            Spacer(Modifier.height(UanSheetDefaults.contentPaddingVertical))
            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn(tween()),
                exit = fadeOut(tween()),
            ) {
                Column(
                    modifier = Modifier.padding(
                        horizontal = UanSheetDefaults.contentPaddingHorizontal,
                    ),
                    verticalArrangement = Arrangement.spacedBy(
                        UanSheetDefaults.contentSpacing,
                    ),
                    content = content,
                )
            }
            AnimatedVisibility(
                visible = !expanded && collapsedContent != null,
                enter = fadeIn(tween()),
                exit = fadeOut(tween()),
            ) {
                Column(
                    modifier = Modifier.padding(
                        horizontal = UanSheetDefaults.contentPaddingHorizontal,
                    ),
                    verticalArrangement = Arrangement.spacedBy(
                        UanSheetDefaults.contentSpacing,
                    ),
                    content = collapsedContent ?: {},
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = UanSheetDefaults.handleOffset / 2)
                .defaultMinSize(
                    minWidth = UanInteractiveDefaults.minTouchTarget,
                    minHeight = UanInteractiveDefaults.minTouchTarget,
                )
                .clip(CircleShape)
                .background(handleContainerColor, CircleShape)
                .border(
                    width = UanSheetDefaults.borderWidth,
                    color = borderColor,
                    shape = CircleShape,
                )
                .clickable(
                    enabled = enabled,
                    interactionSource = interactionSource,
                    indication = null,
                    role = Role.Button,
                    onClick = { onExpandedChange(!expanded) },
                )
                .semantics {
                    role = Role.Button
                    contentDescription = handleContentDescription
                    stateDescription = if (expanded) "expandido" else "colapsado"
                    if (!enabled) disabled()
                },
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = if (expanded) {
                    Icons.Default.KeyboardArrowDown
                } else {
                    Icons.Default.KeyboardArrowUp
                },
                contentDescription = handleContentDescription,
                tint = colors.onSurface,
                modifier = Modifier.size(UanSheetDefaults.handleIconSize),
            )
        }
    }
}

@Composable
fun UanSheetTitle(
    title: String,
    modifier: Modifier = Modifier,
) {
    val colors = UanThemeTokens.current.colors
    Text(
        text = title,
        modifier = modifier,
        style = UanSheetDefaults.titleStyle,
        color = colors.onSurface,
    )
}

@Composable
fun UanSheetBody(
    text: String,
    modifier: Modifier = Modifier,
) {
    val colors = UanThemeTokens.current.colors
    Text(
        text = text,
        modifier = modifier,
        style = UanSheetDefaults.bodyStyle,
        color = colors.muted,
    )
}

