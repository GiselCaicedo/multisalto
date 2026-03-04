package com.example.redscate.generated.set2

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ButtonsIconSet2(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(horizontal = 6.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        FlowRow(horizontalArrangement = Arrangement.spacedBy(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            CrossBadge(active = false)
            CircleCounter(state = CounterState.Inactive)
            IconRectButton(width = 78.dp, height = 78.dp, active = true, icons = 1)
            IconRectButton(width = 78.dp, height = 78.dp, active = false, icons = 1)
        }

        FlowRow(horizontalArrangement = Arrangement.spacedBy(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            CrossBadge(active = true)
            CircleCounter(state = CounterState.Neutral)
            IconRectButton(width = 122.dp, height = 62.dp, active = true, icons = 2)
            IconRectButton(width = 122.dp, height = 62.dp, active = false, icons = 2)
        }

        FlowRow(horizontalArrangement = Arrangement.spacedBy(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            CircleCounter(state = CounterState.Blue)
            IconCard(active = true)
            IconCard(active = false)
        }

        FlowRow(horizontalArrangement = Arrangement.spacedBy(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            CircleCounter(state = CounterState.Red)
            IconCard(active = true)
            IconCard(active = false)
        }
    }
}

private enum class CounterState { Inactive, Neutral, Blue, Red }

@Composable
private fun CrossBadge(active: Boolean) {
    val bg = if (active) Color(0xFFFDD112) else Color(0xFF2F2F2F)
    val border = if (active) Color(0xFFF6F6F6) else Color(0xFF888888)
    val text = if (active) Color(0xFF000000) else Color(0xFF888888)
    Box(modifier = Modifier.size(52.dp), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(24.dp)
                .height(52.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(bg)
                .border(2.dp, border, RoundedCornerShape(6.dp))
        )
        Box(
            modifier = Modifier
                .width(52.dp)
                .height(24.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(bg)
                .border(2.dp, border, RoundedCornerShape(6.dp))
        )
        Text("1", color = text, fontSize = 28.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun CircleCounter(state: CounterState) {
    val bg = when (state) {
        CounterState.Inactive, CounterState.Neutral -> Color(0xFF2F2F2F)
        CounterState.Blue -> Color(0xFF37B2FF)
        CounterState.Red -> Color(0xFFFF2330)
    }
    val border = when (state) {
        CounterState.Inactive -> Color(0xFF888888)
        else -> Color(0xFFF6F6F6)
    }
    val tint = when (state) {
        CounterState.Inactive -> Color(0xFF888888)
        else -> Color(0xFFF6F6F6)
    }
    Box(
        modifier = Modifier
            .size(58.dp)
            .clip(CircleShape)
            .background(bg)
            .border(2.dp, border, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = "Icon",
            tint = tint,
            modifier = Modifier.requiredSize(24.dp).align(Alignment.CenterStart).padding(start = 8.dp)
        )
        Text(
            text = "1",
            color = tint,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterEnd).padding(end = 7.dp)
        )
    }
}

@Composable
private fun IconRectButton(width: androidx.compose.ui.unit.Dp, height: androidx.compose.ui.unit.Dp, active: Boolean, icons: Int) {
    val bg = Color(0xFF2F2F2F)
    val border = if (active) Color(0xFFF6F6F6) else Color(0xFF777777)
    val tint = if (active) Color(0xFFF6F6F6) else Color(0xFF777777)
    Row(
        modifier = Modifier
            .width(width)
            .height(height)
            .clip(RoundedCornerShape(12.dp))
            .background(bg)
            .border(2.dp, border, RoundedCornerShape(12.dp)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(icons) { index ->
            Icon(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "Icon",
                tint = tint,
                modifier = Modifier.requiredSize(24.dp)
            )
            if (index != icons - 1) {
                Box(modifier = Modifier.width(18.dp))
            }
        }
    }
}

@Composable
private fun IconCard(active: Boolean) {
    val bg = Color(0xFF3A3A3A)
    val border = if (active) Color(0xFFF6F6F6) else Color(0xFF777777)
    val tint = if (active) Color(0xFFF6F6F6) else Color(0xFF777777)
    Column(
        modifier = Modifier
            .width(150.dp)
            .height(210.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(bg)
            .border(2.dp, border, RoundedCornerShape(14.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = "Icon",
            tint = tint,
            modifier = Modifier.requiredSize(34.dp)
        )
        Text(
            text = "TEXT",
            color = tint,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 18.dp)
        )
    }
}
