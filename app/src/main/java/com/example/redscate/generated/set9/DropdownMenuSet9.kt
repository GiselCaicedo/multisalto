package com.example.redscate.generated.set9

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DropdownMenuSet9(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf("RH") }
    val options = listOf("RH", "A+", "O+", "B+", "AB+")

    Column(
        modifier = modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        DropdownClosed(
            text = selected,
            arrowUp = expanded,
            active = expanded,
            onClick = { expanded = !expanded }
        )
        if (expanded) {
            DropdownOpen(
                selected = selected,
                options = options.filter { it != selected },
                onSelect = {
                    selected = it
                    expanded = false
                }
            )
        }
        DropdownClosed(text = selected, arrowUp = false, active = false, onClick = { expanded = true })
    }
}

@Composable
private fun DropdownClosed(text: String, arrowUp: Boolean, active: Boolean, onClick: () -> Unit) {
    val border = if (active) Color(0xFF37B2FF) else Color(0xFFF6F6F6)
    Row(
        modifier = Modifier
            .width(170.dp)
            .height(48.dp)
            .background(Color(0xFF000000), RoundedCornerShape(8.dp))
            .border(2.dp, border, RoundedCornerShape(8.dp))
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text, color = Color(0xFFF6F6F6), fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(
            if (arrowUp) "⌃" else "⌄",
            color = Color(0xFF9AA0A6),
            fontSize = 26.sp,
            modifier = Modifier.clickable { onClick() }
        )
    }
}

@Composable
private fun DropdownOpen(selected: String, options: List<String>, onSelect: (String) -> Unit) {
    Column(
        modifier = Modifier
            .width(170.dp)
            .background(Color(0xFF000000), RoundedCornerShape(8.dp))
            .border(2.dp, Color(0xFF37B2FF), RoundedCornerShape(8.dp))
    ) {
        DropdownClosed(text = selected, arrowUp = true, active = true, onClick = { onSelect(selected) })
        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xFF37B2FF)))
        options.forEach { o ->
            Text(
                text = o,
                color = Color(0xFFF6F6F6),
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSelect(o) }
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            )
        }
    }
}
