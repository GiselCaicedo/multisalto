package com.example.redscate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.redscate.uikit.components.RedscateActivationAnimation
import com.redscate.uikit.components.RedscateAppBar
import com.redscate.uikit.components.RedscateAppBarAction
import com.redscate.uikit.components.RedscateAppBarConfig
import com.redscate.uikit.components.RedscateBadge
import com.redscate.uikit.components.RedscateBadgeStyle
import com.redscate.uikit.components.RedscateBadgeTone
import com.redscate.uikit.components.RedscateButton
import com.redscate.uikit.components.RedscateButtonStyle
import com.redscate.uikit.components.RedscateCard
import com.redscate.uikit.components.RedscateCardAction
import com.redscate.uikit.components.RedscateCardConfig
import com.redscate.uikit.components.RedscateCardMetric
import com.redscate.uikit.components.RedscateCardTone
import com.redscate.uikit.components.RedscateCarousel
import com.redscate.uikit.components.RedscateCarouselItem
import com.redscate.uikit.components.RedscateCheckbox
import com.redscate.uikit.components.RedscateCheckboxState
import com.redscate.uikit.components.RedscateDialog
import com.redscate.uikit.components.RedscateDialogAction
import com.redscate.uikit.components.RedscateDialogConfig
import com.redscate.uikit.components.RedscateDialogTone
import com.redscate.uikit.components.RedscateDivider
import com.redscate.uikit.components.RedscateDividerOrientation
import com.redscate.uikit.components.RedscateDropdown
import com.redscate.uikit.components.RedscateIndicatorState
import com.redscate.uikit.components.RedscateList
import com.redscate.uikit.components.RedscateListItemData
import com.redscate.uikit.components.RedscateLoadingIndicator
import com.redscate.uikit.components.RedscateOption
import com.redscate.uikit.components.RedscateRadar
import com.redscate.uikit.components.RedscateStepIndicator
import com.redscate.uikit.components.RedscateSwitch
import com.redscate.uikit.components.RedscateSwitchVariant
import com.redscate.uikit.components.RedscateTextField
import com.redscate.uikit.components.RedscateTextFieldState
import com.redscate.uikit.components.RedscateToolbar
import com.redscate.uikit.components.RedscateToolbarItem
import com.redscate.uikit.components.RedscateToolbarItemState
import com.redscate.uikit.theme.RedscateTheme

class ComponentShowcaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val items = listOf(
            CatalogItem("fixed-appbar", "Coleccion 1", "AppBar", "App Bar", "Navegacion"),
            CatalogItem("fixed-badges", "Coleccion 2", "Badges", "Badges", "General"),
            CatalogItem("fixed-buttons", "Coleccion 3", "Buttons", "Buttons", "Botones"),
            CatalogItem("fixed-buttons-icon", "Coleccion 3", "ButtonsIcon", "Buttons Icon", "Botones"),
            CatalogItem("fixed-cards", "Coleccion 4", "Cards", "Cards", "Tarjetas"),
            CatalogItem("fixed-carousel", "Coleccion 5", "Carousel", "Carousel", "Tarjetas"),
            CatalogItem("fixed-checkboxes", "Coleccion 6", "Checkboxes", "Checkboxes", "Seleccion"),
            CatalogItem("fixed-modal", "Coleccion 7", "Modal", "Modal", "Alertas"),
            CatalogItem("fixed-dividers", "Coleccion 8", "Dividers", "Dividers", "General"),
            CatalogItem("fixed-lists", "Coleccion 8", "Lists", "Lists", "General"),
            CatalogItem("fixed-dropdown-menu", "Coleccion 8", "DropdownMenu", "Dropdown Menu", "Seleccion"),
            CatalogItem("fixed-switch", "Coleccion 9", "Switch", "Switch", "Tema"),
            CatalogItem("fixed-text-fields", "Coleccion 9", "TextFields", "Text fields", "Formulario"),
            CatalogItem("fixed-toolbars", "Coleccion 10", "Toolbars", "Toolbars", "Navegacion"),
            CatalogItem("fixed-radar", "Coleccion 11", "Radar", "Radar", "General"),
            CatalogItem("fixed-activation-animation", "Coleccion 12", "ActivationAnimation", "Activation animation", "General"),
            CatalogItem("fixed-loading-indicator", "Coleccion 13", "LoadingIndicator", "Loading Indicator", "General"),
            CatalogItem("fixed-progress-indicator", "Coleccion 13", "ProgressIndicator", "Progress Indicator", "General")
        )

        setContent {
            RedscateTheme {
                ShowcaseCatalogScreen(
                    items = items,
                    onBack = { finish() }
                )
            }
        }
    }
}

@Composable
private fun ShowcaseCatalogScreen(items: List<CatalogItem>, onBack: () -> Unit) {
    var query by rememberSaveable { mutableStateOf("") }
    var selected by remember(items) { mutableStateOf(items.firstOrNull()) }
    val filtered = remember(items, query) {
        items.filter {
            query.isBlank() ||
                it.displayName.contains(query, ignoreCase = true) ||
                it.collectionLabel.contains(query, ignoreCase = true) ||
                it.category.contains(query, ignoreCase = true)
        }
    }
    if (filtered.isEmpty()) {
        selected = null
    } else if (selected == null || filtered.none { it.id == selected?.id }) {
        selected = filtered.first()
    }
    val selectedIndex = filtered.indexOfFirst { it.id == selected?.id }.coerceAtLeast(0)
    val previewHeight = when (selected?.rawName?.lowercase()) {
        "cards" -> 360.dp
        "carousel" -> 300.dp
        "lists" -> 320.dp
        "radar" -> 360.dp
        "activationanimation" -> 300.dp
        else -> 220.dp
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF090B0F))
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RedscateButton(
                text = "Volver",
                onClick = onBack,
                style = RedscateButtonStyle.Neutral
            )
            androidx.compose.material3.Text(
                text = "Biblioteca UI",
                color = Color(0xFF37B2FF)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        androidx.compose.material3.Text(
            text = "${items.size} componentes",
            color = Color(0xFFB0BEC5)
        )

        Spacer(modifier = Modifier.height(8.dp))
        RedscateTextField(
            value = query,
            onValueChange = { query = it },
            label = "Buscar componente",
            placeholder = "App Bar, Button, Radar..."
        )

        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0F1114))
                .border(1.dp, Color(0xFF28323D))
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RedscateButton(
                    text = "<",
                    onClick = {
                        if (filtered.isNotEmpty()) {
                            val prev = if (selectedIndex <= 0) filtered.lastIndex else selectedIndex - 1
                            selected = filtered[prev]
                        }
                    },
                    enabled = filtered.isNotEmpty(),
                    style = RedscateButtonStyle.Neutral
                )
                androidx.compose.material3.Text(
                    text = selected?.displayName ?: "Selecciona un componente",
                    color = Color.White
                )
                RedscateButton(
                    text = ">",
                    onClick = {
                        if (filtered.isNotEmpty()) {
                            val next = if (selectedIndex >= filtered.lastIndex) 0 else selectedIndex + 1
                            selected = filtered[next]
                        }
                    },
                    enabled = filtered.isNotEmpty(),
                    style = RedscateButtonStyle.Neutral
                )
            }

            Spacer(modifier = Modifier.height(2.dp))
            androidx.compose.material3.Text(
                text = selected?.let { "${it.category} - ${it.collectionLabel}" } ?: "",
                color = Color(0xFF37B2FF)
            )

            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(previewHeight)
                    .background(Color(0xFF171C22))
                    .border(1.dp, Color(0xFF28323D))
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                ComponentPreview(selected)
            }

            Spacer(modifier = Modifier.height(12.dp))
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(filtered, key = { it.id }) { item ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        androidx.compose.material3.Text(
                            text = item.displayName,
                            color = Color.White
                        )
                        RedscateButton(
                            text = "Ver",
                            onClick = { selected = item },
                            style = if (selected?.id == item.id) {
                                RedscateButtonStyle.Primary
                            } else {
                                RedscateButtonStyle.Outline
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ComponentPreview(item: CatalogItem?) {
    val key = item?.rawName?.lowercase().orEmpty()
    when {
        key.contains("appbar") -> {
            RedscateAppBar(
                config = RedscateAppBarConfig(
                    title = "Inicio",
                    subtitle = "Monitoreo",
                    leading = RedscateAppBarAction(id = "back", label = "<"),
                    trailing = listOf(
                        RedscateAppBarAction(id = "info", label = "i"),
                        RedscateAppBarAction(id = "profile", label = "P")
                    )
                ),
                onActionClick = {}
            )
        }
        key.contains("badge") -> {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RedscateBadge(text = "Urgente", tone = RedscateBadgeTone.Danger)
                RedscateBadge(count = 12, tone = RedscateBadgeTone.Primary)
                RedscateBadge(style = RedscateBadgeStyle.Dot, tone = RedscateBadgeTone.Success)
            }
        }
        key.contains("buttonsicon") -> {
            var count by rememberSaveable { mutableStateOf(0) }
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RedscateButton(text = "Alerta", onClick = { count++ }, style = RedscateButtonStyle.Danger)
                RedscateButton(text = "Aceptar", onClick = {}, style = RedscateButtonStyle.Success)
                androidx.compose.material3.Text("Clicks: $count", color = Color.White)
            }
        }
        key.contains("button") -> {
            var count by rememberSaveable { mutableStateOf(0) }
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RedscateButton(text = "Primario", onClick = { count++ })
                RedscateButton(text = "Secundario", onClick = {}, style = RedscateButtonStyle.Outline)
                androidx.compose.material3.Text("Clicks: $count", color = Color.White)
            }
        }
        key.contains("card") -> {
            RedscateCard(
                config = RedscateCardConfig(
                    title = "Unidad desplegada",
                    leadingValue = "24",
                    leadingLabel = "Activa",
                    headlineMetric = RedscateCardMetric("ETA", "07:15", "min"),
                    detailMetrics = listOf(
                        RedscateCardMetric("Zona", "Sector Norte"),
                        RedscateCardMetric("Estado", "En ruta")
                    ),
                    footerAction = RedscateCardAction("open", "Ver detalle"),
                    tone = RedscateCardTone.Accent
                ),
                onActionClick = {}
            )
        }
        key.contains("carousel") -> {
            var currentIndex by rememberSaveable { mutableIntStateOf(0) }
            RedscateCarousel(
                items = listOf(
                    RedscateCarouselItem("1", "Puesto Alfa", "Cobertura estable", "A1"),
                    RedscateCarouselItem("2", "Puesto Bravo", "Sin novedad", "B2"),
                    RedscateCarouselItem("3", "Puesto Charlie", "Requiere relevo", "C3")
                ),
                currentIndex = currentIndex,
                onIndexChange = { currentIndex = it }
            )
        }
        key.contains("checkbox") -> {
            var state by rememberSaveable { mutableStateOf(RedscateCheckboxState.Active) }
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RedscateCheckbox(state = state, onStateChange = { state = it })
                androidx.compose.material3.Text("Estado: ${state.name}", color = Color.White)
            }
        }
        key.contains("modal") -> {
            var visible by rememberSaveable { mutableStateOf(true) }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                RedscateButton(
                    text = if (visible) "Ocultar modal" else "Mostrar modal",
                    onClick = { visible = !visible }
                )
                RedscateDialog(
                    visible = visible,
                    config = RedscateDialogConfig(
                        title = "Atencion",
                        message = "Confirma si deseas continuar con la activacion.",
                        tone = RedscateDialogTone.Danger,
                        actions = listOf(
                            RedscateDialogAction("cancel", "Cancelar"),
                            RedscateDialogAction("confirm", "Continuar", RedscateDialogTone.Success)
                        )
                    ),
                    onDismissRequest = { visible = false },
                    onActionClick = { visible = false }
                )
            }
        }
        key.contains("divider") -> {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                RedscateDivider(emphasized = true)
                Row(
                    modifier = Modifier.height(80.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    androidx.compose.material3.Text("A", color = Color.White)
                    RedscateDivider(
                        modifier = Modifier.height(72.dp),
                        orientation = RedscateDividerOrientation.Vertical
                    )
                    androidx.compose.material3.Text("B", color = Color.White)
                }
            }
        }
        key.contains("list") -> {
            RedscateList(
                items = listOf(
                    RedscateListItemData(
                        id = "alpha",
                        title = "Equipo Alfa",
                        leadingValue = "A",
                        leadingLabel = "Lista",
                        primaryMetrics = listOf(RedscateCardMetric("Estado", "Disponible")),
                        trailingMetric = RedscateCardMetric("ETA", "4m"),
                        action = RedscateCardAction("assign", "Asignar")
                    ),
                    RedscateListItemData(
                        id = "bravo",
                        title = "Equipo Bravo",
                        leadingValue = "B",
                        leadingLabel = "Lista",
                        primaryMetrics = listOf(RedscateCardMetric("Estado", "Ocupado")),
                        trailingMetric = RedscateCardMetric("ETA", "12m"),
                        tone = RedscateCardTone.Success
                    )
                ),
                modifier = Modifier.heightIn(max = 280.dp)
            )
        }
        key.contains("dropdown") -> {
            var expanded by rememberSaveable { mutableStateOf(false) }
            var selectedKey by rememberSaveable { mutableStateOf("rh") }
            RedscateDropdown(
                selectedKey = selectedKey,
                options = listOf(
                    RedscateOption("rh", "RH"),
                    RedscateOption("o+", "O+"),
                    RedscateOption("a-", "A-"),
                    RedscateOption("ab+", "AB+")
                ),
                expanded = expanded,
                onExpandedChange = { expanded = it },
                onOptionSelected = { selectedKey = it.key },
                label = "Tipo de sangre"
            )
        }
        key.contains("switch") -> {
            var checked by rememberSaveable { mutableStateOf(true) }
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RedscateSwitch(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    variant = RedscateSwitchVariant.LeftAccent
                )
                androidx.compose.material3.Text(
                    text = if (checked) "Modo oscuro" else "Modo claro",
                    color = Color.White
                )
            }
        }
        key.contains("text") || key.contains("field") -> {
            var value by rememberSaveable { mutableStateOf("") }
            RedscateTextField(
                value = value,
                onValueChange = { value = it },
                label = "Mensaje",
                placeholder = "Escribe aqui",
                supportingText = "Campo de ejemplo",
                state = if (value.length > 8) RedscateTextFieldState.Focused else RedscateTextFieldState.Default
            )
        }
        key.contains("toolbar") -> {
            RedscateToolbar(
                items = listOf(
                    RedscateToolbarItem("map", "Mapa", state = RedscateToolbarItemState.Active),
                    RedscateToolbarItem("chat", "Chat"),
                    RedscateToolbarItem("sos", "SOS"),
                    RedscateToolbarItem("off", "Off", state = RedscateToolbarItemState.Disabled)
                ),
                onItemClick = {}
            )
        }
        key.contains("radar") -> {
            var selectedDistance by rememberSaveable { mutableStateOf(100) }
            RedscateRadar(
                modifier = Modifier.fillMaxWidth(),
                selectedDistance = selectedDistance,
                distanceOptions = listOf(50, 100, 250),
                onDistanceSelected = { selectedDistance = it }
            )
        }
        key.contains("activationanimation") -> {
            RedscateActivationAnimation(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
            )
        }
        key == "loadingindicator" -> {
            RedscateLoadingIndicator(
                states = listOf(
                    RedscateIndicatorState.Success,
                    RedscateIndicatorState.Warning,
                    RedscateIndicatorState.Inactive
                )
            )
        }
        key == "progressindicator" -> {
            RedscateStepIndicator(totalSteps = 4, currentStep = 3)
        }
        else -> {
            RedscateButton(text = item?.displayName ?: "Probar", onClick = {})
        }
    }
}

private data class CatalogItem(
    val id: String,
    val collectionLabel: String,
    val rawName: String,
    val displayName: String,
    val category: String
)
