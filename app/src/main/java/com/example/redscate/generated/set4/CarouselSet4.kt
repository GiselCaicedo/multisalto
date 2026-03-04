package com.example.redscate.generated.set4

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
fun CarouselSet4(modifier: Modifier = Modifier) {
    val topState = rememberLazyListState()
    val bottomState = rememberLazyListState()
    Column(
        modifier = modifier.fillMaxWidth().padding(vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        LazyRow(
            state = topState,
            horizontalArrangement = Arrangement.spacedBy(22.dp),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 10.dp)
        ) {
            items((1..8).toList()) {
                CarouselTile()
            }
        }

        LazyRow(
            state = bottomState,
            horizontalArrangement = Arrangement.spacedBy(22.dp),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 10.dp)
        ) {
            item { LabelPill(width = 230.dp) }
            item { LabelPill(width = 370.dp) }
            item { LabelPill(width = 230.dp) }
            item { LabelPill(width = 370.dp) }
        }
    }
}

@Composable
private fun CarouselTile() {
    Box(
        modifier = Modifier
            .width(210.dp)
            .height(210.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF3A3A3A))
            .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icono_campo),
            contentDescription = "Campo",
            tint = Color(0xFFF6F6F6),
            modifier = Modifier.requiredSize(120.dp)
        )
    }
}

@Composable
private fun LabelPill(width: androidx.compose.ui.unit.Dp) {
    Row(
        modifier = Modifier
            .width(width)
            .height(74.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(Color(0xFF3A3A3A))
            .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(18.dp)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = "icon",
            tint = Color(0xFFF6F6F6),
            modifier = Modifier.requiredSize(24.dp)
        )
        androidx.compose.foundation.layout.Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "LABEL",
            color = Color(0xFFF6F6F6),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
