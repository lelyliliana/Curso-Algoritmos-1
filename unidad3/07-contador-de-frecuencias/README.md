# U3_07 · Contador de frecuencias y modelo de costo

[Anterior](../../unidad3/06-formato-binario/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/08-orden-de-crecimiento/README.md)

## Objetivo

Contar una operación definida y distinguir ese conteo del tiempo real.

Tema: **Análisis de algoritmos**.

## Problema y contrato

Compararemos dos recorridos sobre n=4: uno visita cada elemento y otro compara todos los pares i<j. Contaremos ejecuciones del cuerpo, no milisegundos.

## Conceptos necesarios

Un contador de frecuencias registra cuántas veces se ejecuta una operación elegida. Primero define qué cuentas: comparaciones, asignaciones, visitas o todas las operaciones bajo un modelo. Sin esa definición, dos cifras no son comparables.

El primer cuerpo se ejecuta n veces. En el segundo, las vueltas internas son n-1,n-2,...,1,0: suman n(n-1)/2. Que haya dos ciclos no basta para afirmar n² visitas exactas: sus límites importan.

Un modelo puede tratar operaciones sobre enteros de ancho fijo como costo constante. No presupongas lo mismo para comparar cadenas de longitud variable o multiplicar enteros de precisión arbitraria. Declara también qué dimensión representa n.

El conteo permite estudiar crecimiento sin depender del equipo. Un tiempo medido incluye compilación, JVM, cachés, sistema operativo y otros factores. Ambos enfoques aportan información distinta.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
visitas ← 0
Para i desde 0 hasta n-1: visitas ← visitas+1
pares ← 0
Para i desde 0 hasta n-1
  Para j desde i+1 hasta n-1: pares ← pares+1
FinPara
Mostrar conteos
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        int n = 4;
        long visitas = 0, pares = 0;
        for (int i = 0; i < n; i++) visitas++;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) pares++;
        }
        System.out.println("Visitas: " + visitas);
        System.out.println("Pares: " + pares);
        System.out.println("Fórmula pares: " + (long) n * (n - 1) / 2);
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad3/07-contador-de-frecuencias
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Visitas: 4
Pares: 6
Fórmula pares: 6
```

## Prueba de escritorio y recorrido

El primer ciclo hace4 visitas. El segundo hace3+2+1+0=6. La fórmula independiente coincide. Estamos contando incrementos del cuerpo, no condiciones de entrada o actualizaciones de índices.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Llamar tiempo a un número de visitas confunde medidas. Contar dos ciclos consecutivos como producto exagera el trabajo. Usar int para fórmulas grandes puede desbordar antes de guardar el resultado.

## Práctica

Prueba n=0,1,5,10. Escribe la fórmula para dos ciclos consecutivos de n y m visitas y para dos ciclos anidados independientes.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Los pares son0,0,10,45. Consecutivos: n+m. Anidados independientes: n×m. El contador debe usar un rango suficiente y el algoritmo de pares no es práctico para n enorme.

</details>

## Explica con tus palabras

¿Qué operación estás contando? ¿Qué supuesto permite tratarla como constante?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad3/06-formato-binario/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/08-orden-de-crecimiento/README.md)
