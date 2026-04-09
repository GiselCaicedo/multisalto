package com.uan.designsystem.uikit.foundation

import androidx.compose.runtime.Composable

/**
 * Indica si el usuario ha activado "reducir movimiento" en el SO.
 *
 * TODO: Implementar lectura real de `Settings.Global.ANIMATOR_DURATION_SCALE`
 * via `LocalContext`. Actualmente retorna `false` para permitir tests JVM.
 */
@Composable
fun rememberUanReduceMotion(): Boolean = false

