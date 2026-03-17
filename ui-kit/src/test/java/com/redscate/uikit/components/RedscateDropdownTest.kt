package com.redscate.uikit.components

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class RedscateDropdownTest {
    @Test
    fun resolveSelectedOption_returnsExpectedOption() {
        val options = listOf(
            RedscateOption(key = "a", label = "A"),
            RedscateOption(key = "b", label = "B")
        )

        val selected = resolveSelectedOption("b", options)

        assertEquals("B", selected?.label)
    }

    @Test
    fun resolveSelectedOption_returnsNullWhenNotFound() {
        val options = listOf(
            RedscateOption(key = "a", label = "A")
        )

        val selected = resolveSelectedOption("z", options)

        assertNull(selected)
    }
}
