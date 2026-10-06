# U3_01 · Registros y datos relacionados

[Anterior](../../unidad2/20-producto-de-matrices/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/02-arreglos-de-registros/README.md)

## Objetivo

Agrupar campos de tipos distintos y reconocer el contrato de un record de Java.

Tema: **Definición de registros y operaciones**.

## Problema y contrato

Un artículo tiene código, nombre y existencias. Guardar esos campos juntos impide que su asociación dependa de posiciones en tres vectores separados.

## Conceptos necesarios

Un registro es una agrupación lógica de campos relacionados. No tiene un tamaño universal en bytes ni equivale necesariamente a una fila de una base de datos. En Java un record es una construcción del lenguaje que facilita representar datos con componentes fijos.

Record genera constructor, accesores, equals, hashCode y toString. Sus accesores usan el nombre del componente: codigo(), no getCodigo(). El constructor compacto permite validar y normalizar antes de asignar los componentes.

La igualdad generada compara todos los componentes. Dos artículos con el mismo código pero existencias diferentes no son iguales como valores completos; eso no decide la identidad del catálogo, que debe prohibir códigos repetidos explícitamente.

Un record es superficialmente inmutable: no permite reasignar componentes, pero un componente que referencia un objeto mutable puede cambiar internamente. Aquí String es inmutable e int es primitivo, por lo que los datos no exponen estado mutable.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Definir registro Articulo(codigo,nombre,existencias)
  validar texto no vacío y existencias >= 0
Crear articulo
Mostrar sus campos por nombre
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        Articulo articulo = new Articulo("K01", "Kit de sensores", 3);
        System.out.println(articulo.codigo() + " / " + articulo.nombre());
        System.out.println("Existencias: " + articulo.existencias());
        System.out.println("Valores iguales: " + articulo.equals(new Articulo("K01", "Kit de sensores", 3)));
    }
}
record Articulo(String codigo, String nombre, int existencias) {
    Articulo {
        if (codigo == null || codigo.isBlank() || nombre == null || nombre.isBlank() || existencias < 0) {
            throw new IllegalArgumentException("Artículo inválido");
        }
        codigo = codigo.strip();
        nombre = nombre.strip();
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad3/01-registros
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
K01 / Kit de sensores
Existencias: 3
Valores iguales: true
```

## Prueba de escritorio y recorrido

El constructor valida y conserva los campos. La comparación final crea otro record con los mismos componentes y equals devuelve true, aunque las instancias sean distintas.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Confundir igualdad de todos los campos con identidad por código puede permitir duplicados. Record no crea setters. Suponer inmutabilidad profunda no es correcto si agregas componentes mutables.

## Práctica

Crea otro record con K01 y existencias4. Compara igualdad y después compara solo códigos. Define qué debería significar duplicado en el catálogo.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Equals dafalse, pero los códigos son iguales. Un catálogo con código único debe rechazar el segundo como alta, o atenderlo con una operación explícita de actualización; no decidirlo por equals del record completo.

</details>

## Explica con tus palabras

¿Qué campos se comparan automáticamente? ¿Por qué un catálogo necesita una regla de identidad adicional?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/20-producto-de-matrices/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/02-arreglos-de-registros/README.md)
