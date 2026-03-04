package com.example.redscate.generated.set12

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.redscate.R

@Composable
fun SwitchSet12(modifier: Modifier = Modifier) {
    var firstOn by remember { mutableStateOf(true) }
    var secondOn by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconSwitch(checked = firstOn, onToggle = { firstOn = !firstOn }, leftActive = false)
        IconSwitch(checked = secondOn, onToggle = { secondOn = !secondOn }, leftActive = true)
    }
}

@Composable
private fun IconSwitch(checked: Boolean, onToggle: () -> Unit, leftActive: Boolean) {
    val trackBorder = Color(0xFFF6F6F6)
    val trackBg = Color(0xFF000000)
    Row(
        modifier = Modifier
            .width(92.dp)
            .background(trackBg, RoundedCornerShape(999.dp))
            .border(2.dp, trackBorder, RoundedCornerShape(999.dp))
            .clickable { onToggle() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        val thumbLeft = if (checked) false else true
        if (thumbLeft) {
            Thumb(active = true, sun = true)
            IconSlot(sun = false, active = false)
        } else {
            IconSlot(sun = true, active = leftActive)
            Thumb(active = true, sun = false)
        }
    }
}

@Composable
private fun Thumb(active: Boolean, sun: Boolean) {
    val bg = Color(0xFFF6F6F6)
    Box(
        modifier = Modifier
            .requiredSize(42.dp)
            .clip(CircleShape)
            .background(bg),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = null,
            tint = if (sun) Color(0xFF37B2FF) else Color(0xFF37B2FF),
            modifier = Modifier.requiredSize(20.dp)
        )
        if (!sun) {
            Spacer(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .width(12.dp)
                    .requiredSize(12.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF6F6F6))
            )
        }
    }
}

@Composable
private fun IconSlot(sun: Boolean, active: Boolean) {
    Box(
        modifier = Modifier.requiredSize(42.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = null,
            tint = if (active) Color(0xFF37B2FF) else Color(0xFF777777),
            modifier = Modifier.requiredSize(18.dp)
        )
        if (!sun) {
            Spacer(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .width(10.dp)
                    .requiredSize(10.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF000000))
            )
        }
    }
}

