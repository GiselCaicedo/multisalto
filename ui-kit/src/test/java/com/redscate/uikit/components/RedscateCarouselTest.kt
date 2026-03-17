package com.redscate.uikit.components

import org.junit.Assert.assertEquals
import org.junit.Test

class RedscateCarouselTest {
    @Test
    fun coerceCarouselIndex_clampsLowerBound() {
        assertEquals(0, coerceCarouselIndex(-2, 3))
    }

    @Test
    fun coerceCarouselIndex_clampsUpperBound() {
        assertEquals(2, coerceCarouselIndex(9, 3))
    }

    @Test
    fun coerceCarouselIndex_handlesEmptyList() {
        assertEquals(0, coerceCarouselIndex(1, 0))
    }
}
