package com.redscate.uikit.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.redscate.uikit.theme.RedscateThemeTokens
import kotlin.math.sqrt

private data class ActivationNode(
    val x: Float,
    val y: Float,
    val large: Boolean = false
)

@Composable
fun RedscateActivationAnimation(
    modifier: Modifier = Modifier
) {
    val tokens = RedscateThemeTokens.current
    val transition = rememberInfiniteTransition(label = "redscate-activation")
    val phase by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(3000, easing = LinearEasing), RepeatMode.Restart),
        label = "redscate-activation-phase"
    )
    val points = mapOf(
        "n" to ActivationNode(0.50f, 0.08f),
        "wt" to ActivationNode(0.15f, 0.30f),
        "et" to ActivationNode(0.85f, 0.30f),
        "c" to ActivationNode(0.50f, 0.50f, true),
        "wb" to ActivationNode(0.15f, 0.72f),
        "eb" to ActivationNode(0.85f, 0.72f),
        "s" to ActivationNode(0.50f, 0.92f)
    )
    val edges = listOf(
        "n" to "wt", "n" to "et", "n" to "c",
        "wt" to "c", "et" to "c",
        "c" to "wb", "c" to "eb", "c" to "s",
        "wb" to "s", "eb" to "s",
        "wt" to "wb", "et" to "eb"
    )

    Canvas(modifier = modifier) {
        fun xy(node: ActivationNode) = Offset(node.x * size.width, node.y * size.height)

        edges.forEach { (aKey, bKey) ->
            val a = xy(points.getValue(aKey))
            val b = xy(points.getValue(bKey))
            repeat(11) { step ->
                val t = step / 10f
                val active = phase >= t
                drawCircle(
                    color = if (active) tokens.colors.primary else tokens.colors.muted,
                    radius = if (active) 5.5f else 4.5f,
                    center = Offset(
                        x = a.x + (b.x - a.x) * t,
                        y = a.y + (b.y - a.y) * t
                    )
                )
            }
        }

        points.values.forEach { node ->
            val dx = node.x - 0.5f
            val dy = node.y - 0.5f
            val distance = sqrt(dx * dx + dy * dy)
            val threshold = when {
                node.large -> 0f
                distance <= 0.35f -> 0.35f
                else -> 0.6f
            }
            val active = phase >= threshold
            drawCircle(
                color = if (active) tokens.colors.primary else tokens.colors.surface,
                radius = if (node.large) 28.dp.toPx() else 16.dp.toPx(),
                center = xy(node),
                style = Fill
            )
            drawCircle(
                color = if (active) tokens.colors.primary else tokens.colors.outline,
                radius = if (node.large) 32.dp.toPx() else 18.dp.toPx(),
                center = xy(node),
                style = Stroke(width = 4.dp.toPx())
            )
        }
    }
}
