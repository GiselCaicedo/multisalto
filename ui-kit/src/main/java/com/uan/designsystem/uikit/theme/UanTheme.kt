package com.uan.designsystem.uikit.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalUanTokens = staticCompositionLocalOf { UanTokens.Default }

/** Acceso a los tokens Uan desde cualquier composable. */
object UanThemeTokens {
    val current: UanTokens
        @Composable
        @ReadOnlyComposable
        get() = LocalUanTokens.current
}

/**
 * Tema raiz del sistema de diseno Uan.
 *
 * Envuelve [MaterialTheme] con un [darkColorScheme] mapeado desde
 * [UanTokens.colors] y provee los tokens via [CompositionLocalProvider].
 *
 * @param tokens Tokens personalizados; por defecto [UanTokens.Default] (tema oscuro).
 */
@Composable
fun UanTheme(
    tokens: UanTokens = UanTokens.Default,
    content: @Composable () -> Unit,
) {
    val c = tokens.colors
    val scheme = darkColorScheme(
        background       = c.background,
        surface          = c.surface,
        onBackground     = c.onSurface,
        onSurface        = c.onSurface,
        onSurfaceVariant = c.muted,
        outline          = c.outline,
        primary          = c.primary,
        onPrimary        = c.onPrimary,
        primaryContainer = c.primaryContainer,
        secondary        = c.info,
        onSecondary      = c.onInfo,
        tertiary         = c.success,
        onTertiary       = c.onSuccess,
        error            = c.error,
        onError          = c.onError,
        errorContainer   = c.errorContainer,
    )
    CompositionLocalProvider(LocalUanTokens provides tokens) {
        MaterialTheme(
            colorScheme = scheme,
            content = content,
        )
    }
}

