# Algoritmos 1

Curso abierto de **Leli Liliana Díaz Izquierdo** para aprender a analizar problemas, diseñar algoritmos, modelar datos y comprobar soluciones.

El recorrido tiene **tres unidades y 42 lecciones desarrolladas**. Cada lección relaciona pseudocódigo, pruebas de escritorio e implementación en **Java 21**. Puedes realizarlo en **Windows, Ubuntu o macOS**.

## Comenzar

[Primera lección: problemas, soluciones y programas](unidad1/01-problemas-y-algoritmos/README.md)

Si no conoces GitHub, puedes leer aquí mismo. Al terminar una lección utiliza **Siguiente recurso**. Para ejecutar programas necesitarás descargar el repositorio y preparar el JDK.

[Cómo estudiar y descargar](docs/como-estudiar-en-github.md) · [Preparar el ambiente](docs/ambiente-y-herramientas.md) · [Convenciones del pseudocódigo](docs/pseudocodigo-y-pruebas.md)

## Unidades y temas en orden

| Unidad | Temas | Acceso |
|---|---|---|
| 1. Introducción a los algoritmos | Clarificar el problema → componentes → pruebas de escritorio → valores y asignaciones | [Unidad 1](unidad1/README.md) |
| 2. Conceptos y estructuras básicas de algoritmos | Condicionales e iterativas → introducción a POO → arreglos | [Unidad 2](unidad2/README.md) |
| 3. Registros, archivos, análisis y hileras | Registros → operaciones con archivos → análisis de algoritmos → hileras de caracteres | [Unidad 3](unidad3/README.md) |

## Qué incluye

- Explicaciones de conceptos y contratos del problema.
- Pseudocódigo con convenciones explícitas y programas completos.
- Resultados esperados y recorridos que explican el cambio de estado.
- Prácticas con orientación de solución y preguntas de comprensión.
- Tres talleres con casos de prueba y criterios.
- Proyecto de catálogo con menú, búsqueda, eliminación y persistencia.
- Verificación automática de ejemplos, contratos, algoritmos y navegación.

## Requisitos

Usa **JDK 21** y un editor a elección. No se necesitan frameworks, Maven ni bases de datos. Java 21 es la base elegida para reproducir el curso; los ejemplos no usan funciones experimentales. Python 3 solo se utiliza si quieres ejecutar la verificación global opcional.

Cada carpeta tiene un Main.java independiente. No importes todos los Main en un mismo módulo del IDE. La guía explica cómo ejecutar el fuente o compilar por separado y cómo preparar el JDK para cada sistema.

## Primera ejecución

Desde la raíz del repositorio entra al ejemplo:

```bash
cd unidad1/01-problemas-y-algoritmos
```

Ejecuta:

```bash
java Main.java
```

La demostración informa3 cuadernos por equipo y2 sobrantes. Cada lección indica sus propias entradas y salidas. Los ejemplos de archivo generan datos exclusivamente en su subcarpeta salida/ y documentan si sobrescriben o anexan.

## Verificación opcional

Desde la raíz, con Python 3 y JDK instalados:

| Sistema | Comando |
|---|---|
| Windows (PowerShell) | `py -3 scripts/verificar.py` |
| Ubuntu (Terminal) | `python3 scripts/verificar.py` |
| macOS (Terminal) | `python3 scripts/verificar.py` |

Si no tienes el lanzador py en Windows, usa `python scripts/verificar.py` y comprueba que sea Python 3. El script ejecuta en carpetas temporales, contrasta salidas, comprueba algoritmos y contratos del proyecto y valida enlaces internos. GitHub Actions repite esas comprobaciones en los tres sistemas con JDK 21.

## Recursos de estudio

[Mapa de cobertura](docs/mapa-del-curso.md) · [Glosario](docs/glosario.md) · [Fuentes oficiales](docs/fuentes.md) · [Cierre](docs/cierre.md)

## Autora

**Leli Liliana Díaz Izquierdo**  
Ingeniera de Sistemas y docente.  
[Sitio personal](https://lelyliliana.com/) · [GitHub](https://github.com/lelyliliana)
