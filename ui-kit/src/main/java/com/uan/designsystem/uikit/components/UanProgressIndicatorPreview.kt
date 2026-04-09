package com.uan.designsystem.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uan.designsystem.uikit.foundation.UanTone
import com.uan.designsystem.uikit.theme.UanTheme
import com.uan.designsystem.uikit.theme.UanThemeTokens

private val StatusStepsCritical = listOf(
    UanProgressStep("1", UanProgressStepState.Completed, "Paso 1 completado"),
    UanProgressStep("2", UanProgressStepState.Completed, "Paso 2 completado"),
    UanProgressStep("3", UanProgressStepState.Critical, "Paso 3 critico"),
)

private val StatusStepsWarning = listOf(
    UanProgressStep("1", UanProgressStepState.Completed, "Paso 1 completado"),
    UanProgressStep("2", UanProgressStepState.Warning, "Paso 2 con advertencia"),
    UanProgressStep("3", UanProgressStepState.Pending, "Paso 3 pendiente"),
)

private val StatusStepsNumbered = listOf(
    UanProgressStep("1", UanProgressStepState.Completed, "Paso 1 completado"),
    UanProgressStep("2", UanProgressStepState.Completed, "Paso 2 completado"),
    UanProgressStep("3", UanProgressStepState.Current, "Paso 3 actual"),
    UanProgressStep("4", UanProgressStepState.Pending, "Paso 4 pendiente"),
)

private val StatusStepsLoading = listOf(
    UanProgressStep("1", UanProgressStepState.Completed, "Paso 1 completado"),
    UanProgressStep("2", UanProgressStepState.Loading, "Paso 2 en carga"),
    UanProgressStep("3", UanProgressStepState.Pending, "Paso 3 pendiente"),
)

private val StatusStepsDisabled = listOf(
    UanProgressStep("1", UanProgressStepState.Completed, "Paso 1 completado"),
    UanProgressStep("2", UanProgressStepState.Disabled, "Paso 2 deshabilitado"),
    UanProgressStep("3", UanProgressStepState.Disabled, "Paso 3 deshabilitado"),
)

@Preview(showBackground = true, backgroundColor = 0xFF090B0F, name = "Progreso - Status variantes")
@Composable
private fun GenericProgressStatusPreview() {
    ProgressIndicatorPreviewContainer {
        Text(
            text = "Status (iconografico)",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        UanProgressIndicator(
            steps = remember { StatusStepsCritical },
            variant = UanProgressIndicatorVariant.Status,
            currentTone = UanTone.Critical,
        )
        UanProgressIndicator(
            steps = remember { StatusStepsWarning },
            variant = UanProgressIndicatorVariant.Status,
            currentTone = UanTone.Warning,
        )
        UanProgressIndicator(
            steps = remember { StatusStepsLoading },
            variant = UanProgressIndicatorVariant.Status,
            currentTone = UanTone.Warning,
        )
        UanProgressIndicator(
            steps = remember { StatusStepsDisabled },
            variant = UanProgressIndicatorVariant.Status,
            enabled = false,
            currentTone = UanTone.Info,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F, name = "Progreso - Numerado")
@Composable
private fun GenericProgressNumberedPreview() {
    ProgressIndicatorPreviewContainer {
        Text(
            text = "Numerado",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        UanProgressIndicator(
            steps = remember { StatusStepsNumbered },
            variant = UanProgressIndicatorVariant.Numbered,
            currentTone = UanTone.Success,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090B0F, name = "UanNumberedProgress")
@Composable
private fun GenericNumberedProgressPreview() {
    ProgressIndicatorPreviewContainer {
        Text(
            text = "UanNumberedProgress (wrapper)",
            style = UanThemeTokens.current.typography.component,
            color = UanThemeTokens.current.colors.onSurface,
        )
        Text(
            text = "Paso 1 de 3",
            style = UanThemeTokens.current.typography.supporting,
            color = UanThemeTokens.current.colors.muted,
        )
        UanNumberedProgress(
            totalSteps = 3,
            currentStep = 1,
        )
        Text(
            text = "Paso 2 de 4",
            style = UanThemeTokens.current.typography.supporting,
            color = UanThemeTokens.current.colors.muted,
        )
        UanNumberedProgress(
            totalSteps = 4,
            currentStep = 2,
        )
        Text(
            text = "Paso 3 de 4 (con warning en paso 4)",
            style = UanThemeTokens.current.typography.supporting,
            color = UanThemeTokens.current.colors.muted,
        )
        UanNumberedProgress(
            totalSteps = 4,
            currentStep = 3,
            warningSteps = setOf(4),
        )
        Text(
            text = "Completado",
            style = UanThemeTokens.current.typography.supporting,
            color = UanThemeTokens.current.colors.muted,
        )
        UanNumberedProgress(
            totalSteps = 3,
            currentStep = 4,
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
