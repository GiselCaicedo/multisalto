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
        contentDescription = "Activacion del codigo azul completada",
    ),
    UanProgressStep(
        label = "2",
        state = UanProgressStepState.Completed,
        contentDescription = "DEA ubicado y listo",
    ),
    UanProgressStep(
        label = "3",
        state = UanProgressStepState.Critical,
        contentDescription = "Descarga inmediata requerida",
    ),
)

private val EvacuacionWarningSteps = listOf(
    UanProgressStep(
        label = "1",
        state = UanProgressStepState.Completed,
        contentDescription = "Ruta despejada",
    ),
    UanProgressStep(
        label = "2",
        state = UanProgressStepState.Warning,
        contentDescription = "Punto de reunion saturado",
    ),
    UanProgressStep(
        label = "3",
        state = UanProgressStepState.Pending,
        contentDescription = "Traslado pendiente",
    ),
)

private val PacienteEstabilizadoSteps = listOf(
    UanProgressStep(
        label = "1",
        state = UanProgressStepState.Completed,
        contentDescription = "Valoracion primaria completada",
    ),
    UanProgressStep(
        label = "2",
        state = UanProgressStepState.Completed,
        contentDescription = "Oxigenacion estable",
    ),
    UanProgressStep(
        label = "3",
        state = UanProgressStepState.Current,
        contentDescription = "Monitoreo activo del paciente",
    ),
    UanProgressStep(
        label = "4",
        state = UanProgressStepState.Pending,
        contentDescription = "Entrega al equipo medico pendiente",
    ),
)

private val TrasladoLoadingSteps = listOf(
    UanProgressStep(
        label = "1",
        state = UanProgressStepState.Completed,
        contentDescription = "Triager realizado",
    ),
    UanProgressStep(
        label = "2",
        state = UanProgressStepState.Loading,
        contentDescription = "Ambulancia en aproximacion",
    ),
    UanProgressStep(
        label = "3",
        state = UanProgressStepState.Pending,
        contentDescription = "Ingreso a urgencias pendiente",
    ),
)

private val ZonaRestringidaDisabledSteps = listOf(
    UanProgressStep(
        label = "1",
        state = UanProgressStepState.Completed,
        contentDescription = "Perimetro inicial asegurado",
    ),
    UanProgressStep(
        label = "2",
        state = UanProgressStepState.Disabled,
        contentDescription = "Ingreso bloqueado por riesgo electrico",
    ),
    UanProgressStep(
        label = "3",
        state = UanProgressStepState.Disabled,
        contentDescription = "Rescate suspendido temporalmente",
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

