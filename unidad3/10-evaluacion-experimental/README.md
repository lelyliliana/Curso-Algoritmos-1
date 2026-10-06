# U3_10 · Evaluación experimental y límites de una medición

[Anterior](../../unidad3/09-busqueda-lineal-y-binaria/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/11-hileras-y-longitud/README.md)

## Objetivo

Diseñar una medición sin confundir el cronómetro con una demostración de complejidad.

Tema: **Análisis de algoritmos**.

## Problema y contrato

Ejecutaremos un cálculo repetido y observaremos un intervalo con System.nanoTime. La salida temporal varía; solo se comprueba que el cálculo y el protocolo funcionen.

## Conceptos necesarios

NanoTime mide intervalos, no fechas del calendario ni garantiza precisión de un nanosegundo real. Para comparar algoritmos, prepara datos fuera de la zona medida, usa el mismo tipo de entrada, repite y conserva resultados para que el trabajo tenga efectos observables.

La JVM puede compilar y optimizar durante la ejecución. Un calentamiento sencillo reduce algunas diferencias, pero no convierte este ejemplo en un benchmark riguroso. Carga del sistema, cachés y recolección de basura influyen. Para evaluación especializada considera JMH.

El programa muestra un checksum reproducible y, solo con --medir, el intervalo variable. El modo predeterminado facilita comprobar el ejemplo sin fijar un tiempo esperado. Un resultado aislado no prueba O(n) ni permite afirmar que un algoritmo es universalmente más rápido.

Para comparar, registra versión del JDK, equipo, tamaños, repeticiones y distribución de datos. Presenta medidas repetidas y relaciona la tendencia con el análisis teórico.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
crear datos fuera de medición
repetir cálculo para calentamiento
inicio ← reloj de intervalos
repetir cálculo conservando resultado
fin ← reloj de intervalos
Mostrar checksum
Opcional: Mostrar fin-inicio
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    static long sumar(int[] datos) {
        long suma = 0;
        for (int dato : datos) suma += dato;
        return suma;
    }
    public static void main(String[] args) {
        int[] datos = new int[1000];
        for (int i = 0; i < datos.length; i++) datos[i] = i;
        long calentamiento = 0;
        for (int i = 0; i < 100; i++) calentamiento += sumar(datos);
        long inicio = System.nanoTime();
        long checksum = 0;
        for (int i = 0; i < 100; i++) checksum += sumar(datos);
        long duracion = System.nanoTime() - inicio;
        System.out.println("Checksum: " + checksum);
        System.out.println("Coincide con calentamiento: " + (checksum == calentamiento));
        if (args.length > 0 && args[0].equals("--medir")) {
            System.out.println("Intervalo observado (ns): " + duracion);
        }
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad3/10-evaluacion-experimental
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Checksum: 49950000
Coincide con calentamiento: true
```

## Prueba de escritorio y recorrido

Los datos0..999 suman499500. Repetir100 veces produce49950000. El intervalo se calcula independientemente y solo se imprime en modo --medir.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Medir generación e impresión junto al cálculo mezcla costos. Fijar un resultado en milisegundos como esperado hace fallar equipos correctos. El calentamiento sencillo no elimina todas las optimizaciones.

## Práctica

Ejecuta `java Main.java --medir` varias veces y registra los intervalos. Duplica el tamaño y conserva el protocolo. Explica por qué no debes derivar una ley exacta de esas pocas medidas.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

El checksum cambia según el tamaño y la duración varía. Una tendencia requiere varias medidas, control de condiciones y análisis de dispersión. El orden asintótico se justifica con el recorrido, no con una única razón temporal.

</details>

## Explica con tus palabras

¿Qué queda dentro del intervalo? ¿Qué no demuestra esta medición?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad3/09-busqueda-lineal-y-binaria/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/11-hileras-y-longitud/README.md)
