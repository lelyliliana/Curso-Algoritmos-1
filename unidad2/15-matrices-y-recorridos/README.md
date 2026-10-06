# U2_15 · Matrices: filas, columnas y forma

[Anterior](../../unidad2/14-ordenamiento-por-seleccion/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/16-sumas-por-fila-y-columna/README.md)

## Objetivo

Interpretar dos dimensiones y recorrer filas o columnas con límites correctos.

Tema: **Arreglos**.

## Problema y contrato

Una tabla registra consumos de dos aulas durante tres días. Veremos recorridos por fila y por columna. El contrato de este ejemplo es una matriz rectangular.

## Conceptos necesarios

En Java int[][] es un arreglo de arreglos. Cada fila puede tener una longitud diferente e incluso ser null. Una matriz rectangular requiere validar igual longitud de filas si recibes datos externos. En este ejemplo la inicialización fija esa forma.

La longitud exterior cuenta filas y datos[fila].length cuenta columnas de esa fila. Recorrer por filas visita todas las columnas de una fila antes de pasar a otra. Recorrer por columnas invierte el orden de los ciclos, pero no cambia el acceso datos[fila][columna].

No todas las tablas bidimensionales representan matrices numéricas en sentido matemático. Para suma y producto matricial necesitaremos además dimensiones compatibles. Aquí solo representamos una tabla rectangular de mediciones completas.

El costo de recorrer f×c datos es O(f×c). Escribir dos ciclos no implica siempre O(n²): si filas y columnas crecen independientemente, conserva ambas variables.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Para fila desde 0 hasta f-1
  Para columna desde 0 hasta c-1
    visitar datos[fila][columna]
  FinPara
FinPara
Repetir con columna como ciclo exterior
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[][] datos = {{2, 4, 6}, {1, 3, 5}};
        System.out.println("Por filas:");
        for (int[] fila : datos) System.out.println(Arrays.toString(fila));
        System.out.println("Por columnas:");
        for (int c = 0; c < datos[0].length; c++) {
            StringBuilder columna = new StringBuilder();
            for (int f = 0; f < datos.length; f++) {
                if (f > 0) columna.append(" ");
                columna.append(datos[f][c]);
            }
            System.out.println(columna);
        }
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/15-matrices-y-recorridos
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Por filas:
[2, 4, 6]
[1, 3, 5]
Por columnas:
2 1
4 3
6 5
```

## Prueba de escritorio y recorrido

El primer recorrido conserva cada fila. El segundo fija c=0 y visita2,1; después c=1 visita4,3; finalmente c=2 visita6,5. Las seis celdas son las mismas.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Invertir los índices del acceso al invertir ciclos falla en matrices no cuadradas. Usar datos[0] sin comprobar filas falla con una matriz exterior vacía. Suponer que toda matriz de Java es rectangular omite su modelo de arreglos.

## Práctica

Crea una matriz3×2 y predice ambos recorridos. Describe qué validaciones agregarías antes de recorrer por columnas si la entrada fuera externa.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Comprueba al menos una fila y longitud conocida; verifica que ninguna fila sea null y que todas tengan esa longitud. Una entrada irregular necesita otro contrato o debe rechazarse.

</details>

## Explica con tus palabras

¿Qué cambia entre recorridos y qué permanece igual? ¿Qué mide cada length?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/14-ordenamiento-por-seleccion/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/16-sumas-por-fila-y-columna/README.md)
