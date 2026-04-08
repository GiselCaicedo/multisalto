package com.uan.designsystem.uikit.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.dismiss
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.paneTitle
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.uan.designsystem.uikit.foundation.UanIconButton
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.foundation.color
import com.uan.designsystem.uikit.foundation.rememberUanReduceMotion
import com.uan.designsystem.uikit.theme.UanThemeTokens

/**
 * Datos de una accion del modal.
 *
 * @param label Texto del boton.
 * @param onClick Callback al pulsar.
 * @param style Estilo visual del boton.
 * @param enabled Si la accion esta habilitada.
 * @param loading Si la accion esta en estado de carga.
 */
data class UanModalAction(
    val label: String,
    val onClick: () -> Unit,
    val style: UanButtonStyle = UanButtonStyle.Secondary,
    val enabled: Boolean = true,
    val loading: Boolean = false,
)

/**
 * Modal principal del sistema de diseno Uan.
 *
 * Ventana centrada y obligatoria que interrumpe el flujo principal para
 * acciones criticas (confirmacion reforzada) o presentacion de informacion
 * vital de autoproteccion.
 *
 * Soporta 4 variantes segun la combinacion de parametros:
 * - **Alert**: Solo titulo + cuerpo, sin media ni cierre. Usa [tone] para
 *   indicar urgencia (Danger, Critical, Success...).
 * - **Media Carousel**: Titulo + slot de media (imagen/carrusel).
 * - **Content**: Titulo + subtitulo + cuerpo + media opcional.
 * - **Content + Dismiss**: Igual que Content con boton x para cerrar.
 *
 * @param visible Controla la visibilidad del modal (estado hoisted).
 * @param onDismissRequest Callback al intentar cerrar (back, scrim).
 * @param modifier Modificador externo.
 * @param title Titulo principal del modal.
 * @param subtitle Subtitulo opcional.
 * @param body Texto del cuerpo.
 * @param tone Tono semantico que controla el acento lateral y color del titulo.
 * @param showCloseButton Si muestra el boton x para cerrar.
 * @param primaryAction Accion primaria (boton izquierdo).
 * @param secondaryAction Accion secundaria (boton derecho).
 * @param dismissOnBackPress Si se cierra al pulsar atras.
 * @param dismissOnClickOutside Si se cierra al pulsar fuera.
 * @param media Slot composable para imagen o carrusel.
 * @param navigationAction Slot para boton de navegacion (back/chevron).
 */
@Composable
fun UanModal(
    visible: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    title: String = "",
    subtitle: String? = null,
    body: String? = null,
    tone: UanTone = UanTone.Neutral,
    showCloseButton: Boolean = false,
    primaryAction: UanModalAction? = null,
    secondaryAction: UanModalAction? = null,
    dismissOnBackPress: Boolean = true,
    dismissOnClickOutside: Boolean = false,
    media: (@Composable () -> Unit)? = null,
    navigationAction: (@Composable () -> Unit)? = null,
) {
    val tokens = UanThemeTokens.current
    val reduceMotion = rememberUanReduceMotion()
    val motionDuration = if (reduceMotion) 0 else tokens.motion.durationMedium

    if (visible) {
        Dialog(
            onDismissRequest = onDismissRequest,
            properties = DialogProperties(
                dismissOnBackPress = dismissOnBackPress,
                dismissOnClickOutside = dismissOnClickOutside,
                usePlatformDefaultWidth = false,
            ),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = UanModalDefaults.scrimAlpha))
                    .then(
                        if (dismissOnClickOutside) {
                            Modifier.clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = onDismissRequest,
                            )
                        } else {
                            Modifier
                        }
                    )
                    .semantics {
                        if (showCloseButton) {
                            dismiss { onDismissRequest(); true }
                        }
                    },
                contentAlignment = Alignment.Center,
            ) {
                AnimatedVisibility(
                    visible = visible,
                    enter = fadeIn(tween(motionDuration)) + scaleIn(
                        initialScale = 0.92f,
                        animationSpec = tween(
                            motionDuration,
                            easing = tokens.motion.easingEmphasized,
                        ),
                    ),
                    exit = fadeOut(tween(motionDuration)) + scaleOut(
                        targetScale = 0.92f,
                        animationSpec = tween(
                            motionDuration,
                            easing = tokens.motion.easingStandard,
                        ),
                    ),
                ) {
                    UanModalContent(
                        modifier = modifier,
                        title = title,
                        subtitle = subtitle,
                        body = body,
                        tone = tone,
                        showCloseButton = showCloseButton,
                        onDismissRequest = onDismissRequest,
                        primaryAction = primaryAction,
                        secondaryAction = secondaryAction,
                        media = media,
                        navigationAction = navigationAction,
                    )
                }
            }
        }
    }
}

@Composable
internal fun UanModalContent(
    modifier: Modifier,
    title: String,
    subtitle: String?,
    body: String?,
    tone: UanTone,
    showCloseButton: Boolean,
    onDismissRequest: () -> Unit,
    primaryAction: UanModalAction?,
    secondaryAction: UanModalAction?,
    media: (@Composable () -> Unit)?,
    navigationAction: (@Composable () -> Unit)?,
) {
    val tokens = UanThemeTokens.current
    val colors = tokens.colors
    val toneColor = tone.color()
    val isNeutral = tone == UanTone.Neutral
    val containerShape = RoundedCornerShape(UanModalDefaults.containerCornerRadius)
    val modalMaxWidth = tokens.grid.touchTarget * 7 + tokens.spacing.xs

    val toneLabel = when (tone) {
        UanTone.Neutral -> "informativo"
        UanTone.Primary -> "principal"
        UanTone.Success -> "exito"
        UanTone.Info -> "informacion"
        UanTone.Warning -> "advertencia"
        UanTone.Danger -> "peligro"
        UanTone.Critical -> "critico"
    }

    Row(
        modifier = modifier
            .widthIn(max = modalMaxWidth)
            .height(IntrinsicSize.Min)
            .clip(containerShape)
            .background(colors.surface, containerShape)
            .semantics(mergeDescendants = true) {
                paneTitle = title
                liveRegion = LiveRegionMode.Polite
                stateDescription = "Dialogo $toneLabel"
            },
    ) {
        // Acento lateral semantico
        if (!isNeutral) {
            Box(
                modifier = Modifier
                    .width(UanModalDefaults.toneAccentWidth)
                    .fillMaxHeight()
                    .background(toneColor),
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(
                    horizontal = UanModalDefaults.contentPaddingHorizontal,
                    vertical = UanModalDefaults.contentPaddingVertical,
                ),
        ) {
            // Header: titulo + boton cerrar
            ModalHeader(
                title = title,
                toneColor = toneColor,
                isNeutral = isNeutral,
                showCloseButton = showCloseButton,
                onDismissRequest = onDismissRequest,
            )

            // Subtitulo
            if (subtitle != null) {
                Spacer(Modifier.height(UanModalDefaults.titleSubtitleSpacing))
                Text(
                    text = subtitle,
                    style = UanModalDefaults.subtitleStyle,
                    color = colors.onSurface,
                )
            }

            // Cuerpo
            if (body != null) {
                Spacer(Modifier.height(UanModalDefaults.bodySpacing))
                Text(
                    text = body,
                    style = UanModalDefaults.bodyStyle,
                    color = colors.muted,
                )
            }

            // Media
            if (media != null) {
                Spacer(Modifier.height(UanModalDefaults.mediaSpacing))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = UanModalDefaults.mediaMaxHeight)
                        .clip(
                            RoundedCornerShape(UanModalDefaults.mediaCornerRadius),
                        ),
                ) {
                    media()
                }
            }

            // Acciones
            val hasActions =
                primaryAction != null || secondaryAction != null || navigationAction != null
            if (hasActions) {
                Spacer(Modifier.height(UanModalDefaults.actionsSpacing))
                ModalActions(
                    primaryAction = primaryAction,
                    secondaryAction = secondaryAction,
                    navigationAction = navigationAction,
                )
            }
        }
    }
}

@Composable
private fun ModalHeader(
    title: String,
    toneColor: Color,
    isNeutral: Boolean,
    showCloseButton: Boolean,
    onDismissRequest: () -> Unit,
) {
    val tokens = UanThemeTokens.current
    val titleColor = if (isNeutral) tokens.colors.onSurface else toneColor

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            style = UanModalDefaults.titleStyle,
            color = titleColor,
            modifier = Modifier.weight(1f, fill = false),
        )

        if (showCloseButton) {
            UanIconButton(
                contentDescription = "Cerrar dialogo",
                onClick = onDismissRequest,
                borderColor = tokens.colors.outline,
                shape = RoundedCornerShape(tokens.shapes.smallRadius),
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = tokens.colors.onSurface,
                )
            }
        }
    }
}

@Composable
private fun ModalActions(
    primaryAction: UanModalAction?,
    secondaryAction: UanModalAction?,
    navigationAction: (@Composable () -> Unit)?,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            UanModalDefaults.actionButtonSpacing,
            Alignment.Start,
        ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (navigationAction != null) {
            navigationAction()
        }

        // Empujar botones a la derecha si hay navigationAction
        if (navigationAction != null) {
            Spacer(Modifier.weight(1f))
        }

        if (primaryAction != null) {
            UanButton(
                text = primaryAction.label,
                onClick = primaryAction.onClick,
                style = primaryAction.style,
                enabled = primaryAction.enabled,
                loading = primaryAction.loading,
                size = UanButtonSize.Regular,
            )
        }

        if (secondaryAction != null) {
            UanButton(
                text = secondaryAction.label,
                onClick = secondaryAction.onClick,
                style = secondaryAction.style,
                enabled = secondaryAction.enabled,
                loading = secondaryAction.loading,
                size = UanButtonSize.Regular,
            )
        }
    }
}

