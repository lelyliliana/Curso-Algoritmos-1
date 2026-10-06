# U3_06 · Formato binario explícito y versionado

[Anterior](../../unidad3/05-importar-y-filtrar/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/07-contador-de-frecuencias/README.md)

## Objetivo

Leer valores en el mismo orden y tipo con que se escribieron.

Tema: **Manejo de archivos de datos y operaciones**.

## Problema y contrato

Guardaremos una versión de formato, un código y existencias. El archivo es binario y se procesa secuencialmente, lo que muestra que formato y acceso son decisiones distintas.

## Conceptos necesarios

DataOutputStream escribe tipos definidos y DataInputStream lee sus equivalentes. El contrato es int para versión, writeUTF para código e int para existencias. Un lector debe conocer ese orden; cambiarlo interpreta bytes con significado incorrecto.

WriteUTF usa UTF modificado de Java y tiene límites de longitud. No equivale a un archivo de texto UTF-8. Una marca de versión permite rechazar formatos desconocidos o implementar una migración deliberada.

Los streams se cierran con try-with-resources. Cerrar un decorador cierra también el flujo envuelto. Se termina la escritura antes de leer. El ejemplo sobrescribe únicamente su archivo de muestra.

No estamos serializando automáticamente un objeto ni implementando cifrado. Un formato explícito facilita comprobar datos, pero necesita seguir validando rangos y estructura. Un binario corrupto puede producir IOException o valores que deben rechazarse.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Abrir salida
Escribir version, codigo, existencias
Cerrar salida
Abrir entrada
Leer y validar version
Leer codigo y existencias en el mismo orden
Cerrar entrada
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class Main {
    public static void main(String[] args) throws IOException {
        Path archivo = Path.of("salida", "articulo.bin");
        Files.createDirectories(archivo.getParent());
        try (DataOutputStream out = new DataOutputStream(Files.newOutputStream(archivo))) {
            out.writeInt(1); out.writeUTF("K01"); out.writeInt(3);
        }
        try (DataInputStream in = new DataInputStream(Files.newInputStream(archivo))) {
            if (in.readInt() != 1) throw new IOException("Versión no admitida");
            String codigo = in.readUTF();
            int unidades = in.readInt();
            if (codigo.isBlank() || unidades < 0) throw new IOException("Datos inválidos");
            System.out.println(codigo + ": " + unidades);
        }
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad3/06-formato-binario
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
K01: 3
```

## Prueba de escritorio y recorrido

La salida guarda tres valores en orden. El primer bloque cierra. La entrada verifica1 como versión y recupera K01 y3. La validación precede al mensaje.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

ReadInt no recupera una cadena escrita con writeUTF. Abrir el binario como texto no respeta el contrato. Creer que binario significa acceso aleatorio confunde dos propiedades.

## Práctica

Agrega precio con writeLong y readLong. Define versión2 y explica cómo detectas un archivo truncado o de versión1.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

El lector2 verifica la marca y lee precio después de unidades. Un archivo1 se rechaza por versión. Un archivo2 truncado puede generar EOFException, subclase de IOException; no debes presentar una lectura incompleta como exitosa.

</details>

## Explica con tus palabras

¿Por qué importa la versión? ¿Qué garantiza cerrar antes de leer?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad3/05-importar-y-filtrar/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/07-contador-de-frecuencias/README.md)
