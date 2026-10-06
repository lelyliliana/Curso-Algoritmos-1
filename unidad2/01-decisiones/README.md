# U2_01 · Decisiones simples, compuestas y anidadas

[Anterior](../../unidad1/08-asignacion-y-entrada/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/02-selector-multiple/README.md)

## Objetivo

Construir ramas excluyentes y separar validación de decisión.

Tema: **Estructuras condicionales e iterativas**.

## Problema y contrato

Una actividad acepta edades de 12 a 17 años. Quien cumple la edad y tiene autorización puede participar. Un dato negativo debe diagnosticarse como inválido, no solo como una edad fuera del grupo.

## Conceptos necesarios

If selecciona una rama según una condición. Else atiende el caso contrario y else-if permite encadenar alternativas excluyentes. Varios if independientes pueden ejecutarse en una misma entrada, de modo que no equivalen a una cadena excluyente.

Una decisión anidada permite evaluar una regla dentro de otra. No necesitas preguntar por autorización cuando la edad ya impide participar. Aun así, demasiada anidación dificulta seguir el flujo: separa validaciones y usa nombres para condiciones cuando ayuden.

El contrato acepta ambos extremos, 12 y 17. Las pruebas deben cubrir edades 11, 12, 17 y 18, además de un dato inválido. La autorización no cambia el rango de edad. Llaves explícitas ayudan a reconocer a qué if pertenece un else.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Si edad < 0: Mostrar "Edad inválida"
SiNo Si edad < 12 O edad > 17: Mostrar "Fuera del grupo"
SiNo Si autorizada: Mostrar "Puede participar"
SiNo: Mostrar "Falta autorización"
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        int edad = 12;
        boolean autorizada = false;
        if (edad < 0) {
            System.out.println("Edad inválida");
        } else if (edad < 12 || edad > 17) {
            System.out.println("Fuera del grupo");
        } else if (autorizada) {
            System.out.println("Puede participar");
        } else {
            System.out.println("Falta autorización");
        }
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/01-decisiones
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Falta autorización
```

## Prueba de escritorio y recorrido

La edad no es negativa y está en el rango permitido. La autorización es falsa, de modo que se toma la última rama. Ninguna otra rama se ejecuta.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Un ; después de if puede dejar su cuerpo vacío. Usar && para «menor que 12 o mayor que 17» nunca detecta una edad fuera de ambos extremos. La autorización no debe anular una edad inválida.

## Práctica

Construye una tabla de edad y autorización con seis casos. Prueba la frontera superior. Explica por qué un else final no significa necesariamente error.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Con 17 y autorización true participa; con 18 no pertenece al grupo. El else final representa falta de autorización, una situación prevista. -1 debe generar el primer diagnóstico.

</details>

## Explica con tus palabras

¿Qué ramas son excluyentes? ¿Qué condición distingue 17 de 18?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad1/08-asignacion-y-entrada/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/02-selector-multiple/README.md)
