package com.redscate.uikit.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.redscate.uikit.theme.RedscateTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class RedscateComponentsInstrumentedTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun redscateButton_triggersClickCallback() {
        var clicks = 0
        composeRule.setContent {
            RedscateTheme {
                RedscateButton(
                    text = "Accion",
                    onClick = { clicks++ }
                )
            }
        }

        composeRule.onNodeWithText("Accion").performClick()

        assertEquals(1, clicks)
    }

    @Test
    fun redscateDropdown_selectsOptionAndCloses() {
        val options = listOf(
            RedscateOption("rh", "RH"),
            RedscateOption("op", "O+")
        )
        var selected = "rh"
        var expanded = true

        composeRule.setContent {
            RedscateTheme {
                RedscateDropdown(
                    selectedKey = selected,
                    options = options,
                    expanded = expanded,
                    onExpandedChange = { expanded = it },
                    onOptionSelected = { selected = it.key }
                )
            }
        }

        composeRule.onNodeWithText("O+").performClick()
        assertEquals("op", selected)
        assertEquals(false, expanded)
    }

    @Test
    fun redscateTextField_showsSupportingError() {
        composeRule.setContent {
            RedscateTheme {
                RedscateTextField(
                    value = "",
                    onValueChange = {},
                    label = "Nombre",
                    state = RedscateTextFieldState.Error,
                    supportingText = "Campo requerido"
                )
            }
        }

        composeRule.onNodeWithText("Campo requerido").assertIsDisplayed()
    }

    @Test
    fun redscateAppBar_callsActionCallback() {
        var clickedId = ""
        composeRule.setContent {
            RedscateTheme {
                RedscateAppBar(
                    config = RedscateAppBarConfig(
                        title = "Inicio",
                        trailing = listOf(
                            RedscateAppBarAction(id = "go", label = "Go")
                        )
                    ),
                    onActionClick = { clickedId = it }
                )
            }
        }

        composeRule.onNodeWithText("Go").performClick()
        assertEquals("go", clickedId)
    }

    @Test
    fun redscateDialog_actionCallbackFires() {
        var clickedId = ""
        composeRule.setContent {
            RedscateTheme {
                RedscateDialog(
                    visible = true,
                    config = RedscateDialogConfig(
                        title = "Atencion",
                        actions = listOf(
                            RedscateDialogAction(id = "ok", label = "OK")
                        )
                    ),
                    onDismissRequest = {},
                    onActionClick = { clickedId = it }
                )
            }
        }

        composeRule.onNodeWithText("OK").performClick()
        assertEquals("ok", clickedId)
    }

    @Test
    fun redscateCarousel_changesIndexOnArrow() {
        val items = listOf(
            RedscateCarouselItem(id = "1", title = "Uno"),
            RedscateCarouselItem(id = "2", title = "Dos")
        )
        var index = 0
        composeRule.setContent {
            RedscateTheme {
                RedscateCarousel(
                    items = items,
                    currentIndex = index,
                    onIndexChange = { index = it }
                )
            }
        }

        composeRule.onNodeWithText(">").performClick()
        assertEquals(1, index)
    }

    @Test
    fun redscateList_actionCallbackFires() {
        var clickedId = ""
        composeRule.setContent {
            RedscateTheme {
                RedscateList(
                    items = listOf(
                        RedscateListItemData(
                            id = "item-1",
                            title = "Paciente",
                            action = RedscateCardAction(id = "open", label = "Abrir")
                        )
                    ),
                    onActionClick = { _, actionId -> clickedId = actionId }
                )
            }
        }

        composeRule.onNodeWithText("Abrir").performClick()
        assertEquals("open", clickedId)
    }

    @Test
    fun redscateStepIndicator_rendersStepLabels() {
        composeRule.setContent {
            RedscateTheme {
                RedscateStepIndicator(totalSteps = 3, currentStep = 2)
            }
        }

        composeRule.onNodeWithText("1").assertIsDisplayed()
        composeRule.onNodeWithText("3").assertIsDisplayed()
    }
}
