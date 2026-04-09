package com.uan.designsystem.uikit.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import com.uan.designsystem.uikit.theme.UanThemeTokens

/**
 * Primitiva compartida de boton de icono del sistema Uan.
 *
 * Garantiza area minima tocable, ripple y semantica de accesibilidad.
 *
 * @param contentDescription Descripcion accesible obligatoria.
 * @param onClick Accion al pulsar; `null` = no interactivo.
 * @param enabled Estado habilitado/inhabilitado.
 * @param selected Estado de seleccion visual.
 * @param shape Forma del boton (por defecto [CircleShape]).
 * @param containerColor Color de fondo.
 * @param selectedContainerColor Color de fondo cuando [selected] es `true`.
 * @param borderColor Color de borde; [Color.Transparent] = sin borde.
 * @param content Contenido composable (icono).
 */
@Composable
fun UanIconButton(
    contentDescription: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    selected: Boolean = false,
    shape: Shape = CircleShape,
    containerColor: Color = Color.Transparent,
    selectedContainerColor: Color? = null,
    borderColor: Color = Color.Transparent,
    content: @Composable () -> Unit,
) {
    val tokens = UanThemeTokens.current
    val resolvedSelected = selectedContainerColor ?: tokens.colors.primary
    val bgColor = if (selected) resolvedSelected else containerColor
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .size(UanInteractiveDefaults.iconButtonSize)
            .clip(shape)
            .background(bgColor, shape)
            .then(
                if (borderColor != Color.Transparent)
                    Modifier.border(UanInteractiveDefaults.borderWidth, borderColor, shape)
                else Modifier
            )
            .alpha(if (enabled) 1f else UanInteractiveDefaults.disabledAlpha)
            .then(
                if (onClick != null)
                    Modifier.clickable(
                        enabled = enabled,
                        interactionSource = interactionSource,
                        indication = ripple(bounded = true),
                        role = Role.Button,
                        onClick = onClick,
                    )
                else Modifier
            )
            .semantics {
                this.contentDescription = contentDescription
                role = Role.Button
                if (!enabled) disabled()
            },
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

