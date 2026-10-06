# U2_16 · Suma por filas y por columnas

[Anterior](../../unidad2/15-matrices-y-recorridos/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/17-diagonales/README.md)

## Objetivo

Ubicar acumuladores según el subtotal que representan.

Tema: **Arreglos**.

## Problema y contrato

Con la misma tabla de consumos calcularemos total por aula y por día. La suma de todos los subtotales debe coincidir en ambas perspectivas.

## Conceptos necesarios

Para un subtotal por fila, reinicia el acumulador al comenzar cada fila. Para uno por columna, reinícialo al comenzar cada columna. Si lo reinicias dentro del ciclo interno conservas solo la última celda; si nunca lo reinicias obtienes acumulados, no subtotales independientes.

La matriz de demostración es rectangular y no vacía. Long permite acumular valores int con más rango. Puedes guardar los resultados en arreglos de longitud filas o columnas si necesitas procesarlos después.

La propiedad suma(subtotalesFilas) = suma(subtotalesColumnas) = totalCeldas es una comprobación útil. No demuestra cada subtotal individual, por lo que también conviene contrastar un caso calculado manualmente.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Para cada fila
  suma ← 0
  Para cada columna: suma ← suma + dato
  Mostrar suma
FinPara
Repetir con columna exterior para subtotal por día
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        int[][] datos = {{2, 4, 6}, {1, 3, 5}};
        for (int f = 0; f < datos.length; f++) {
            long suma = 0;
            for (int c = 0; c < datos[f].length; c++) suma += datos[f][c];
            System.out.println("Fila " + f + ": " + suma);
        }
        for (int c = 0; c < datos[0].length; c++) {
            long suma = 0;
            for (int f = 0; f < datos.length; f++) suma += datos[f][c];
            System.out.println("Columna " + c + ": " + suma);
        }
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/16-sumas-por-fila-y-columna
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Fila 0: 12
Fila 1: 9
Columna 0: 3
Columna 1: 7
Columna 2: 11
```

## Prueba de escritorio y recorrido

Las filas suman12 y9; las columnas3,7 y11. Ambas agrupaciones producen21 como total. Los acumuladores se reinician en cada grupo.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Confundir subtotal con acumulado produce salidas como12 y21 para las filas. Un índice mal ubicado puede mezclar dimensiones. Sumar filas no indica cuántas mediciones hay.

## Práctica

Guarda subtotales en dos arreglos. Comprueba ambos totales con una condición ejecutable y prueba una matriz1×3.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Los arreglos tienen longitudes2 y3. Sus sumas deben ser21. Una matriz1×3 tiene un subtotal de fila y tres subtotales de columna, cada uno igual a su celda.

</details>

## Explica con tus palabras

¿Dónde se reinicia cada acumulador? ¿Por qué comparar totales no basta para demostrar todos los subtotales?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/15-matrices-y-recorridos/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/17-diagonales/README.md)
