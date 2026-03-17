package com.redscate.uikit.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalRedscateTokens = staticCompositionLocalOf { RedscateTokens.Default }

object RedscateThemeTokens {
    val current: RedscateTokens
        @Composable
        @ReadOnlyComposable
        get() = LocalRedscateTokens.current
}

@Composable
fun RedscateTheme(
    tokens: RedscateTokens = RedscateTokens.Default,
    content: @Composable () -> Unit
) {
    val scheme = darkColorScheme(
        background = tokens.colors.background,
        surface = tokens.colors.surface,
        primary = tokens.colors.primary,
        onPrimary = tokens.colors.onPrimary,
        onSurface = tokens.colors.onSurface,
        error = tokens.colors.error
    )
    CompositionLocalProvider(LocalRedscateTokens provides tokens) {
        MaterialTheme(
            colorScheme = scheme,
            content = content
        )
    }
}
