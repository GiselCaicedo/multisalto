package com.uan.designsystem.uikit.theme.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class UanElevations(
    val level0: Dp,
    val level1: Dp,
    val level2: Dp,
    val level3: Dp,
    val level4: Dp,
    val interactiveOffsetY: Dp,
)

val UanDefaultElevations = UanElevations(
    level0 = 0.dp,
    level1 = 1.dp,
    level2 = 2.dp,
    level3 = 3.dp,
    level4 = 6.dp,
    interactiveOffsetY = 3.dp,
)

