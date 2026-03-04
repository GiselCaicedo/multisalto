package com.example.redscate.generated.set3

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
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
import androidx.compose.foundation.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.redscate.R

@Composable
fun CardsSet3(modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier = modifier.fillMaxWidth()) {
        val compact = maxWidth < 430.dp
        val spacing = if (compact) 14.dp else 18.dp
        val corner = if (compact) 12.dp else 14.dp
        val titleSize = if (compact) 16.sp else 18.sp
        val valueSize = if (compact) 14.sp else 18.sp
        val bodySize = if (compact) 14.sp else 17.sp

        Column(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(spacing)
        ) {
            CardMain(
                outline = Color(0xFFF6F6F6),
                titleSize = titleSize,
                valueSize = valueSize,
                bodySize = bodySize,
                corner = corner
            )
            CardBloodAge(
                outline = Color(0xFF37B2FF),
                titleSize = titleSize,
                valueSize = valueSize,
                bodySize = bodySize,
                corner = corner
            )
            CardProgress(
                outline = Color(0xFF37B2FF),
                titleSize = titleSize,
                valueSize = valueSize,
                bodySize = bodySize,
                corner = corner
            )
        }
    }
}

@Composable
private fun CardMain(
    outline: Color,
    titleSize: androidx.compose.ui.unit.TextUnit,
    valueSize: androidx.compose.ui.unit.TextUnit,
    bodySize: androidx.compose.ui.unit.TextUnit,
    corner: androidx.compose.ui.unit.Dp
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(corner))
            .border(2.dp, outline, RoundedCornerShape(corner))
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .requiredSize(50.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF2F2F2F))
                    .border(2.dp, Color(0xFFF6F6F6), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon),
                    contentDescription = "Icon",
                    tint = Color(0xFFF6F6F6),
                    modifier = Modifier.requiredSize(18.dp).align(Alignment.CenterStart).padding(start = 7.dp)
                )
                Text("1", color = Color(0xFFF6F6F6), fontWeight = FontWeight.Bold, fontSize = 26.sp, modifier = Modifier.align(Alignment.CenterEnd).padding(end = 7.dp))
            }
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.CenterStart
            ) {
                Text("Nombre", color = Color(0xFFF6F6F6), fontWeight = FontWeight.Bold, fontSize = titleSize, modifier = Modifier.padding(start = 12.dp))
            }
            Spacer(modifier = Modifier.width(10.dp))
            CloseBtn()
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Column {
                    Text("Recibido", color = Color(0xFFF6F6F6), fontSize = bodySize)
                    Text("08:57:34  05/05/2025", color = Color(0xFFF6F6F6), fontWeight = FontWeight.Bold, fontSize = bodySize)
                }
                Column {
                    Text("Solicitado", color = Color(0xFFF6F6F6), fontSize = bodySize)
                    Text("08:57:34  05/05/2025", color = Color(0xFFF6F6F6), fontWeight = FontWeight.Bold, fontSize = bodySize)
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .width(98.dp)
                    .height(92.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Distancia", color = Color(0xFF888888), fontSize = bodySize)
                    Text("200M", color = Color(0xFFF6F6F6), fontWeight = FontWeight.Bold, fontSize = valueSize)
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFF3A3A3A))
                .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(12.dp)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(id = R.drawable.icon), contentDescription = "icon", tint = Color(0xFFF6F6F6), modifier = Modifier.requiredSize(18.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text("LABEL", color = Color(0xFFF6F6F6), fontWeight = FontWeight.Bold, fontSize = 32.sp)
        }
    }
}

@Composable
private fun CardBloodAge(
    outline: Color,
    titleSize: androidx.compose.ui.unit.TextUnit,
    valueSize: androidx.compose.ui.unit.TextUnit,
    bodySize: androidx.compose.ui.unit.TextUnit,
    corner: androidx.compose.ui.unit.Dp
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(corner))
            .border(2.dp, outline, RoundedCornerShape(corner))
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.requiredSize(50.dp).clip(CircleShape).background(Color(0xFFF6F6F6)), contentAlignment = Alignment.Center) {
                Text("1", color = Color(0xFF000000), fontWeight = FontWeight.Bold, fontSize = 28.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.CenterStart
            ) {
                Text("Nombre", color = Color(0xFFF6F6F6), fontWeight = FontWeight.Bold, fontSize = titleSize, modifier = Modifier.padding(start = 12.dp))
            }
            Spacer(modifier = Modifier.width(10.dp))
            CloseBtn()
        }

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            SmallChip(labelMain = "O+", labelSuffix = null, valueSize = valueSize, modifier = Modifier.weight(1f))
            SmallChip(labelMain = "33", labelSuffix = "Años", valueSize = valueSize, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun CardProgress(
    outline: Color,
    titleSize: androidx.compose.ui.unit.TextUnit,
    valueSize: androidx.compose.ui.unit.TextUnit,
    bodySize: androidx.compose.ui.unit.TextUnit,
    corner: androidx.compose.ui.unit.Dp
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(corner))
            .border(2.dp, outline, RoundedCornerShape(corner))
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.requiredSize(50.dp).clip(CircleShape).background(Color(0xFFF6F6F6)), contentAlignment = Alignment.Center) {
                Text("1", color = Color(0xFF000000), fontWeight = FontWeight.Bold, fontSize = 28.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.CenterStart
            ) {
                Text("Nombre", color = Color(0xFFF6F6F6), fontWeight = FontWeight.Bold, fontSize = titleSize, modifier = Modifier.padding(start = 12.dp))
            }
            Spacer(modifier = Modifier.width(10.dp))
            CloseBtn()
        }

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(62.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(12.dp))
                    .padding(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(52.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFF0DB11B))
                )
                Image(
                    painter = painterResource(id = R.drawable.rectangle_1),
                    contentDescription = "battery-marker",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .width(10.dp)
                        .height(40.dp)
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .width(2.dp)
                        .height(40.dp)
                        .background(Color(0xFFF6F6F6).copy(alpha = 0.35f))
                )
            }
            Box(
                modifier = Modifier
                    .width(98.dp)
                    .height(62.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Porcentaje", color = Color(0xFF888888), fontSize = bodySize)
                    Text("80%", color = Color(0xFFF6F6F6), fontWeight = FontWeight.Bold, fontSize = valueSize)
                }
            }
        }
    }
}

@Composable
private fun CloseBtn() {
    Box(
        modifier = Modifier
            .requiredSize(50.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF3A3A3A))
            .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text("×", color = Color(0xFFF6F6F6), fontSize = 32.sp, fontWeight = FontWeight.Light)
    }
}

@Composable
private fun SmallChip(
    labelMain: String,
    labelSuffix: String?,
    valueSize: androidx.compose.ui.unit.TextUnit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(52.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center) {
            Text(labelMain, color = Color(0xFFF6F6F6), fontSize = valueSize, fontWeight = FontWeight.Bold)
            if (!labelSuffix.isNullOrBlank()) {
                Spacer(modifier = Modifier.width(6.dp))
                Text(labelSuffix, color = Color(0xFF888888), fontSize = 24.sp)
            }
        }
    }
}
