# Taller de unidad 1 · Compra de materiales

[Índice](README.md) · [Unidad siguiente](../unidad2/README.md)

## Problema

Una jornada compra entre1 y20 paquetes de cuadernos. Cada paquete vale12000 pesos. Desde5 paquetes hay un descuento del10 % sobre el subtotal. El programa debe recibir la cantidad, rechazar entradas fuera del contrato e informar subtotal, descuento y total.

Para esta práctica el precio no cambia y usamos pesos enteros. El descuento descarta fracciones de peso si aparecen; con esta tarifa no aparecen. Separa esa decisión de la regla del umbral.

## Trabajo por etapas

1. Identifica entrada, formato, rango, constante y salidas. Escribe qué significa «desde5».
2. Diseña pseudocódigo usando las convenciones del curso. Separa conversión, validación, cálculo y presentación.
3. Construye una prueba de escritorio antes de implementar. Registra el estado de cantidad, subtotal, descuento y total.
4. Implementa y compara casos. No cambies resultados esperados para adaptarlos a una fórmula incorrecta.
5. Prueba una entrada de texto no numérico y distingue ese rechazo del rango inválido.
6. Documenta ejecución y una decisión en tu README.

## Casos

| Cantidad | Subtotal | Descuento | Total |
|---|---|---|---|
| 1 | 12000 | 0 | 12000 |
| 4 | 48000 | 0 | 48000 |
| 5 | 60000 | 6000 | 54000 |
| 20 | 240000 | 24000 | 216000 |
| 0 o21 | Rechazo | No calcular | No calcular |
| `cinco` | Formato inválido | No calcular | No calcular |

## Evidencias y criterios

Conserva fuentes, pseudocódigo, tabla de predicción/observación y README reproducible. Si utilizas video, una explicación de3 a5 minutos puede mostrar un caso de frontera y un rechazo. Comparte enlaces a tus materiales y explica las decisiones con tus palabras.

| Criterio | Peso | Evidencia |
|---|---|---|
| Análisis | 25 % | Entradas, rangos y regla explícitos |
| Diseño | 25 % | Pseudocódigo coherente y prueba de escritorio |
| Implementación | 30 % | Cálculo y rechazos correctos |
| Verificación y comunicación | 20 % | Casos contrastados y pasos reproducibles |

## Orientación de solución

La conversión obtiene un entero. Después valida1..20. Subtotal = cantidad ×12000L; descuento es subtotal ×10/100 si cantidad >=5 y cero en otro caso; total es subtotal menos descuento. Los límites del ejercicio mantienen el cálculo dentro del rango de long. NumberFormatException atiende texto no convertible, pero no reemplaza la validación del dominio.

## Autoevaluación

¿La entrada5 recibe descuento? ¿0 se rechaza antes del cálculo? ¿Sabes explicar por qué el dinero es entero? ¿La tabla refleja cada cambio de estado? ¿Otra persona puede reproducir tu ejecución?
