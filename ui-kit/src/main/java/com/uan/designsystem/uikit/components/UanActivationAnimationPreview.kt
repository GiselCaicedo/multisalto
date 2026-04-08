package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericActivationPreview() {
    ActivationPreviewContainer {
        UanActivationAnimation(
            active = true,
            tone = UanTone.Info,
            contentDescription = "Animacion de ejemplo",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericActivationVariantPreview() {
    ActivationPreviewContainer {
        UanActivationAnimation(
            active = true,
            tone = UanTone.Warning,
            contentDescription = "Animacion de ejemplo",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericActivationSearchPreview() {
    ActivationPreviewContainer {
        UanActivationAnimation(
            active = true,
            tone = UanTone.Success,
            contentDescription = "Animacion de ejemplo",
            nodeCount = 10,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericActivationCriticalPreview() {
    ActivationPreviewContainer {
        UanActivationAnimation(
            active = true,
            tone = UanTone.Critical,
            contentDescription = "Animacion de ejemplo",
            centerContent = {
                Text(
                    text = "!",
                    style = UanActivationAnimationDefaults.labelStyle,
                    color = UanThemeTokens.current.colors.onCritical,
                )
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun GenericActivationInactivePreview() {
    ActivationPreviewContainer {
        UanActivationAnimation(
            active = false,
            tone = UanTone.Info,
            contentDescription = "Animacion inactiva",
        )
    }
}

@Composable
private fun ActivationPreviewContainer(
    content: @Composable () -> Unit,
) {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            content()
        }
    }
}

