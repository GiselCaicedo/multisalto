package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

private val ParoCardiacoStatusSteps = listOf(
    UanProgressStep(
        label = "1",
        state = UanProgressStepState.Completed,
        contentDescription = "Paso 1 completado",
    ),
    UanProgressStep(
        label = "2",
        state = UanProgressStepState.Completed,
        contentDescription = "Paso 2 completado",
    ),
    UanProgressStep(
        label = "3",
        state = UanProgressStepState.Critical,
        contentDescription = "Paso 3 critico",
    ),
)

private val EvacuacionWarningSteps = listOf(
    UanProgressStep(
        label = "1",
        state = UanProgressStepState.Completed,
        contentDescription = "Paso 1 completado",
    ),
    UanProgressStep(
        label = "2",
        state = UanProgressStepState.Warning,
        contentDescription = "Paso 2 con advertencia",
    ),
    UanProgressStep(
        label = "3",
        state = UanProgressStepState.Pending,
        contentDescription = "Paso 3 pendiente",
    ),
)

private val PacienteEstabilizadoSteps = listOf(
    UanProgressStep(
        label = "1",
        state = UanProgressStepState.Completed,
        contentDescription = "Paso 1 completado",
    ),
    UanProgressStep(
        label = "2",
        state = UanProgressStepState.Completed,
        contentDescription = "Paso 2 completado",
    ),
    UanProgressStep(
        label = "3",
        state = UanProgressStepState.Current,
        contentDescription = "Paso 3 actual",
    ),
    UanProgressStep(
        label = "4",
        state = UanProgressStepState.Pending,
        contentDescription = "Paso 4 pendiente",
    ),
)

private val TrasladoLoadingSteps = listOf(
    UanProgressStep(
        label = "1",
        state = UanProgressStepState.Completed,
        contentDescription = "Paso 1 completado",
    ),
    UanProgressStep(
        label = "2",
        state = UanProgressStepState.Loading,
        contentDescription = "Paso 2 en carga",
    ),
    UanProgressStep(
        label = "3",
        state = UanProgressStepState.Pending,
        contentDescription = "Paso 3 pendiente",
    ),
)

private val ZonaRestringidaDisabledSteps = listOf(
    UanProgressStep(
        label = "1",
        state = UanProgressStepState.Completed,
        contentDescription = "Paso 1 completado",
    ),
    UanProgressStep(
        label = "2",
        state = UanProgressStepState.Disabled,
        contentDescription = "Paso 2 deshabilitado",
    ),
    UanProgressStep(
        label = "3",
        state = UanProgressStepState.Disabled,
        contentDescription = "Paso 3 deshabilitado",
    ),
)

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun ParoCardiacoIndicadorCriticoPreview() {
    ProgressIndicatorPreviewContainer {
        val steps = remember { ParoCardiacoStatusSteps }
        UanProgressIndicator(
            steps = steps,
            variant = UanProgressIndicatorVariant.Status,
            currentTone = UanTone.Critical,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun EvacuacionIndicadorAdvertenciaPreview() {
    ProgressIndicatorPreviewContainer {
        val steps = remember { EvacuacionWarningSteps }
        UanProgressIndicator(
            steps = steps,
            variant = UanProgressIndicatorVariant.Status,
            currentTone = UanTone.Warning,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun PacienteEstabilizadoNumeradoPreview() {
    ProgressIndicatorPreviewContainer {
        val steps = remember { PacienteEstabilizadoSteps }
        UanProgressIndicator(
            steps = steps,
            variant = UanProgressIndicatorVariant.Numbered,
            currentTone = UanTone.Success,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun AmbulanciaEnCaminoLoadingPreview() {
    ProgressIndicatorPreviewContainer {
        val steps = remember { TrasladoLoadingSteps }
        UanProgressIndicator(
            steps = steps,
            variant = UanProgressIndicatorVariant.Status,
            currentTone = UanTone.Warning,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F)
@Composable
private fun ZonaRestringidaDeshabilitadoPreview() {
    ProgressIndicatorPreviewContainer {
        val steps = remember { ZonaRestringidaDisabledSteps }
        UanProgressIndicator(
            steps = steps,
            variant = UanProgressIndicatorVariant.Status,
            enabled = false,
            currentTone = UanTone.Info,
        )
    }
}

@Composable
private fun ProgressIndicatorPreviewContainer(
    content: @Composable () -> Unit,
) {
    UanTheme {
        val tokens = UanThemeTokens.current
        Column(
            modifier = Modifier
                .background(tokens.colors.background)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            content()
        }
    }
}

