# U2_18 · Intercambiar filas, columnas y ordenar por una clave

[Anterior](../../unidad2/17-diagonales/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/19-transpuesta-y-suma/README.md)

## Objetivo

Modificar una tabla conservando la relación entre los campos de cada fila.

Tema: **Arreglos**.

## Problema y contrato

Una tabla relaciona código de aula y cantidad. Ordenar solamente la columna de códigos mezclaría esos códigos con cantidades de otras aulas. Debemos mover filas completas.

## Conceptos necesarios

Intercambiar filas de un arreglo de arreglos puede hacerse intercambiando referencias a sus arreglos interiores. Intercambiar columnas requiere visitar cada fila y cambiar dos celdas. La tabla de este ejemplo es rectangular con dos columnas.

Ordenar por una columna selecciona una clave, pero mueve todo el registro representado en cada fila. Usaremos selección por la columna0 y un intercambio de filas. La relación código-cantidad se mantiene porque ambos campos viajan juntos.

Los intercambios modifican la tabla original. Si dos filas fueran referencias al mismo arreglo, un cambio de celdas en una afectaría ambas; el ejemplo construye filas independientes. En problemas con campos de tipos distintos, es preferible usar registros tipados, que estudiarás en la unidad 3.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
intercambiar fila0 y fila2
intercambiar columna0 y columna1 por cada fila
restaurar columnas
Para cada posición de fila
  buscar menor clave pendiente
  intercambiar filas completas
FinPara
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
import java.util.Arrays;
public class Main {
    static void columnas(int[][] datos, int a, int b) {
        for (int[] fila : datos) {
            int temporal = fila[a]; fila[a] = fila[b]; fila[b] = temporal;
        }
    }
    static void filas(int[][] datos, int a, int b) {
        int[] temporal = datos[a]; datos[a] = datos[b]; datos[b] = temporal;
    }
    public static void main(String[] args) {
        int[][] datos = {{30, 5}, {10, 8}, {20, 2}};
        filas(datos, 0, 2);
        columnas(datos, 0, 1);
        columnas(datos, 0, 1);
        for (int i = 0; i < datos.length - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < datos.length; j++) {
                if (datos[j][0] < datos[minimo][0]) minimo = j;
            }
            filas(datos, i, minimo);
        }
        for (int[] fila : datos) System.out.println(Arrays.toString(fila));
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/18-intercambios-y-orden-de-filas
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
[10, 8]
[20, 2]
[30, 5]
```

## Prueba de escritorio y recorrido

El primer intercambio cambia el orden sin romper parejas. Dos intercambios de columnas restauran su posición. Selección por código produce10,20,30 con sus cantidades8,2,5.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Ordenar una sola columna pierde asociaciones. Copiar filas por referencia no crea copias profundas. Indicar un índice de columna inexistente falla en la operación.

## Práctica

Ordena por cantidad descendente. Verifica que las parejas originales sigan intactas y define una regla para empates.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

El orden por cantidades es [10,8], [30,5], [20,2]. Busca el máximo de columna1 en cada pasada. Para empates, define una segunda clave o documenta que esta selección no es estable.

</details>

## Explica con tus palabras

¿Qué unidad debe moverse al ordenar por una columna? ¿Qué costo tiene intercambiar filas frente a columnas?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/17-diagonales/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/19-transpuesta-y-suma/README.md)
