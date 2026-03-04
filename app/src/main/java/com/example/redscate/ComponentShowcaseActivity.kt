package com.example.redscate

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.redscate.generated.set0.AppBarSet0
import com.example.redscate.generated.set10.CheckSet10
import com.example.redscate.generated.set10.LoadingIndicatorSet10
import com.example.redscate.generated.set10.ProgressIndicatorSet10
import com.example.redscate.generated.set10.Property1Component1Set10
import com.example.redscate.generated.set2.ButtonsIconSet2
import com.example.redscate.generated.set1.BadgesSet1
import com.example.redscate.generated.set2.ButtonsSet2
import com.example.redscate.generated.set3.CardsSet3
import com.example.redscate.generated.set4.CarouselSet4
import com.example.redscate.generated.set5.CheckboxesSet5
import com.example.redscate.generated.set6.ModalSet6
import com.example.redscate.generated.set7.DividersSet7
import com.example.redscate.generated.set8.ListsSet8
import com.example.redscate.generated.set9.DropdownMenuSet9
import com.example.redscate.generated.set12.SwitchSet12
import com.example.redscate.generated.set13.TextFieldsSet13
import com.example.redscate.generated.set14.ToolbarsSet14
import com.example.redscate.generated.set15.RadarSet15
import com.example.redscate.generated.set16.ActivationAnimationSet16
import kotlin.text.RegexOption.DOT_MATCHES_ALL

class ComponentShowcaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val items = loadCatalog()
        setContent {
            MaterialTheme {
                ShowcaseCatalogScreen(
                    items = items,
                    onBack = { finish() }
                )
            }
        }
    }

    private fun loadCatalog(): List<CatalogItem> {
        return listOf(
            CatalogItem(
                id = "fixed-appbar",
                collectionLabel = "Coleccion 1",
                rawName = "AppBar",
                displayName = "App Bar",
                category = "Navegacion"
            ),
            CatalogItem(
                id = "fixed-badges",
                collectionLabel = "Coleccion 2",
                rawName = "Badges",
                displayName = "Badges",
                category = "General"
            ),
            CatalogItem(
                id = "fixed-buttons",
                collectionLabel = "Coleccion 3",
                rawName = "Buttons",
                displayName = "Buttons",
                category = "Botones"
            ),
            CatalogItem(
                id = "fixed-buttons-icon",
                collectionLabel = "Coleccion 3",
                rawName = "ButtonsIcon",
                displayName = "Buttons Icon",
                category = "Botones"
            ),
            CatalogItem(
                id = "fixed-cards",
                collectionLabel = "Coleccion 4",
                rawName = "Cards",
                displayName = "Cards",
                category = "Tarjetas"
            ),
            CatalogItem(
                id = "fixed-carousel",
                collectionLabel = "Coleccion 5",
                rawName = "Carousel",
                displayName = "Carousel",
                category = "Tarjetas"
            ),
            CatalogItem(
                id = "fixed-checkboxes",
                collectionLabel = "Coleccion 6",
                rawName = "Checkboxes",
                displayName = "Checkboxes",
                category = "Seleccion"
            ),
            CatalogItem(
                id = "fixed-modal",
                collectionLabel = "Coleccion 7",
                rawName = "Modal",
                displayName = "Modal",
                category = "Alertas"
            ),
            CatalogItem(
                id = "fixed-dividers",
                collectionLabel = "Coleccion 8",
                rawName = "Dividers",
                displayName = "Dividers",
                category = "General"
            ),
            CatalogItem(
                id = "fixed-lists",
                collectionLabel = "Coleccion 8",
                rawName = "Lists",
                displayName = "Lists",
                category = "General"
            ),
            CatalogItem(
                id = "fixed-dropdown-menu",
                collectionLabel = "Coleccion 8",
                rawName = "DropdownMenu",
                displayName = "Dropdown Menu",
                category = "Seleccion"
            ),
            CatalogItem(
                id = "fixed-switch",
                collectionLabel = "Coleccion 9",
                rawName = "Switch",
                displayName = "Switch",
                category = "Tema"
            ),
            CatalogItem(
                id = "fixed-text-fields",
                collectionLabel = "Coleccion 9",
                rawName = "TextFields",
                displayName = "Text fields",
                category = "Formulario"
            ),
            CatalogItem(
                id = "fixed-toolbars",
                collectionLabel = "Coleccion 10",
                rawName = "Toolbars",
                displayName = "Toolbars",
                category = "Navegacion"
            ),
            CatalogItem(
                id = "fixed-radar",
                collectionLabel = "Coleccion 11",
                rawName = "Radar",
                displayName = "Radar",
                category = "General"
            ),
            CatalogItem(
                id = "fixed-activation-animation",
                collectionLabel = "Coleccion 12",
                rawName = "ActivationAnimation",
                displayName = "Activation animation",
                category = "General"
            ),
            CatalogItem(
                id = "fixed-loading-indicator",
                collectionLabel = "Coleccion 13",
                rawName = "LoadingIndicator",
                displayName = "Loading Indicator",
                category = "General"
            ),
            CatalogItem(
                id = "fixed-progress-indicator",
                collectionLabel = "Coleccion 13",
                rawName = "ProgressIndicator",
                displayName = "Progress Indicator",
                category = "General"
            )
        )
    }

    private fun readAssetTextOrNull(path: String): String? {
        return try {
            assets.open(path).bufferedReader().use { it.readText() }
        } catch (_: Exception) {
            null
        }
    }

    private fun humanizeName(raw: String): String {
        val key = raw.lowercase()
        if (key == "propiedad1clock1" || key == "loadinganimation" || key == "steps1" || key == "loading" || key == "animationloadingadvertence") {
            return "Progress Indicator"
        }
        return raw.replace(Regex("([a-z])([A-Z])"), "$1 $2")
            .replace('_', ' ')
            .trim()
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    }

    private fun folderOrderKey(folderName: String): Int {
        if (folderName == "generatedCode") return 0
        val number = Regex("""\\((\\d+)\\)""").find(folderName)?.groupValues?.getOrNull(1)?.toIntOrNull()
        return number ?: Int.MAX_VALUE
    }

    private fun componentCategory(rawName: String): String {
        val key = rawName.lowercase()
        return when {
            "appbar" in key || "header" in key -> "Navegacion"
            "button" in key -> "Botones"
            "dropdown" in key || "menu" in key -> "Seleccion"
            "switch" in key || "toggle" in key -> "Tema"
            "card" in key || "panel" in key -> "Tarjetas"
            "alert" in key || "modal" in key || "dialog" in key -> "Alertas"
            "input" in key || "textfield" in key || "field" in key -> "Formulario"
            else -> "General"
        }
    }
}

@Composable
private fun ShowcaseCatalogScreen(items: List<CatalogItem>, onBack: () -> Unit) {
    var query by remember { mutableStateOf("") }
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
    val previewHeight = when {
        selected?.rawName?.lowercase()?.contains("buttonsicon") == true -> 760.dp
        selected?.rawName?.lowercase()?.contains("buttons") == true -> 640.dp
        selected?.rawName?.lowercase()?.contains("cards") == true -> 980.dp
        selected?.rawName?.lowercase()?.contains("carousel") == true -> 430.dp
        selected?.rawName?.lowercase()?.contains("checkbox") == true -> 320.dp
        selected?.rawName?.lowercase()?.contains("modal") == true -> 1200.dp
        selected?.rawName?.lowercase()?.contains("dividers") == true -> 220.dp
        selected?.rawName?.lowercase()?.contains("lists") == true -> 700.dp
        selected?.rawName?.lowercase()?.contains("dropdownmenu") == true -> 420.dp
        selected?.rawName?.lowercase()?.contains("switch") == true -> 300.dp
        selected?.rawName?.lowercase()?.contains("textfields") == true -> 520.dp
        selected?.rawName?.lowercase()?.contains("toolbar") == true -> 340.dp
        selected?.rawName?.lowercase()?.contains("radar") == true -> 1040.dp
        selected?.rawName?.lowercase()?.contains("activationanimation") == true -> 760.dp
        selected?.rawName?.lowercase()?.contains("loading") == true -> 560.dp
        else -> 260.dp
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF090B0F)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onBack,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF243145))
                ) {
                    Text("Volver")
                }
                Text(
                    text = "Biblioteca UI",
                    color = Color(0xFF37B2FF),
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "${items.size} componentes",
                color = Color(0xFFB0BEC5),
                modifier = Modifier.padding(top = 8.dp)
            )

            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Buscar componente") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                singleLine = true
            )

            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF0F1114))
            ) {
                Column(modifier = Modifier.fillMaxSize().padding(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = {
                                if (filtered.isNotEmpty()) {
                                    val prev = if (selectedIndex <= 0) filtered.lastIndex else selectedIndex - 1
                                    selected = filtered[prev]
                                }
                            },
                            enabled = filtered.isNotEmpty(),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF243145))
                        ) {
                            Text("<")
                        }
                        Text(
                            text = selected?.displayName ?: "Selecciona un componente",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Button(
                            onClick = {
                                if (filtered.isNotEmpty()) {
                                    val next = if (selectedIndex >= filtered.lastIndex) 0 else selectedIndex + 1
                                    selected = filtered[next]
                                }
                            },
                            enabled = filtered.isNotEmpty(),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF243145))
                        ) {
                            Text(">")
                        }
                    }
                    Text(
                        text = selected?.let { "${it.category} · ${it.collectionLabel}" } ?: "",
                        color = Color(0xFF37B2FF),
                        modifier = Modifier.padding(top = 2.dp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(previewHeight)
                            .padding(top = 12.dp)
                            .background(Color(0xFF171C22))
                            .border(1.dp, Color(0xFF28323D)),
                        contentAlignment = Alignment.Center
                    ) {
                        val showedComposablePreview = GeneratedComposablePreview(selected)
                        if (showedComposablePreview) return@Box
                        val showedAssetPreview = GeneratedAssetPreview(selected)
                        if (!showedAssetPreview) {
                            ComponentPreview(selected)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun GeneratedComposablePreview(item: CatalogItem?): Boolean {
    val key = item?.rawName?.lowercase().orEmpty()
    return when {
        key.contains("appbar") || key.contains("header") -> {
            AppBarSet0()
            true
        }
        key.contains("badge") -> {
            BadgesSet1()
            true
        }
        key.contains("buttonsicon") -> {
            ButtonsIconSet2()
            true
        }
        key.contains("cards") -> {
            CardsSet3()
            true
        }
        key.contains("carousel") -> {
            CarouselSet4()
            true
        }
        key.contains("checkbox") -> {
            CheckboxesSet5()
            true
        }
        key.contains("modal") -> {
            ModalSet6()
            true
        }
        key.contains("dividers") -> {
            DividersSet7()
            true
        }
        key.contains("lists") -> {
            ListsSet8()
            true
        }
        key.contains("dropdownmenu") -> {
            DropdownMenuSet9()
            true
        }
        key.contains("switch") -> {
            SwitchSet12()
            true
        }
        key.contains("textfields") -> {
            TextFieldsSet13()
            true
        }
        key.contains("toolbar") -> {
            ToolbarsSet14()
            true
        }
        key.contains("radar") -> {
            RadarSet15(Modifier.fillMaxSize())
            true
        }
        key.contains("activationanimation") -> {
            ActivationAnimationSet16()
            true
        }
        key.contains("button") -> {
            ButtonsSet2()
            true
        }
        key == "loadingindicator" -> {
            LoadingIndicatorSet10()
            true
        }
        key == "progressindicator" -> {
            ProgressIndicatorSet10()
            true
        }
        key == "loadinganimation" || key == "steps1" || key == "loading" || key == "animationloadingadvertence" -> {
            ProgressIndicatorSet10()
            true
        }
        key == "propiedad1clock1" -> {
            ProgressIndicatorSet10()
            true
        }
        key == "property1component1" -> {
            Property1Component1Set10()
            true
        }
        key == "check" -> {
            CheckSet10()
            true
        }
        else -> false
    }
}

@Composable
private fun GeneratedAssetPreview(item: CatalogItem?): Boolean {
    val rawName = item?.rawName ?: return false
    val assetName = resolveFigmaAsset(rawName) ?: return false
    val context = LocalContext.current
    val bitmap = remember(assetName) {
        runCatching {
            context.assets.open(assetName).use { input ->
                BitmapFactory.decodeStream(input)
            }
        }.getOrNull()
    } ?: return false

    Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = rawName,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        contentScale = ContentScale.Fit
    )
    return true
}

private fun resolveFigmaAsset(rawName: String): String? {
    val key = rawName.lowercase()
    val base = when {
        key.contains("appbar") || key.contains("header") -> "App Bar.png"
        key.contains("badge") -> "Badges.png"
        key.contains("button") -> "Buttons.png"
        key.contains("card") -> "Cards.png"
        key.contains("carousel") -> "Carousel.png"
        key.contains("checkbox") || key.contains("checkorg") || key == "check" -> "Checkboxes.png"
        key.contains("divider") -> "Dividers.png"
        key.contains("dropdown") || key.contains("menu") -> "Dropdown Menu.png"
        key.contains("switch") -> "Switch.png"
        key.contains("textfield") || key.contains("textfields") || key.contains("field") -> "Text fields.png"
        key.contains("toolbar") -> "Toolbars.png"
        key.contains("modal") -> "Modal.png"
        key == "list" || key.contains("styleestandardlayoutinfo") -> "Lists.png"
        key.contains("radar") -> "Radar.png"
        key.contains("loading") || key.contains("clock") || key.contains("steps") -> "Progress indicators.png"
        else -> null
    } ?: return null
    return "FIGMA/$base"
}

@Composable
private fun ComponentPreview(item: CatalogItem?) {
    val key = item?.rawName?.lowercase().orEmpty()
    when {
        key.contains("appbar") || key.contains("header") -> {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(Color(0xFF111317))
                    .padding(horizontal = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("SECCION", color = Color.White, fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier
                        .width(34.dp)
                        .height(34.dp)
                        .border(2.dp, Color(0xFFF6F6F6))
                        .background(Color(0xFF2F2F2F)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gc0_icon),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize().padding(4.dp)
                    )
                }
            }
        }
        key.contains("button") -> {
            var count by remember { mutableStateOf(0) }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = { count++ }) { Text("Primario") }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2F2F2F))
                ) { Text("Secundario") }
                Text("Clicks: $count", color = Color.White)
            }
        }
        key.contains("dropdown") || key.contains("menu") -> {
            var expanded by remember { mutableStateOf(false) }
            var selected by remember { mutableStateOf("RH") }
            val options = listOf("RH", "O+", "A-", "AB+")
            Box {
                Button(onClick = { expanded = true }) { Text(selected) }
                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    options.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option) },
                            onClick = {
                                selected = option
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
        key.contains("switch") || key.contains("toggle") -> {
            var checked by remember { mutableStateOf(true) }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(if (checked) "Modo oscuro" else "Modo claro", color = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Switch(checked = checked, onCheckedChange = { checked = it })
            }
        }
        key.contains("input") || key.contains("field") || key.contains("text") -> {
            var value by remember { mutableStateOf("") }
            OutlinedTextField(
                value = value,
                onValueChange = { value = it },
                label = { Text("Escribe aqui") },
                singleLine = true
            )
        }
        key.contains("alert") || key.contains("modal") || key.contains("dialog") -> {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF7A1219)),
                modifier = Modifier.padding(8.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Atencion", color = Color.White, fontWeight = FontWeight.Bold)
                    Text("Mensaje de prueba del componente", color = Color.White)
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = {}) { Text("Aceptar") }
                        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2F2F2F))) {
                            Text("Cancelar")
                        }
                    }
                }
            }
        }
        key.contains("card") || key.contains("panel") || key.contains("chat") -> {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1B232E)),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text("Tarjeta de contenido", color = Color.White, fontWeight = FontWeight.SemiBold)
                    Text("Vista util para revisar jerarquia visual.", color = Color(0xFFB0BEC5))
                    Button(onClick = {}) { Text("Accion") }
                }
            }
        }
        else -> {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = item?.displayName
                        ?: "Componente",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Vista funcional de referencia",
                    color = Color(0xFF90A4AE),
                    modifier = Modifier.padding(top = 4.dp)
                )
                Button(onClick = {}, modifier = Modifier.padding(top = 10.dp)) {
                    Text("Probar")
                }
            }
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
