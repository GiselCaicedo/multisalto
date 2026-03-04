package com.example.redscate.generated.set6

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
fun ModalSet6(modifier: Modifier = Modifier) {
    val scroll = rememberScrollState()
    FlowRow(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(scroll)
            .padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        AlertColumn()
        ModalGalleryCard()
        ModalSingleCard(withClose = true, taller = false)
        ModalSingleCard(withClose = true, taller = true)
    }
}

@Composable
private fun AlertColumn() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        AlertModal(titleColor = Color(0xFFFF2330), actionColor = Color(0xFFFF2330))
        AlertModal(titleColor = Color(0xFF0DB11B), actionColor = Color(0xFF0DB11B))
    }
}

@Composable
private fun AlertModal(titleColor: Color, actionColor: Color) {
    Column(
        modifier = Modifier
            .width(210.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(12.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("¡Atención!", color = titleColor, fontSize = 34.sp, fontWeight = FontWeight.Bold)
        Text("Texto", color = Color(0xFFF6F6F6), fontSize = 16.sp)
        Text("Texto", color = Color(0xFFF6F6F6), fontSize = 16.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            PillButton("LABEL", actionColor, Modifier.weight(1f))
            PillButton("LABEL", Color(0xFF3A3A3A), Modifier.weight(1f))
        }
    }
}

@Composable
private fun ModalGalleryCard() {
    Column(
        modifier = Modifier
            .width(210.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(12.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text("Titulo", color = Color(0xFFF6F6F6), fontSize = 16.sp, fontWeight = FontWeight.Bold)
        CheckerPlaceholder(height = 180.dp)
        Row(verticalAlignment = Alignment.CenterVertically) {
            ArrowMini()
            Spacer(Modifier.width(8.dp))
            Text("1 · 2 · 3 · 4", color = Color(0xFF888888), fontSize = 14.sp)
            Spacer(Modifier.weight(1f))
            ArrowMini()
        }
    }
}

@Composable
private fun ModalSingleCard(withClose: Boolean, taller: Boolean) {
    Column(
        modifier = Modifier
            .width(210.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(12.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Titulo", color = Color(0xFFF6F6F6), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text("Subtitulo", color = Color(0xFFF6F6F6), fontSize = 14.sp)
                Text("Texto", color = Color(0xFFF6F6F6), fontSize = 14.sp)
            }
            if (withClose) {
                CloseMini()
            }
        }
        CheckerPlaceholder(height = if (taller) 250.dp else 190.dp)
        Row(verticalAlignment = Alignment.CenterVertically) {
            ArrowMini()
            Spacer(Modifier.weight(1f))
            PillButton("LABEL", Color(0xFF3A3A3A), Modifier.width(92.dp))
        }
    }
}

@Composable
private fun CheckerPlaceholder(height: androidx.compose.ui.unit.Dp) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF777777))
    ) {
        val c1 = Color(0xFF8B8B8B)
        val c2 = Color(0xFF6F6F6F)
        Column(Modifier.fillMaxWidth()) {
            repeat(8) { row ->
                Row(Modifier.fillMaxWidth()) {
                    repeat(8) { col ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(height / 8)
                                .background(if ((row + col) % 2 == 0) c1 else c2)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PillButton(label: String, bg: Color, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(36.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(bg)
            .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = "icon",
            tint = Color(0xFFF6F6F6),
            modifier = Modifier.requiredSize(14.dp)
        )
        Spacer(Modifier.width(8.dp))
        Text(label, color = Color(0xFFF6F6F6), fontSize = 17.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun CloseMini() {
    Box(
        modifier = Modifier
            .requiredSize(36.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF3A3A3A))
            .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text("×", color = Color(0xFFF6F6F6), fontSize = 24.sp)
    }
}

@Composable
private fun ArrowMini() {
    Box(
        modifier = Modifier
            .requiredSize(36.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF3A3A3A))
            .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text("‹", color = Color(0xFFF6F6F6), fontSize = 24.sp)
    }
}
