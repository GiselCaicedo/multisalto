package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun EvacuacionDividerPreview() {
    DividerPreviewContainer {
        UanDivider(tone = UanTone.Info)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun PacienteDividerPreview() {
    DividerPreviewContainer {
        UanDivider(tone = UanTone.Success, inset = 16.dp)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun RiesgoDividerPreview() {
    DividerPreviewContainer {
        UanDivider(tone = UanTone.Critical)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun VerticalDividerPreview() {
    DividerPreviewContainer {
        Row(
            modifier = Modifier.height(48.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Box(Modifier.weight(1f).background(UanThemeTokens.current.colors.surface))
            UanVerticalDivider(tone = UanTone.Warning)
            Box(Modifier.weight(1f).background(UanThemeTokens.current.colors.surface))
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun DisabledDividerPreview() {
    DividerPreviewContainer {
        UanDivider(enabled = false, tone = UanTone.Danger)
    }
}

@Composable
private fun DividerPreviewContainer(
    content: @Composable () -> Unit,
) {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(tokens.colors.background)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            content()
        }
    }
}

