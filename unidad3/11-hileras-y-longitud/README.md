# U3_11 · Hileras, asignación, longitud y subhileras

[Anterior](../../unidad3/10-evaluacion-experimental/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/12-editar-y-concatenar/README.md)

## Objetivo

Trabajar con cadenas inmutables y distinguir unidades UTF-16 de puntos de código.

Tema: **Manejo de hileras de caracteres**.

## Problema y contrato

Extraeremos una parte de un nombre y compararemos la longitud de un texto con emoji. Las operaciones de índice requieren conocer qué unidad está contando Java.

## Conceptos necesarios

Una hilera o cadena representa una secuencia textual. String es inmutable: sus operaciones devuelven valores nuevos, no cambian el objeto original. Asignar una referencia no duplica necesariamente el texto ni convierte una cadena en editable.

Length cuenta unidades de código UTF-16. Un carácter suplementario, como 😀, utiliza dos unidades. CodePointCount cuenta puntos de código, pero tampoco equivale siempre a símbolos percibidos: combinaciones de letras, acentos o emoji pueden contener varios puntos de código.

Substring(inicio,fin) incluye inicio y excluye fin; los índices son unidades UTF-16. Un corte dentro de un par sustituto puede separar un carácter. Para trabajar por puntos de código usa offsetByCodePoints para obtener los límites correspondientes. El ejemplo de extracción usa texto básico donde cada letra ocupa una unidad.

La igualdad de contenido usa equals. == compara identidad de referencias. Que algunas cadenas literales compartan una instancia no valida usar == para todo texto.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
nombre ← "Algoritmos"
parte ← subcadena(nombre,0,4), fin exclusivo
texto ← "A😀"
Mostrar longitudUTF16 y cantidad de puntos de código
Comparar contenido
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        String nombre = "Algoritmos";
        String parte = nombre.substring(0, 4);
        System.out.println("Parte: " + parte);
        System.out.println("Original: " + nombre);
        String texto = "A😀";
        System.out.println("Unidades UTF-16: " + texto.length());
        System.out.println("Puntos de código: " + texto.codePointCount(0, texto.length()));
        System.out.println("Igual contenido: " + nombre.equals(new String("Algoritmos")));
        System.out.println("Concatenación: " + parte.concat(" paso a paso"));
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad3/11-hileras-y-longitud
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Parte: Algo
Original: Algoritmos
Unidades UTF-16: 3
Puntos de código: 2
Igual contenido: true
Concatenación: Algo paso a paso
```

## Prueba de escritorio y recorrido

Substring toma posiciones0,1,2,3 y devuelve Algo. El original permanece. A ocupa una unidad y el emoji dos, de modo que length da3 y codePointCount da2.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Pensar que fin es inclusivo cambia la extracción. Confundir longitudUTF16 con símbolos visibles falla con Unicode. Comparar mediante == no verifica contenido.

## Práctica

Extrae el emoji completo con offsetByCodePoints desde el punto1 hasta2. Compara una é precompuesta con e seguida de acento combinante.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Los límites son offsetByCodePoints(0,1) y offsetByCodePoints(0,2). La primera é tiene1 punto de código y la forma combinada2, aunque puedan verse iguales. Normalización Unicode puede atender equivalencia según el contrato.

</details>

## Explica con tus palabras

¿Qué cuenta length? ¿Por qué incluso los puntos de código no siempre son símbolos percibidos?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad3/10-evaluacion-experimental/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/12-editar-y-concatenar/README.md)
