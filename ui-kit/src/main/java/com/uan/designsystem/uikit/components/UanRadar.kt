package com.uan.designsystem.uikit.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.foundation.rememberUanReduceMotion
import com.uan.designsystem.uikit.theme.UanThemeTokens
import kotlin.math.max
import kotlin.math.min

enum class UanRadarState {
    Inactive,
    Active,
    Critical,
    Disabled,
}

@Immutable
data class UanRadarRange(
    val distanceMeters: Float,
    val label: String,
)

@Composable
fun UanRadar(
    distanceMeters: Float,
    distanceRanges: List<UanRadarRange>,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    tone: UanTone = UanTone.Info,
    state: UanRadarState = UanRadarState.Active,
    showScaleLabels: Boolean = false,
    targetContentDescription: String = "Objetivo detectado",
    targetContent: (@Composable () -> Unit)? = null,
) {
    val tokens = UanThemeTokens.current
    val reduceMotion = rememberUanReduceMotion()
    val pulseDuration = if (reduceMotion) 0 else tokens.motion.durationEmphasis
    val ringColor = UanRadarDefaults.ringColor(
        tone = tone,
        state = state,
        enabled = enabled,
    )
    val targetContainerColor = UanRadarDefaults.targetContainerColor(
        tone = tone,
        state = state,
        enabled = enabled,
    )
    val targetContentColor = UanRadarDefaults.targetContentColor(
        tone = tone,
        state = state,
        enabled = enabled,
    )
    val effectiveState = if (enabled) state else UanRadarState.Disabled
    val sortedRanges = remember(distanceRanges) {
        distanceRanges.sortedBy { it.distanceMeters }
    }
    val maxDistance = remember(sortedRanges) {
        max(sortedRanges.maxOfOrNull { range: UanRadarRange -> range.distanceMeters } ?: 1f, 1f)
    }
    val safeDistance = distanceMeters.coerceAtLeast(0f)
    val normalizedDistance = min(safeDistance / maxDistance, 1f)
    val labelSpacingFromRing = UanRadarDefaults.labelSpacingFromRing
    val targetSize = UanRadarDefaults.targetSize
    val ringStrokeWidth = UanRadarDefaults.ringStrokeWidth

    val transition = rememberInfiniteTransition(label = "radarPulse")
    val pulseAlpha by transition.animateFloat(
        initialValue = 0.92f,
        targetValue = if (effectiveState == UanRadarState.Critical) 0.45f else 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = pulseDuration),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "radarPulseAlpha",
    )
    val resolvedPulseAlpha = if (reduceMotion || effectiveState != UanRadarState.Critical) {
        1f
    } else {
        pulseAlpha
    }

    BoxWithConstraints(
        modifier = modifier
            .defaultMinSize(
                minWidth = UanRadarDefaults.minSize,
                minHeight = UanRadarDefaults.minSize,
            )
            .semantics(mergeDescendants = false) {
                contentDescription = targetContentDescription
                stateDescription = radarStateDescription(
                    distanceMeters = safeDistance,
                    state = effectiveState,
                )
                if (!enabled || effectiveState == UanRadarState.Disabled) disabled()
            },
        contentAlignment = Alignment.Center,
    ) {
        val canvasSize = if (maxWidth <= maxHeight) maxWidth else maxHeight
        val ringCount = max(sortedRanges.size, 1)
        val labelClearance = if (showScaleLabels) {
            8.dp + labelSpacingFromRing
        } else {
            0.dp
        }
        val availableRadius = canvasSize / 2 - labelClearance
        val minimumRadius = targetSize * 1.5f
        val maxRadius = if (availableRadius >= minimumRadius) availableRadius else minimumRadius

        Canvas(
            modifier = Modifier.fillMaxSize(),
        ) {
            val center = Offset(size.width / 2f, size.height / 2f)
            val strokeWidth = ringStrokeWidth.toPx()
            val maxRadiusPx = maxRadius.toPx()
            val ringSpacingPx = if (ringCount > 0) maxRadiusPx / ringCount else maxRadiusPx

            repeat(ringCount) { index ->
                val radius = maxRadiusPx - ringSpacingPx * index
                drawCircle(
                    color = ringColor.copy(
                        alpha = ringAlphaFor(index = index, state = effectiveState) * resolvedPulseAlpha,
                    ),
                    radius = radius,
                    center = center,
                    style = Stroke(width = strokeWidth),
                )
            }
        }

        if (showScaleLabels) {
            sortedRanges.forEachIndexed { index, range ->
                val radiusFraction = (index + 1).toFloat() / ringCount.toFloat()
                val offsetY = -(maxRadius * radiusFraction) - labelSpacingFromRing
                RadarScaleLabel(
                    text = range.label,
                    tone = tone,
                    state = effectiveState,
                    enabled = enabled,
                    modifier = Modifier.align(Alignment.Center)
                        .graphicsLayer { translationY = offsetY.toPx() },
                )
            }
        }

        Box(
            modifier = Modifier
                .size(targetSize)
                .clip(CircleShape)
                .background(targetContainerColor, CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            val content = targetContent
            if (content != null) {
                content()
            } else {
                Icon(
                    imageVector = Icons.Default.Navigation,
                    contentDescription = targetContentDescription,
                    tint = targetContentColor,
                    modifier = Modifier
                        .size(UanRadarDefaults.targetIconSize)
                        .graphicsLayer { rotationZ = -90f },
                )
            }
        }
    }
}

@Composable
private fun RadarScaleLabel(
    text: String,
    tone: UanTone,
    state: UanRadarState,
    enabled: Boolean,
    modifier: Modifier = Modifier,
) {
    val containerColor = UanRadarDefaults.labelContainerColor(
        tone = tone,
        state = state,
        enabled = enabled,
    )
    val contentColor = UanRadarDefaults.labelContentColor(
        tone = tone,
        state = state,
        enabled = enabled,
    )

    Text(
        text = text,
        style = UanRadarDefaults.labelTextStyle,
        color = contentColor,
        modifier = modifier
            .clip(RoundedCornerShape(UanRadarDefaults.labelCornerRadius))
            .background(containerColor.copy(alpha = 0.85f))
            .padding(
                horizontal = UanRadarDefaults.labelHorizontalPadding,
                vertical = UanRadarDefaults.labelVerticalPadding,
            ),
    )
}

private fun ringAlphaFor(
    index: Int,
    state: UanRadarState,
): Float = when (state) {
    UanRadarState.Inactive -> 0.55f - index * 0.08f
    UanRadarState.Active -> 1f - index * 0.1f
    UanRadarState.Critical -> 1f - index * 0.06f
    UanRadarState.Disabled -> 0.35f
}.coerceAtLeast(0.2f)

private fun radarStateDescription(
    distanceMeters: Float,
    state: UanRadarState,
): String {
    val roundedDistance = distanceMeters.toInt()
    return when (state) {
        UanRadarState.Inactive -> "radar inactivo, ultima distancia $roundedDistance metros"
        UanRadarState.Active -> "objetivo a $roundedDistance metros"
        UanRadarState.Critical -> "proximidad critica, objetivo a $roundedDistance metros"
        UanRadarState.Disabled -> "radar inhabilitado"
    }
}

