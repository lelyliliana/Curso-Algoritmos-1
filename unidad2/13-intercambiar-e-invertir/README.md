# U2_13 · Intercambio e inversión del vector

[Anterior](../../unidad2/12-mayor-y-menor/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/14-ordenamiento-por-seleccion/README.md)

## Objetivo

Modificar posiciones sin perder el valor que todavía se necesita.

Tema: **Arreglos**.

## Problema y contrato

Intercambiaremos dos posiciones y después invertiremos toda una secuencia. El intercambio necesita una variable temporal para no sobrescribir uno de los valores.

## Conceptos necesarios

Asignar primero datos[i] = datos[j] destruye el valor anterior de i si no se conservó. La secuencia correcta guarda temporal, reemplaza i y luego coloca temporal en j. Es una operación de estado, no una comparación.

Invertir usa dos índices que avanzan desde extremos opuestos. Intercambiamos mientras izquierda < derecha. En longitud impar, el elemento central no necesita cambiar; en par, todos se emparejan. Un vector vacío o de un elemento requiere cero intercambios.

La operación modifica el mismo arreglo. Si necesitas conservar el original, clónalo antes. El recorrido hace aproximadamente n/2 intercambios y es O(n), aunque no visite cada posición con un contador desde cero.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
izquierda ← 0; derecha ← n-1
Mientras izquierda < derecha
  temporal ← datos[izquierda]
  datos[izquierda] ← datos[derecha]
  datos[derecha] ← temporal
  izquierda ← izquierda + 1; derecha ← derecha - 1
FinMientras
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
import java.util.Arrays;
public class Main {
    static void intercambiar(int[] datos, int i, int j) {
        int temporal = datos[i];
        datos[i] = datos[j];
        datos[j] = temporal;
    }
    public static void main(String[] args) {
        int[] datos = {1, 2, 3, 4, 5};
        for (int i = 0, j = datos.length - 1; i < j; i++, j--) {
            intercambiar(datos, i, j);
        }
        System.out.println(Arrays.toString(datos));
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/13-intercambiar-e-invertir
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
[5, 4, 3, 2, 1]
```

## Prueba de escritorio y recorrido

Se intercambian posiciones0/4 y1/3. Cuando los índices llegan a2/2, el ciclo termina. El3 central conserva su posición.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Usar dos asignaciones sin temporal duplica un dato. Recorrer hasta que i alcance n después de invertir por parejas puede deshacer la inversión. Intercambiar índices externos falla por límite.

## Práctica

Prueba longitud4, longitud1 y vacío. Invierte dos veces y comprueba que recuperas el vector original.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Cuatro elementos requieren dos intercambios. Uno o vacío ninguno. Invertir dos veces devuelve el orden original, una propiedad útil para comprobar la operación.

</details>

## Explica con tus palabras

¿Qué dato conserva temporal? ¿Por qué no debe recorrerse la segunda mitad otra vez?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/12-mayor-y-menor/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/14-ordenamiento-por-seleccion/README.md)
