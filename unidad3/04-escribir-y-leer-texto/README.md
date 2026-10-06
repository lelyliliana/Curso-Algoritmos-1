# U3_04 · Escritura, lectura y cierre de archivos

[Anterior](../../unidad3/03-archivos-y-formatos/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/05-importar-y-filtrar/README.md)

## Objetivo

Completar operaciones de archivo con UTF-8 y cierre de recursos.

Tema: **Manejo de archivos de datos y operaciones**.

## Problema y contrato

Escribiremos dos nombres y recorreremos el archivo línea a línea. Repetir la demostración reemplaza el archivo, de modo que no acumula duplicados.

## Conceptos necesarios

Files.write con una lista de líneas crea el archivo y, sin opciones adicionales, sobrescribe el existente. Si necesitas anexar, define CREATE y APPEND de StandardOpenOption. Las dos políticas producen resultados diferentes al ejecutar varias veces.

BufferedReader permite recorrer líneas sin cargar todo el archivo. ReadLine devuelve null al terminar; una línea vacía es una cadena vacía y no equivale a fin de archivo. Try-with-resources cierra el lector también ante una excepción.

IOException indica fallos de lectura o escritura. El ejemplo la declara en main para dejar visible un fallo de la demostración. Una aplicación interactiva debe comunicarlo en el punto donde pueda decidir reintentar o terminar; no debe afirmar éxito antes de completar.

Usar una ruta relativa y UTF-8 permite reproducir el comportamiento en distintos sistemas. Los saltos de línea pueden variar entre sistemas sin cambiar los registros leídos.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Crear carpeta padre
Escribir dos líneas en UTF-8 (reemplazo)
Abrir lector
Mientras leerLinea no sea fin
  Mostrar línea y contar
FinMientras
Cerrar lector
Mostrar cantidad
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException {
        Path archivo = Path.of("salida", "nombres.txt");
        Files.createDirectories(archivo.getParent());
        Files.write(archivo, List.of("Ana", "José"), StandardCharsets.UTF_8);
        int cantidad = 0;
        try (BufferedReader lector = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                cantidad++;
                System.out.println(linea);
            }
        }
        System.out.println("Líneas: " + cantidad);
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad3/04-escribir-y-leer-texto
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Ana
José
Líneas: 2
```

## Prueba de escritorio y recorrido

La escritura finaliza antes de abrir el lector. Cada readLine obtiene una línea sin su salto. La tercera devuelve null y termina el ciclo; el lector se cierra al salir del bloque.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Buscar cadena vacía como fin omite líneas válidas vacías. Olvidar crear la carpeta impide guardar. Anexar por accidente repite nombres en cada ejecución.

## Práctica

Agrega una línea vacía entre los nombres y predice el contador. Ejecuta dos veces y revisa que el contenido no se duplique. Después prueba APPEND en una copia.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Con línea vacía el contador es3. Sobrescribir conserva3 líneas en cada ejecución. Anexar suma las nuevas líneas a las anteriores: requiere una regla de duplicados si la aplicación no debe repetir.

</details>

## Explica con tus palabras

¿Qué diferencia hay entre línea vacía y fin? ¿Quién cierra el recurso?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad3/03-archivos-y-formatos/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/05-importar-y-filtrar/README.md)
