# Convenciones de pseudocódigo y pruebas

[Inicio](../README.md) · [Representaciones](../unidad1/02-representar-la-solucion/README.md)

El pseudocódigo expresa el diseño; Java es la implementación ejecutable. La notación del curso no depende de PSeInt ni tiene que poder pegarse directamente en una herramienta. Si utilizas otra notación, declara sus equivalencias.

| Notación del curso | Significado | Java cuando corresponde |
|---|---|---|
| `←` | Asignación | `=` |
| `=` en condiciones | Igualdad | `==` para primitivos; `equals` para contenido de texto |
| `Y`, `O`, `NO` | Operaciones lógicas | `&&`, `||`, `!` |
| `DIV` | Cociente entero | `/` con operandos enteros |
| `MOD` | Residuo | `%` |
| Potencia matemática | Elevar un valor | Multiplicación para cuadrado o `Math.pow`; nunca `^` |
| Posiciones0..n-1 | Índices desde cero | Índices de arreglos y unidades UTF-16 de cadenas |
| Subcadena(inicio,fin) | Inicio incluido, fin excluido | `substring(inicio,fin)` |
| Repetir Hasta Que condición | Terminar cuando sea verdadera | `do-while` con condición de continuación equivalente |

En los recorridos Para desde a hasta b, ambos extremos se incluyen, salvo que se indique otro límite. En Java debes traducirlo explícitamente al operador correcto. Para un intervalo vacío, el cuerpo no se ejecuta.

## Construir una prueba de escritorio

1. Identifica entradas y supuestos.
2. Escribe el resultado requerido antes de mirar la ejecución.
3. Crea una fila por instrucción o iteración relevante.
4. Registra variable, valor anterior y valor nuevo; con arreglos, registra índices.
5. Verifica la condición que selecciona cada rama o termina el ciclo.
6. Compara la predicción con la ejecución y localiza la primera diferencia.

| Caso | Entrada | Predicción | Observación | Explicación |
|---|---|---|---|---|
| Habitual | Datos representativos | Resultado calculado manualmente | Resultado del programa | Regla utilizada |
| Frontera | Justo antes/en/después del límite | Rama esperada | Rama observada | Operador inclusivo o exclusivo |
| Inválido | Viola formato o rango | Rechazo | Mensaje o excepción | Estado que debe conservarse |

## Evidencias que comprueban más que una salida

Para ordenamiento, verifica orden y conservación de los valores. Para una búsqueda, verifica que el índice corresponda al objetivo o que la ausencia sea correcta. Para intercambios, aplica dos veces y comprueba recuperación. Para archivos, realiza ida y vuelta y compara campos. Para una carga inválida, comprueba que el estado anterior siga intacto.

Una excepción esperada debe ser específica; no captures cualquier fallo como si demostrara el rechazo previsto. No ajustes los resultados esperados para que coincidan con una regla equivocada.
