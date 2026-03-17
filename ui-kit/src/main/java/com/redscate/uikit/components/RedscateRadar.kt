package com.redscate.uikit.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.redscate.uikit.theme.RedscateThemeTokens

private val RadarRingRatios = listOf(1f, 0.75f, 0.5f, 0.25f)

@Composable
fun RedscateRadar(
    modifier: Modifier = Modifier,
    selectedDistance: Int? = null,
    distanceOptions: List<Int> = emptyList(),
    pulsing: Boolean = true,
    onDistanceSelected: (Int) -> Unit = {}
) {
    val tokens = RedscateThemeTokens.current
    val transition = rememberInfiniteTransition(label = "redscate-radar")
    val pulseAlpha by transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(tween(1200), RepeatMode.Reverse),
        label = "redscate-radar-alpha"
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        if (distanceOptions.isNotEmpty()) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                distanceOptions.forEach { distance ->
                    val selected = distance == selectedDistance
                    Box(
                        modifier = Modifier
                            .background(
                                color = if (selected) tokens.colors.outline else tokens.colors.surface,
                                shape = RoundedCornerShape(tokens.shapes.pillRadius)
                            )
                            .clickable { onDistanceSelected(distance) }
                            .padding(horizontal = 10.dp, vertical = 5.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "$distance m",
                            color = if (selected) tokens.colors.background else tokens.colors.onSurface,
                            style = tokens.typography.supporting
                        )
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.size(220.dp)) {
                val strokeWidth = 3.dp.toPx()
                val center = Offset(size.width / 2f, size.height / 2f)
                val maxRadius = size.minDimension / 2f - strokeWidth
                RadarRingRatios.forEachIndexed { index, ratio ->
                    drawCircle(
                        color = if (pulsing && index == 1) {
                            tokens.colors.primary.copy(alpha = pulseAlpha)
                        } else {
                            tokens.colors.outline
                        },
                        radius = maxRadius * ratio,
                        center = center,
                        style = Stroke(width = strokeWidth)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .background(tokens.colors.primary, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+",
                    color = tokens.colors.onPrimary,
                    style = tokens.typography.label
                )
            }
        }
    }
}
