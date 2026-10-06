# U2_11 · Suma y promedio de un vector

[Anterior](../../unidad2/10-vectores/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/12-mayor-y-menor/README.md)

## Objetivo

Acumular datos y declarar cómo atender la ausencia de mediciones.

Tema: **Arreglos**.

## Problema y contrato

Calcularemos la media de tres consumos. Una colección vacía no tiene media observada; debe atenderse antes de dividir.

## Conceptos necesarios

El acumulador comienza en cero fuera del recorrido. Cada dato se añade una vez. Un long permite sumar los int de un arreglo sin el desbordamiento temprano de int. La media requiere convertir antes de dividir, porque la cantidad de datos es entera.

La suma vacía puede definirse como cero, pero la media vacía no resulta de una división válida. En esta aplicación mostramos Sin mediciones y terminamos. Esa política no debe confundirse con una medición real igual a cero.

El algoritmo recorre n elementos: su trabajo es lineal. No requiere ordenar para sumar. La salida decimal usa double y puede aproximar fracciones no representables exactamente. Para fines de medición eso puede ser apropiado, pero la precisión requerida depende del dominio.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Si longitud(datos)=0: informar ausencia y terminar
suma ← 0
Para cada valor: suma ← suma + valor
media ← suma / cantidad, con división decimal
Mostrar suma, media
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        int[] consumos = {12, 8, 11};
        if (consumos.length == 0) {
            System.out.println("Sin mediciones");
            return;
        }
        long suma = 0;
        for (int consumo : consumos) suma += consumo;
        double media = (double) suma / consumos.length;
        System.out.println("Suma: " + suma);
        System.out.println("Media: " + media);
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/11-suma-y-promedio
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Suma: 31
Media: 10.333333333333334
```

## Prueba de escritorio y recorrido

Suma pasa de 0 a 12, a 20 y a 31. La conversión a double ocurre antes de dividir entre 3, conservando una aproximación de la fracción.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Reiniciar suma en cada iteración deja solo el último dato. Convertir después de dividir pierde la fracción. Inventar media cero para ausencia de datos confunde estados.

## Práctica

Prueba un único valor 7, tres ceros y un arreglo vacío. Para cada caso escribe cantidad, suma y si existe una media.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Un dato 7 produce suma7 y media7.0. Tres ceros producen suma0 y media0.0. Vacío informa ausencia y no calcula media; no equivale al segundo caso.

</details>

## Explica con tus palabras

¿Cuándo la media cero es válida? ¿Es necesario ordenar?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/10-vectores/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/12-mayor-y-menor/README.md)
