package com.example.redscate.generated.set10

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.redscate.R
import kotlin.math.min

private enum class IndicatorState { INACTIVE, SUCCESS, WARNING }

@Composable
fun LoadingIndicatorSet10(modifier: Modifier = Modifier) {
    FitContent(baseWidth = 240.dp, baseHeight = 430.dp, modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(38.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoadingLegacyHeader()
            LoadingLegacyBody()
        }
    }
}

@Composable
private fun LoadingLegacyHeader() {
    Box(
        modifier = Modifier
            .requiredWidth(80.dp)
            .requiredHeight(124.dp)
    ) {
        DotRowSimple(
            first = Color(0xFF888888),
            second = Color(0xFF888888),
            third = Color(0xFF888888),
            modifier = Modifier.align(Alignment.TopStart).offset(x = 20.dp, y = 20.dp)
        )
        DotRowSimple(
            first = Color(0xFFFDD112),
            second = Color(0xFF888888),
            third = Color(0xFF888888),
            modifier = Modifier.align(Alignment.TopStart).offset(x = 20.dp, y = 58.dp)
        )
        DotRowSimple(
            first = Color(0xFF0DB11B),
            second = Color(0xFF0DB11B),
            third = Color(0xFF0DB11B),
            modifier = Modifier.align(Alignment.TopStart).offset(x = 20.dp, y = 96.dp)
        )
    }
}

@Composable
private fun DotRowSimple(first: Color, second: Color, third: Color, modifier: Modifier = Modifier) {
    Box(modifier = modifier.requiredWidth(44.dp).requiredHeight(8.dp)) {
        Box(Modifier.requiredSize(8.dp).clip(CircleShape).background(first))
        Box(Modifier.offset(x = 18.dp).requiredSize(8.dp).clip(CircleShape).background(second))
        Box(Modifier.offset(x = 36.dp).requiredSize(8.dp).clip(CircleShape).background(third))
    }
}

@Composable
private fun LoadingLegacyBody() {
    Box(
        modifier = Modifier
            .requiredWidth(190.dp)
            .requiredHeight(270.dp)
    ) {
        Box(
            modifier = Modifier.align(Alignment.TopStart).offset(x = 16.dp, y = 20.dp),
        ) {
            Box(
                modifier = Modifier
                    .requiredSize(50.dp)
                    .clip(shape = CircleShape)
                    .border(BorderStroke(2.dp, AppColors.color_RDS_icon_advertence), CircleShape)
                    .drawBehind {
                        val stroke = 2.dp.toPx()
                        val cx = size.width / 2f
                        val cy = size.height / 2f
                        drawLine(
                            color = AppColors.color_RDS_icon_advertence,
                            start = Offset(cx, cy),
                            end = Offset(cx, cy - size.height * 0.28f),
                            strokeWidth = stroke
                        )
                        drawLine(
                            color = AppColors.color_RDS_icon_advertence,
                            start = Offset(cx, cy),
                            end = Offset(cx + size.width * 0.24f, cy),
                            strokeWidth = stroke
                        )
                    }
            )
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 88.dp, y = 0.dp)
                    .requiredSize(50.dp)
                    .clip(shape = CircleShape)
                    .border(
                        border = BorderStroke(2.dp, AppColors.color_RDS_icon_success),
                        shape = CircleShape
                    )
            ) {
                Icon(
                    painter = androidx.compose.ui.res.painterResource(id = R.drawable.vector_loading_indicator),
                    contentDescription = "check",
                    tint = AppColors.color_RDS_icon_success,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .requiredWidth(24.dp)
                        .requiredHeight(16.dp)
                        .offset(y = 1.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 48.dp, y = 128.dp)
                .requiredSize(10.dp)
                .clip(CircleShape)
                .background(AppColors.color_RDS_alert)
        )

        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 40.dp, y = 192.dp)
                .requiredSize(50.dp)
                .clip(shape = CircleShape)
                .border(
                    border = BorderStroke(2.dp, AppColors.color_RDS_outline_inactive),
                    shape = CircleShape
                )
        )
    }
}

@Composable
fun ProgressIndicatorSet10(modifier: Modifier = Modifier) {
    FitContent(baseWidth = 440.dp, baseHeight = 360.dp, modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.offset(x = 14.dp, y = 18.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                StepNumberRow(listOf(false, false, false))
                StepNumberRow(listOf(true, false, false))
                StepNumberRow(listOf(true, true, false))
                StepNumberRow(listOf(true, true, true))
            }

            Column(
                modifier = Modifier.offset(x = 108.dp, y = 18.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                StepNumberRow(listOf(false, false, false, false))
                StepNumberRow(listOf(true, false, false, false))
                StepNumberRow(listOf(true, true, false, false))
                StepNumberRow(listOf(true, true, true, false))
            }

            Column(
                modifier = Modifier.offset(x = 238.dp, y = 14.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                IndicatorChain(listOf(IndicatorState.INACTIVE, IndicatorState.INACTIVE, IndicatorState.INACTIVE))
                IndicatorChain(listOf(IndicatorState.SUCCESS, IndicatorState.INACTIVE, IndicatorState.INACTIVE))
                IndicatorChain(listOf(IndicatorState.SUCCESS, IndicatorState.WARNING, IndicatorState.INACTIVE))
                IndicatorChain(listOf(IndicatorState.SUCCESS, IndicatorState.SUCCESS, IndicatorState.INACTIVE))
                IndicatorChain(listOf(IndicatorState.SUCCESS, IndicatorState.SUCCESS, IndicatorState.WARNING))
                IndicatorChain(listOf(IndicatorState.SUCCESS, IndicatorState.SUCCESS, IndicatorState.SUCCESS))
            }
        }
    }
}

@Composable
private fun FitContent(
    baseWidth: Dp,
    baseHeight: Dp,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val scale = min(maxWidth.value / baseWidth.value, maxHeight.value / baseHeight.value)
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Box(
                modifier = Modifier
                    .requiredWidth(baseWidth)
                    .requiredHeight(baseHeight)
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                    }
            ) {
                content()
            }
        }
    }
}

@Composable
private fun StepNumberRow(states: List<Boolean>) {
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
        states.forEachIndexed { index, active ->
            NumberDot(number = index + 1, active = active)
        }
    }
}

@Composable
private fun NumberDot(number: Int, active: Boolean) {
    val borderColor = if (active) AppColors.color_RDS_success else AppColors.color_RDS_on_surface_container_inactive
    val fillColor = if (active) AppColors.color_RDS_success else Color.Transparent
    val textColor = if (active) AppColors.color_RDS_on_success else AppColors.color_RDS_on_surface_container_inactive
    Box(
        modifier = Modifier
            .requiredSize(18.dp)
            .clip(CircleShape)
            .background(fillColor)
            .border(BorderStroke(1.5.dp, borderColor), CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(number.toString(), color = textColor, fontSize = 9.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun IndicatorChain(states: List<IndicatorState>) {
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
        states.forEachIndexed { index, state ->
            StatusCircle(state)
            if (index != states.lastIndex) {
                DotSeparator(
                    color = if (state == IndicatorState.SUCCESS && states[index + 1] == IndicatorState.SUCCESS) {
                        AppColors.color_RDS_success
                    } else if (states[index + 1] == IndicatorState.WARNING) {
                        AppColors.color_RDS_advertence
                    } else {
                        AppColors.color_RDS_on_surface_container_inactive
                    }
                )
            }
        }
    }
}

@Composable
private fun DotSeparator(color: Color) {
    Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
        repeat(3) {
            Box(
                modifier = Modifier
                    .requiredSize(6.dp)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}

@Composable
private fun StatusCircle(state: IndicatorState) {
    val color = when (state) {
        IndicatorState.INACTIVE -> AppColors.color_RDS_on_surface_container_inactive
        IndicatorState.SUCCESS -> AppColors.color_RDS_success
        IndicatorState.WARNING -> AppColors.color_RDS_advertence
    }
    Box(
        modifier = Modifier
            .requiredSize(36.dp)
            .clip(CircleShape)
            .border(BorderStroke(2.dp, color), CircleShape),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            IndicatorState.SUCCESS -> {
                Icon(
                    painter = androidx.compose.ui.res.painterResource(id = R.drawable.vector_loading_indicator),
                    contentDescription = "success",
                    tint = color,
                    modifier = Modifier.requiredWidth(18.dp).requiredHeight(12.dp)
                )
            }
            IndicatorState.WARNING -> {
                ClockGlyph(color)
            }
            IndicatorState.INACTIVE -> Unit
        }
    }
}

@Composable
private fun ClockGlyph(color: Color) {
    Box(
        modifier = Modifier
            .requiredSize(16.dp)
            .drawBehind {
                val stroke = 1.8.dp.toPx()
                val cx = size.width / 2f
                val cy = size.height / 2f
                drawLine(color = color, start = Offset(cx, cy), end = Offset(cx, cy - size.height * 0.32f), strokeWidth = stroke)
                drawLine(color = color, start = Offset(cx, cy), end = Offset(cx + size.width * 0.26f, cy), strokeWidth = stroke)
            }
    )
}

private fun Modifier.dashedBorder(): Modifier = this.drawBehind {
    val strokeWidth = 1.dp.toPx()
    drawRoundRect(
        color = Color.Transparent,
        topLeft = Offset(strokeWidth / 2f, strokeWidth / 2f),
        size = Size(size.width - strokeWidth, size.height - strokeWidth),
        cornerRadius = CornerRadius(5.dp.toPx(), 5.dp.toPx()),
        style = Stroke(
            width = strokeWidth,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(12f, 8f), 0f)
        )
    )
}

@Composable
fun Propiedad1clock1Set10(modifier: Modifier = Modifier) {
    Box(modifier = modifier.requiredSize(60.dp), contentAlignment = Alignment.Center) {
        StatusCircle(IndicatorState.WARNING)
    }
}

@Composable
fun Property1Component1Set10(modifier: Modifier = Modifier) {
    Box(modifier = modifier.requiredSize(60.dp), contentAlignment = Alignment.Center) {
        StatusCircle(IndicatorState.SUCCESS)
    }
}

@Composable
fun CheckSet10(modifier: Modifier = Modifier) {
    Box(modifier = modifier.requiredSize(60.dp), contentAlignment = Alignment.Center) {
        StatusCircle(IndicatorState.SUCCESS)
    }
}
