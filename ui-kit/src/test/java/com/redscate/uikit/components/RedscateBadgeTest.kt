package com.redscate.uikit.components

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class RedscateBadgeTest {
    @Test
    fun formatBadgeCount_returnsNullForZeroOrLess() {
        assertNull(formatBadgeCount(0))
        assertNull(formatBadgeCount(-1))
    }

    @Test
    fun formatBadgeCount_capsLargeValues() {
        assertEquals("99+", formatBadgeCount(120))
    }
}
