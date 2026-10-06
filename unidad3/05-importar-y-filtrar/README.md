# U3_05 · Importar, validar y filtrar registros de texto

[Anterior](../../unidad3/04-escribir-y-leer-texto/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/06-formato-binario/README.md)

## Objetivo

Convertir filas en datos tipados con un diagnóstico localizado.

Tema: **Manejo de archivos de datos y operaciones**.

## Problema y contrato

Un archivo incluye código y unidades. Algunas filas contienen datos inválidos. La política de esta práctica es informar y omitir filas erróneas; el proyecto final exigirá rechazar la carga completa.

## Conceptos necesarios

Un formato requiere encabezado, campos, separador, codificación y límites. Usamos codigo;unidades sin comillas, escapes ni punto y coma dentro del código. Es texto delimitado sencillo, no CSV general. Un parser CSV completo debe atender comillas y separadores dentro de campos.

Split con -1 conserva campos finales vacíos. Primero valida número de campos, después conversión y finalmente rango. La unicidad por código es otra regla: si el dominio la necesita, debes comprobarla sobre el conjunto y no inferirla del formato.

El número de línea permite localizar el problema. No conviertas una celda vacía a cero silenciosamente: ausencia y cantidad0 son estados distintos. Tras validar puedes filtrar solo registros con existencias positivas.

Este ejemplo utiliza un archivo fijo con encabezado esperado y conserva una fila válida. Para un archivo externo, comprueba el encabezado y permite que no exista ningún registro válido sin acceder a una posición inexistente.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Escribir muestra
Para cada fila de datos
  separar y validar campos
  convertir unidades
  Si válida y unidades > 0: mostrar
  Si inválida: informar número de línea
FinPara
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException {
        Path archivo = Path.of("salida", "articulos.txt");
        Files.createDirectories(archivo.getParent());
        Files.write(archivo, List.of("codigo;unidades", "K01;3", "K02;0", "K03;dos", "K04;-1"), StandardCharsets.UTF_8);
        List<String> lineas = Files.readAllLines(archivo, StandardCharsets.UTF_8);
        if (lineas.isEmpty() || !lineas.get(0).equals("codigo;unidades")) throw new IllegalArgumentException("Encabezado inválido");
        for (int i = 1; i < lineas.size(); i++) {
            try {
                String[] campos = lineas.get(i).split(";", -1);
                if (campos.length != 2 || campos[0].isBlank()) throw new IllegalArgumentException("Campos inválidos");
                int unidades = Integer.parseInt(campos[1]);
                if (unidades < 0) throw new IllegalArgumentException("Unidades negativas");
                if (unidades > 0) System.out.println(campos[0] + ": " + unidades);
            } catch (IllegalArgumentException e) {
                System.out.println("Línea " + (i + 1) + ": inválida");
            }
        }
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad3/05-importar-y-filtrar
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
Línea 4: inválida
Línea 5: inválida
```

## Prueba de escritorio y recorrido

K01 pasa formato y rango y tiene existencias. K02 es válido pero no cumple el filtro. Las líneas4 y5 fallan por formato numérico y rango, respectivamente.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Confundir filtrado con rechazo clasifica incorrectamente K02. Omitir -1 en split puede ocultar un campo final vacío. Cargar parcialmente sin documentarlo contradice sistemas que exigen consistencia del archivo completo.

## Práctica

Agrega código vacío, unidades vacías y una fila extra con tres campos. Define una política de códigos repetidos y una comprobación que la aplique.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Las tres nuevas filas son inválidas. Un Set de códigos o una búsqueda de registros anteriores puede detectar duplicados. Decide si rechazas la fila o todo el archivo y comunica esa política.

</details>

## Explica con tus palabras

¿Qué registro es válido aunque no se muestre? ¿Por qué formato y reglas de conjunto son validaciones diferentes?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad3/04-escribir-y-leer-texto/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/06-formato-binario/README.md)
