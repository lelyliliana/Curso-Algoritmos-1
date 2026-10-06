# U1_05 · Operadores aritméticos y precedencia

[Anterior](../../unidad1/04-representacion-de-datos/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad1/06-relaciones-y-logica/README.md)

## Objetivo

Evaluar expresiones sin trasladar símbolos de otro lenguaje.

Tema: **Componentes de un algoritmo**.

## Problema y contrato

Compararemos expresiones con y sin paréntesis, división entera y decimal, residuo y potencia. La elección del operador forma parte del algoritmo.

## Conceptos necesarios

En Java `+`, `-`, `*`, `/` y `%` expresan operaciones aritméticas. Si los dos operandos de / son enteros, el resultado descarta la fracción hacia cero. Con al menos un operando decimal, la operación produce una aproximación decimal.

Java no usa una barra invertida como división entera ni `**` como potencia. `^` es XOR de enteros o booleanos, no exponenciación. Para el cuadrado de un valor puedes multiplicarlo por sí mismo; Math.pow devuelve double y sirve para potencias en cálculos aproximados.

Multiplicación, división y residuo se agrupan antes que suma y resta. Los operadores de igual nivel usualmente se evalúan según su asociatividad, pero no conviene deducir una regla para todos sin revisar el lenguaje. Los paréntesis hacen visible la agrupación requerida.

El pseudocódigo usa DIV, MOD y potencia expresada como operación matemática; la traducción debe conservar significado, no símbolos idénticos. Si el divisor puede ser cero, define y valida el contrato antes de calcular.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
a ← 2 + 3 × 4
b ← (2 + 3) × 4
entero ← 7 DIV 2
decimal ← 7 / 2.0
cuadrado ← 5 × 5
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Sin paréntesis: " + (2 + 3 * 4));
        System.out.println("Con paréntesis: " + ((2 + 3) * 4));
        System.out.println("Entera: " + 7 / 2);
        System.out.println("Decimal: " + 7 / 2.0);
        System.out.println("Residuo: " + 7 % 2);
        System.out.println("Cuadrado: " + 5 * 5);
        System.out.println("XOR, no potencia: " + (5 ^ 2));
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad1/05-operadores-aritmeticos
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Sin paréntesis: 14
Con paréntesis: 20
Entera: 3
Decimal: 3.5
Residuo: 1
Cuadrado: 25
XOR, no potencia: 7
```

## Prueba de escritorio y recorrido

3 × 4 se calcula primero en la expresión inicial. 7/2 pierde la fracción porque ambos operandos son enteros. XOR opera sobre bits: 0101 XOR 0010 produce 0111, es decir 7.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

`(double)(7/2)` produce 3.0, no 3.5. `5 ^ 2` compila, pero no calcula el cuadrado; es un error lógico. Dividir por cero entero lanza una excepción.

## Práctica

Calcula (9 + 5)/2 como entero y decimal. Calcula 9/4 de ambas formas. Escribe una expresión que obtenga el área de un cuadrado de lado 6.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

La primera división produce 7 o 7.0. 9/4 produce 2 o 2.25. El área es lado × lado = 36. Usa la conversión antes de dividir si necesitas la fracción.

</details>

## Explica con tus palabras

¿Por qué un operador que compila puede estar equivocado? ¿Cómo expresas potencia en Java?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad1/04-representacion-de-datos/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad1/06-relaciones-y-logica/README.md)
