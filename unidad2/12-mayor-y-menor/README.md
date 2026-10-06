# U2_12 · Mayor y menor dato del vector

[Anterior](../../unidad2/11-suma-y-promedio/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/13-intercambiar-e-invertir/README.md)

## Objetivo

Encontrar extremos inicializando desde un dato real.

Tema: **Arreglos**.

## Problema y contrato

Los valores representan temperaturas que pueden ser negativas. Iniciar máximo en cero daría una temperatura que no existe si todos los datos son negativos.

## Conceptos necesarios

Después de comprobar que hay datos, inicializamos mínimo y máximo con el primero. Recorremos los demás y actualizamos cuando un valor supera el extremo vigente. No necesitamos ordenar: una sola pasada basta.

Al terminar cada iteración, mínimo y máximo representan los extremos de la porción ya visitada. Esa invariante explica tanto la inicialización como la condición de actualización. Empates no necesitan cambios si solo queremos el valor.

Si queremos la posición del primer extremo, también conservamos su índice y actualizamos solo con desigualdad estricta. Con <= o >= podemos seleccionar la última posición empatada. No hay una regla universal: declara cuál necesitas.

Un vector vacío no tiene máximo o mínimo en este dominio. El ejemplo informa ausencia y termina. El trabajo de la búsqueda es O(n) y el espacio adicional O(1).

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
validar que datos no esté vacío
menor ← datos[0]; mayor ← datos[0]
Para i desde 1 hasta n-1
  Si datos[i] < menor: menor ← datos[i]
  Si datos[i] > mayor: mayor ← datos[i]
FinPara
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        int[] temperaturas = {-8, -3, -12, -3};
        if (temperaturas.length == 0) {
            System.out.println("Sin temperaturas");
            return;
        }
        int menor = temperaturas[0];
        int mayor = temperaturas[0];
        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] < menor) menor = temperaturas[i];
            if (temperaturas[i] > mayor) mayor = temperaturas[i];
        }
        System.out.println("Menor: " + menor);
        System.out.println("Mayor: " + mayor);
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/12-mayor-y-menor
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Menor: -12
Mayor: -3
```

## Prueba de escritorio y recorrido

Ambos extremos comienzan en -8. -3 cambia mayor; -12 cambia menor; el último -3 empata y no cambia ninguno. Ningún cero ficticio participa.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Inicializar en cero falla con datos todos negativos o todos positivos según el extremo. Acceder a [0] antes de validar falla con vacío. Ordenar solo para conocer extremos añade trabajo innecesario.

## Práctica

Registra el índice del primer máximo. Prueba {-3,-8,-3}. Luego define la variante que conserve el último máximo.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

La primera variante conserva índice0 usando >. La última conserva índice2 usando >=. El valor máximo es -3 en las dos; cambia la política de empate.

</details>

## Explica con tus palabras

¿Qué invariante tiene el recorrido? ¿Qué cambia al admitir igualdad en la actualización?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/11-suma-y-promedio/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/13-intercambiar-e-invertir/README.md)
