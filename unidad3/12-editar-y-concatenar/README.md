# U3_12 · Concatenar, insertar, borrar y reemplazar

[Anterior](../../unidad3/11-hileras-y-longitud/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/13-posicion-y-busqueda-de-texto/README.md)

## Objetivo

Escoger String o StringBuilder según si necesitas un valor nuevo o edición acumulada.

Tema: **Manejo de hileras de caracteres**.

## Problema y contrato

Construiremos y editaremos un título. El mismo objeto StringBuilder cambia en cada operación, mientras que una cadena String requeriría guardar cada resultado nuevo.

## Conceptos necesarios

StringBuilder representa una secuencia mutable y permite append, insert, delete y replace. Los rangos de borrado y reemplazo incluyen inicio y excluyen fin. Las posiciones siguen contando unidades UTF-16; aquí usamos caracteres básicos para observar índices con claridad.

Concat devuelve una nueva String. En un ciclo que arma un texto largo, acumular con + puede crear muchos resultados intermedios; un builder suele expresar mejor la construcción progresiva. Su espacio crece con la longitud de la salida, no es O(1) solo por haber una variable.

Insertar o borrar en medio puede desplazar caracteres posteriores. No presupongas costo constante para cualquier edición. StringBuilder no ofrece sincronización automática para uso compartido entre hilos; el curso trabaja en un solo hilo.

ToString obtiene una String con el contenido actual. Modificar después el builder no cambia esa cadena ya obtenida. Esa distinción permite conservar una versión textual de una construcción mutable.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
builder ← "Curso Java"
insertar "de " en posición6
borrar intervalo9..13
agregar "algoritmos"
reemplazar intervalo0..5 por "Taller"
Mostrar versión final
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        StringBuilder titulo = new StringBuilder("Curso Java");
        titulo.insert(6, "de ");
        System.out.println("Insertar: " + titulo);
        titulo.delete(9, 13);
        titulo.append("algoritmos");
        System.out.println("Borrar y agregar: " + titulo);
        titulo.replace(0, 5, "Taller");
        String copia = titulo.toString();
        titulo.append(" 1");
        System.out.println("Versión guardada: " + copia);
        System.out.println("Actual: " + titulo);
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad3/12-editar-y-concatenar
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Insertar: Curso de Java
Borrar y agregar: Curso de algoritmos
Versión guardada: Taller de algoritmos
Actual: Taller de algoritmos 1
```

## Prueba de escritorio y recorrido

Insertar agrega de antes de Java. Delete retira posiciones9..12. Append agrega algoritmos. Replace cambia Curso por Taller. La String obtenida conserva esa versión al agregar1 al builder.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Aplicar índices de una versión anterior tras insertar puede editar otra parte. Un fin inclusivo no es el contrato de delete. Guardar una referencia al mismo builder no conserva una versión independiente.

## Práctica

Construye un reporte de tres nombres con append y saltos de línea. Obtén una String, modifica el builder y comprueba que el reporte anterior permanece.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

La String producida es un resultado separado. Puedes usar append(nombre).append(System.lineSeparator()) por persona. El builder seguirá cambiando, pero el reporte previo no.

</details>

## Explica con tus palabras

¿Qué operaciones modifican el objeto? ¿Por qué los índices deben recalcularse tras una edición?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad3/11-hileras-y-longitud/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/13-posicion-y-busqueda-de-texto/README.md)
