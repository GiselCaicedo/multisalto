package com.redscate.uikit.components

import org.junit.Assert.assertEquals
import org.junit.Test

class RedscateLoadingIndicatorTest {
    @Test
    fun coerceIndicatorStep_clampsInsideRange() {
        assertEquals(0, coerceIndicatorStep(-1, 3))
        assertEquals(2, coerceIndicatorStep(2, 3))
        assertEquals(3, coerceIndicatorStep(8, 3))
    }
}
