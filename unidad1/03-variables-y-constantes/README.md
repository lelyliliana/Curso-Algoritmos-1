# U1_03 · Variables, constantes y nombres

[Anterior](../../unidad1/02-representar-la-solucion/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad1/04-representacion-de-datos/README.md)

## Objetivo

Relacionar datos del problema con variables de significado claro.

Tema: **Componentes de un algoritmo**.

## Problema y contrato

Una jornada dispone de 4 cajas con 12 cuadernos por caja. Conservaremos el número de cajas y una cantidad por caja fija para este cálculo. Los nombres deben explicar qué cuenta cada dato.

## Conceptos necesarios

Una variable tiene tipo, nombre y valor. Su valor puede cambiar durante la ejecución. Una constante expresa un valor que permanece fijo bajo el contrato del cálculo. En Java `final` impide reasignar una variable; con objetos eso no garantiza inmutabilidad interna.

Usamos `int` para cantidades pequeñas, `long` para cálculos enteros con mayor rango, `double` para aproximaciones decimales, `boolean` para condiciones y `String` para texto. El tipo debe escogerse por el dominio y el rango, no solo por comodidad.

Los identificadores distinguen mayúsculas. Un nombre como `cantidadCajas` comunica más que `x`. Java exige inicializar una variable local antes de leerla. En estos ejemplos la declaración y el cálculo son instrucciones diferentes, separadas por punto y coma.

La cantidad por caja es fija en esta demostración, pero no necesariamente en toda aplicación. No declares una constante universal para un valor que cambia entre productos. Los supuestos deben quedar cerca de las decisiones que justifican.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
cantidadCajas ← 4
CUADERNOS_POR_CAJA ← 12
total ← cantidadCajas × CUADERNOS_POR_CAJA
Mostrar total
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        int cantidadCajas = 4;
        final int CUADERNOS_POR_CAJA = 12;
        long total = (long) cantidadCajas * CUADERNOS_POR_CAJA;
        System.out.println("Cuadernos: " + total);
        cantidadCajas = 5;
        System.out.println("Cajas actualizadas: " + cantidadCajas);
        System.out.println("Total calculado antes: " + total);
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad1/03-variables-y-constantes
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Cuadernos: 48
Cajas actualizadas: 5
Total calculado antes: 48
```

## Prueba de escritorio y recorrido

El total se calcula con 4 cajas. Después, cambiar cantidadCajas a 5 no recalcula automáticamente una variable ya asignada. Total conserva 48 hasta recibir otra asignación.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Creer que una variable guarda una fórmula que se actualiza sola confunde asignación con una hoja de cálculo. Un número entre comillas es texto. Reasignar una variable final falla al compilar.

## Práctica

Recalcula total después de cambiar las cajas. Predice el nuevo resultado. Explica cuándo la cantidad por caja dejaría de ser una constante del cálculo.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

El segundo cálculo produce 60. Si cada caja contiene cantidades diferentes, necesitas recibir o almacenar esa información; multiplicar por una única constante ya no representa el problema.

</details>

## Explica con tus palabras

¿Qué guarda total: una fórmula o un valor? ¿Por qué importa el rango del tipo?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad1/02-representar-la-solucion/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad1/04-representacion-de-datos/README.md)
