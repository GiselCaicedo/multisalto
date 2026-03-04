package com.example.redscate.generated.set15

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import com.example.redscate.R

private val RadarRingRatios = listOf(1.00f, 0.75f, 0.50f, 0.25f)

@Composable
fun RadarSet15(modifier: Modifier = Modifier) {
    val scroll = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(scroll)
            .padding(vertical = 18.dp),
        verticalArrangement = Arrangement.spacedBy(56.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RadarItem(color = Color(0xFF888888), stroke = 2f, marker = R.drawable.ic_radar_vector_outlined, pulse = false)
        RadarItem(color = Color(0xFF37B2FF), stroke = 4f, marker = R.drawable.ic_radar_vector_filled, pulse = true)
        RadarWithDistanceLabels()
    }
}

@Composable
private fun RadarWithDistanceLabels() {
    var selected by remember { mutableStateOf(50) }
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        val isWide = maxWidth > 330.dp
        val size = if (isWide) 230.dp else 185.dp
        val markerSize = if (isWide) 34.dp else 28.dp
        Box(modifier = Modifier.requiredSize(size), contentAlignment = Alignment.Center) {
            RadarRings(size = size, color = Color(0xFFF6F6F6), stroke = 4f, pulse = false)
            Image(
                painter = painterResource(id = R.drawable.ic_radar_vector_filled),
                contentDescription = "radar marker",
                modifier = Modifier.requiredSize(markerSize)
            )

            val labelWidth = 46.dp
            val labelHeight = 22.dp
            val labels = listOf(200, 150, 100, 50)
            labels.forEachIndexed { i, d ->
                val active = selected == d
                val radius = (size / 2f) * RadarRingRatios[i]
                val yOffset = (size / 2f) - radius - (labelHeight / 2f)
                Box(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .offset(y = yOffset)
                        .width(labelWidth)
                        .height(labelHeight)
                        .background(if (active) Color(0xFFF6F6F6) else Color(0xFFE5E5E5), RoundedCornerShape(999.dp))
                        .clickable { selected = d },
                    contentAlignment = Alignment.Center
                ) {
                    Text("$d m", color = Color(0xFF333333), fontSize = 10.sp)
                }
            }
        }
    }
}

@Composable
private fun RadarItem(
    color: Color,
    stroke: Float,
    marker: Int,
    pulse: Boolean
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        val size = if (maxWidth > 330.dp) 230.dp else 185.dp
        val markerSize = if (maxWidth > 330.dp) 34.dp else 28.dp
        Box(modifier = Modifier.requiredSize(size), contentAlignment = Alignment.Center) {
            RadarRings(size = size, color = color, stroke = stroke, pulse = pulse)
            Image(
                painter = painterResource(id = marker),
                contentDescription = "radar marker",
                modifier = Modifier.requiredSize(markerSize)
            )
        }
    }
}

@Composable
private fun RadarRings(
    size: androidx.compose.ui.unit.Dp,
    color: Color,
    stroke: Float,
    pulse: Boolean
) {
    val transition = rememberInfiniteTransition(label = "radar")
    val pulseAlpha by transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(tween(1200), repeatMode = RepeatMode.Reverse),
        label = "pulse"
    )
    Canvas(modifier = Modifier.requiredSize(size)) {
        val center = Offset(size.toPx() / 2f, size.toPx() / 2f)
        val maxRadius = size.toPx() / 2f - stroke / 2f
        RadarRingRatios.forEachIndexed { index, ratio ->
            drawCircle(
                color = if (pulse && index == 1) color.copy(alpha = pulseAlpha) else color,
                radius = maxRadius * ratio,
                center = center,
                style = Stroke(width = stroke)
            )
        }
    }
}
