# U2_17 · Diagonales y clasificación de matrices

[Anterior](../../unidad2/16-sumas-por-fila-y-columna/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/18-intercambios-y-orden-de-filas/README.md)

## Objetivo

Localizar diagonales en una matriz cuadrada y explicar el caso central.

Tema: **Arreglos**.

## Problema y contrato

Una matriz3×3 tiene diagonal principal y secundaria. Calcularemos sus sumas sin recorrer todas sus celdas.

## Conceptos necesarios

Una matriz cuadrada tiene igual número de filas y columnas. En ella, la diagonal principal contiene posiciones (i,i) y la secundaria (i,n-1-i). Las expresiones dependen de índices desde cero; trasladar una fórmula de posiciones desde uno requiere ajustarla.

Una matriz rectangular no cuadrada no cumple el contrato de este ejemplo. Java también permite arreglos irregulares, así que el método valida todas las filas. La comprobación de forma cuesta O(n) filas; sumar diagonales también O(n).

En una matriz cuadrada de tamaño impar, las diagonales comparten la celda central. Si sumas ambas sumas para obtener la unión de diagonales, debes restar una vez ese centro. Si deseas dos resultados separados, el centro pertenece legítimamente a ambos.

Términos como triangular o diagonal describen propiedades de sus valores, no solo su forma. Tener índices de una diagonal no convierte toda la matriz en una matriz diagonal.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
validar forma cuadrada
principal ← 0; secundaria ← 0
Para i desde 0 hasta n-1
  principal ← principal + datos[i][i]
  secundaria ← secundaria + datos[i][n-1-i]
FinPara
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        int[][] datos = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = datos.length;
        for (int[] fila : datos) {
            if (fila == null || fila.length != n) throw new IllegalArgumentException("Debe ser cuadrada");
        }
        long principal = 0, secundaria = 0;
        for (int i = 0; i < n; i++) {
            principal += datos[i][i];
            secundaria += datos[i][n - 1 - i];
        }
        System.out.println("Principal: " + principal);
        System.out.println("Secundaria: " + secundaria);
        long union = principal + secundaria;
        if (n % 2 == 1) union -= datos[n / 2][n / 2];
        System.out.println("Unión: " + union);
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/17-diagonales
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Principal: 15
Secundaria: 15
Unión: 25
```

## Prueba de escritorio y recorrido

Principal suma1,5,9. Secundaria suma3,5,7. Las dos sumas dan30, pero la unión debe contar5 una sola vez y da25.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Usar n-i con índices desde cero accede al índice n. Confundir unión con suma de las dos diagonales duplica el centro. Ignorar forma puede exceder una fila corta.

## Práctica

Prueba una matriz2×2 y otra1×1. Describe la política para una matriz0×0 y comprueba que este código no accede a una celda inexistente.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

En2×2 no se comparte centro. En1×1 la unión es el único dato. El código permite0×0 y produce sumas0; si el dominio exige al menos una celda, agrega rechazo explícito.

</details>

## Explica con tus palabras

¿Qué posiciones integran cada diagonal? ¿Por qué la paridad afecta la unión?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/16-sumas-por-fila-y-columna/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/18-intercambios-y-orden-de-filas/README.md)
