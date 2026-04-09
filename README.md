# UAN Design System

Libreria Android basada en Jetpack Compose para centralizar la identidad visual, los tokens de diseno y los componentes reutilizables de la Universidad de los Andes.

## Resumen

El proyecto esta organizado como una libreria consumible y no como una aplicacion final. Su objetivo es ofrecer una base reusable de tema, foundation y componentes que pueda publicarse como artefacto Maven y extenderse de forma controlada.

## Estado tecnico

- Modulo principal: `ui-kit`
- `compileSdk`: 35
- `minSdk`: 26
- Java: 11
- UI: Jetpack Compose
- Publicacion: `release` con `sourcesJar`

## Estructura del kit

- `theme`: tema raiz, tokens y esquema visual
- `theme/tokens`: colores, tipografia, formas, spacing, grid, iconografia, elevaciones y motion
- `foundation`: utilidades transversales y defaults compartidos
- `components`: componentes Compose reutilizables del sistema

## Tema y tokens

El tema raiz se expone con `UanTheme` y provee acceso global a los tokens con `UanThemeTokens.current`.

Los tokens disponibles centralizan:

- `UanColors` y `UanDarkColors`
- `UanTypography`
- `UanShapes`
- `UanSpacing`
- `UanGrid`
- `UanIconography`
- `UanElevations`
- `UanMotion`

## Foundation

La capa foundation contiene primitives y helpers reutilizables como:

- `UanTone`
- `UanIconButton`
- `UanElevation`
- `UanGridDefaults`
- `UanInteractiveDefaults`
- `UanAccessibility`

## Componentes disponibles

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

Cada componente incluye su respectivo archivo de defaults y, en varios casos, previews para validacion visual.

## Material de referencia

La carpeta `FIGMA/` contiene exportaciones visuales de referencia del sistema:

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

## Build y publicacion

El modulo `ui-kit` esta preparado para publicacion Maven con:

- `groupId`: `com.uan.designsystem`
- `artifactId`: `uan-design-system`
- `version`: `1.0.0`

## Uso basico

```kotlin
UanTheme {
    // UI de la pantalla
}
```

## Documentacion tecnica completa

La documentacion detallada del proyecto se mantiene en:

- [DOCUMENTACION_DESARROLLO_UAN_DESIGN_SYSTEM.md](DOCUMENTACION_DESARROLLO_UAN_DESIGN_SYSTEM.md)

