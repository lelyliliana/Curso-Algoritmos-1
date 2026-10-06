# U2_20 · Multiplicación de matrices

[Anterior](../../unidad2/19-transpuesta-y-suma/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/01-registros/README.md)

## Objetivo

Calcular productos fila-columna y validar dimensiones compatibles.

Tema: **Arreglos**.

## Problema y contrato

Multiplicaremos una matriz2×3 por una3×2. El resultado tendrá2×2. Es una operación distinta de multiplicar celdas en posiciones equivalentes.

## Conceptos necesarios

El producto A(f×k) × B(k×c) está definido cuando columnas de A = filas de B. Cada salida[f][c] es la suma de A[f][i] × B[i][c] para i de0 a k-1. La dimensión compartida k es el recorrido de acumulación.

Se necesitan tres recorridos: fila de salida, columna de salida y dimensión común. El acumulador se reinicia para cada celda de salida. No lo reinicies dentro del recorrido k ni lo compartas entre todas las celdas.

El método valida que las matrices sean rectangulares, no vacías y compatibles. Usa long para cada producto y Math.addExact para detectar desbordamiento en la suma. Multiplicar dos int convertidos a long cabe en long; sumar muchos productos todavía puede excederlo.

El algoritmo directo realiza O(f×k×c) trabajo y la salida ocupa O(f×c). Para matrices cuadradas n×n el trabajo es O(n³), pero conserva las dimensiones cuando son independientes.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
validar columnas(A)=filas(B)
Para f en filas(A)
  Para c en columnas(B)
    acumulado ← 0
    Para i en columnas(A)
      acumulado ← acumulado + A[f][i] × B[i][c]
    FinPara
    resultado[f][c] ← acumulado
  FinPara
FinPara
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
import java.util.Arrays;
public class Main {
    static int columnas(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            throw new IllegalArgumentException("Matriz vacía");
        }
        int c = m[0].length;
        for (int[] fila : m) {
            if (fila == null || fila.length != c) throw new IllegalArgumentException("Matriz irregular");
        }
        return c;
    }
    static long[][] multiplicar(int[][] a, int[][] b) {
        int k = columnas(a), c = columnas(b);
        if (k != b.length) throw new IllegalArgumentException("Dimensiones incompatibles");
        long[][] resultado = new long[a.length][c];
        for (int f = 0; f < a.length; f++) {
            for (int columna = 0; columna < c; columna++) {
                long suma = 0;
                for (int i = 0; i < k; i++) {
                    suma = Math.addExact(suma, (long) a[f][i] * b[i][columna]);
                }
                resultado[f][columna] = suma;
            }
        }
        return resultado;
    }
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int[][] b = {{7, 8}, {9, 10}, {11, 12}};
        for (long[] fila : multiplicar(a, b)) System.out.println(Arrays.toString(fila));
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/20-producto-de-matrices
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
[58, 64]
[139, 154]
```

## Prueba de escritorio y recorrido

Primera celda:1×7+2×9+3×11=58. La siguiente usa columna8,10,12 y produce64. La segunda fila repite los productos con4,5,6 y produce139,154.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Multiplicar celda a celda no es el producto matricial. Reutilizar el acumulador entre salidas mezcla resultados. La compatibilidad no exige que las matrices tengan igual forma.

## Práctica

Multiplica una matriz2×2 por la identidad2×2. Prueba una matriz incompatible y otra irregular. Comprueba que se rechacen antes de producir salida.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

La identidad conserva la matriz original. Una2×3 por2×2 es incompatible; una fila de longitud diferente viola la rectangularidad. Ambas deben lanzar IllegalArgumentException.

</details>

## Explica con tus palabras

¿Qué dimensión se comparte? ¿Dónde se reinicia el acumulador?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/19-transpuesta-y-suma/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/01-registros/README.md)
