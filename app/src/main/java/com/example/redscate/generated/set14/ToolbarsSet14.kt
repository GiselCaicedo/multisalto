package com.example.redscate.generated.set14

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.redscate.R

@Composable
fun ToolbarsSet14(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ToolbarRow(infoActive = false, sosActive = false)
        ToolbarRow(infoActive = false, sosActive = true)
        ToolbarRow(infoActive = true, sosActive = false)
    }
}

@Composable
private fun ToolbarRow(infoActive: Boolean, sosActive: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color(0xFF353535), RoundedCornerShape(10.dp))
            .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(10.dp))
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (infoActive) {
            Icon(
                painter = painterResource(id = R.drawable.ic_toolbar_info_filled),
                contentDescription = "info active",
                tint = Color.Unspecified,
                modifier = Modifier.requiredSize(38.dp)
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.ic_toolbar_info_outlined),
                contentDescription = "info inactive",
                tint = Color.Unspecified,
                modifier = Modifier.requiredSize(38.dp)
            )
        }

        if (sosActive) {
            Icon(
                painter = painterResource(id = R.drawable.ic_toolbar_sos_filled),
                contentDescription = "sos active",
                tint = Color.Unspecified,
                modifier = Modifier.requiredSize(38.dp)
            )
        } else {
            SosOutlined()
        }
    }
}

@Composable
private fun SosOutlined() {
    Box(
        modifier = Modifier
            .requiredSize(38.dp)
            .border(2.dp, Color(0xFF888888), CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text("SOS", color = Color(0xFF888888), fontSize = 13.sp, fontWeight = FontWeight.Bold)
    }
}

