package com.uan.designsystem.uikit.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.semantics
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.foundation.colorFor
import com.uan.designsystem.uikit.foundation.rememberUanReduceMotion
import com.uan.designsystem.uikit.theme.UanThemeTokens

/**
 * Animacion de activacion del sistema Uan.
 *
 * Muestra anillos concentricos pulsantes emanando desde un punto central,
 * confirmando visualmente que una accion ha sido iniciada.
 *
 * @param active Si la animacion esta activa (anillos pulsantes) o inactiva (estaticos).
 * @param modifier Modificador externo.
 * @param tone Tono cromatico de los anillos y centro.
 * @param ringCount Cantidad de anillos concentricos.
 * @param contentDescription Descripcion accesible.
 * @param centerContent Contenido composable del punto central (icono).
 */
@Composable
fun UanActivationAnimation(
    active: Boolean,
    modifier: Modifier = Modifier,
    tone: UanTone = UanTone.Info,
    ringCount: Int = 4,
    contentDescription: String = "Animacion de activacion",
    centerContent: (@Composable () -> Unit)? = null,
) {
    val tokens = UanThemeTokens.current
    val colors = tokens.colors
    val reduceMotion = rememberUanReduceMotion()
    val duration = if (reduceMotion) 0 else tokens.motion.durationActivation
    val transition = rememberInfiniteTransition(label = "activation")
    val pulse by transition.animateFloat(
        initialValue = 0f,
        targetValue = if (active) 1f else 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = duration.coerceAtLeast(1)),
            repeatMode = RepeatMode.Restart,
        ),
        label = "activationPulse",
    )
    val toneColor = tone.colorFor(colors)
    val centerSize = UanActivationAnimationDefaults.centerSize
    val ringStrokeWidth = UanActivationAnimationDefaults.ringStrokeWidth

    Box(
        modifier = modifier
            .defaultMinSize(
                minWidth = UanActivationAnimationDefaults.minSize,
                minHeight = UanActivationAnimationDefaults.minSize,
            )
            .semantics {
                this.contentDescription = contentDescription
                stateDescription = if (active) "activo" else "inactivo"
            },
        contentAlignment = Alignment.Center,
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val center = Offset(size.width / 2f, size.height / 2f)
            val maxRadius = size.minDimension * 0.46f
            val ringSpacing = maxRadius / ringCount.coerceAtLeast(1)
            val strokeWidth = ringStrokeWidth.toPx()

            repeat(ringCount) { index ->
                val animatedRadius = if (active && !reduceMotion) {
                    ((index + pulse) % ringCount.toFloat() + 1f) * ringSpacing
                } else {
                    (index + 1) * ringSpacing
                }
                val alpha = if (active) {
                    1f - (animatedRadius / maxRadius).coerceIn(0f, 1f) * 0.65f
                } else {
                    0.5f - index * 0.08f
                }.coerceAtLeast(0.15f)

                drawCircle(
                    color = toneColor.copy(alpha = alpha),
                    radius = animatedRadius,
                    center = center,
                    style = Stroke(width = strokeWidth),
                )
            }
        }

        Box(
            modifier = Modifier
                .size(centerSize)
                .background(
                    color = toneColor,
                    shape = CircleShape,
                ),
            contentAlignment = Alignment.Center,
        ) {
            if (centerContent != null) {
                centerContent()
            }
        }
    }
}
