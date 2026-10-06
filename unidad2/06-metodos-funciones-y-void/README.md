# U2_06 · Métodos con retorno y métodos void

[Anterior](../../unidad2/05-ciclos-anidados/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/07-parametros-y-alcance/README.md)

## Objetivo

Separar cálculo y presentación mediante parámetros y valores devueltos.

Tema: **Introducción a la programación orientada a objetos**.

## Problema y contrato

Una aplicación calcula áreas rectangulares para varias salas. El mismo método debe devolver un área que pueda sumarse, mientras otro se encarga de mostrarla.

## Conceptos necesarios

Un método reúne instrucciones bajo una firma. Sus parámetros describen entradas y su tipo de retorno describe la salida. Return entrega un valor y termina ese método. Void indica ausencia de valor devuelto; imprimir no equivale a devolver.

El contrato de area exige medidas positivas y finitas. Double puede contener NaN o infinito, por lo que comprobar únicamente <=0 no detecta todos los valores inválidos. La excepción informa un contrato violado y evita calcular un área que parezca válida.

Usamos métodos static para reglas independientes en esta introducción. No necesitas crear un objeto para cada cálculo sencillo. Después construiremos clases cuando datos y comportamiento pertenezcan a una misma responsabilidad.

Separar presentación permite reutilizar la función en otra interfaz o prueba. Copiar la fórmula dentro de cada impresión genera lugares distintos donde una corrección puede quedar pendiente.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Funcion area(ancho, alto)
  validar medidas positivas y finitas
  Retornar ancho × alto
FinFuncion
Procedimiento mostrar(valor)
  Mostrar valor
FinProcedimiento
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    static double area(double ancho, double alto) {
        if (!Double.isFinite(ancho) || !Double.isFinite(alto) || ancho <= 0 || alto <= 0) {
            throw new IllegalArgumentException("Medidas inválidas");
        }
        return ancho * alto;
    }
    static void mostrar(double valor) {
        System.out.println("Área: " + valor);
    }
    public static void main(String[] args) {
        mostrar(area(3, 4));
        double total = area(3, 4) + area(2, 5);
        System.out.println("Total: " + total);
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/06-metodos-funciones-y-void
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Área: 12.0
Total: 22.0
```

## Prueba de escritorio y recorrido

area(3,4) devuelve 12 y mostrar lo imprime. Las dos llamadas siguientes devuelven 12 y 10, que main suma. El cálculo no imprime mensajes propios.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Un método void no puede usarse como número en una suma. Los parámetros no necesitan tener el mismo nombre que las variables del llamador. Una función con validación parcial puede aceptar NaN.

## Práctica

Prueba una medida cero y Double.NaN. Agrega una validación del producto si necesitas rechazar un resultado infinito con medidas extremadamente grandes.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Ambas entradas se rechazan. Dos medidas finitas muy grandes pueden producir infinito al multiplicarse; verifica también `Double.isFinite(resultado)` si el contrato exige un resultado finito.

</details>

## Explica con tus palabras

¿Qué diferencia hay entre salida por pantalla y retorno? ¿Dónde debe conservarse el contrato?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/05-ciclos-anidados/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/07-parametros-y-alcance/README.md)
