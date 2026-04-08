package com.uan.designsystem.uikit.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.foundation.colorFor
import com.uan.designsystem.uikit.foundation.contentColorFor
import com.uan.designsystem.uikit.theme.UanThemeTokens

object UanCheckboxDefaults {
    val containerSize: Dp = 28.dp
    val iconSize: Dp = 18.dp
    val borderWidth: Dp = UanInteractiveDefaults.borderWidth

    @Composable
    @ReadOnlyComposable
    fun containerColor(
        state: UanCheckboxState,
        enabled: Boolean,
        tone: UanTone,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val baseColor = when (state) {
            UanCheckboxState.Checked -> tone.colorFor(colors)
            UanCheckboxState.Indeterminate -> colors.warning
            UanCheckboxState.Unchecked -> colors.background
        }
        return if (enabled) baseColor else baseColor.copy(alpha = colors.disabledAlpha)
    }

    @Composable
    @ReadOnlyComposable
    fun borderColor(
        state: UanCheckboxState,
        enabled: Boolean,
        tone: UanTone,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val baseColor = when (state) {
            UanCheckboxState.Checked -> tone.colorFor(colors)
            UanCheckboxState.Indeterminate -> colors.warning
            UanCheckboxState.Unchecked -> colors.outline
        }
        return if (enabled) baseColor else baseColor.copy(alpha = colors.disabledAlpha)
    }

    @Composable
    @ReadOnlyComposable
    fun contentColor(
        state: UanCheckboxState,
        enabled: Boolean,
        tone: UanTone,
    ): Color {
        val colors = UanThemeTokens.current.colors
        val baseColor = when (state) {
            UanCheckboxState.Checked -> tone.contentColorFor(colors)
            UanCheckboxState.Indeterminate -> colors.onWarning
            UanCheckboxState.Unchecked -> colors.background
        }
        return if (enabled) baseColor else baseColor.copy(alpha = colors.disabledAlpha)
    }
}

