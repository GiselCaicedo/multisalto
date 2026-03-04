package com.example.redscate.generated.set5

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.redscate.R

@Composable
fun CheckboxesSet5(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CheckboxItem(state = CheckboxState.Inactive)
        CheckboxItem(state = CheckboxState.Active)
        CheckboxItem(state = CheckboxState.Checked)
    }
}

private enum class CheckboxState { Inactive, Active, Checked }

@Composable
private fun CheckboxItem(state: CheckboxState) {
    val fill = when (state) {
        CheckboxState.Inactive -> Color(0xFF2F2F2F)
        CheckboxState.Active -> Color.Transparent
        CheckboxState.Checked -> Color(0xFF37B2FF)
    }
    val border = when (state) {
        CheckboxState.Inactive -> Color(0xFF888888)
        CheckboxState.Active -> Color(0xFFF6F6F6)
        CheckboxState.Checked -> Color(0xFF37B2FF)
    }
    Box(
        modifier = Modifier
            .requiredSize(46.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(fill)
            .border(2.dp, border, RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        if (state == CheckboxState.Checked) {
            Icon(
                painter = painterResource(id = R.drawable.vector_loading_indicator),
                contentDescription = "checked",
                tint = Color(0xFF000000),
                modifier = Modifier.requiredSize(24.dp)
            )
        }
    }
}
