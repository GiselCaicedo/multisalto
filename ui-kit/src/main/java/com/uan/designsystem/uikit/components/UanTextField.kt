package com.uan.designsystem.uikit.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.input.VisualTransformation
import com.uan.designsystem.uikit.foundation.UanIconButton
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.foundation.rememberUanReduceMotion
import com.uan.designsystem.uikit.theme.UanThemeTokens

/**
 * Campo de texto principal del sistema de diseno Uan.
 *
 * Disenado para formularios de emergencia: alto contraste, bordes gruesos,
 * estados de error claros y area tocable minima de 48dp.
 *
 * Implementa un outlined text field con label flotante que se eleva al
 * enfocar o cuando el campo tiene contenido.
 *
 * @param value Texto actual del campo (estado hoisted).
 * @param onValueChange Callback al cambiar el texto.
 * @param modifier Modificador externo.
 * @param label Label del campo — actua como placeholder cuando esta vacio
 *   y flota como label reducido cuando tiene foco o contenido.
 * @param placeholder Placeholder adicional visible solo cuando el campo
 *   tiene foco pero esta vacio. Si es null, no se muestra.
 * @param enabled Estado habilitado/inhabilitado.
 * @param readOnly Si el campo es de solo lectura.
 * @param isError Si el campo esta en estado de error.
 * @param errorMessage Texto de error mostrado debajo del campo cuando
 *   [isError] es true. Si es null, solo se muestra el borde rojo.
 * @param leadingIcon Slot composable para icono al inicio del campo.
 * @param trailingIcon Slot composable para icono al final del campo.
 * @param keyboardOptions Opciones del teclado (tipo, IME action, etc.).
 * @param keyboardActions Acciones del teclado (onDone, onSearch, etc.).
 * @param singleLine Si el campo es de una sola linea.
 * @param maxLines Maximo de lineas visibles.
 * @param visualTransformation Transformacion visual (ej: password dots).
 * @param interactionSource Fuente de interacciones para observar foco.
 */
@Composable
fun UanTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "",
    placeholder: String? = null,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    isError: Boolean = false,
    errorMessage: String? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val tokens = UanThemeTokens.current
    val colors = tokens.colors
    val reduceMotion = rememberUanReduceMotion()
    val motionDuration = if (reduceMotion) 0 else tokens.motion.durationShort

    val isFocused by interactionSource.collectIsFocusedAsState()
    val hasContent = value.isNotEmpty()
    val shouldFloat = isFocused || hasContent

    // Colores animados
    val borderColor by animateColorAsState(
        targetValue = when {
            !enabled -> colors.outline.copy(alpha = colors.disabledAlpha)
            isError -> colors.error
            isFocused -> colors.primary
            else -> colors.outline
        },
        animationSpec = tween(motionDuration),
        label = "textFieldBorder",
    )

    val labelColor by animateColorAsState(
        targetValue = when {
            !enabled -> colors.muted.copy(alpha = colors.disabledAlpha)
            isError -> colors.error
            isFocused -> colors.primary
            else -> colors.muted
        },
        animationSpec = tween(motionDuration),
        label = "textFieldLabel",
    )

    // Semantica
    val stateDesc = when {
        !enabled -> "inhabilitado"
        isError && errorMessage != null -> "error: $errorMessage"
        isError -> "error"
        isFocused -> "enfocado"
        else -> ""
    }

    Column(modifier = modifier) {
        // Campo principal
        TextFieldContainer(
            value = value,
            onValueChange = onValueChange,
            label = label,
            placeholder = placeholder,
            enabled = enabled,
            readOnly = readOnly,
            isError = isError,
            shouldFloat = shouldFloat,
            isFocused = isFocused,
            borderColor = borderColor,
            labelColor = labelColor,
            motionDuration = motionDuration,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            visualTransformation = visualTransformation,
            interactionSource = interactionSource,
            stateDescription = stateDesc,
            errorMessage = errorMessage,
        )

        // Mensaje de error
        if (isError && errorMessage != null) {
            Spacer(Modifier.height(UanTextFieldDefaults.errorMessageSpacing))
            ErrorMessage(
                message = errorMessage,
                trailingIcon = trailingIcon,
            )
        }
    }
}

@Composable
private fun TextFieldContainer(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String?,
    enabled: Boolean,
    readOnly: Boolean,
    isError: Boolean,
    shouldFloat: Boolean,
    isFocused: Boolean,
    borderColor: androidx.compose.ui.graphics.Color,
    labelColor: androidx.compose.ui.graphics.Color,
    motionDuration: Int,
    leadingIcon: (@Composable () -> Unit)?,
    trailingIcon: (@Composable () -> Unit)?,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    singleLine: Boolean,
    maxLines: Int,
    visualTransformation: VisualTransformation,
    interactionSource: MutableInteractionSource,
    stateDescription: String,
    errorMessage: String?,
) {
    val tokens = UanThemeTokens.current
    val colors = tokens.colors
    val shape = RoundedCornerShape(UanTextFieldDefaults.cornerRadius)
    val floatingLabelPadding = tokens.spacing.xxs

    val labelOffsetY by animateFloatAsState(
        targetValue = if (shouldFloat) -1f else 0f,
        animationSpec = tween(motionDuration),
        label = "labelOffset",
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = UanTextFieldDefaults.minHeight)
            .clip(shape)
            .background(colors.surface, shape)
            .border(
                BorderStroke(UanTextFieldDefaults.borderWidth, borderColor),
                shape,
            )
            .alpha(if (enabled) 1f else UanInteractiveDefaults.disabledAlpha)
            .semantics(mergeDescendants = true) {
                if (stateDescription.isNotEmpty()) {
                    this.stateDescription = stateDescription
                }
                if (!enabled) disabled()
                if (isError && errorMessage != null) {
                    error(errorMessage)
                }
            },
    ) {
        // Label flotante (encima del borde cuando shouldFloat)
        if (label.isNotEmpty() && shouldFloat) {
            Box(
                modifier = Modifier
                    .padding(
                        start = UanTextFieldDefaults.contentPaddingHorizontal,
                    )
                    .align(Alignment.TopStart)
                    .background(colors.surface)
                    .padding(horizontal = floatingLabelPadding),
            ) {
                Text(
                    text = label,
                    style = UanTextFieldDefaults.floatingLabelStyle,
                    color = labelColor,
                    modifier = Modifier.align(Alignment.TopStart),
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = UanTextFieldDefaults.contentPaddingHorizontal,
                    vertical = UanTextFieldDefaults.contentPaddingVertical,
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            if (leadingIcon != null) {
                leadingIcon()
                Spacer(Modifier.width(UanTextFieldDefaults.iconSpacing))
            }

            Box(modifier = Modifier.weight(1f)) {
                // Placeholder / inline label
                val showPlaceholder = !shouldFloat && label.isNotEmpty() && value.isEmpty()
                val showFocusPlaceholder = isFocused && value.isEmpty() && placeholder != null
                if (showPlaceholder) {
                    Text(
                        text = label,
                        style = UanTextFieldDefaults.placeholderStyle,
                        color = colors.muted,
                    )
                } else if (showFocusPlaceholder) {
                    Text(
                        text = placeholder!!,
                        style = UanTextFieldDefaults.placeholderStyle,
                        color = colors.muted.copy(alpha = 0.6f),
                    )
                }

                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    enabled = enabled,
                    readOnly = readOnly,
                    textStyle = UanTextFieldDefaults.inputStyle.copy(
                        color = colors.onSurface,
                    ),
                    keyboardOptions = keyboardOptions,
                    keyboardActions = keyboardActions,
                    singleLine = singleLine,
                    maxLines = maxLines,
                    visualTransformation = visualTransformation,
                    interactionSource = interactionSource,
                    cursorBrush = SolidColor(
                        if (isError) colors.error else colors.primary,
                    ),
                    decorationBox = { innerTextField ->
                        innerTextField()
                    },
                )
            }

            if (trailingIcon != null && !(isError && errorMessage != null)) {
                Spacer(Modifier.width(UanTextFieldDefaults.iconSpacing))
                trailingIcon()
            }
        }
    }
}

@Composable
private fun ErrorMessage(
    message: String,
    trailingIcon: (@Composable () -> Unit)?,
) {
    val tokens = UanThemeTokens.current
    val colors = tokens.colors
    val shape = RoundedCornerShape(UanTextFieldDefaults.cornerRadius)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                BorderStroke(UanTextFieldDefaults.borderWidth, colors.error),
                shape,
            )
            .padding(
                horizontal = UanTextFieldDefaults.contentPaddingHorizontal,
                vertical = UanTextFieldDefaults.contentPaddingVertical,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = message,
            style = UanTextFieldDefaults.errorStyle,
            color = colors.error,
            modifier = Modifier.weight(1f),
        )
        if (trailingIcon != null) {
            Spacer(Modifier.width(UanTextFieldDefaults.iconSpacing))
            trailingIcon()
        }
    }
}

