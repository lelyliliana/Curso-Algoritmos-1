# U2_07 · Parámetros, alcance y paso por valor

[Anterior](../../unidad2/06-metodos-funciones-y-void/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/08-clases-y-constructores/README.md)

## Objetivo

Explicar qué puede cambiar un método y qué variables están a su alcance.

Tema: **Introducción a la programación orientada a objetos**.

## Problema y contrato

Una función intentará aumentar una cantidad entera y modificar el primer elemento de un arreglo. La diferencia sirve para entender el paso por valor de Java.

## Conceptos necesarios

Una variable local existe dentro de su bloque. Un parámetro es una variable local del método que recibe una copia del valor del argumento. Java siempre pasa por valor: para un primitivo copia el número; para un objeto copia el valor de la referencia.

Cambiar el parámetro entero no modifica la variable del llamador. Una referencia copiada puede apuntar al mismo arreglo, por lo que cambiar sus elementos es visible fuera del método. Eso no convierte el paso en «por referencia»: reasignar el parámetro a otro arreglo no cambia la referencia del llamador.

Los atributos de una clase tienen un alcance distinto de las variables locales; un atributo static pertenece a la clase. No son «variables globales» sin límites dentro de Java. Usar estado compartido innecesario dificulta saber qué entrada afecta el resultado.

El ejemplo usa un arreglo de un elemento como avance del tema posterior. Observa únicamente la relación entre referencia y contenido: `[0]` designa el primer elemento.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
numero ← 5
Cambiar copia del numero a 6
vector ← [5]
Cambiar elemento 0 del vector a 6
Reasignar copia de referencia a otro vector
Mostrar originales
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    static void cambiarNumero(int numero) { numero++; }
    static void cambiarArreglo(int[] datos) {
        datos[0]++;
        datos = new int[]{99};
    }
    public static void main(String[] args) {
        int numero = 5;
        int[] datos = {5};
        cambiarNumero(numero);
        cambiarArreglo(datos);
        System.out.println("Número: " + numero);
        System.out.println("Elemento: " + datos[0]);
    }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/07-parametros-y-alcance
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Número: 5
Elemento: 6
```

## Prueba de escritorio y recorrido

El parámetro entero aumenta una copia. El parámetro arreglo comparte inicialmente el objeto y cambia su elemento a 6. Su posterior reasignación solo cambia la variable local, no la referencia de main.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Decir que Java pasa objetos por referencia confunde modificar contenido con cambiar una referencia. Una variable local no está disponible en cualquier método. Declarar todo static para compartirlo puede ocultar dependencias.

## Práctica

Haz que cambiarNumero devuelva el nuevo valor y asígnalo en main. Después crea una copia del arreglo con clone antes de modificarla.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

`numero = aumentar(numero)` permite recibir 6 explícitamente. Modificar `datos.clone()` no cambia elementos del arreglo original de enteros. Para arreglos de objetos, clone copia referencias y no es una copia profunda.

</details>

## Explica con tus palabras

¿Qué se copia cuando el argumento es un objeto? ¿Por qué reasignar el parámetro no cambia main?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/06-metodos-funciones-y-void/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/08-clases-y-constructores/README.md)
