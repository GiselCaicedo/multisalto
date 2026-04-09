package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.PriorityHigh
import androidx.compose.material.icons.filled.Sensors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

/* ═══════════════════════════════════════════════════════════════
 * Preview 1 — Red hexagonal de dispositivos (cubo 3D isometrico)
 * ═══════════════════════════════════════════════════════════════ */

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "NetworkMesh - Red de dispositivos (Figma)",
    widthDp = 220,
    heightDp = 680,
)
@Composable
private fun GenericNetworkMeshPreview() {
    ActivationPreviewContainer {
        Text(
            text = "Red de dispositivos",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        // 3 dispositivos conectados de 6
        UanNetworkMesh(
            connectedCount = 3,
            totalNodes = 6,
            tone = UanTone.Info,
            contentDescription = "3 de 6 dispositivos conectados",
            modifier = Modifier.size(180.dp),
            centerContent = {
                Icon(
                    imageVector = Icons.Default.Sensors,
                    contentDescription = null,
                    tint = UanThemeTokens.current.colors.onInfo,
                    modifier = Modifier.size(20.dp),
                )
            },
        )
        // 5 dispositivos conectados de 6
        UanNetworkMesh(
            connectedCount = 5,
            totalNodes = 6,
            tone = UanTone.Info,
            contentDescription = "5 de 6 dispositivos conectados",
            modifier = Modifier.size(180.dp),
            centerContent = {
                Icon(
                    imageVector = Icons.Default.Sensors,
                    contentDescription = null,
                    tint = UanThemeTokens.current.colors.onInfo,
                    modifier = Modifier.size(20.dp),
                )
            },
        )
        // Todos conectados
        UanNetworkMesh(
            connectedCount = 6,
            totalNodes = 6,
            tone = UanTone.Info,
            contentDescription = "6 de 6 dispositivos conectados",
            modifier = Modifier.size(180.dp),
            centerContent = {
                Icon(
                    imageVector = Icons.Default.Sensors,
                    contentDescription = null,
                    tint = UanThemeTokens.current.colors.onInfo,
                    modifier = Modifier.size(20.dp),
                )
            },
        )
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 2 — Anillos de activacion Info (progresion de tamano)
 * ═══════════════════════════════════════════════════════════════ */

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "Activation - Info progresion (Figma)",
    widthDp = 200,
    heightDp = 560,
)
@Composable
private fun GenericActivationInfoProgressionPreview() {
    ActivationPreviewContainer {
        Text(
            text = "Info",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        val sizes = listOf(40.dp, 64.dp, 88.dp, 120.dp, 160.dp)
        sizes.forEach { s ->
            UanActivationAnimation(
                active = true,
                tone = UanTone.Info,
                ringCount = when {
                    s < 60.dp -> 1
                    s < 80.dp -> 2
                    s < 110.dp -> 3
                    else -> 4
                },
                modifier = Modifier.size(s),
                centerContent = {
                    Icon(
                        imageVector = Icons.Default.Navigation,
                        contentDescription = null,
                        tint = UanThemeTokens.current.colors.onInfo,
                        modifier = Modifier
                            .size(UanActivationAnimationDefaults.centerIconSize)
                            .graphicsLayer { rotationZ = -45f },
                    )
                },
            )
        }
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 3 — Anillos Neutral con labels de distancia (Radar)
 * ═══════════════════════════════════════════════════════════════ */

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "Activation - Neutral con distancia (Figma)",
    widthDp = 220,
    heightDp = 620,
)
@Composable
private fun GenericActivationNeutralWithDistancePreview() {
    val ranges = remember {
        listOf(
            UanRadarRange(distanceMeters = 50f, label = "50m"),
            UanRadarRange(distanceMeters = 100f, label = "100m"),
            UanRadarRange(distanceMeters = 150f, label = "150m"),
            UanRadarRange(distanceMeters = 200f, label = "200m"),
        )
    }
    ActivationPreviewContainer {
        Text(
            text = "Neutral (distancia)",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        // Progresion de tamaños mostrando 1, 2, 3, 4 anillos con labels
        UanRadar(
            distanceMeters = 30f,
            distanceRanges = ranges.take(1),
            state = UanRadarState.Active,
            tone = UanTone.Neutral,
            showScaleLabels = true,
            modifier = Modifier.size(80.dp),
            targetContentDescription = "Objetivo",
        )
        UanRadar(
            distanceMeters = 60f,
            distanceRanges = ranges.take(2),
            state = UanRadarState.Active,
            tone = UanTone.Neutral,
            showScaleLabels = true,
            modifier = Modifier.size(110.dp),
            targetContentDescription = "Objetivo",
        )
        UanRadar(
            distanceMeters = 80f,
            distanceRanges = ranges.take(3),
            state = UanRadarState.Active,
            tone = UanTone.Neutral,
            showScaleLabels = true,
            modifier = Modifier.size(140.dp),
            targetContentDescription = "Objetivo",
        )
        UanRadar(
            distanceMeters = 120f,
            distanceRanges = ranges,
            state = UanRadarState.Active,
            tone = UanTone.Neutral,
            showScaleLabels = true,
            modifier = Modifier.size(180.dp),
            targetContentDescription = "Objetivo",
        )
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 4 — Anillos Success con labels de distancia
 * ═══════════════════════════════════════════════════════════════ */

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "Activation - Success con distancia (Figma)",
    widthDp = 220,
    heightDp = 620,
)
@Composable
private fun GenericActivationSuccessWithDistancePreview() {
    val ranges = remember {
        listOf(
            UanRadarRange(distanceMeters = 50f, label = "50m"),
            UanRadarRange(distanceMeters = 100f, label = "100m"),
            UanRadarRange(distanceMeters = 150f, label = "150m"),
            UanRadarRange(distanceMeters = 200f, label = "200m"),
        )
    }
    ActivationPreviewContainer {
        Text(
            text = "Success (distancia)",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        UanRadar(
            distanceMeters = 30f,
            distanceRanges = ranges.take(1),
            state = UanRadarState.Active,
            tone = UanTone.Success,
            showScaleLabels = true,
            modifier = Modifier.size(80.dp),
            targetContentDescription = "Objetivo",
            targetContent = {
                Icon(
                    imageVector = Icons.Default.Navigation,
                    contentDescription = null,
                    tint = UanThemeTokens.current.colors.onSuccess,
                    modifier = Modifier
                        .size(UanRadarDefaults.targetIconSize)
                        .graphicsLayer { rotationZ = -45f },
                )
            },
        )
        UanRadar(
            distanceMeters = 60f,
            distanceRanges = ranges.take(2),
            state = UanRadarState.Active,
            tone = UanTone.Success,
            showScaleLabels = true,
            modifier = Modifier.size(110.dp),
            targetContentDescription = "Objetivo",
            targetContent = {
                Icon(
                    imageVector = Icons.Default.Navigation,
                    contentDescription = null,
                    tint = UanThemeTokens.current.colors.onSuccess,
                    modifier = Modifier
                        .size(UanRadarDefaults.targetIconSize)
                        .graphicsLayer { rotationZ = -45f },
                )
            },
        )
        UanRadar(
            distanceMeters = 80f,
            distanceRanges = ranges.take(3),
            state = UanRadarState.Active,
            tone = UanTone.Success,
            showScaleLabels = true,
            modifier = Modifier.size(140.dp),
            targetContentDescription = "Objetivo",
            targetContent = {
                Icon(
                    imageVector = Icons.Default.Navigation,
                    contentDescription = null,
                    tint = UanThemeTokens.current.colors.onSuccess,
                    modifier = Modifier
                        .size(UanRadarDefaults.targetIconSize)
                        .graphicsLayer { rotationZ = -45f },
                )
            },
        )
        UanRadar(
            distanceMeters = 120f,
            distanceRanges = ranges,
            state = UanRadarState.Active,
            tone = UanTone.Success,
            showScaleLabels = true,
            modifier = Modifier.size(180.dp),
            targetContentDescription = "Objetivo",
            targetContent = {
                Icon(
                    imageVector = Icons.Default.Navigation,
                    contentDescription = null,
                    tint = UanThemeTokens.current.colors.onSuccess,
                    modifier = Modifier
                        .size(UanRadarDefaults.targetIconSize)
                        .graphicsLayer { rotationZ = -45f },
                )
            },
        )
    }
}

/* ═══════════════════════════════════════════════════════════════
 * Preview 5 — Todos los tonos + estados
 * ═══════════════════════════════════════════════════════════════ */

@Preview(
    showBackground = true,
    backgroundColor = 0xFF090B0F,
    name = "Activation - Tonos y estados",
    widthDp = 400,
)
@Composable
private fun GenericActivationAllTonesPreview() {
    ActivationPreviewContainer {
        Text(
            text = "Tonos",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            UanActivationAnimation(
                active = true,
                tone = UanTone.Info,
                modifier = Modifier.weight(1f).size(80.dp),
                ringCount = 3,
                centerContent = {
                    Icon(
                        imageVector = Icons.Default.Navigation,
                        contentDescription = null,
                        tint = UanThemeTokens.current.colors.onInfo,
                        modifier = Modifier
                            .size(UanActivationAnimationDefaults.centerIconSize)
                            .graphicsLayer { rotationZ = -45f },
                    )
                },
            )
            UanActivationAnimation(
                active = true,
                tone = UanTone.Success,
                modifier = Modifier.weight(1f).size(80.dp),
                ringCount = 3,
                centerContent = {
                    Icon(
                        imageVector = Icons.Default.Navigation,
                        contentDescription = null,
                        tint = UanThemeTokens.current.colors.onSuccess,
                        modifier = Modifier
                            .size(UanActivationAnimationDefaults.centerIconSize)
                            .graphicsLayer { rotationZ = -45f },
                    )
                },
            )
            UanActivationAnimation(
                active = true,
                tone = UanTone.Critical,
                modifier = Modifier.weight(1f).size(80.dp),
                ringCount = 3,
                centerContent = {
                    Icon(
                        imageVector = Icons.Default.PriorityHigh,
                        contentDescription = null,
                        tint = UanThemeTokens.current.colors.onCritical,
                        modifier = Modifier.size(UanActivationAnimationDefaults.centerIconSize),
                    )
                },
            )
            UanActivationAnimation(
                active = true,
                tone = UanTone.Warning,
                modifier = Modifier.weight(1f).size(80.dp),
                ringCount = 3,
            )
        }

        Text(
            text = "Inactivo vs Activo",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = "Inactivo",
                    style = UanThemeTokens.current.typography.supporting,
                    color = UanThemeTokens.current.colors.muted,
                )
                UanActivationAnimation(
                    active = false,
                    tone = UanTone.Info,
                    modifier = Modifier.size(100.dp),
                    centerContent = {
                        Icon(
                            imageVector = Icons.Default.Navigation,
                            contentDescription = null,
                            tint = UanThemeTokens.current.colors.onInfo,
                            modifier = Modifier
                                .size(UanActivationAnimationDefaults.centerIconSize)
                                .graphicsLayer { rotationZ = -45f },
                        )
                    },
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = "Activo",
                    style = UanThemeTokens.current.typography.supporting,
                    color = UanThemeTokens.current.colors.muted,
                )
                UanActivationAnimation(
                    active = true,
                    tone = UanTone.Info,
                    modifier = Modifier.size(100.dp),
                    centerContent = {
                        Icon(
                            imageVector = Icons.Default.Navigation,
                            contentDescription = null,
                            tint = UanThemeTokens.current.colors.onInfo,
                            modifier = Modifier
                                .size(UanActivationAnimationDefaults.centerIconSize)
                                .graphicsLayer { rotationZ = -45f },
                        )
                    },
                )
            }
        }
    }
}

@Composable
private fun ActivationPreviewContainer(
    content: @Composable () -> Unit,
) {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(tokens.colors.background)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            content()
        }
    }
}
