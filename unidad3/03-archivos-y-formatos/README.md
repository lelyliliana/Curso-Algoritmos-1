# U3_03 · Archivos, formatos y codificación

[Anterior](../../unidad3/02-arreglos-de-registros/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/04-escribir-y-leer-texto/README.md)

## Objetivo

Distinguir persistencia, formato y codificación sin atribuir propiedades falsas.

Tema: **Definición de registros y operaciones**.

## Problema y contrato

Guardaremos una palabra con tilde y verificaremos cuántos bytes ocupa en UTF-8. El número de bytes no tiene por qué coincidir con String.length().

## Conceptos necesarios

Un archivo es una secuencia de bytes conservada por el sistema de archivos. Un formato establece cómo interpretarlos. Un archivo de texto usa una codificación de caracteres, como UTF-8; un binario puede representar números, imágenes o un formato específico. Binario no significa cifrado ni ilegible para toda herramienta humana.

La extensión orienta, pero no garantiza el formato real. Renombrar .txt a .bin no transforma los datos. El acceso secuencial o aleatorio es una forma de procesar posiciones y no depende exclusivamente de texto frente a binario.

Los archivos pueden contener datos maestros, movimientos, resultados o respaldo según su función. Esas categorías describen usos, no tipos primitivos. Guardar un dato en memoria no lo hace persistente; necesitas completar la escritura.

Path define una ruta. Las relativas se resuelven desde la carpeta de trabajo, no automáticamente desde donde está el fuente. Usamos salida/ en cada ejemplo para localizar claramente lo generado.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
texto ← "José"
codificar texto en UTF-8
crear carpeta salida
guardar bytes
Mostrar longitud textual y cantidad de bytes
leer y decodificar con UTF-8
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
public class Main {
    public static void main(String[] args) throws IOException {
        String texto = "José";
        byte[] bytes = texto.getBytes(StandardCharsets.UTF_8);
        Path archivo = Path.of("salida", "nombre.txt");
        Files.createDirectories(archivo.getParent());
        Files.write(archivo, bytes);
        System.out.println("Unidades UTF-16: " + texto.length());
        System.out.println("Bytes UTF-8: " + bytes.length);
        System.out.println("Recuperado: " + Files.readString(archivo, StandardCharsets.UTF_8));
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad3/03-archivos-y-formatos
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Unidades UTF-16: 4
Bytes UTF-8: 5
Recuperado: José
```

## Prueba de escritorio y recorrido

J,o,s ocupan un byte cada uno en UTF-8 y é ocupa dos. El texto tiene4 unidades UTF-16 y5 bytes UTF-8. La misma codificación permite recuperarlo correctamente.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Confundir bytes con caracteres produce cortes inválidos. Leer con otra codificación puede dañar la interpretación. La extensión no prueba contenido ni cifrado.

## Práctica

Prueba Ana y un emoji. Compara unidades UTF-16, puntos de código y bytes UTF-8; no generalices una relación fija entre esas medidas.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Ana tiene3 unidades y3 bytes. El emoji 😀 usa2 unidades UTF-16,1 punto de código y4 bytes UTF-8. La cuenta de símbolos percibidos exige otra consideración para combinaciones.

</details>

## Explica con tus palabras

¿Qué papel cumple la codificación? ¿Una extensión cambia los bytes?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad3/02-arreglos-de-registros/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/04-escribir-y-leer-texto/README.md)
