package com.uan.designsystem.uikit.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import com.uan.designsystem.uikit.foundation.UanInteractiveDefaults
import com.uan.designsystem.uikit.foundation.rememberUanReduceMotion
import com.uan.designsystem.uikit.theme.UanThemeTokens

/**
 * Barra de navegacion principal del sistema de diseno Uan.
 *
 * Limitada a exactamente dos secciones para garantizar una jerarquia
 * clara y minimizar la carga cognitiva bajo estres. Cada seccion se
 * representa como un item circular seleccionable.
 *
 * @param selectedIndex Indice del item seleccionado (0 = inicio, 1 = fin).
 *   Usa -1 si ninguno esta seleccionado.
 * @param onItemSelected Callback al seleccionar un item con su indice.
 * @param modifier Modificador externo.
 * @param enabled Estado habilitado/inhabilitado de toda la barra.
 * @param startContentDescription Descripcion accesible del item de inicio.
 * @param endContentDescription Descripcion accesible del item de fin.
 * @param containerColor Color de fondo del contenedor.
 * @param selectedIndicatorColor Color del indicador circular cuando esta seleccionado.
 * @param startContent Slot composable para el contenido del item de inicio (icono/texto).
 * @param endContent Slot composable para el contenido del item de fin (icono/texto).
 */
@Composable
fun UanToolbar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    startContentDescription: String = "",
    endContentDescription: String = "",
    containerColor: Color = UanThemeTokens.current.colors.surface,
    selectedIndicatorColor: Color = UanThemeTokens.current.colors.primary,
    startContent: @Composable () -> Unit,
    endContent: @Composable () -> Unit,
) {
    val tokens = UanThemeTokens.current
    val colors = tokens.colors
    val containerShape = RoundedCornerShape(UanToolbarDefaults.containerCornerRadius)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(UanToolbarDefaults.height)
            .clip(containerShape)
            .background(containerColor, containerShape)
            .border(
                UanToolbarDefaults.containerBorderWidth,
                colors.outlineVariant,
                containerShape,
            )
            .alpha(if (enabled) 1f else UanInteractiveDefaults.disabledAlpha),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ToolbarItem(
            index = 0,
            selected = selectedIndex == 0,
            enabled = enabled,
            contentDescription = startContentDescription,
            selectedIndicatorColor = selectedIndicatorColor,
            onClick = { onItemSelected(0) },
            content = startContent,
        )

        ToolbarItem(
            index = 1,
            selected = selectedIndex == 1,
            enabled = enabled,
            contentDescription = endContentDescription,
            selectedIndicatorColor = selectedIndicatorColor,
            onClick = { onItemSelected(1) },
            content = endContent,
        )
    }
}

@Composable
private fun ToolbarItem(
    index: Int,
    selected: Boolean,
    enabled: Boolean,
    contentDescription: String,
    selectedIndicatorColor: Color,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    val tokens = UanThemeTokens.current
    val reduceMotion = rememberUanReduceMotion()
    val motionDuration = if (reduceMotion) 0 else tokens.motion.durationShort
    val interactionSource = remember { MutableInteractionSource() }

    val indicatorColor by animateColorAsState(
        targetValue = if (selected) selectedIndicatorColor else Color.Transparent,
        animationSpec = tween(motionDuration),
        label = "toolbarIndicator$index",
    )

    val stateDesc = when {
        !enabled -> "inhabilitado"
        selected -> "seleccionado"
        else -> "no seleccionado"
    }

    Box(
        modifier = Modifier
            .size(UanInteractiveDefaults.minTouchTarget)
            .clip(CircleShape)
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = ripple(bounded = true),
                role = Role.Tab,
                onClick = onClick,
            )
            .semantics {
                this.contentDescription = contentDescription
                role = Role.Tab
                this.selected = selected
                this.stateDescription = stateDesc
                if (!enabled) disabled()
            },
        contentAlignment = Alignment.Center,
    ) {
        // Indicador circular de seleccion
        Box(
            modifier = Modifier
                .size(UanToolbarDefaults.indicatorSize)
                .clip(CircleShape)
                .background(indicatorColor, CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            content()
        }
    }
}

