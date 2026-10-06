# U2_05 · Ciclos anidados y tablas de resultados

[Anterior](../../unidad2/04-para-contadores-y-acumuladores/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/06-metodos-funciones-y-void/README.md)

## Objetivo

Analizar recorridos combinados y ubicar acumuladores en el nivel correcto.

Tema: **Estructuras condicionales e iterativas**.

## Problema y contrato

Calcularemos volúmenes de cilindros para dos radios y dos alturas. Cada radio se combina con cada altura, de modo que habrá cuatro resultados.

## Conceptos necesarios

Un ciclo anidado ejecuta el recorrido interno para cada valor del externo. Si el externo realiza n vueltas y el interno m independientes, el cuerpo se ejecuta n × m veces. Dos ciclos consecutivos recorren n + m, no n × m.

El área de la base depende solo del radio; puede calcularse una vez por radio fuera del ciclo de alturas. El volumen depende de ambos y se calcula dentro del ciclo interno. Ubicar cada cálculo según sus dependencias evita repetir trabajo innecesario.

Todos los valores usan las mismas unidades: radio y altura en centímetros, área en cm² y volumen en cm³. La fórmula es πr²h. Para una salida de demostración redondeamos a dos decimales con Locale.ROOT, que utiliza punto decimal de forma predecible.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Para radio en {1,2}
  area ← PI × radio × radio
  Para altura en {3,4}
    volumen ← area × altura
    Mostrar radio, altura, volumen
  FinPara
FinPara
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
import java.util.Locale;
public class Main {
    public static void main(String[] args) {
        for (int radio = 1; radio <= 2; radio++) {
            double area = Math.PI * radio * radio;
            for (int altura = 3; altura <= 4; altura++) {
                double volumen = area * altura;
                System.out.printf(Locale.ROOT, "r=%d h=%d V=%.2f cm3%n", radio, altura, volumen);
            }
        }
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/05-ciclos-anidados
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
r=1 h=3 V=9.42 cm3
r=1 h=4 V=12.57 cm3
r=2 h=3 V=37.70 cm3
r=2 h=4 V=50.27 cm3
```

## Prueba de escritorio y recorrido

Radio 1 combina alturas 3 y 4. Luego radio 2 repite ambas alturas. Cada combinación produce una línea; el área se calcula dos veces y el volumen cuatro.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

No reiniciar correctamente la variable interna puede omitir combinaciones. Mezclar centímetros y metros produce unidades incoherentes. `radio ^ 2` no calcula el cuadrado en Java.

## Práctica

Agrega radio 3 y altura 5. Predice el número de resultados antes de ejecutar. Explica qué ocurriría si los ciclos se colocaran uno después de otro.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Hay 3 radios y 3 alturas: 9 combinaciones. Ciclos consecutivos no generan pares radio/altura; solo dos recorridos separados. El volumen requiere ambas dimensiones en la misma combinación.

</details>

## Explica con tus palabras

¿Qué expresión depende solo del ciclo externo? ¿Cuántas veces se ejecuta el cuerpo interno?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/04-para-contadores-y-acumuladores/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/06-metodos-funciones-y-void/README.md)
