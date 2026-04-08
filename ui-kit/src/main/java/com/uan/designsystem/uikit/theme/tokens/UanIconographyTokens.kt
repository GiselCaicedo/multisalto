package com.uan.designsystem.uikit.theme.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class UanIconography(
    val strokeWidth: Dp,
    val small: Dp,
    val medium: Dp,
    val large: Dp,
)

val UanDefaultIconography = UanIconography(
    strokeWidth = 2.dp,
    small = 16.dp,
    medium = 24.dp,
    large = 32.dp,
)

