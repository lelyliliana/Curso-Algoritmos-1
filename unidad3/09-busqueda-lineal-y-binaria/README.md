# U3_09 · Búsqueda lineal y búsqueda binaria

[Anterior](../../unidad3/08-orden-de-crecimiento/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/10-evaluacion-experimental/README.md)

## Objetivo

Comparar estrategias respetando la precondición del orden.

Tema: **Análisis de algoritmos**.

## Problema y contrato

Buscaremos14 en un arreglo ordenado. Ambas búsquedas devolverán su posición y contaremos elementos inspeccionados, no cada operador relacional por separado.

## Conceptos necesarios

La búsqueda lineal visita de izquierda a derecha hasta encontrar o terminar. Funciona sin ordenar y cuesta O(n) en el peor caso. La binaria requiere orden ascendente: compara el centro y descarta una mitad. Su peor recorrido inspecciona O(log n) elementos.

Ordenar para una única búsqueda puede costar más que buscar linealmente. Si harás muchas consultas sobre datos que no cambian, el costo de preparar el orden puede amortizarse. Si ordenas el original, las posiciones ya no son las mismas de antes.

El centro se calcula izquierda + (derecha-izquierda)/2 para evitar una suma de índices innecesariamente grande. La actualización descarta también el centro inspeccionado. Con duplicados esta versión devuelve alguna coincidencia, no necesariamente la primera.

Las dos funciones usan -1 para ausencia. La búsqueda binaria no verifica el orden en cada llamada porque esa verificación sería O(n); su contrato exige recibirlo ya establecido.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
izquierda ← 0; derecha ← n-1
Mientras izquierda <= derecha
  medio ← izquierda + (derecha-izquierda) DIV 2
  Si dato[medio]=objetivo: Retornar medio
  Si dato[medio]<objetivo: izquierda ← medio+1
  SiNo: derecha ← medio-1
FinMientras
Retornar -1
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    static Resultado lineal(int[] datos, int objetivo) {
        int visitas = 0;
        for (int i = 0; i < datos.length; i++) {
            visitas++;
            if (datos[i] == objetivo) return new Resultado(i, visitas);
        }
        return new Resultado(-1, visitas);
    }
    static Resultado binaria(int[] datos, int objetivo) {
        int izquierda = 0, derecha = datos.length - 1, visitas = 0;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            visitas++;
            if (datos[medio] == objetivo) return new Resultado(medio, visitas);
            if (datos[medio] < objetivo) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return new Resultado(-1, visitas);
    }
    public static void main(String[] args) {
        int[] datos = {2, 4, 6, 8, 10, 12, 14};
        Resultado a = lineal(datos, 14), b = binaria(datos, 14);
        System.out.println("Lineal: posición " + a.posicion() + ", visitas " + a.visitas());
        System.out.println("Binaria: posición " + b.posicion() + ", visitas " + b.visitas());
    }
}
record Resultado(int posicion, int visitas) {}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad3/09-busqueda-lineal-y-binaria
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Lineal: posición 6, visitas 7
Binaria: posición 6, visitas 3
```

## Prueba de escritorio y recorrido

Lineal visita todos los elementos hasta14. Binaria inspecciona8,12 y14 en índices3,5,6. Cada actualización reduce el intervalo y permite terminar.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Usar binaria en datos desordenados puede devolver ausencia falsa. No mover un límite más allá de medio puede dejar el mismo intervalo. Comparar visitas con operadores exactos sin definirlo altera el modelo de costo.

## Práctica

Prueba el primero, el último, un valor intermedio, ausencia y vacío. Agrega duplicados y verifica que el índice devuelto corresponda a un dato igual, sin exigir que sea el primero.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Las coincidencias deben apuntar al objetivo; ausencia y vacío devuelven-1. Con duplicados solo se garantiza alguna coincidencia. Para la primera, conserva el candidato y continúa a la izquierda.

</details>

## Explica con tus palabras

¿Qué costo tiene preparar el orden? ¿Por qué la precondición no se revisa dentro de cada búsqueda?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad3/08-orden-de-crecimiento/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad3/10-evaluacion-experimental/README.md)
