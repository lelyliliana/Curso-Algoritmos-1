# Taller de unidad 3 · Catálogo verificable

[Índice](README.md) · [Proyecto de referencia](14-proyecto-integrador/README.md)

## Problema

Amplía el catálogo del proyecto con actualización de existencias y listado ordenado por nombre. Conserva alta única, búsqueda, borrado y recuperación desde archivo. La actualización de un código inexistente debe informar ausencia sin crear un artículo implícito.

Define si el listado usa orden natural de Java o una comparación lingüística local. Para esta práctica puedes usar el primero y declararlo. El listado ordenado debe conservar parejas de código, nombre y unidades y no modificar el orden interno.

## Trabajo por etapas

1. Define contratos de actualización y listado, incluyendo unidades negativas, ausencia y empates.
2. Modifica el catálogo sin exponer el arreglo interno. Actualiza con un record nuevo validado.
3. Ordena una copia de registros completos, no columnas separadas.
4. Conserva el formato de archivo o declara una nueva versión si cambia.
5. Prueba guardar/cargar después de actualizar y después de borrar.
6. Analiza alta, búsqueda, borrado, listado y carga según cantidad, capacidad y longitud de campos.

## Casos

| Escenario | Resultado requerido |
|---|---|
| ActualizarK01 a7 unidades | Conserva código/nombre; cambia unidades a7 |
| ActualizarK99 ausente | No agrega registro |
| Actualizar a-1 | Rechazo; conserva estado previo |
| Listar nombres con orden distinto al interno | Muestra copia ordenada; catálogo conserva su orden |
| Guardar/cargar tras actualización | Recupera7 unidades reales |
| Archivo con duplicado, campo inválido o capacidad excedida | Rechazo completo; estado previo intacto |
| Borrar primero y guardar/cargar | No reaparece el registro borrado |

## Evidencias y criterios

Incluye fuentes, README, archivo de muestra válido, tabla de casos y análisis de costos. La evidencia de recuperación debe cerrar y volver a iniciar, o construir una instancia nueva desde archivo: imprimir el estado todavía en memoria no demuestra persistencia. Una explicación en video de3 a5 minutos puede mostrar un cambio y una carga rechazada.

| Criterio | Peso | Evidencia |
|---|---|---|
| Contratos | 25 % | Identidad y actualización coherentes |
| Operaciones | 25 % | Registro completo y copia al ordenar |
| Persistencia | 30 % | Recuperación real y carga sin publicación parcial |
| Análisis y documentación | 20 % | Costos declarados y reproducción clara |

## Orientación de solución

Posicion localiza el índice. Actualizar puede devolver false para ausencia; al encontrar, crea `new Articulo(codigo,nombre,nuevasUnidades)` y solo después reemplaza la celda. La validación del constructor impide publicar unidades negativas. Para ordenar, snapshot crea una copia del arreglo; ordena esa copia por nombre y, si necesitas desempate, por código.

Buscar y borrar sonO(n) bajo costo de comparación de código acotado. Si cuentas longitudes variables, incluye ese costo. El ordenamiento depende del método elegido; selección esΘ(n²). Cargar en este catálogo llama a alta con búsqueda de duplicados por cada fila: puede hacerO(n²) comparaciones de códigos, no necesariamente O(n), aunque leer las líneas sea un recorrido. Esta distinción evita analizar solo el bucle visible e ignorar métodos llamados.

## Autoevaluación

¿La actualización valida antes de reemplazar? ¿El ordenamiento conserva campos asociados? ¿La carga comprueba duplicados como conjunto? ¿Incluiste el costo de las funciones llamadas? ¿Tus pruebas observan que el estado se conserva ante fallo?
