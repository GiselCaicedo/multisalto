package com.example.redscate.generated.set2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.redscate.R

private data class BtnSpec(
    val widthFraction: Float,
    val container: Color,
    val border: Color,
    val label: Color
)

@Composable
fun ButtonsSet2(modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier = modifier.fillMaxWidth()) {
        val compact = maxWidth < 420.dp
        val rowSpacing = if (compact) 10.dp else 12.dp
        val pillHeight = if (compact) 30.dp else 36.dp
        val textSize = if (compact) 11.sp else 14.sp
        val iconSize = if (compact) 11.dp else 13.dp
        val specs = listOf(
            BtnSpec(0.34f, Color(0xFF2F2F2F), Color(0xFF6F737A), Color(0xFF888888)),
            BtnSpec(0.46f, Color(0xFF2F2F2F), Color(0xFF6F737A), Color(0xFF888888)),
            BtnSpec(0.58f, Color(0xFF2F2F2F), Color(0xFF6F737A), Color(0xFF888888)),
            BtnSpec(0.70f, Color(0xFF2F2F2F), Color(0xFF6F737A), Color(0xFF888888)),
            BtnSpec(0.82f, Color(0xFF2F2F2F), Color(0xFF6F737A), Color(0xFF888888)),
            BtnSpec(0.34f, Color(0xFF2F2F2F), Color(0xFFF6F6F6), Color(0xFFF6F6F6)),
            BtnSpec(0.46f, Color(0xFF2F2F2F), Color(0xFFF6F6F6), Color(0xFFF6F6F6)),
            BtnSpec(0.58f, Color(0xFF2F2F2F), Color(0xFFF6F6F6), Color(0xFFF6F6F6)),
            BtnSpec(0.70f, Color(0xFF2F2F2F), Color(0xFFF6F6F6), Color(0xFFF6F6F6)),
            BtnSpec(0.82f, Color(0xFF2F2F2F), Color(0xFFF6F6F6), Color(0xFFF6F6F6)),
            BtnSpec(0.34f, Color(0xFFFF2330), Color(0xFFF6F6F6), Color(0xFFF6F6F6)),
            BtnSpec(0.52f, Color(0xFFFF2330), Color(0xFFF6F6F6), Color(0xFFF6F6F6)),
            BtnSpec(0.70f, Color(0xFFFF2330), Color(0xFFF6F6F6), Color(0xFFF6F6F6)),
            BtnSpec(0.82f, Color(0xFFFF2330), Color(0xFFF6F6F6), Color(0xFFF6F6F6)),
            BtnSpec(0.34f, Color(0xFF0DB11B), Color(0xFFF6F6F6), Color(0xFFF6F6F6)),
            BtnSpec(0.52f, Color(0xFF0DB11B), Color(0xFFF6F6F6), Color(0xFFF6F6F6)),
            BtnSpec(0.70f, Color(0xFF0DB11B), Color(0xFFF6F6F6), Color(0xFFF6F6F6)),
            BtnSpec(0.82f, Color(0xFF0DB11B), Color(0xFFF6F6F6), Color(0xFFF6F6F6))
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(rowSpacing),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            specs.forEach { spec ->
                ResponsiveButtonPill(
                    widthFraction = spec.widthFraction,
                    height = pillHeight,
                    textSize = textSize,
                    iconSize = iconSize,
                    container = spec.container,
                    border = spec.border,
                    label = spec.label
                )
            }
        }
    }
}

@Composable
private fun ResponsiveButtonPill(
    widthFraction: Float,
    height: androidx.compose.ui.unit.Dp,
    textSize: androidx.compose.ui.unit.TextUnit,
    iconSize: androidx.compose.ui.unit.Dp,
    container: Color,
    border: Color,
    label: Color
) {
    BoxWithConstraints(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        val w = maxWidth * widthFraction
        Row(
            modifier = Modifier
                .width(w)
                .height(height)
                .clip(RoundedCornerShape(8.dp))
                .background(container)
                .border(2.dp, border, RoundedCornerShape(8.dp)),
            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "Icon",
                tint = label,
                modifier = Modifier
                    .requiredSize(iconSize)
                    .border(BorderStroke(1.dp, label), RoundedCornerShape(50))
            )
            Text(
                text = "LABEL",
                color = label,
                fontSize = textSize,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
