# U3_13 · Posición, búsqueda y reemplazo textual

[Anterior](../../unidad3/12-editar-y-concatenar/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/14-proyecto-integrador/README.md)

## Objetivo

Encontrar subcadenas sin interpretar ausencia como una posición válida.

Tema: **Manejo de hileras de caracteres**.

## Problema y contrato

Buscaremos varias ocurrencias de sol en una frase. La aplicación declarará si admite coincidencias solapadas y si busca palabras completas o subcadenas.

## Conceptos necesarios

IndexOf devuelve el índice de la primera coincidencia desde una posición y -1 si no encuentra. Esa señal no puede pasarse directamente a substring. Una coincidencia de subcadena no implica palabra completa: sol también aparece dentro de girasol.

La búsqueda distingue mayúsculas. Si el contrato es insensible a ellas, puedes normalizar con Locale.ROOT para una regla técnica, pero el cambio puede afectar posiciones en ciertos textos Unicode. Para mostrar nombres y textos originales no reemplaces destructivamente su forma.

En esta práctica avanzamos por la longitud del patrón y contamos ocurrencias no solapadas. Para permitir solapamiento en texto básico, avanza uno después de cada coincidencia. Un patrón vacío requiere una política específica; este método lo rechaza para evitar un ciclo ambiguo.

String.replace trabaja sobre coincidencias literales y devuelve una String nueva; replaceAll interpreta una expresión regular. Escoge según el contrato y no trates un patrón regular como texto sin escape.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
posicion ← buscar(texto,patron,0)
Mientras posicion != -1
  contar y mostrar
  posicion ← buscar(texto,patron,posicion+longitud(patron))
FinMientras
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    static int contar(String texto, String patron) {
        if (patron.isEmpty()) throw new IllegalArgumentException("Patrón vacío");
        int cantidad = 0, desde = 0, posicion;
        while ((posicion = texto.indexOf(patron, desde)) != -1) {
            cantidad++;
            desde = posicion + patron.length();
        }
        return cantidad;
    }
    public static void main(String[] args) {
        String texto = "sol y sol";
        System.out.println("Primera posición: " + texto.indexOf("sol"));
        System.out.println("Cantidad: " + contar(texto, "sol"));
        System.out.println("Ausente: " + texto.indexOf("luna"));
        System.out.println("Reemplazo: " + texto.replace("sol", "luz"));
        System.out.println("Original: " + texto);
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad3/13-posicion-y-busqueda-de-texto
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Primera posición: 0
Cantidad: 2
Ausente: -1
Reemplazo: luz y luz
Original: sol y sol
```

## Prueba de escritorio y recorrido

Las coincidencias comienzan en0 y6. Tras cada una, desde avanza3 unidades. Una búsqueda posterior devuelve-1. Replace produce otra cadena y el texto original permanece.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

No avanzar desde repite la misma coincidencia. Usar -1 como índice excede límites. Creer que indexOf reconoce palabras completas cuenta subcadenas no deseadas.

## Práctica

Busca ana en banana con política sin solapamiento y con solapamiento. Prueba texto vacío, patrón ausente y patrón vacío.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Banana contiene ana en1 y3; sin solapamiento cuenta1, avanzando uno cuenta2. Texto vacío y patrón ausente dan0 con patrón no vacío. Patrón vacío se rechaza por contrato.

</details>

## Explica con tus palabras

¿Qué significa -1? ¿Qué regla de coincidencia conserva el algoritmo?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad3/12-editar-y-concatenar/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/14-proyecto-integrador/README.md)
