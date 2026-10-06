# U3_02 · Arreglos de registros y operaciones de catálogo

[Anterior](../../unidad3/01-registros/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/03-archivos-y-formatos/README.md)

## Objetivo

Administrar capacidad, cantidad lógica y operaciones sin desalinear campos.

Tema: **Definición de registros y operaciones**.

## Problema y contrato

Un catálogo de capacidad3 contiene dos artículos. Buscaremos un código y eliminaremos otro desplazando registros completos. Los espacios no utilizados del arreglo contienen null.

## Conceptos necesarios

La capacidad es el tamaño del arreglo; cantidad es el número de elementos válidos. Solo posiciones0..cantidad-1 contienen artículos del catálogo. Una búsqueda debe recorrer esa zona, no toda la capacidad indiscriminadamente.

Agregar exige espacio y código no repetido. Eliminar una posición desplaza las posteriores hacia la izquierda y limpia la última ocupada. Actualizar reemplaza un record completo validado, porque sus componentes no se reasignan.

Buscar linealmente cuesta O(n) en el número de registros. Eliminar puede costar O(n) por desplazamientos. Usar arreglos en este curso permite observar esas operaciones; una colección dinámica puede gestionar capacidad en aplicaciones mayores.

La fila es la unidad de movimiento. Ordenar nombres y códigos por separado rompería su relación. El ejemplo opera sobre un bloque pequeño fijo; el proyecto final encapsulará cantidad y todas las reglas en una clase.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
catalogo de capacidad3; cantidad ← 2
Buscar codigo recorriendo 0..cantidad-1
Para eliminar posicion
  desplazar siguientes una posición a la izquierda
  cantidad ← cantidad-1
  limpiar ultima ocupada
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        Articulo[] catalogo = new Articulo[3];
        catalogo[0] = new Articulo("K01", "Sensores");
        catalogo[1] = new Articulo("K02", "Cables");
        int cantidad = 2;
        int encontrado = -1;
        for (int i = 0; i < cantidad; i++) {
            if (catalogo[i].codigo().equals("K02")) { encontrado = i; break; }
        }
        System.out.println("Posición K02: " + encontrado);
        int eliminar = 0;
        for (int i = eliminar; i < cantidad - 1; i++) catalogo[i] = catalogo[i + 1];
        catalogo[--cantidad] = null;
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Primero: " + catalogo[0].codigo());
        System.out.println("Capacidad: " + catalogo.length);
    }
}
record Articulo(String codigo, String nombre) {}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad3/02-arreglos-de-registros
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Posición K02: 1
Cantidad: 1
Primero: K02
Capacidad: 3
```

## Prueba de escritorio y recorrido

La búsqueda visita dos registros y encuentra índice1. Al eliminar0 se mueve K02 a0, cantidad baja a1 y la posición1 se limpia. Capacidad permanece3.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Recorrer null como si fuera registro produce una excepción. Decrementar cantidad sin desplazar deja un hueco en la zona válida. Eliminar una posición no encontrada (-1) requiere rechazo previo.

## Práctica

Extrae buscar y eliminar a métodos. Prueba eliminar primero, último y código inexistente. Añade validación de códigos y nombres en el constructor.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Buscar devuelve -1 para ausencia. Eliminar debe comprobar esa señal y conservar estado si no hay registro. Tras borrar el último no hay desplazamientos, pero sí limpieza y decremento. La validación debe impedir campos nulos o vacíos.

</details>

## Explica con tus palabras

¿Qué diferencia hay entre cantidad y capacidad? ¿Qué se conserva al mover un registro completo?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad3/01-registros/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/03-archivos-y-formatos/README.md)
