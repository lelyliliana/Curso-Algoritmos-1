# U1_08 · Asignación, actualización y entrada de datos

[Anterior](../../unidad1/07-prueba-de-escritorio/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/01-decisiones/README.md)

## Objetivo

Aplicar una secuencia de asignaciones y recibir datos sin perder su significado.

Tema: **Valores y asignaciones a variables**.

## Problema y contrato

Una caja empieza con 10 unidades. El usuario escribe el número de unidades vendidas, de 0 a 10. La entrada llega como texto y debe convertirse antes de actualizar el saldo.

## Conceptos necesarios

Una asignación evalúa el lado derecho y guarda el resultado en el izquierdo. `disponibles = disponibles - vendidas` utiliza el valor anterior de disponibles y lo reemplaza. No es una igualdad matemática que deba despejarse.

La entrada de consola es texto. Scanner.nextLine lee una línea e Integer.parseInt intenta convertirla. Primero se valida formato y después rango. Capturamos NumberFormatException para informar texto no entero; la regla de negocio rechaza ventas negativas o superiores a las existencias.

Leemos siempre líneas completas para evitar el salto pendiente que suele aparecer al combinar nextInt y nextLine. El Scanner se cierra al terminar la aplicación, porque cierra también System.in. Un dato correctamente convertido no necesariamente es válido para la regla.

La actualización ocurre una sola vez y únicamente tras validar. Un dato inválido no consume unidades. Para repetir ventas haría falta un ciclo y una política de terminación, que estudiarás en la siguiente unidad.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
disponibles ← 10
Leer texto
convertir texto a entero vendidas
Si vendidas no está en 0..disponibles: rechazar
SiNo: disponibles ← disponibles - vendidas
Mostrar disponibles
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int disponibles = 10;
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Unidades vendidas (0..10):");
            if (!teclado.hasNextLine()) return;
            int vendidas = Integer.parseInt(teclado.nextLine().strip());
            if (vendidas < 0 || vendidas > disponibles) {
                System.out.println("Venta fuera de rango");
                return;
            }
            disponibles = disponibles - vendidas;
            System.out.println("Disponibles: " + disponibles);
        } catch (NumberFormatException e) {
            System.out.println("Escribe un número entero");
        }
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad1/08-asignacion-y-entrada
```

4. Ejecuta el archivo:

```bash
java Main.java
```

Cuando el programa lo solicite, escribe:

```text
3
```

La salida esperada no incluye el eco del teclado que puede mostrar tu terminal.

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Unidades vendidas (0..10):
Disponibles: 7
```

## Prueba de escritorio y recorrido

Escribe 3 y presiona Enter. La conversión produce un entero válido; la regla acepta la venta. El saldo anterior 10 se utiliza en la resta y se reemplaza por 7.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Actualizar antes de validar permite saldos negativos. Escribir tres no es formato entero. Multiplicar un dato String no funciona como una operación numérica.

## Práctica

Prueba 0, 10, 11, -1 y `tres`. Haz una tabla con formato válido, rango válido y saldo final para cada caso.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

0 conserva 10 y 10 deja 0. 11 y -1 tienen formato entero pero se rechazan por rango. tres se rechaza por formato. Ningún rechazo llega a la asignación del saldo.

</details>

## Explica con tus palabras

¿Qué valor usa el lado derecho de una asignación? ¿Por qué se necesitan dos validaciones?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad1/07-prueba-de-escritorio/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/01-decisiones/README.md)
