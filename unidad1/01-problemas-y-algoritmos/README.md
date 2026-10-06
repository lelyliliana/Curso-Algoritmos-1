# U1_01 · Problemas, soluciones y programas

[Anterior](../../README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad1/02-representar-la-solucion/README.md)

## Objetivo

Convertir una necesidad en entradas, reglas y resultados comprobables.

Tema: **Clarificar el problema mediante acciones algorítmicas**.

## Problema y contrato

Un grupo necesita distribuir 17 cuadernos entre 5 equipos por igual. Queremos informar cuántos recibe cada equipo y cuántos quedan. Antes de programar, aclaramos que no se parten cuadernos y que los equipos deben ser al menos uno.

## Conceptos necesarios

Un problema expresa una necesidad; una solución algorítmica establece pasos precisos y finitos; un programa implementa esos pasos en un lenguaje. Describir «repartir» no determina si debe haber igualdad, si se permiten fracciones o qué hacer con sobrantes. Los requisitos resuelven esas ambigüedades.

| Elemento | Contrato |
|---|---|
| Entradas | Cuadernos: entero no negativo; equipos: entero positivo |
| Proceso | Cociente entero y residuo |
| Salidas | Unidades por equipo y sobrantes |
| Supuesto | Se reparten unidades completas |

La validez del dato precede al cálculo. Con cero equipos la división no tiene sentido; con cero cuadernos y equipos positivos el reparto sí está definido. La terminación y la precisión de instrucciones permiten ejecutar el algoritmo sin adivinar decisiones. En este curso trabajaremos principalmente algoritmos deterministas: las mismas entradas y reglas producen la misma salida.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Inicio
  validar cuadernos >= 0 y equipos > 0
  porEquipo ← cuadernos DIV equipos
  sobrantes ← cuadernos MOD equipos
  mostrar porEquipo, sobrantes
Fin
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        int cuadernos = 17;
        int equipos = 5;
        if (cuadernos < 0 || equipos <= 0) {
            System.out.println("Datos de reparto inválidos");
            return;
        }
        System.out.println("Por equipo: " + cuadernos / equipos);
        System.out.println("Sobrantes: " + cuadernos % equipos);
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad1/01-problemas-y-algoritmos
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Por equipo: 3
Sobrantes: 2
```

## Prueba de escritorio y recorrido

17 / 5 produce 3 unidades completas. 17 % 5 produce 2. La comprobación `5 × 3 + 2 = 17` permite contrastar la salida con la cantidad original.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Confundir programa con algoritmo limita la solución a una sintaxis. Dividir sin validar equipos deja un caso inválido sin respuesta. Usar una media decimal cambia el requisito de unidades completas.

## Práctica

Prueba 0 cuadernos y 5 equipos; 20 y 5; 17 y 0. Añade una comprobación que reconstruya el total a partir del cociente y residuo.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Los dos casos válidos producen (0,0) y (4,0). El tercero se rechaza. Para valores válidos, equipos × porEquipo + sobrantes debe recuperar cuadernos, y 0 <= sobrantes < equipos.

</details>

## Explica con tus palabras

¿Qué supuesto cambia si permitimos partir cuadernos? ¿Por qué cero cuadernos y cero equipos son casos distintos?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad1/02-representar-la-solucion/README.md)
