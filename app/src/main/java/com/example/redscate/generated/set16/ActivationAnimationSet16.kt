package com.example.redscate.generated.set16

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.redscate.R

@Composable
fun ActivationAnimationSet16(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(label = "activation")
    val phase by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(3000, easing = LinearEasing), RepeatMode.Restart),
        label = "phase"
    )

    BoxWithConstraints(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        val base = if (maxWidth < 360.dp) maxWidth else 360.dp
        Box(modifier = Modifier.requiredSize(base)) {
            val points = mapOf(
                "n" to P(0.50f, 0.08f),
                "wt" to P(0.15f, 0.30f),
                "et" to P(0.85f, 0.30f),
                "c" to P(0.50f, 0.50f),
                "wb" to P(0.15f, 0.72f),
                "eb" to P(0.85f, 0.72f),
                "s" to P(0.50f, 0.92f)
            )

            val edges = listOf(
                "n" to "wt", "n" to "et", "n" to "c",
                "wt" to "c", "et" to "c",
                "c" to "wb", "c" to "eb", "c" to "s",
                "wb" to "s", "eb" to "s",
                "wt" to "wb", "et" to "eb"
            )

            Canvas(modifier = Modifier.requiredSize(base)) {
                val blue = Color(0xFF37B2FF)
                val gray = Color(0xFF8A8F98)

                fun xy(p: P) = Offset(p.x * size.width, p.y * size.height)

                edges.forEach { (aKey, bKey) ->
                    val a = xy(points.getValue(aKey))
                    val b = xy(points.getValue(bKey))
                    val dots = 10
                    for (i in 0..dots) {
                        val t = i.toFloat() / dots
                        val x = a.x + (b.x - a.x) * t
                        val y = a.y + (b.y - a.y) * t
                        val active = phase >= t
                        drawCircle(
                            color = if (active) blue else gray,
                            radius = if (active) 6f else 5f,
                            center = Offset(x, y)
                        )
                    }
                }
            }

            val nodeOrder = listOf("n", "wt", "et", "c", "wb", "eb", "s")
            nodeOrder.forEach { key ->
                val p = points.getValue(key)
                val dx = p.x - 0.5f
                val dy = p.y - 0.5f
                val distance = kotlin.math.sqrt(dx * dx + dy * dy)
                val activationThreshold = when {
                    key == "c" -> 0.0f
                    distance <= 0.35f -> 0.35f
                    else -> 0.6f
                }
                Node(base, p, big = key == "c", active = phase >= activationThreshold)
            }
        }
    }
}

@Composable
private fun Node(canvas: Dp, p: P, big: Boolean, active: Boolean) {
    val s = if (big) 66.dp else 38.dp
    val x = canvas * p.x - s / 2f
    val y = canvas * p.y - s / 2f
    Image(
        painter = painterResource(id = if (active) R.drawable.ic_antenna_filled else R.drawable.ic_antenna_outlined),
        contentDescription = "node",
        modifier = Modifier
            .offset(x = x, y = y)
            .requiredSize(s)
    )
}

private data class P(val x: Float, val y: Float)
