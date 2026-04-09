package com.uan.designsystem.uikit.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.foundation.colorFor
import com.uan.designsystem.uikit.theme.UanThemeTokens
import kotlin.math.cos
import kotlin.math.sin

/**
 * Estado de un nodo dentro de la red.
 */
enum class UanMeshNodeState {
    Idle,
    Connected,
    Active,
    Disconnected,
}

/**
 * Modelo de un nodo de la red.
 */
@Immutable
data class UanMeshNode(
    val state: UanMeshNodeState,
    val label: String = "",
)

/**
 * Visualizacion de red de dispositivos del sistema Uan.
 *
 * Dibuja un cubo isometrico (hexagono 3D) con nodos en los vertices
 * y aristas conectadas con lineas punteadas. El nodo central se destaca
 * como el dispositivo principal (mas grande, color del tono activo).
 *
 * Los nodos perifericos se distribuyen en un patron hexagonal alrededor
 * del centro, conectados entre si y al centro con lineas punteadas.
 *
 * @param connectedCount Cantidad de nodos perifericos conectados (azules).
 * @param totalNodes Cantidad total de nodos perifericos.
 * @param modifier Modificador externo.
 * @param tone Tono cromatico para nodos conectados y el centro.
 * @param contentDescription Descripcion accesible.
 * @param centerContent Contenido composable del nodo central (icono).
 */
@Composable
fun UanNetworkMesh(
    connectedCount: Int,
    totalNodes: Int,
    modifier: Modifier = Modifier,
    tone: UanTone = UanTone.Info,
    contentDescription: String = "Red de dispositivos",
    centerContent: (@Composable () -> Unit)? = null,
) {
    val tokens = UanThemeTokens.current
    val colors = tokens.colors
    val toneColor = tone.colorFor(colors)
    val idleColor = colors.outline
    val disconnectedColor = colors.muted.copy(alpha = 0.4f)

    val centerNodeSize = UanNetworkMeshDefaults.centerNodeSize
    val peripheralNodeSize = UanNetworkMeshDefaults.peripheralNodeSize
    val lineStrokeWidth = UanNetworkMeshDefaults.lineStrokeWidth
    val dashInterval = UanNetworkMeshDefaults.dashInterval

    val stateDesc = "$connectedCount de $totalNodes conectados"

    Box(
        modifier = modifier
            .defaultMinSize(
                minWidth = UanNetworkMeshDefaults.minSize,
                minHeight = UanNetworkMeshDefaults.minSize,
            )
            .semantics {
                this.contentDescription = contentDescription
                this.stateDescription = stateDesc
            },
        contentAlignment = Alignment.Center,
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val center = Offset(size.width / 2f, size.height / 2f)
            val hexRadius = size.minDimension * 0.38f
            val nodePx = peripheralNodeSize.toPx()
            val centerPx = centerNodeSize.toPx()
            val strokePx = lineStrokeWidth.toPx()
            val dashPx = dashInterval.toPx()

            // Compute hexagonal node positions (6 around center)
            val hexNodes = (0 until totalNodes.coerceAtMost(12)).map { i ->
                val angle = (Math.PI / 6.0) + (i.toDouble() / totalNodes.coerceAtMost(12)) * Math.PI * 2
                Offset(
                    x = center.x + (cos(angle) * hexRadius).toFloat(),
                    y = center.y + (sin(angle) * hexRadius).toFloat(),
                )
            }

            val dashEffect = PathEffect.dashPathEffect(
                floatArrayOf(dashPx, dashPx * 0.8f),
                0f,
            )

            // Draw connections: center to each node
            hexNodes.forEachIndexed { i, pos ->
                val isConnected = i < connectedCount
                val lineColor = if (isConnected) toneColor else idleColor
                drawLine(
                    color = lineColor.copy(alpha = if (isConnected) 0.7f else 0.3f),
                    start = center,
                    end = pos,
                    strokeWidth = strokePx,
                    cap = StrokeCap.Round,
                    pathEffect = dashEffect,
                )
            }

            // Draw connections between adjacent peripheral nodes
            for (i in hexNodes.indices) {
                val j = (i + 1) % hexNodes.size
                val eitherConnected = i < connectedCount || j < connectedCount
                val bothConnected = i < connectedCount && j < connectedCount
                val lineColor = when {
                    bothConnected -> toneColor
                    eitherConnected -> idleColor
                    else -> idleColor
                }
                drawLine(
                    color = lineColor.copy(alpha = if (bothConnected) 0.5f else 0.2f),
                    start = hexNodes[i],
                    end = hexNodes[j],
                    strokeWidth = strokePx,
                    cap = StrokeCap.Round,
                    pathEffect = dashEffect,
                )
            }

            // Draw peripheral nodes
            hexNodes.forEachIndexed { i, pos ->
                val isConnected = i < connectedCount
                val nodeColor = if (isConnected) toneColor else idleColor
                val nodeAlpha = if (isConnected) 0.85f else 0.45f
                // Outer ring
                drawCircle(
                    color = nodeColor.copy(alpha = nodeAlpha),
                    radius = nodePx / 2f,
                    center = pos,
                    style = androidx.compose.ui.graphics.drawscope.Stroke(width = strokePx),
                )
                // Inner dot
                drawCircle(
                    color = nodeColor.copy(alpha = if (isConnected) 0.6f else 0.25f),
                    radius = nodePx / 4f,
                    center = pos,
                )
            }

            // Center node background circle
            drawCircle(
                color = toneColor,
                radius = centerPx / 2f,
                center = center,
            )
        }

        // Center content overlay
        Box(
            modifier = Modifier.size(centerNodeSize),
            contentAlignment = Alignment.Center,
        ) {
            if (centerContent != null) {
                centerContent()
            }
        }
    }
}

object UanNetworkMeshDefaults {
    val minSize: Dp = 160.dp
    val centerNodeSize: Dp = 36.dp
    val peripheralNodeSize: Dp = 24.dp
    val lineStrokeWidth: Dp = 1.5.dp
    val dashInterval: Dp = 4.dp
}
