package com.redscate.uikit.theme

import org.junit.Assert.assertTrue
import org.junit.Test

class RedscateTokensTest {
    @Test
    fun defaultTokens_haveVisibleContrastAnchors() {
        val tokens = RedscateTokens.Default

        assertTrue(tokens.colors.primary != tokens.colors.background)
        assertTrue(tokens.colors.onSurface != tokens.colors.background)
    }
}
