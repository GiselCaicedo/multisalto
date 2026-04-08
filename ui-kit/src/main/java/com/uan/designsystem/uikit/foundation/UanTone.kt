package com.uan.designsystem.uikit.foundation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.uan.designsystem.uikit.theme.UanThemeTokens
import com.uan.designsystem.uikit.theme.tokens.UanColors

/**
 * Tono semantico unificado del sistema Uan.
 *
 * Cada tono mapea a un triplete de colores (principal, contenido, contenedor)
 * definido en [UanColors].
 */
enum class UanTone {
    Neutral,
    Primary,
    Success,
    Info,
    Warning,
    Danger,
    Critical,
}

/** Color principal del tono. */
fun UanTone.colorFor(colors: UanColors): Color = when (this) {
    UanTone.Neutral  -> colors.muted
    UanTone.Primary  -> colors.primary
    UanTone.Success  -> colors.success
    UanTone.Info     -> colors.info
    UanTone.Warning  -> colors.warning
    UanTone.Danger   -> colors.error
    UanTone.Critical -> colors.critical
}

/** Color de contenido (texto/icono) sobre el tono. */
fun UanTone.contentColorFor(colors: UanColors): Color = when (this) {
    UanTone.Neutral  -> colors.onSurface
    UanTone.Primary  -> colors.onPrimary
    UanTone.Success  -> colors.onSuccess
    UanTone.Info     -> colors.onInfo
    UanTone.Warning  -> colors.onWarning
    UanTone.Danger   -> colors.onError
    UanTone.Critical -> colors.onCritical
}

/** Color de contenedor del tono. */
fun UanTone.containerColorFor(colors: UanColors): Color = when (this) {
    UanTone.Neutral  -> colors.surface
    UanTone.Primary  -> colors.primaryContainer
    UanTone.Success  -> colors.successContainer
    UanTone.Info     -> colors.infoContainer
    UanTone.Warning  -> colors.warningContainer
    UanTone.Danger   -> colors.errorContainer
    UanTone.Critical -> colors.criticalContainer
}

/** Color principal del tono (composable — lee del tema actual). */
@Composable
fun UanTone.color(): Color = colorFor(UanThemeTokens.current.colors)

/** Color de contenido del tono (composable). */
@Composable
fun UanTone.contentColor(): Color = contentColorFor(UanThemeTokens.current.colors)

/** Color de contenedor del tono (composable). */
@Composable
fun UanTone.containerColor(): Color = containerColorFor(UanThemeTokens.current.colors)

