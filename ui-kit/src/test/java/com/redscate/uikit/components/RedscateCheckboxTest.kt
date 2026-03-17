package com.redscate.uikit.components

import org.junit.Assert.assertEquals
import org.junit.Test

class RedscateCheckboxTest {
    @Test
    fun nextCheckboxState_cyclesAcrossAllStates() {
        assertEquals(RedscateCheckboxState.Active, nextCheckboxState(RedscateCheckboxState.Inactive))
        assertEquals(RedscateCheckboxState.Checked, nextCheckboxState(RedscateCheckboxState.Active))
        assertEquals(RedscateCheckboxState.Inactive, nextCheckboxState(RedscateCheckboxState.Checked))
    }
}
