# U1_06 · Comparaciones y lógica booleana

[Anterior](../../unidad1/05-operadores-aritmeticos/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad1/07-prueba-de-escritorio/README.md)

## Objetivo

Construir condiciones compuestas con tablas de verdad y cortocircuito.

Tema: **Componentes de un algoritmo**.

## Problema y contrato

Una persona puede entrar a un laboratorio si está inscrita y tiene autorización. Compararemos esa regla con OR y con negación para identificar diferencias.

## Conceptos necesarios

Los operadores relacionales `<`, `<=`, `>`, `>=`, `==` y `!=` comparan valores y devuelven booleanos. AND (`&&`) exige ambas condiciones; OR (`||`) exige al menos una; NOT (`!`) niega. XOR booleano (`^`) exige que los valores sean distintos, por lo que no equivale a OR.

| A | B | A AND B | A OR B |
|---|---|---|---|
| false | false | false | false |
| false | true | false | true |
| true | false | false | true |
| true | true | true | true |

`&&` y `||` usan cortocircuito: pueden omitir el segundo operando cuando el primero determina el resultado. Esto permite comprobar que una referencia no sea null antes de llamar a sus métodos. `!` tiene prioridad sobre `&&`, y `&&` sobre `||`; usa paréntesis para comunicar reglas compuestas.

En Java `=` asigna y `==` compara valores primitivos. Para contenido de String utiliza equals, no identidad con ==. Las leyes de De Morgan permiten negar una regla: NO(A Y B) equivale a NO A O NO B.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
permitido ← inscrita Y autorizada
rechazado ← NO(inscrita Y autorizada)
Comparar con NO inscrita O NO autorizada
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        boolean inscrita = true;
        boolean autorizada = false;
        System.out.println("Permitido: " + (inscrita && autorizada));
        System.out.println("OR: " + (inscrita || autorizada));
        System.out.println("Rechazado: " + !(inscrita && autorizada));
        System.out.println("De Morgan: " + (!inscrita || !autorizada));
        String nombre = null;
        System.out.println("Nombre válido: " + (nombre != null && !nombre.isBlank()));
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad1/06-relaciones-y-logica
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Permitido: false
OR: true
Rechazado: true
De Morgan: true
Nombre válido: false
```

## Prueba de escritorio y recorrido

AND falla por falta de autorización. OR es verdadero porque la inscripción existe, pero no representa el permiso requerido. La validación del nombre termina en la comparación con null y no ejecuta isBlank.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Invertir el orden de la comprobación de null puede provocar NullPointerException. AND y OR no son intercambiables. Usar & en lugar de && evalúa ambos lados y pierde ese cortocircuito.

## Práctica

Prueba las cuatro combinaciones de inscripción y autorización. Añade una suspensión que prohíba entrada incluso si ambas condiciones son verdaderas.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Solo true/true permite entrada. La condición nueva es `inscrita && autorizada && !suspendida`. Verifica suspensión true con los dos permisos concedidos.

</details>

## Explica con tus palabras

¿Qué evita el cortocircuito? ¿Qué caso distingue XOR de OR?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad1/05-operadores-aritmeticos/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad1/07-prueba-de-escritorio/README.md)
