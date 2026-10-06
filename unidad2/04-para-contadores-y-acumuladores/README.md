# U2_04 · Para, contadores y acumuladores

[Anterior](../../unidad2/03-mientras-y-repetir/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/05-ciclos-anidados/README.md)

## Objetivo

Recorrer un intervalo y conservar una propiedad después de cada iteración.

Tema: **Estructuras condicionales e iterativas**.

## Problema y contrato

Sumaremos los números de 1 a 6 y contaremos cuántos son pares. Una variable reúne valores y otra cuenta eventos: sus actualizaciones son diferentes.

## Conceptos necesarios

For reúne inicialización, condición y actualización. Resulta útil cuando conoces el recorrido. El límite inclusivo o exclusivo debe corresponder al problema: para 1..6 usamos <=6, mientras que para posiciones de un arreglo de longitud n usaremos <n.

Total es un acumulador y pares un contador. Ambos comienzan en cero, fuera del ciclo. Después de visitar cada número, total contiene la suma de los ya recorridos y pares la cantidad de pares vistos. Esa invariante ayuda a revisar el algoritmo.

El trabajo crece con la cantidad de valores visitados. Un for no tiene complejidad constante solo por ser una única instrucción escrita; su cuerpo se ejecuta repetidamente. Un paso distinto de uno cambia el recorrido y requiere revisar límites y terminación.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
total ← 0; pares ← 0
Para numero desde 1 hasta 6
  total ← total + numero
  Si numero MOD 2 = 0: pares ← pares + 1
FinPara
Mostrar total, pares
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        int total = 0;
        int pares = 0;
        for (int numero = 1; numero <= 6; numero++) {
            total += numero;
            if (numero % 2 == 0) pares++;
        }
        System.out.println("Suma: " + total);
        System.out.println("Pares: " + pares);
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/04-para-contadores-y-acumuladores
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Suma: 21
Pares: 3
```

## Prueba de escritorio y recorrido

Total cambia a 1, 3, 6, 10, 15 y 21. El contador solo cambia en 2, 4 y 6. Al llegar a 7 la condición impide otra iteración.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Inicializar total dentro del cuerpo borra lo acumulado. Aumentar pares por el número en lugar de uno suma valores, no cuenta. Usar <6 omite un dato del contrato.

## Práctica

Extiende el recorrido a 10. Luego recorre únicamente pares con paso 2 y comprueba si obtienes el mismo conteo de pares.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

La suma de 1..10 es 55 y hay 5 pares. Recorriendo 2,4,6,8,10 hay 5 iteraciones, pero la suma cambia a 30 porque no visitas los impares. Los dos objetivos no deben confundirse.

</details>

## Explica con tus palabras

¿Qué conserva cada variable? ¿Cómo cambia el resultado al cambiar el paso?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/03-mientras-y-repetir/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/05-ciclos-anidados/README.md)
