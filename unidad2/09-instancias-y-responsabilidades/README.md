# U2_09 · Instancias independientes y operaciones

[Anterior](../../unidad2/08-clases-y-constructores/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/10-vectores/README.md)

## Objetivo

Distinguir estado de instancia de estado de clase y diseñar una operación coherente.

Tema: **Introducción a la programación orientada a objetos**.

## Problema y contrato

Dos contadores registran asistencia en salas diferentes. Incrementar uno no debe afectar al otro. La clase define el comportamiento común y cada objeto conserva su cantidad.

## Conceptos necesarios

Los atributos de instancia pertenecen a cada objeto; los static pertenecen a la clase. Si cantidad fuera static, las dos salas compartirían el mismo contador, contradiciendo el requisito.

Dos variables pueden apuntar al mismo objeto. Asignar `otra = salaA` no copia su estado: crea otra referencia a la misma instancia. Las modificaciones se observan desde ambas referencias. Construir un objeto con new crea una instancia distinta.

Una consulta puede devolver el número sin permitir asignarlo directamente. Una operación como registrar debe expresar qué cambia y limitar rangos. Math.incrementExact detecta el desbordamiento de int si se alcanzara su límite; el ejemplo no necesita aceptar cantidades silenciosamente envueltas.

No necesitas herencia para demostrar objetos. Primero aprende a repartir responsabilidades y conservar estados independientes; las jerarquías se justifican por relaciones reales, no por agregar complejidad.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Crear contador A
Crear contador B
Registrar dos veces en A
Registrar una vez en B
alias ← A
Registrar usando alias
Mostrar A y B
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        Contador salaA = new Contador();
        Contador salaB = new Contador();
        salaA.registrar();
        salaA.registrar();
        salaB.registrar();
        Contador alias = salaA;
        alias.registrar();
        System.out.println("Sala A: " + salaA.cantidad());
        System.out.println("Sala B: " + salaB.cantidad());
    }
}
class Contador {
    private int cantidad;
    void registrar() { cantidad = Math.incrementExact(cantidad); }
    int cantidad() { return cantidad; }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/09-instancias-y-responsabilidades
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Sala A: 3
Sala B: 1
```

## Prueba de escritorio y recorrido

Sala A recibe dos operaciones, B una. Alias señala A y su operación modifica la misma instancia. Hay dos objetos, aunque existen tres variables de referencia.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Contar variables como si fueran objetos produce una interpretación equivocada. Declarar cantidad static mezcla salas. Una asignación de referencias no clona un objeto.

## Práctica

Construye una tercera instancia en lugar de asignar un alias. Registra una vez en ella y predice las tres cantidades. Explica cómo comprobarías independencia.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

A queda en 2, B en 1 y la tercera en 1. Una prueba registra solo en un objeto y comprueba que las consultas de los otros no cambian.

</details>

## Explica con tus palabras

¿Cuántos objetos crea este main? ¿Cuándo dos nombres señalan el mismo estado?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/08-clases-y-constructores/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/10-vectores/README.md)
