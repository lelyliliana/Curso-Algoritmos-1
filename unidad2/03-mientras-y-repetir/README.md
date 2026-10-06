# U2_03 · Mientras y repetir: condición de entrada y salida

[Anterior](../../unidad2/02-selector-multiple/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/04-para-contadores-y-acumuladores/README.md)

## Objetivo

Distinguir ciclos que comprueban antes o después y definir su terminación.

Tema: **Estructuras condicionales e iterativas**.

## Problema y contrato

Recorreremos tres turnos con while y compararemos una condición inicialmente falsa con do-while. La diferencia esencial es cuándo se comprueba la condición.

## Conceptos necesarios

While evalúa antes del cuerpo y puede ejecutarse cero veces. Do-while evalúa después y ejecuta al menos una. En el pseudocódigo del curso, «Repetir Hasta Que condición» termina cuando esa condición se vuelve verdadera; en Java do-while continúa mientras su condición es verdadera. Al traducir debes negar la condición de terminación cuando corresponda.

Cada ciclo necesita un estado inicial, una condición y un cambio que permita terminar. Un contador mide cantidad de repeticiones; un acumulador reúne valores. Inicializar el contador en un lugar incorrecto puede impedir la terminación.

Los ciclos con centinela terminan al recibir un valor especial acordado, que no debe procesarse como dato. Si lees entrada, también considera que pueda agotarse. No supongas que un usuario escribirá indefinidamente o que el fin de la entrada es una medición cero.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
turno ← 1
Mientras turno <= 3
  Mostrar turno
  turno ← turno + 1
FinMientras
intentos ← 0
Repetir
  intentos ← intentos + 1
Hasta Que intentos >= 1
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        int turno = 1;
        while (turno <= 3) {
            System.out.println("Turno: " + turno);
            turno++;
        }
        int intentos = 0;
        do {
            intentos++;
        } while (intentos < 1);
        System.out.println("Intentos: " + intentos);
        int contador = 5;
        while (contador < 3) contador++;
        System.out.println("While no entró: " + contador);
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/03-mientras-y-repetir
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Turno: 1
Turno: 2
Turno: 3
Intentos: 1
While no entró: 5
```

## Prueba de escritorio y recorrido

Turno aumenta a 4 después de tres impresiones y la condición falla. Do-while realiza un incremento antes de comprobar. El último while no ejecuta porque 5 < 3 es falso desde el inicio.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Copiar literalmente Hasta Que como condición del while invierte la regla. Omitir turno++ genera un ciclo infinito. Contar un centinela como dato altera totales y promedios.

## Práctica

Diseña pseudocódigo que lea cantidades no negativas hasta -1, sume solo las válidas y termine también ante fin de entrada. Explica qué sucede si -1 es el primer valor.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Comprueba si hay línea, convierte, sal si es -1 y después valida/procesa. Si -1 llega primero, no hay datos y suma vale 0. El número de datos válidos también es 0; no se debe calcular una media.

</details>

## Explica con tus palabras

¿Qué condición continúa y cuál termina? ¿Cómo garantizas que el estado avance?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/02-selector-multiple/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/04-para-contadores-y-acumuladores/README.md)
