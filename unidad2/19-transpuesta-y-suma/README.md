# U2_19 · Transpuesta y suma de matrices

[Anterior](../../unidad2/18-intercambios-y-orden-de-filas/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/20-producto-de-matrices/README.md)

## Objetivo

Crear resultados con dimensiones correctas y no confundir operaciones.

Tema: **Arreglos**.

## Problema y contrato

Transpondremos una matriz2×3 y la sumaremos con otra de igual forma. La transpuesta cambia filas por columnas; la suma combina posiciones correspondientes.

## Conceptos necesarios

La transpuesta de una matriz f×c tiene forma c×f y cumple resultado[c][f] = original[f][c]. Una matriz no cuadrada hace visible el cambio de dimensiones. Construir solo un cuadrado n×n ocultaría una implementación incorrecta.

Para sumar matrices, ambas deben tener las mismas dimensiones. Cada celda de salida es a[f][c] + b[f][c]. No es concatenar filas ni multiplicar. Aquí las entradas literales garantizan matrices rectangulares y compatibles; al aceptar datos externos debes validar esa condición antes de comenzar.

Usamos long en la salida de suma para que la adición de dos int no desborde int. La conversión tiene lugar antes de sumar. Las operaciones crean matrices nuevas y conservan los originales.

Ambas recorren f×c celdas, O(f×c), y su salida ocupa espacio proporcional a esas celdas. Contar el espacio del resultado es importante aunque no modifiques la entrada.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Crear transpuesta de c filas y f columnas
Para cada celda (fila,columna)
  transpuesta[columna][fila] ← a[fila][columna]
  suma[fila][columna] ← a[fila][columna] + b[fila][columna]
FinPara
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int[][] b = {{10, 20, 30}, {40, 50, 60}};
        int filas = a.length, columnas = a[0].length;
        int[][] transpuesta = new int[columnas][filas];
        long[][] suma = new long[filas][columnas];
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                transpuesta[c][f] = a[f][c];
                suma[f][c] = (long) a[f][c] + b[f][c];
            }
        }
        System.out.println("Transpuesta:");
        for (int[] fila : transpuesta) System.out.println(Arrays.toString(fila));
        System.out.println("Suma:");
        for (long[] fila : suma) System.out.println(Arrays.toString(fila));
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/19-transpuesta-y-suma
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Transpuesta:
[1, 4]
[2, 5]
[3, 6]
Suma:
[11, 22, 33]
[44, 55, 66]
```

## Prueba de escritorio y recorrido

A tiene2 filas y3 columnas, así que la transpuesta tiene3 filas y2 columnas. La suma conserva2×3 y combina celdas con iguales coordenadas.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Crear la transpuesta con la forma original falla o pierde datos. Sumar formas distintas no tiene este contrato matemático. Convertir a long después de una suma int deja un desbordamiento ya ocurrido.

## Práctica

Transpón dos veces y comprueba que recuperas los datos. Agrega validación para filas nulas, forma irregular y dimensiones diferentes en la suma.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

La doble transposición recupera forma y valores. Valida longitud exterior, longitud de cada fila y correspondencia con b antes del recorrido. Una entrada inválida debe rechazarse, no sumarse parcialmente.

</details>

## Explica con tus palabras

¿Cómo cambia la forma en la transpuesta? ¿Por qué la suma conserva la forma?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/18-intercambios-y-orden-de-filas/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/20-producto-de-matrices/README.md)
