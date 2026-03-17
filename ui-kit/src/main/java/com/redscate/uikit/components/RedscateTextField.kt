package com.redscate.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.redscate.uikit.theme.RedscateThemeTokens

enum class RedscateTextFieldState {
    Default,
    Focused,
    Error,
    Muted
}

@Composable
fun RedscateTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    state: RedscateTextFieldState = RedscateTextFieldState.Default,
    supportingText: String? = null,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = true
) {
    val tokens = RedscateThemeTokens.current
    val borderColor = when (state) {
        RedscateTextFieldState.Default -> tokens.colors.outline
        RedscateTextFieldState.Focused -> tokens.colors.primary
        RedscateTextFieldState.Error -> tokens.colors.error
        RedscateTextFieldState.Muted -> tokens.colors.muted
    }
    val textColor = when (state) {
        RedscateTextFieldState.Muted -> tokens.colors.muted
        RedscateTextFieldState.Error -> tokens.colors.error
        else -> tokens.colors.onSurface
    }
    val labelColor = when (state) {
        RedscateTextFieldState.Focused -> tokens.colors.primary
        RedscateTextFieldState.Error -> tokens.colors.error
        else -> tokens.colors.muted
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(tokens.colors.surface, RoundedCornerShape(tokens.shapes.mediumRadius))
                .border(2.dp, borderColor, RoundedCornerShape(tokens.shapes.mediumRadius))
                .padding(horizontal = 10.dp, vertical = 8.dp)
        ) {
            Text(
                text = label,
                color = labelColor,
                style = tokens.typography.supporting,
                modifier = Modifier
                    .background(tokens.colors.surface)
                    .padding(horizontal = 4.dp)
            )
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                enabled = enabled,
                readOnly = readOnly,
                singleLine = singleLine,
                textStyle = TextStyle(
                    color = textColor,
                    fontSize = tokens.typography.body.fontSize,
                    fontWeight = tokens.typography.body.fontWeight
                ),
                modifier = Modifier.fillMaxWidth(),
                decorationBox = { innerTextField ->
                    if (value.isEmpty() && placeholder.isNotBlank()) {
                        Text(
                            text = placeholder,
                            color = tokens.colors.muted,
                            style = tokens.typography.body
                        )
                    }
                    innerTextField()
                }
            )
        }
        if (!supportingText.isNullOrBlank()) {
            Text(
                text = supportingText,
                color = if (state == RedscateTextFieldState.Error) tokens.colors.error else tokens.colors.muted,
                style = tokens.typography.supporting
            )
        }
    }
}
