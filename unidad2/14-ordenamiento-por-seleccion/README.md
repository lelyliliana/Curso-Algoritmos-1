# U2_14 · Ordenamiento por selección

[Anterior](../../unidad2/13-intercambiar-e-invertir/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/15-matrices-y-recorridos/README.md)

## Objetivo

Construir un orden progresivo buscando el mínimo pendiente.

Tema: **Arreglos**.

## Problema y contrato

Ordenaremos cuatro cantidades sin llamar a una biblioteca de ordenamiento. El objetivo es seguir las comparaciones y los intercambios, no recomendar este método para grandes volúmenes.

## Conceptos necesarios

Selección divide el vector en una parte ordenada y otra pendiente. Para cada posición i busca el mínimo de i..n-1 y lo intercambia con i. Al terminar una pasada, la posición i contiene el siguiente menor valor.

No intercambiamos cada vez que encontramos un candidato: conservamos su índice y realizamos el intercambio al terminar la búsqueda. El algoritmo hace n(n-1)/2 comparaciones para esta versión, incluso si la entrada ya está ordenada. Por tanto su tiempo es Θ(n²) y su espacio adicional O(1).

Esta variante con intercambios no garantiza estabilidad: dos elementos iguales con información asociada pueden cambiar su orden relativo. Para datos reales, evalúa el contrato del ordenamiento de biblioteca. Primero comprende esta implementación sobre enteros y después analiza alternativas.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Para i desde 0 hasta n-2
  minimo ← i
  Para j desde i+1 hasta n-1
    Si datos[j] < datos[minimo]: minimo ← j
  FinPara
  intercambiar datos[i] y datos[minimo]
FinPara
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
import java.util.Arrays;
public class Main {
    static void ordenar(int[] datos) {
        for (int i = 0; i < datos.length - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < datos.length; j++) {
                if (datos[j] < datos[minimo]) minimo = j;
            }
            int temporal = datos[i];
            datos[i] = datos[minimo];
            datos[minimo] = temporal;
        }
    }
    public static void main(String[] args) {
        int[] datos = {7, 2, 5, 1};
        ordenar(datos);
        System.out.println(Arrays.toString(datos));
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/14-ordenamiento-por-seleccion
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
[1, 2, 5, 7]
```

## Prueba de escritorio y recorrido

La primera pasada coloca1 en posición0 e intercambia7 al final. Las siguientes confirman2 y5. Hay3+2+1=6 comparaciones, independientemente de esos intercambios.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

No reiniciar minimo en i arrastra un índice de la parte ya ordenada. Confundir índice mínimo con valor mínimo rompe el acceso. Ordenar no elimina duplicados.

## Práctica

Agrega un contador de comparaciones. Prueba una entrada de5 datos ordenada y otra invertida. Prueba duplicados y vacío.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Ambas entradas de5 datos hacen10 comparaciones. Los duplicados se conservan; vacío no entra al ciclo. La salida debe estar ordenada y contener los mismos valores y frecuencias que la entrada.

</details>

## Explica con tus palabras

¿Qué porción queda resuelta tras cada pasada? ¿Qué propiedad además del orden debe conservarse?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/13-intercambiar-e-invertir/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/15-matrices-y-recorridos/README.md)
