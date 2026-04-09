package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.uan.designsystem.uikit.foundation.UanTone

@Composable
fun UanDivider(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    tone: UanTone = UanTone.Neutral,
    thickness: androidx.compose.ui.unit.Dp = UanDividerDefaults.thickness,
    inset: androidx.compose.ui.unit.Dp = UanDividerDefaults.inset,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = inset)
            .height(thickness)
            .background(UanDividerDefaults.color(tone = tone, enabled = enabled)),
    )
}

@Composable
fun UanVerticalDivider(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    tone: UanTone = UanTone.Neutral,
    thickness: androidx.compose.ui.unit.Dp = UanDividerDefaults.thickness,
    inset: androidx.compose.ui.unit.Dp = UanDividerDefaults.inset,
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .padding(vertical = inset)
            .width(thickness)
            .background(UanDividerDefaults.color(tone = tone, enabled = enabled)),
    )
}

