# U2_02 · Selector múltiple con switch

[Anterior](../../unidad2/01-decisiones/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/03-mientras-y-repetir/README.md)

## Objetivo

Elegir una respuesta según opciones discretas y atender opciones desconocidas.

Tema: **Estructuras condicionales e iterativas**.

## Problema y contrato

Un menú identifica tres servicios por número. Usaremos switch para devolver el nombre de cada uno. No se trata de evaluar intervalos numéricos.

## Conceptos necesarios

Switch selecciona según un valor discreto. En Java 21 puedes utilizar una expresión switch con flechas que produce un resultado. Cada caso queda delimitado y evita la caída accidental al caso siguiente de la sintaxis tradicional con dos puntos.

Default define qué ocurre con opciones no reconocidas. Omitir una salida válida para algunas opciones deja la regla incompleta. Si necesitas decidir sobre rangos, como edades, if suele expresar mejor el problema.

El selector no transforma por sí mismo una entrada de teclado en número ni valida todo el dominio. Primero defines y conviertes la entrada; después seleccionas. En la aplicación integradora el menú coordinará operaciones sin duplicar sus reglas.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Segun opcion
  1: servicio ← "Consulta"
  2: servicio ← "Préstamo"
  3: servicio ← "Devolución"
  Otro: servicio ← "Opción desconocida"
FinSegun
Mostrar servicio
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        int opcion = 2;
        String servicio = switch (opcion) {
            case 1 -> "Consulta";
            case 2 -> "Préstamo";
            case 3 -> "Devolución";
            default -> "Opción desconocida";
        };
        System.out.println(servicio);
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/02-selector-multiple
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Préstamo
```

## Prueba de escritorio y recorrido

Opción vale 2. Switch produce Préstamo y lo asigna a servicio. El programa imprime un único resultado y termina.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Copiar la sintaxis de otro lenguaje puede no compilar. Usar switch para condiciones arbitrarias sin identificar la versión del lenguaje complica una decisión sencilla. Una opción desconocida debe tener respuesta explícita.

## Práctica

Agrega opción 4 para renovar. Prueba 0, 1, 4 y 9. Explica cómo separarías el menú del método que procesa una renovación.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

4 produce Renovación; 0 y 9 producen el default. El menú debe llamar a una operación que valide sus propias reglas, no concentrar en cada case todo el almacenamiento y cálculo.

</details>

## Explica con tus palabras

¿Cuándo resulta más claro switch que if? ¿Qué protege default?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/01-decisiones/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/03-mientras-y-repetir/README.md)
