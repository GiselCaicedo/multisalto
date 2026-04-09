package com.uan.designsystem.uikit.theme.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class UanSpacing(
    val xxxs: Dp,
    val xxs: Dp,
    val xs: Dp,
    val sm: Dp,
    val md: Dp,
    val lg: Dp,
    val xl: Dp,
    val xxl: Dp,
)

@Immutable
data class UanGrid(
    val columns: Int,
    val gutter: Dp,
    val screenMargin: Dp,
    val touchTarget: Dp,
)

val UanDefaultSpacing = UanSpacing(
    xxxs = 2.dp,
    xxs = 4.dp,
    xs = 8.dp,
    sm = 12.dp,
    md = 16.dp,
    lg = 24.dp,
    xl = 32.dp,
    xxl = 40.dp,
)

val UanDefaultGrid = UanGrid(
    columns = 4,
    gutter = 8.dp,
    screenMargin = 16.dp,
    touchTarget = 48.dp,
)

