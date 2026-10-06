# U3_08 · Orden de crecimiento: O, Ω y Θ

[Anterior](../../unidad3/07-contador-de-frecuencias/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/09-busqueda-lineal-y-binaria/README.md)

## Objetivo

Interpretar límites asintóticos y conservar parámetros independientes.

Tema: **Análisis de algoritmos**.

## Problema y contrato

Calcularemos conteos para distintos tamaños. La tabla muestra crecimiento lineal, triangular y rectangular; no muestra tiempos de un computador.

## Conceptos necesarios

Big O expresa una cota superior asintótica bajo un modelo definido, no un tiempo exacto ni un sinónimo obligatorio de peor caso. Ω expresa cota inferior y Θ una cota ajustada. Puedes analizar cualquiera de ellas sobre una función de mejor, peor o caso promedio, siempre que declares el caso.

Si una función es3n+5, su crecimiento esΘ(n). Para n(n-1)/2, esΘ(n²). No se elimina cualquier término por una regla mecánica: se justifica cuál domina cuando n crece. Si hay dimensiones independientes, n+m no se reduce a n sin una relación que lo permita.

| Trabajo | Orden ajustado bajo estas condiciones |
|---|---|
| Una operación de costo fijo | Θ(1) |
| Recorrido de n datos | Θ(n) |
| Pares i<j | Θ(n²) |
| Recorrer f×c celdas | Θ(f×c) |
| Reducir un intervalo a la mitad | Θ(log n) en el peor recorrido |

También analiza memoria. Un algoritmo puede usar O(1) espacio auxiliar y producir una salida O(n); declara si incluyes la salida. Asintótico no garantiza que una versión sea más rápida para todos los tamaños pequeños.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Para cada n de la tabla
  lineal ← 3n+5
  triangular ← n(n-1)/2
  Mostrar n, lineal, triangular
FinPara
Conservar f y c si crecen independientemente
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        for (int n : new int[]{10, 20, 40}) {
            long lineal = 3L * n + 5;
            long triangular = (long) n * (n - 1) / 2;
            System.out.println("n=" + n + " lineal=" + lineal + " pares=" + triangular);
        }
        int filas = 3, columnas = 7;
        System.out.println("Celdas f*c: " + filas * columnas);
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad3/08-orden-de-crecimiento
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
n=10 lineal=35 pares=45
n=20 lineal=65 pares=190
n=40 lineal=125 pares=780
Celdas f*c: 21
```

## Prueba de escritorio y recorrido

Al duplicar n, la función lineal se acerca a duplicarse; la cuadrática se acerca a cuadruplicarse. Los términos pequeños explican que las razones no sean exactas con estos tamaños.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Presentar O(n) como n milisegundos inventa unidades. Decir que dos ciclos siempre son O(n²) ignora sus dimensiones. Elegir la cota O(n²) para un recorrido lineal es válida pero poco informativa frente a la cota ajustada.

## Práctica

Analiza un recorrido de n datos seguido de otro de m. Después analiza producto f×k×c. Explica qué cambia si las tres dimensiones valen n.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Los recorridos consecutivos tienenΘ(n+m) bajo costo fijo. El producto directo tieneΘ(fkc); con todas iguales a n esΘ(n³). No impongas esa igualdad a un caso rectangular.

</details>

## Explica con tus palabras

¿Qué diferencia hay entre una cota superior y una ajustada? ¿Qué tamaño representa cada parámetro?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad3/07-contador-de-frecuencias/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/09-busqueda-lineal-y-binaria/README.md)
