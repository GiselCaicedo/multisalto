package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanElevationDefaults {
    val width: Dp = 144.dp
    val height: Dp = 112.dp
    val cornerRadius: Dp = 16.dp
    val horizontalPadding: Dp = 20.dp
    val verticalPadding: Dp = 16.dp

    val labelStyle: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = UanThemeTokens.current.typography.label.copy(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 22.sp,
        )
}

