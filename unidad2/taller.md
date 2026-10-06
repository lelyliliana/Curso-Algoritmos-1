# Taller de unidad 2 · Mediciones por aula

[Índice](README.md) · [Unidad siguiente](../unidad3/README.md)

## Problema

Un centro conserva mediciones enteras no negativas para varias aulas durante varios días. La tabla es rectangular, tiene al menos una fila y una columna y no admite datos ausentes. Construye una clase Mediciones que reciba esos datos, proteja su estado y calcule totales por aula, por día, total general y media global.

Agrega transpuesta como resultado nuevo. La media debe dividir entre cantidad de celdas, no entre filas. Si necesitas más adelante datos ausentes, amplía el contrato; no conviertas automáticamente ausencia a cero.

## Trabajo por etapas

1. Define dimensiones, significado de filas/columnas y reglas de valores.
2. Diseña los ciclos y ubica cada acumulador. Establece la propiedad de conservación del total.
3. Crea constructor y atributos privados. Copia las filas para que una modificación externa no cambie la tabla interna.
4. Implementa consultas con retorno, manteniendo las impresiones en main.
5. Calcula transpuesta con dimensiones invertidas sin cambiar la entrada.
6. Comprueba resultados y rechazos con datos pequeños.

## Casos

| Entrada | Resultado requerido |
|---|---|
| `{{2,4,6},{1,3,5}}` | Filas12,9; columnas3,7,11; total21; media3.5 |
| `{{0}}` | Todos los totales0; media0.0 válida |
| `{{7}}` | Total7; media7.0; transpuesta1×1 |
| Exterior vacío | Rechazo |
| Fila nula o longitudes distintas | Rechazo |
| Una medición negativa | Rechazo |
| Modificar entrada después de construir | No altera la instancia |

## Evidencias y criterios

Presenta fuente, diseño de métodos, trazas de al menos un ciclo y tabla de pruebas. Una explicación breve debe justificar la copia de filas y la división de la media. Si trabajas en equipo, identifica contribuciones. Conserva un README que indique carpeta de ejecución y JDK requerido.

| Criterio | Peso | Evidencia |
|---|---|---|
| Contrato y modelo | 25 % | Dimensiones, valores y encapsulación |
| Recorridos | 30 % | Totales y media correctos |
| Operaciones | 20 % | Transpuesta nueva con forma correcta |
| Verificación | 25 % | Fronteras, rechazos y ausencia de alias mutable |

## Orientación de solución

Valida forma y cada dato antes de completar la construcción. `entrada.clone()` solo copia el arreglo exterior; copia también cada fila con clone. Guarda ese resultado como atributo privado. Cada método de subtotal inicializa su acumulador antes del recorrido interno. Total puede calcularse con un recorrido completo o sumando subtotales. Media usa `(double) total / ((long) filas * columnas)`; ambas dimensiones son positivas por contrato.

Para transpuesta, crea una matriz columnas×filas y coloca cada dato en la coordenada invertida. Si devuelves datos internos, vuelve a exponer mutación: devuelve resultados nuevos o copias.

## Autoevaluación

¿Tu clase resiste que el llamador cambie su entrada? ¿Suma de filas y columnas coincide? ¿Has probado una tabla no cuadrada? ¿Podrías explicar cada índice? ¿Una fila vacía se acepta o rechaza según el contrato?
