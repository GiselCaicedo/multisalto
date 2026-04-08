package com.uan.designsystem.uikit.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.theme.UanThemeTokens

/** Estilo visual del boton Uan. */
enum class UanButtonStyle {
    Primary,
    Secondary,
    Ghost,
    Danger,
    Warning,
    Critical,
}

/** Tamano del boton Uan. */
enum class UanButtonSize {
    Compact,
    Regular,
    Large,
}

/**
 * Boton principal del sistema de diseno Uan.
 *
 * Soporta 6 estilos visuales, 3 tamanos, estado de carga con
 * indicador animado y estado inhabilitado con opacidad reducida.
 *
 * @param onClick Callback al pulsar.
 * @param modifier Modificador externo.
 * @param enabled Estado habilitado/inhabilitado.
 * @param loading Muestra indicador de progreso circular.
 * @param style Estilo visual ([UanButtonStyle]).
 * @param size Tamano ([UanButtonSize]).
 * @param fillWidth Si `true`, ocupa todo el ancho disponible.
 * @param content Contenido composable del boton.
 */
@Composable
fun UanButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    style: UanButtonStyle = UanButtonStyle.Primary,
    size: UanButtonSize = UanButtonSize.Regular,
    fillWidth: Boolean = false,
    content: @Composable RowScope.() -> Unit,
) {
    val tokens = UanThemeTokens.current
    val colors = tokens.colors

    val containerColor: Color
    val contentColor: Color
    val borderColor: Color

    when (style) {
        UanButtonStyle.Primary -> {
            containerColor = colors.primary
            contentColor = colors.onPrimary
            borderColor = Color.Transparent
        }
        UanButtonStyle.Secondary -> {
            containerColor = Color.Transparent
            contentColor = colors.onSurface
            borderColor = colors.outline
        }
        UanButtonStyle.Ghost -> {
            containerColor = Color.Transparent
            contentColor = colors.onSurface
            borderColor = Color.Transparent
        }
        UanButtonStyle.Danger -> {
            containerColor = colors.error
            contentColor = colors.onError
            borderColor = Color.Transparent
        }
        UanButtonStyle.Warning -> {
            containerColor = colors.warning
            contentColor = colors.onWarning
            borderColor = Color.Transparent
        }
        UanButtonStyle.Critical -> {
            containerColor = colors.critical
            contentColor = colors.onCritical
            borderColor = Color.Transparent
        }
    }

    val verticalPadding: Dp = when (size) {
        UanButtonSize.Compact -> UanButtonDefaults.compactVerticalPadding
        UanButtonSize.Regular -> UanButtonDefaults.regularVerticalPadding
        UanButtonSize.Large -> UanButtonDefaults.largeVerticalPadding
    }

    val contentAlpha by animateFloatAsState(
        targetValue = if (loading) 0f else 1f,
        animationSpec = tween(tokens.motion.durationShort),
        label = "buttonContentAlpha",
    )
    val loadingAlpha by animateFloatAsState(
        targetValue = if (loading) 1f else 0f,
        animationSpec = tween(tokens.motion.durationShort),
        label = "buttonLoadingAlpha",
    )

    val interactive = enabled && !loading

    Surface(
        onClick = { if (interactive) onClick() },
        modifier = modifier
            .then(if (fillWidth) Modifier.fillMaxWidth() else Modifier)
            .alpha(if (enabled) 1f else UanInteractiveDefaults.disabledAlpha)
            .semantics {
                role = Role.Button
                if (!enabled) disabled()
            },
        enabled = interactive,
        color = containerColor,
        contentColor = contentColor,
        shape = RoundedCornerShape(tokens.shapes.smallRadius),
        border = if (borderColor != Color.Transparent)
            BorderStroke(UanInteractiveDefaults.borderWidth, borderColor)
        else null,
    ) {
        Box(contentAlignment = Alignment.Center) {
            Row(
                modifier = Modifier
                    .padding(
                        horizontal = UanButtonDefaults.horizontalPadding,
                        vertical = verticalPadding,
                    )
                    .alpha(contentAlpha),
                horizontalArrangement = Arrangement.spacedBy(
                    UanInteractiveDefaults.itemSpacing,
                    Alignment.CenterHorizontally,
                ),
                verticalAlignment = Alignment.CenterVertically,
                content = content,
            )
            val indicatorSize: Dp = when (size) {
                UanButtonSize.Compact -> UanButtonDefaults.compactIndicatorSize
                UanButtonSize.Regular -> UanButtonDefaults.regularIndicatorSize
                UanButtonSize.Large -> UanButtonDefaults.largeIndicatorSize
            }
            CircularProgressIndicator(
                modifier = Modifier
                    .size(indicatorSize)
                    .alpha(loadingAlpha),
                color = contentColor,
                strokeWidth = UanButtonDefaults.strokeWidth,
            )
        }
    }
}

/**
 * Sobrecarga de conveniencia con parametro [text].
 *
 * @param text Texto del boton.
 * @param leadingIcon Icono opcional antes del texto.
 * @param trailingIcon Icono opcional despues del texto.
 */
@Composable
fun UanButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    style: UanButtonStyle = UanButtonStyle.Primary,
    size: UanButtonSize = UanButtonSize.Regular,
    fillWidth: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
) {
    val tokens = UanThemeTokens.current
    val contentColor: Color = when (style) {
        UanButtonStyle.Primary -> tokens.colors.onPrimary
        UanButtonStyle.Secondary, UanButtonStyle.Ghost -> tokens.colors.onSurface
        UanButtonStyle.Danger -> tokens.colors.onError
        UanButtonStyle.Warning -> tokens.colors.onWarning
        UanButtonStyle.Critical -> tokens.colors.onCritical
    }

    UanButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        loading = loading,
        style = style,
        size = size,
        fillWidth = fillWidth,
    ) {
        if (leadingIcon != null) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                tint = contentColor,
                modifier = Modifier.size(UanButtonDefaults.iconSize),
            )
        }
        Text(
            text = text,
            color = contentColor,
            style = UanButtonDefaults.textStyle,
        )
        if (trailingIcon != null) {
            Icon(
                imageVector = trailingIcon,
                contentDescription = null,
                tint = contentColor,
                modifier = Modifier.size(UanButtonDefaults.iconSize),
            )
        }
    }
}

