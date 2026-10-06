# U1_07 · Pruebas de escritorio y casos límite

[Anterior](../../unidad1/06-relaciones-y-logica/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad1/08-asignacion-y-entrada/README.md)

## Objetivo

Seguir valores y contrastar una solución con resultados definidos por el requisito.

Tema: **Pruebas de escritorio**.

## Problema y contrato

Una tienda aplica descuento del 10 % a compras desde 100000 pesos. La frontera exacta importa: «desde» incluye 100000. Probaremos antes, en y después del umbral.

## Conceptos necesarios

Una prueba de escritorio ejecuta mentalmente instrucciones sobre datos concretos y registra cambios de variables. No consiste en copiar la salida del computador. Primero predice y después contrasta. Un caso de frontera separa dos comportamientos; suele revelar errores entre > y >=.

| Compra | Condición >=100000 | Descuento | Total |
|---|---|---|---|
| 99990 | false | 0 | 99990 |
| 100000 | true | 10000 | 90000 |
| 100010 | true | 10001 | 90009 |

Usamos pesos enteros y un rango de compras de 0 a 1000000. La división entera descarta fracciones de peso si aparecen; esa política forma parte del ejemplo. El método valida el rango antes de calcular.

Las comprobaciones ejecutables comparan obtenido con esperado y lanzan AssertionError si hay diferencia. No dependen de activar las sentencias assert con opciones especiales. Una prueba exitosa no demuestra ausencia de todo defecto; sí permite detectar cambios que violen esos casos.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Para cada compra de prueba
  validar rango
  descuento ← 0
  Si compra >= 100000: descuento ← compra × 10 DIV 100
  total ← compra - descuento
  comparar con resultado requerido
FinPara
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    static long total(long compra) {
        if (compra < 0 || compra > 1000000) throw new IllegalArgumentException("Compra fuera de rango");
        long descuento = compra >= 100000 ? compra * 10 / 100 : 0;
        return compra - descuento;
    }
    public static void main(String[] args) {
        long[] compras = {99990, 100000, 100010};
        long[] esperados = {99990, 90000, 90009};
        for (int i = 0; i < compras.length; i++) {
            long obtenido = total(compras[i]);
            if (obtenido != esperados[i]) throw new AssertionError("Caso " + i);
            System.out.println(compras[i] + " -> " + obtenido);
        }
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad1/07-prueba-de-escritorio
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
99990 -> 99990
100000 -> 90000
100010 -> 90009
```

## Prueba de escritorio y recorrido

El descuento comienza en cero para cada compra. Solo las dos últimas cumplen el umbral. La comprobación compara cada total con la tabla definida antes de ejecutar.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Cambiar el esperado para coincidir con un cálculo incorrecto anula la prueba. Probar solamente una compra muy grande no distingue > de >=. Suponer que compilar significa resolver bien omite los errores lógicos.

## Práctica

Cambia temporalmente >= por > y ejecuta. Restaura la regla y añade compra cero y compra negativa. Sigue el método línea por línea en una tabla.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

El caso 100000 falla con >. Compra cero produce 0 y compra negativa se rechaza. Para probar el rechazo, captura IllegalArgumentException y falla si el método acepta el dato.

</details>

## Explica con tus palabras

¿Qué dato eliges para detectar una frontera mal implementada? ¿Qué diferencia hay entre predicción y observación?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad1/06-relaciones-y-logica/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad1/08-asignacion-y-entrada/README.md)
