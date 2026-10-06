# U2_10 · Vectores: creación, índices y recorrido

[Anterior](../../unidad2/09-instancias-y-responsabilidades/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/11-suma-y-promedio/README.md)

## Objetivo

Almacenar datos homogéneos de tamaño fijo y acceder sin exceder límites.

Tema: **Arreglos**.

## Problema y contrato

Tres aulas reportan 12, 8 y 10 asistentes. Un arreglo guarda esos valores y permite recorrerlos usando su posición.

## Conceptos necesarios

Un vector de este curso es un arreglo unidimensional, no necesariamente la clase java.util.Vector. Tiene elementos del mismo tipo y longitud fija. Sus índices comienzan en cero; para longitud n van de 0 a n-1.

Length es una propiedad del arreglo, no un método. Un ciclo con índice permite mostrar posición y dato. For-each recorre valores cuando la posición no importa. Los arreglos de primitivas se inicializan con valores predeterminados al usar new, pero esos ceros no significan que ya hayas recibido mediciones.

Copiar una referencia no copia los elementos. Clone crea otro arreglo, aunque para objetos solo copia referencias. Para insertar o borrar lógicamente en un arreglo de capacidad fija necesitas una cantidad de elementos utilizados y desplazamientos; no puedes cambiar su longitud con add.

El arreglo siguiente está completamente ocupado. Más adelante trabajaremos un catálogo con cantidad lógica distinta de la capacidad.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
datos ← [12,8,10]
Para i desde 0 hasta longitud(datos)-1
  Mostrar i, datos[i]
FinPara
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        int[] asistentes = {12, 8, 10};
        for (int i = 0; i < asistentes.length; i++) {
            System.out.println("Aula " + (i + 1) + ": " + asistentes[i]);
        }
        System.out.println("Cantidad de datos: " + asistentes.length);
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/10-vectores
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Aula 1: 12
Aula 2: 8
Aula 3: 10
Cantidad de datos: 3
```

## Prueba de escritorio y recorrido

i visita 0, 1 y 2. Cada posición muestra su dato. El número para el usuario suma uno al índice técnico. Cuando i vale 3 no entra al cuerpo.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Usar <=length accede fuera de límite. `datos.length()` no existe. Confundir tamaño con último índice lleva a errores aun cuando solo haya un elemento.

## Práctica

Agrega una cuarta aula y predice las salidas. Prueba un arreglo vacío y explica qué hace el ciclo. Cambia un valor sin cambiar la longitud.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Con cuatro elementos hay cuatro líneas. Un arreglo vacío tiene longitud 0 y el ciclo no entra. Cambiar `asistentes[1]` reemplaza un dato, no crea otra posición.

</details>

## Explica con tus palabras

¿Qué distingue índice de cantidad? ¿Qué necesita una inserción en capacidad fija?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/09-instancias-y-responsabilidades/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/11-suma-y-promedio/README.md)
