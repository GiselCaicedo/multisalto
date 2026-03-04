package com.example.redscate.generated.set8

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

@Composable
fun ListsSet8(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxWidth().padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items((1..5).toList()) {
            ListCardItem()
        }
    }
}

@Composable
private fun ListCardItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(10.dp))
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(7.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .requiredSize(34.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF2F2F2F))
                    .border(2.dp, Color(0xFFF6F6F6), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon),
                    contentDescription = "icon",
                    tint = Color(0xFFF6F6F6),
                    modifier = Modifier.requiredSize(12.dp).align(Alignment.CenterStart).padding(start = 5.dp)
                )
                Text("1", color = Color(0xFFF6F6F6), fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.align(Alignment.CenterEnd).padding(end = 5.dp))
            }
            Spacer(Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(34.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.CenterStart
            ) {
                Text("Nombre", color = Color(0xFFF6F6F6), fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 8.dp))
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Recibido", color = Color(0xFFF6F6F6), fontSize = 10.sp)
                Text("08:57:34  05/05/2025", color = Color(0xFFF6F6F6), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                Text("Solicitado", color = Color(0xFFF6F6F6), fontSize = 10.sp)
                Text("08:57:34  05/05/2025", color = Color(0xFFF6F6F6), fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
            Box(
                modifier = Modifier
                    .width(64.dp)
                    .height(62.dp)
                    .clip(RoundedCornerShape(9.dp))
                    .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(9.dp)),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Distancia", color = Color(0xFF888888), fontSize = 8.sp)
                    Text("200M", color = Color(0xFFF6F6F6), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFF3A3A3A))
                .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(8.dp)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "icon",
                tint = Color(0xFFF6F6F6),
                modifier = Modifier.requiredSize(12.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text("LABEL", color = Color(0xFFF6F6F6), fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
    }
}

