# U1_04 · Bits, bytes, tipos y representación

[Anterior](../../unidad1/03-variables-y-constantes/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad1/05-operadores-aritmeticos/README.md)

## Objetivo

Distinguir unidades de almacenamiento, modelos lógicos y límites numéricos.

Tema: **Componentes de un algoritmo**.

## Problema y contrato

Interpretaremos un número en binario y observaremos el máximo de int. También compararemos un cálculo decimal aproximado con uno decimal exacto.

## Conceptos necesarios

Un bit representa un valor binario; un byte contiene 8 bits. Un campo, un registro, un archivo y una base de datos son conceptos de organización lógica, no unidades sucesivas de tamaño. Un archivo puede contener registros, imágenes o muchos otros formatos; una base de datos no se reduce a un «byte más grande».

En Java int usa 32 bits con signo y va de -2147483648 a 2147483647. Long tiene 64 bits. Los enteros tienen rango finito; una operación fuera de él puede desbordar. `Math.addExact` permite detectar un desbordamiento de suma en lugar de aceptar el resultado envuelto.

Double representa aproximaciones binarias. 0.1 no tiene una representación binaria finita exacta, por lo que 0.1 + 0.2 puede mostrar una pequeña diferencia. BigDecimal desde texto permite representar esos decimales exactamente. Elegirlo no elimina la necesidad de definir redondeo al dividir.

Una cadena es texto, no un tipo primitivo. Char almacena una unidad de código UTF-16, que no representa por sí sola todos los caracteres de Unicode. Estudiaremos esa distinción al manejar hileras.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Mostrar representación binaria de 10
Mostrar máximo de entero de 32 bits
Sumar 0.1 y 0.2 con aproximación binaria
Sumar esos decimales desde texto exacto
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
import java.math.BigDecimal;
public class Main {
    public static void main(String[] args) {
        System.out.println("10 en binario: " + Integer.toBinaryString(10));
        System.out.println("Máximo int: " + Integer.MAX_VALUE);
        System.out.println("Aproximado: " + (0.1 + 0.2));
        BigDecimal suma = new BigDecimal("0.1").add(new BigDecimal("0.2"));
        System.out.println("Exacto: " + suma);
        try {
            Math.addExact(Integer.MAX_VALUE, 1);
        } catch (ArithmeticException e) {
            System.out.println("Desbordamiento detectado");
        }
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad1/04-representacion-de-datos
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
10 en binario: 1010
Máximo int: 2147483647
Aproximado: 0.30000000000000004
Exacto: 0.3
Desbordamiento detectado
```

## Prueba de escritorio y recorrido

1010 representa 8 + 2. La suma aproximada refleja la representación binaria; BigDecimal construye desde texto y produce 0.3. La suma exacta de int detecta que no cabe el siguiente valor.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Tratar registro o campo como unidad fija de bytes inventa tamaños. Crear BigDecimal desde 0.1 double incorpora su aproximación previa. Guardar un resultado desbordado en long después de la operación no lo recupera.

## Práctica

Convierte 13 a binario y comprueba su expansión. Compara sumar 1 al máximo int con una conversión a long antes de sumar.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

13 es 1101: 8 + 4 + 1. `(long) Integer.MAX_VALUE + 1` produce 2147483648. Si la suma se hizo primero en int, la conversión posterior conserva el resultado incorrecto.

</details>

## Explica con tus palabras

¿Por qué una unidad lógica no tiene tamaño fijo? ¿Cuándo tiene lugar el desbordamiento?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad1/03-variables-y-constantes/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad1/05-operadores-aritmeticos/README.md)
