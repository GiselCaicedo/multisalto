package com.example.redscate.generated.set13

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldsSet13(modifier: Modifier = Modifier) {
    var mainValue by remember { mutableStateOf("David Leal ") }
    var smallValue by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
            FieldDefault("Nombre", Modifier.weight(1f), small = false)
            FieldDefault("Nombre", Modifier.width(132.dp), small = true)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
            FieldMuted("Nombre", Modifier.weight(1f), small = false)
            FieldMuted("Nombre", Modifier.width(132.dp), small = true)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
            FieldFocused(
                label = "Nombre",
                value = mainValue,
                onChange = { mainValue = it },
                modifier = Modifier.weight(1f)
            )
            FieldFocused(
                label = "Nombre",
                value = smallValue,
                onChange = { smallValue = it },
                modifier = Modifier.width(132.dp)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
            FieldError("Por favor completa la casilla", withClose = true, modifier = Modifier.weight(1f))
            FieldError("No Completado", withClose = false, modifier = Modifier.width(132.dp))
        }
    }
}

@Composable
private fun FieldDefault(text: String, modifier: Modifier, small: Boolean) {
    Box(
        modifier = modifier
            .height(if (small) 54.dp else 58.dp)
            .border(2.dp, Color(0xFFF6F6F6), RoundedCornerShape(10.dp))
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(text, color = Color(0xFFF6F6F6), fontSize = if (small) 14.sp else 17.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun FieldMuted(text: String, modifier: Modifier, small: Boolean) {
    Box(
        modifier = modifier
            .height(if (small) 54.dp else 58.dp)
            .border(2.dp, Color(0xFFAAAAAA), RoundedCornerShape(10.dp))
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(text, color = Color(0xFF888888), fontSize = if (small) 14.sp else 17.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun FieldFocused(label: String, value: String, onChange: (String) -> Unit, modifier: Modifier) {
    Box(
        modifier = modifier
            .height(64.dp)
            .border(2.dp, Color(0xFF37B2FF), RoundedCornerShape(10.dp))
            .padding(horizontal = 10.dp, vertical = 6.dp)
    ) {
        Text(
            label,
            color = Color(0xFFB0B6C0),
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.TopStart).background(Color(0xFF171C22)).padding(horizontal = 4.dp)
        )
        BasicTextField(
            value = value,
            onValueChange = onChange,
            singleLine = true,
            textStyle = TextStyle(color = Color(0xFFF6F6F6), fontSize = 16.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth()
        )
    }
}

@Composable
private fun FieldError(text: String, withClose: Boolean, modifier: Modifier) {
    Row(
        modifier = modifier
            .height(56.dp)
            .border(2.dp, Color(0xFFFF2330), RoundedCornerShape(10.dp))
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text,
            color = Color(0xFFFF2330),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        if (withClose) {
            Text("×", color = Color(0xFFFF2330), fontSize = 28.sp)
        }
    }
}

