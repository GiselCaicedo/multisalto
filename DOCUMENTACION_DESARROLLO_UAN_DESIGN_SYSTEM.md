# Documentacion del desarrollo del sistema UAN Design System

## 1. Resumen ejecutivo

El proyecto **UAN Design System** es una libreria Android basada en **Jetpack Compose** que centraliza componentes visuales, tokens de diseno y reglas de interfaz para mantener consistencia en las aplicaciones de la Universidad de los Andes.

El repositorio esta organizado como una **libreria consumible** y no como una aplicacion final. Su objetivo es exponer una base reutilizable de tema, foundation y componentes que pueda publicarse como artefacto Maven y extenderse de forma controlada.

## 2. Estado actual del proyecto

### 2.1 Configuracion tecnica

- Modo de construccion: libreria Android
- Modulo principal: `ui-kit`
- `compileSdk`: 35
- `minSdk`: 26
- `sourceCompatibility` y `targetCompatibility`: Java 11
- `jvmToolchain`: 11
- UI: Jetpack Compose
- Publicacion: `release` con `sourcesJar`

### 2.2 Paquete base

El paquete publico principal es:

- `com.uan.designsystem.uikit`

Los subpaquetes visibles en el codigo son:

- `com.uan.designsystem.uikit.theme`
- `com.uan.designsystem.uikit.theme.tokens`
- `com.uan.designsystem.uikit.foundation`
- `com.uan.designsystem.uikit.components`

### 2.3 Material visual de referencia

La carpeta `FIGMA/` contiene exportaciones visuales del sistema, usadas como referencia de diseno y validacion de consistencia.

Los archivos cubren, entre otros:

- sistema cromatico
- tipografia
- espaciado y rejilla
- iconografia
- elevacion
- activation animation
- app bar
- badges
- buttons
- cards
- carousel
- checkboxes
- dividers
- dropdown menu
- lists
- modal
- progress indicators
- radar
- sheets
- switch
- text fields
- toolbars

## 3. Objetivo funcional

El design system busca resolver estos problemas:

- Unificar la identidad visual en Android.
- Evitar duplicacion de estilos entre pantallas y equipos.
- Centralizar la definicion de colores, tipografia, espaciado y motion.
- Exponer componentes reutilizables para formularios, feedback, navegacion, contenedores y acciones.
- Permitir una adopcion consistente mediante un tema raiz simple de envolver.

## 4. Arquitectura del kit

La arquitectura se organiza en cuatro capas:

1. **Theme y tokens**: define la base visual y las reglas de estilo.
2. **Foundation**: provee primitivas y utilidades transversales.
3. **Components**: contiene los componentes de UI reutilizables.
4. **Publishing**: prepara el modulo para distribucion externa.

## 5. Theme y tokens

### 5.1 Tema raiz

El tema raiz se implementa en `UanTheme`.

Responsabilidades:

- Envolver `MaterialTheme`.
- Proveer tokens mediante `CompositionLocalProvider`.
- Mapear la paleta interna a `darkColorScheme`.
- Mantener acceso global a los tokens via `UanThemeTokens.current`.

### 5.2 Contenedor de tokens

`UanTokens` agrupa toda la configuracion visual del sistema:

- `colors`
- `typography`
- `shapes`
- `spacing`
- `grid`
- `iconography`
- `elevations`
- `motion`

La instancia por defecto es `UanTokens.Default` y usa una configuracion oscura.

### 5.3 Colores

`UanColors` define la paleta semantica y de superficie.

Tokens disponibles:

- `background`
- `surface`
- `surfaceContainer`
- `outline`
- `outlineVariant`
- `muted`
- `onSurface`
- `primary`
- `onPrimary`
- `primaryContainer`
- `success`
- `onSuccess`
- `successContainer`
- `info`
- `onInfo`
- `infoContainer`
- `warning`
- `onWarning`
- `warningContainer`
- `error`
- `onError`
- `errorContainer`
- `critical`
- `onCritical`
- `criticalContainer`
- `disabledAlpha`

La paleta por defecto es `UanDarkColors`.

### 5.4 Tipografia

`UanTypography` centraliza estilos tipograficos para uso transversal.

Estilos definidos:

- `label`
- `body`
- `supporting`
- `notification`
- `general`
- `small`
- `distance`
- `sos`
- `alert`
- `section`
- `component`
- `subtitle`
- `button`

### 5.5 Formas

`UanShapes` define radios del sistema:

- `smallRadius`
- `mediumRadius`
- `largeRadius`
- `pillRadius`

### 5.6 Espaciado y grid

`UanSpacing` define una escala de separacion:

- `xxxs`
- `xxs`
- `xs`
- `sm`
- `md`
- `lg`
- `xl`
- `xxl`

`UanGrid` define reglas de composicion:

- `columns`
- `gutter`
- `screenMargin`
- `touchTarget`

### 5.7 Iconografia

`UanIconography` define reglas de tamano e implementacion de iconos:

- `strokeWidth`
- `small`
- `medium`
- `large`

### 5.8 Elevaciones

`UanElevations` define la profundidad visual del sistema:

- `level0`
- `level1`
- `level2`
- `level3`
- `level4`
- `interactiveOffsetY`

### 5.9 Motion

`UanMotion` define duraciones y easing reutilizables:

- `durationShort`
- `durationMedium`
- `durationLong`
- `durationEmphasis`
- `durationActivation`
- `easingStandard`
- `easingEmphasized`
- `easingDecelerate`
- `easingLinear`

## 6. Foundation

La capa foundation contiene abstracciones reutilizables que reducen el trabajo repetido en componentes.

### 6.1 Utilidades disponibles

- `UanAccessibility`
- `UanElevation` como modificador
- `UanGridDefaults`
- `UanIconButton`
- `UanIconographyDefaults`
- `UanInteractiveDefaults`
- `UanTone`

### 6.2 Rol de foundation

Esta capa se usa para:

- resolver colores por tono semantico
- aplicar elevaciones de forma uniforme
- encapsular comportamiento interactivo
- mantener defaults reutilizables
- concentrar reglas de accesibilidad y reduccion de movimiento

## 7. Catalogo de componentes

### 7.1 Componentes principales

El modulo `components` expone estos componentes Compose:

- `UanActivationAnimation`
- `UanAppBar`
- `UanBadge`
- `UanButton`
- `UanCard`
- `UanCarousel`
- `UanCheckbox`
- `UanDivider`
- `UanDropdownMenu`
- `UanElevation`
- `UanLists`
- `UanModal`
- `UanNetworkMesh`
- `UanProgressIndicator`
- `UanRadar`
- `UanSheet`
- `UanSwitch`
- `UanTextField`
- `UanToolbar`

### 7.2 Defaults por componente

Cada componente tiene un objeto `Defaults` o equivalente para centralizar valores reutilizables.

Ejemplos:

- `UanButtonDefaults`
- `UanCardDefaults`
- `UanBadgeDefaults`
- `UanAppBarDefaults`
- `UanDropdownMenuDefaults`
- `UanProgressIndicatorDefaults`
- `UanTextFieldDefaults`
- `UanToolbarDefaults`

### 7.3 Previews

El codigo incluye previews dedicados para validacion visual rapida.

Estos previews existen para varias piezas del kit, incluyendo:

- `UanButtonPreview`
- `UanCardPreview`
- `UanBadgePreview`
- `UanCheckboxPreview`
- `UanDividerPreview`
- `UanDropdownMenuPreview`
- `UanProgressIndicatorPreview`
- `UanTextFieldPreview`
- `UanToolbarPreview`
- `UanModalPreview`
- `UanSheetPreview`
- `UanSwitchPreview`
- `UanRadarPreview`
- `UanCarouselPreview`
- `UanActivationAnimationPreview`
- `UanElevationPreview`
- `UanAppBarPreview`
- `UanListsPreview`

### 7.4 Uso funcional del catalogo

El catalogo cubre necesidades tipicas de una interfaz de producto:

- acciones primarias y secundarias
- cabeceras y barras superiores
- etiquetas y estados
- formularios y campos
- contenedores visuales
- navegacion y paneles
- feedback de progreso
- elementos modales
- patrones de lista
- separadores y jerarquia visual

## 8. Configuracion de build y publicacion

### 8.1 Modulo `ui-kit`

El archivo `ui-kit/build.gradle.kts` define:

- plugin de Android library
- plugin de Compose compiler
- publicacion Maven
- dependencias de Compose BOM y UI
- tooling de preview
- testing con JUnit, Espresso y Compose UI Test

### 8.2 Publicacion Maven

La publicacion se registra como:

- `groupId`: `com.uan.designsystem`
- `artifactId`: `uan-design-system`
- `version`: `1.0.0`

El release publica ademas el sources jar.

### 8.3 Repositorios

La resolucion de dependencias usa:

- `google()`
- `mavenCentral()`
- repositorio de plugins de Gradle

## 9. Integracion recomendada

### 9.1 Consumo basico

La forma esperada de integrar el kit es envolver la UI en `UanTheme` y usar los componentes desde `com.uan.designsystem.uikit.components`.

Ejemplo:

```kotlin
UanTheme {
    // UI de la pantalla
}
```

### 9.2 Recomendaciones de uso

- Usar `UanTheme` como raiz visual de la pantalla o modulo.
- Reutilizar los tokens en vez de crear colores y espaciados locales.
- Tomar los defaults de cada componente antes de redefinirlos.
- Usar previews para revisar cambios visuales antes de publicar.
- Mantener compatibilidad con Compose y minSdk 26.

## 10. Compatibilidad y supuestos tecnicos

### 10.1 Compatibilidad declarada

- Android SDK 35
- minSdk 26
- Kotlin con toolchain 11
- Jetpack Compose como UI principal

### 10.2 Supuestos del proyecto

- El theme por defecto es oscuro.
- El modulo principal es una libreria, no una app standalone.
- La evolucion del kit se concentra en reutilizacion y consistencia visual.

## 11. Estructura de mantenimiento

### 11.1 Criterios de evolucion

- Nuevos componentes deben seguir la nomenclatura `Uan*`.
- Los defaults deben vivir junto al componente.
- Los tokens deben ampliarse en `theme/tokens` antes de duplicarse localmente.
- Las utilidades compartidas deben ir a `foundation`.

### 11.2 Convenciones de versionado

- La version publica actual es `1.0.0`.
- Cualquier cambio de API publica del kit deberia versionarse de forma controlada.

## 12. Resumen final

El proyecto UAN Design System ya contiene:

- un tema raiz funcional
- tokens centralizados de color, tipografia, forma, spacing, grid, iconografia, elevacion y motion
- una capa foundation reusable
- un catalogo amplio de componentes Compose
- previews de apoyo visual
- configuracion de publicacion Maven para consumo externo

La documentacion de este archivo funciona como referencia tecnica principal del repositorio.
La capa de componentes concentra las piezas visuales que consumen las aplicaciones:

- Botones y acciones.
- Elementos de navegacion y encabezado.
- Contenedores y superficies.
- Formularios y entradas.
- Retroalimentacion, estados y progreso.
- Componentes compuestos para casos especificos del sistema.

### 4.5 Publicacion

El modulo `ui-kit` esta configurado como libreria Android con publicacion Maven:

- `namespace = com.uan.designsystem.uikit`
- `compileSdk = 35`
- `minSdk = 26`
- `maven-publish` habilitado
- artefacto `com.uan.designsystem:uan-design-system:1.0.0`

## 5. Sprints / fases de desarrollo

> Nota: esta seccion esta redactada como una organizacion por fases del trabajo. Si luego necesitas que quede alineada a sprints reales con fechas exactas, se puede ajustar sin cambiar la estructura del documento.

### Sprint 1. Base tecnica y configuracion del proyecto

- Creacion del modulo `ui-kit`.
- Configuracion de Gradle, version catalog y repositorios.
- Definicion de `compileSdk`, `minSdk`, toolchain y dependencias base.
- Activacion del soporte de Compose y del pipeline de publicacion.

### Sprint 2. Tokens, tema y base visual

- Construccion de la capa de tokens.
- Definicion de paleta de color, tipografia, espacios, grid, elevacion, iconografia y motion.
- Implementacion de `UanTheme`.
- Mapeo del sistema al esquema de `MaterialTheme`.

### Sprint 3. Foundation y utilidades comunes

- Implementacion de helpers de tono.
- Creacion de modificadores y defaults reutilizables.
- Definicion de bases para accesibilidad e interaccion.
- Consolidacion de reglas transversales para todos los componentes.

### Sprint 4. Construccion de componentes principales

- Desarrollo de componentes de accion, entrada y navegacion.
- Implementacion de variantes, defaults y previews.
- Homologacion de comportamiento visual entre componentes.
- Validacion de consistencia con el sistema de tokens.

### Sprint 5. Componentes compuestos, estabilizacion y entrega

- Construccion de componentes mas complejos o compuestos.
- Revision de patrones reutilizables y refinamiento de APIs.
- Preparacion del artefacto para publicacion.
- Documentacion y organizacion de resultados.

## 6. Resultados

En esta seccion se enumeran todos los componentes principales del modulo `ui-kit` y la funcion de cada uno. Cada bloque deja un espacio reservado para insertar la imagen o captura correspondiente.

### 6.1 UanActivationAnimation

Animacion visual que refuerza la activacion de una accion, evento o estado interactivo.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanActivationAnimation]

### 6.2 UanAppBar

Barra superior que organiza titulo, acciones y elementos de navegacion dentro de la pantalla.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanAppBar]

### 6.3 UanBadge

Indicador compacto para mostrar estados, contadores, categorias o etiquetas semanticas.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanBadge]

### 6.4 UanIconButton

Boton con icono reutilizable para acciones rapidas, accesos compactos y elementos de navegacion con soporte visual.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanIconButton]

### 6.5 UanButton

Boton principal del sistema para ejecutar acciones primarias, secundarias o de soporte.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanButton]

### 6.6 UanCard

Superficie contenedora para agrupar informacion relacionada con jerarquia visual clara.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanCard]

### 6.7 UanCarousel

Contenedor deslizable para presentar elementos de forma secuencial, como tarjetas o contenido destacado.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanCarousel]

### 6.8 UanCheckbox

Control binario de seleccion para formularios, listas de opciones y preferencias del usuario.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanCheckbox]

### 6.9 UanDivider

Separador horizontal para dividir bloques de contenido y reforzar la estructura visual.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanDivider]

### 6.10 UanVerticalDivider

Separador vertical para delimitar columnas, grupos o elementos alineados en fila.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanVerticalDivider]

### 6.11 UanDropdownMenu

Menu contextual desplegable para mostrar acciones u opciones de seleccion de manera compacta.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanDropdownMenu]

### 6.12 UanElevation

Aplicador de profundidad visual para resaltar superficies, capas o contenedores.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanElevation]

### 6.13 UanLists

Componente para representar listas estructuradas de elementos con comportamiento uniforme.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanLists]

### 6.14 UanModal

Dialogo o capa emergente para mensajes relevantes, confirmaciones y decisiones del usuario.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanModal]

### 6.15 UanProgressIndicator

Indicador general de progreso para comunicar avance, carga o estado de una operacion.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanProgressIndicator]

### 6.16 UanNumberedProgress

Variante de progreso numerada para representar pasos ordenados dentro de un flujo.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanNumberedProgress]

### 6.17 UanIconProgress

Variante de progreso con iconos para reforzar visualmente el estado de cada paso o etapa.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanIconProgress]

### 6.18 UanRadar

Visualizacion especializada para representar rangos, comparaciones o niveles dentro del sistema.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanRadar]

### 6.19 UanSheet

Panel inferior o superficie emergente para mostrar informacion complementaria o acciones secundarias.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanSheet]

### 6.20 UanSheetTitle

Subcomponente para renderizar el titulo dentro de la hoja inferior o panel emergente.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanSheetTitle]

### 6.21 UanSheetBody

Subcomponente para presentar el cuerpo de contenido dentro de la hoja inferior.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanSheetBody]

### 6.22 UanSwitch

Control binario para encender o apagar opciones de configuracion o preferencia.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanSwitch]

### 6.23 UanTextField

Campo de entrada de texto para capturar informacion en formularios o procesos de registro.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanTextField]

### 6.24 UanToolbar

Barra de herramientas para agrupar acciones rapidas y controles frecuentes dentro de una vista.

**Espacio para imagen:**  
[Insertar aqui la imagen de UanToolbar]

## 7. Componentes de soporte y base comun

Ademas de los componentes visuales principales, el sistema incluye piezas de soporte que fortalecen la experiencia y la consistencia:

- `UanThemeTokens` para acceder a los tokens desde cualquier composable.
- `UanTokens.Default` como configuracion base del sistema.
- `UanTypography` y `UanShapes` como estructuras de configuracion.
- `UanTone` para estandarizar semantica visual.
- `UanInteractiveDefaults` para reglas de interaccion.
- `UanAccessibility` para consideraciones de accesibilidad.
- `UanIconography`, `UanGrid` y `UanElevation` como utilidades de framework.

## 8. Testing

### 8.1 Configuracion disponible

El proyecto ya tiene configuradas dependencias para:

- **JUnit 4** para pruebas unitarias.
- **AndroidX JUnit** para pruebas instrumentadas.
- **Espresso** para interaccion con UI tradicional.
- **Compose UI Test** para pruebas de interfaces construidas con Compose.
- **Compose tooling** para inspeccion visual en desarrollo.

### 8.2 Estado observado en el repositorio

Al momento de esta documentacion no se observan archivos de prueba en:

- `ui-kit/src/test`
- `ui-kit/src/androidTest`

Esto indica que el proyecto cuenta con la infraestructura lista para probar, pero aun no tiene pruebas automatizadas registradas en el repositorio.

### 8.3 Estrategia de testing recomendada

- Validar cada componente con previews.
- Crear pruebas unitarias para validaciones de defaults, resolucion de tono y reglas de estado.
- Crear pruebas instrumentadas para flujos de interaccion en componentes complejos.
- Añadir pruebas de Compose para estados visuales, accesibilidad y comportamiento.
- Verificar que los componentes principales se rendericen correctamente con el tema `UanTheme`.

## 9. Conclusiones

El desarrollo dejo como resultado un sistema de diseno modular, reutilizable y alineado con Compose, con una base de tokens, tema y componentes suficientes para estandarizar la interfaz de las aplicaciones de la Universidad de los Andes.

La estructura actual permite seguir escalando el sistema con nuevos componentes, nuevas variantes y una cobertura mayor de pruebas sin romper la organizacion existente.
